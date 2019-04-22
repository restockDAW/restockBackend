app.controller("proveidorsCtrl", function($scope, $http, $window, proveidorsService, Notification) {
        
    $scope.proveidor = {};
    $scope.proveidors = [];
    $scope.modalType = null;
        
    this.$onInit = onInit();
    
    function onInit() {
        console.log("Proveidors controller initiatied!");
        LoadProveidors(); 
    }

    function LoadProveidors() {
        //add loader
        return proveidorsService.getAllProveidors(1)
            .then(function (data) {
                console.log(data);
                $scope.proveidors = data;
            }).catch(function(response) {
                //notification of error
            }).finally(function() {
                //stop loader
            })        
    }
    
    
    /* Netejem el proveidor quan es tanqui el modal */
    $(".modal").on('hidden.bs.modal', function(){
        $scope.proveidor = {};
        //aprofitem per netejar el tipus de modal
        $scope.modalType = null;
        $scope.$apply();
    });
    
    $scope.OpenAddProveidorModal = function() {
        $scope.modalType = "alta";
        $('#modalProveidor').modal('show');           
    }
    
    $scope.AddProveidor = function(proveidor) {
        console.log(proveidor);
        
        var organitzacio = {};
        organitzacio.id = 1;
        
        proveidor.organitzacio = organitzacio;
        
        return proveidorsService.createProveidor(proveidor)
            .then(function (response) {
                console.log(response);
                Notification.primary(response);
                $('#modalProveidor').modal('hide');    
                $scope.UserCreation.$setPristine();
                LoadProveidors();
            }).catch(function(response) {
                Notification.error(response);
            }).finally(function() {
                //stop loader
            })       
    }
    
    $scope.OpenEditProveidorModal = function(proveidor) {
        $scope.modalType = "modificacio";
        $scope.proveidor = angular.copy(proveidor);
        $('#modalProveidor').modal('show');   
          
    }
    
    $scope.UpdateProveidor = function(proveidor) {
        return proveidorsService.updateProveidor(proveidor)
            .then(function (response) {
                console.log(response);
                Notification.primary(response);
                $('#modalProveidor').modal('hide');   
                LoadProveidors();
            }).catch(function(response) {
                Notification.error(response);
            }).finally(function() {
                //stop loader
            })     
    }
    
    
    $scope.OpenDeleteProveidorModal = function(proveidor) {
        $scope.proveidor = proveidor;
        $('#modalDeleteProveidor').modal('show');    
    }
    
    $scope.ConfirmDelete = function(proveidor) {         
        return proveidorsService.deleteProveidor(proveidor)
            .then(function (response) {
                console.log(response);
                Notification.primary(response);
                $('#modalDeleteProveidor').modal('hide');   
                LoadProveidors();
            }).catch(function(response) {
                Notification.error(response);
            }).finally(function() {
                //stop loader
            })       
    }
    
});