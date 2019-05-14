app.controller("botiguesCtrl", function($scope, $http, $window, Notification, botiguesService, responsablesService, Auth) {
        
    $scope.botiga = {};
    $scope.botigues = [];
    $scope.modalType = null;
        
    this.$onInit = onInit();
    
    function onInit() {
        console.log("Botigues controller initiatied!");
        LoadBotigues(); 
    }
    
    function LoadBotigues() {
        //add loader
        return botiguesService.getAllBotigues(Auth.currentUser().organitzacio.id)
            .then(function (data) {
                console.log(data);
                $scope.botigues = data;
            }).catch(function(response) {
                Notification.error(response);
                //notification of error
            }).finally(function() {
                //stop loader
            })        
    }
    
    function LoadResponsables() {
        return responsablesService.getAllResponsables(Auth.currentUser().organitzacio.id)
            .then(function (data) {
                console.log(data);
                $scope.responsables = data;
            }).catch(function(response) {
                //notification of error
            }).finally(function() {
                //stop loader
            })        
    }
    
    /* Netejem la botiga quan es tanqui el modal */
    $("#modalBotiga").on('hidden.bs.modal', function(){
        $scope.botiga = {};
        //aprofitem per netejar el tipus de modal
        $scope.modalType = null;
        $scope.$apply();
    });
    
    $scope.OpenAddBotigaModal = function() {
        $scope.modalType = "alta";
        $('#modalBotiga').modal('show');   
        LoadResponsables();
    }
    
    $scope.OpenAddResponsableModal = function() {
        $('#modalResponsable').modal('show');           
    }
    
    $scope.AddResponsable = function(responsable) {
        console.log(responsable);
        responsable.dataNaixement = moment(responsable.dataNaixement).format('DD/MM/YYYY');
        responsable.rol = 2; //hardcoded value for responsable
        
        var organitzacio = {};
        organitzacio.id = Auth.currentUser().organitzacio.id;
        organitzacio.usuari = responsable;
        
        //responsable.organitzacio = organitzacio;
        
        return responsablesService.createResponsable(organitzacio)
            .then(function (response) {
                console.log(response);
                Notification.primary(response);
                $('#modalResponsable').modal('hide');    
                $scope.UserCreation.$setPristine();
                LoadResponsables();
            }).catch(function(response) {
                Notification.error(response);
            }).finally(function() {
                //stop loader
            })       
    }
    
    
    $scope.AddBotiga = function(botiga) {
        console.log(botiga);
        
        var organitzacio = {};
        organitzacio.id = Auth.currentUser().organitzacio.id;
        
        botiga.organitzacio = organitzacio;
        //botiga.usuari = angular.fromJson(botiga.usuari)
        
        return botiguesService.createBotiga(botiga)
            .then(function (response) {
                console.log(response);
                Notification.primary(response);
                $('#modalBotiga').modal('hide');    
                $scope.BotigaCreation.$setPristine();
                LoadBotigues();
            }).catch(function(response) {
                Notification.error(response);
            }).finally(function() {
                //stop loader
            })       
    }
    
    $scope.OpenEditBotigaModal = function(botiga) {
        $scope.modalType = "modificacio";
        $scope.botiga = angular.copy(botiga);
        $('#modalBotiga').modal('show');    
        LoadResponsables();          
    }
    
    $scope.UpdateBotiga = function(botiga) {
        return botiguesService.updateBotiga(botiga)
            .then(function (response) {
                botiguesService.updateResponsableBotiga(botiga)
                .then(function (response) {  
                    console.log(response);
                    Notification.primary(response);
                    $('#modalBotiga').modal('hide');   
                    LoadBotigues();
                }).catch(function(response) {
                    Notification.error(response);
                }).finally(function() {
                    //stop loader
                })   
            }).catch(function(response) {
                Notification.error(response);
            }).finally(function() {
                //stop loader
            })     
    }    
    
    $scope.UpdateResponsableBotiga = function(botiga) {
        return botiguesService.updateBotiga(botiga)
            .then(function (response) {  
                
            }).catch(function(response) {
                Notification.error(response);
            }).finally(function() {
                //stop loader
            })     
    }
    
    
    $scope.OpenDeleteBotigaModal = function(botiga) {
        $scope.botiga = botiga;
        $('#modalDeleteBotiga').modal('show');    
    }
    
    $scope.ConfirmDelete = function(botiga) {         
        return botiguesService.deleteBotiga(botiga)
            .then(function (response) {
                console.log(response);
                Notification.primary(response);
                $('#modalDeleteBotiga').modal('hide');   
                LoadBotigues();
            }).catch(function(response) {
                Notification.error(response);
            }).finally(function() {
                //stop loader
            })       
    }
    
    
    
});