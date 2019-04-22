app.controller("botiguesCtrl", function($scope, $http, $window, Notification, botiguesService, responsablesService) {
        
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
        return botiguesService.getAllBotigues(1)
            .then(function (data) {
                console.log(data);
                $scope.botigues = data;
            }).catch(function(response) {
                //notification of error
            }).finally(function() {
                //stop loader
            })        
    }
    
    function LoadResponsables() {
        return responsablesService.getAllResponsables()
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
    $(".modal").on('hidden.bs.modal', function(){
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
    
    $scope.AddBotiga = function(botiga) {
        console.log(botiga);
        
        var organitzacio = {};
        organitzacio.id = 1;
        
        botiga.organitzacio = organitzacio;
        botiga.usuari = angular.fromJson(botiga.usuari)
        
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