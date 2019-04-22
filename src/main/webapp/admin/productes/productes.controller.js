app.controller("productesCtrl", function($scope, $http, $window, Notification, productesService, proveidorsService) {
        
    $scope.producte = {};
    $scope.productes = [];      
    $scope.modalType = null;
            
    this.$onInit = onInit();
    
    function onInit() {
        console.log("Productes controller initiatied!");
        LoadProductes();
    }
        
    
    function LoadProductes() {
        //add loader
        return productesService.getAllProductes()
            .then(function (data) {
                console.log(data);
                $scope.productes = data;
            }).catch(function(response) {
                //notification of error
            }).finally(function() {
                //stop loader
            })        
    }
    
    
    /* Netejem el producte quan es tanqui el modal */
    $(".modal").on('hidden.bs.modal', function(){
        $scope.producte = {};
        //aprofitem per netejar el tipus de modal
        $scope.modalType = null;
        $scope.$apply();
    });
    
    $scope.OpenAddProducteModal = function() {
        $scope.modalType = "alta";
        $('#modalProducte').modal('show');           
    }
    
    $scope.AddResponsable = function(producte) {
        console.log(producte);
        
        return productesService.createProducte(producte)
            .then(function (response) {
                console.log(response);
                Notification.primary(response);
                $('#modalProducte').modal('hide');    
                $scope.ProductCreation.$setPristine();
                LoadProductes();
            }).catch(function(response) {
                Notification.error(response);
            }).finally(function() {
                //stop loader
            })       
    }
    
    $scope.OpenEditProducteModal = function(producte) {
        $scope.modalType = "modificacio";
        $scope.producte = angular.copy(producte);
        $('#modalProducte').modal('show');   
          
    }
    
    $scope.UpdateProducte = function(producte) {
        return productesService.updateProducte(producte)
            .then(function (response) {
                console.log(response);
                Notification.primary(response);
                $('#modalProducte').modal('hide');   
                LoadProductes();
            }).catch(function(response) {
                Notification.error(response);
            }).finally(function() {
                //stop loader
            })     
    }
    
    
    $scope.OpenDeleteProducteModal = function(producte) {
        $scope.producte = producte;
        $('#modalDeleteProducte').modal('show');    
    }
    
    $scope.ConfirmDelete = function(producte) {         
        return productesService.deleteProducte(producte)
            .then(function (response) {
                console.log(response);
                Notification.primary(response);
                $('#modalDeleteProducte').modal('hide');   
                LoadProductes();
            }).catch(function(response) {
                Notification.error(response);
            }).finally(function() {
                //stop loader
            })       
    }
    
});