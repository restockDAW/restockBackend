app.controller("responsablesCtrl", function($scope, $http, $window, Notification, responsablesService) {
        
    $scope.responsable = {};
    $scope.responsables = [];        
    $scope.modalType = null;
    
    this.$onInit = onInit();
    
    function onInit() {
        console.log("Responsables controller initiatied!");
        LoadResponsables(); 
    }
        
    
    function LoadResponsables() {
        //add loader
        //return responsablesService.getAllResponsables(1)
        return responsablesService.getAll()
            .then(function (data) {
                console.log(data);
                $scope.responsables = data;
            }).catch(function(response) {
                //notification of error
            }).finally(function() {
                //stop loader
            })        
    }
    
    
    /* Netejem el responsable quan es tanqui el modal */
    $(".modal").on('hidden.bs.modal', function(){
        $scope.responsable = {};
        //aprofitem per netejar el tipus de modal
        $scope.modalType = null;
        $scope.$apply();
    });
    
    $scope.OpenAddResponsableModal = function() {
        $scope.modalType = "alta";
        $('#modalResponsable').modal('show');           
    }
    
    $scope.AddResponsable = function(responsable) {
        console.log(responsable);
        responsable.dataNaixement = moment(responsable.dataNaixement).format('DD/MM/YYYY');
        responsable.rol = 2; //hardcoded value for responsable
        
        var organitzacio = {};
        organitzacio.id = 1;
        
        responsable.organitzacio = organitzacio;
        
        
        return responsablesService.createResponsable(responsable)
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
    
    $scope.OpenEditResponsableModal = function(responsable) {
        $scope.modalType = "modificacio";
        $scope.responsable = angular.copy(responsable);
        $scope.responsable.dataNaixement = moment(responsable.dataNaixement, 'DD/MM/YYYY').toDate();
        
        $('#modalResponsable').modal('show');   
          
    }
    
    $scope.UpdateResponsable = function(responsable) {
        responsable.dataNaixement = moment(responsable.dataNaixement).format('DD/MM/YYYY');
        return responsablesService.updateResponsable(responsable)
            .then(function (response) {
                console.log(response);
                Notification.primary(response);
                $('#modalResponsable').modal('hide');   
                LoadResponsables();
            }).catch(function(response) {
                Notification.error(response);
            }).finally(function() {
                //stop loader
            })     
    }
    
    
    $scope.OpenDeleteResponsableModal = function(responsable) {
        $scope.responsable = responsable;
        $('#modalDeleteResponsable').modal('show');    
    }
    
    $scope.ConfirmDelete = function(responsable) {         
        return responsablesService.deleteResponsable(responsable)
            .then(function (response) {
                console.log(response);
                Notification.primary(response);
                $('#modalDeleteResponsable').modal('hide');   
                LoadResponsables();
            }).catch(function(response) {
                Notification.error(response);
            }).finally(function() {
                //stop loader
            })       
    }
    
    
});