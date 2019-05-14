app.controller("productesCtrl", function($scope, $http, $window, Notification, productesService, proveidorsService, Auth) {
        
    $scope.producte = {};
    $scope.productes = [];      
    $scope.modalType = null;
            
    $scope.proveidors = [];
    $scope.families = [];
    $scope.subfamilies = [];
    
    this.$onInit = onInit();
    
    function onInit() {
        console.log("Productes controller initiatied!");
        LoadProductes();
    }
    
    function LoadProductes() {
        //add loader
        return productesService.getAllProductes(Auth.currentUser().organitzacio.id)
            .then(function (data) {
                console.log(data);
                $scope.productes = data;
            }).catch(function(response) {
                //notification of error
            }).finally(function() {
                //stop loader
            })        
    }
    
    
    function LoadProveidors() {
        return proveidorsService.getAllProveidors(Auth.currentUser().organitzacio.id)
            .then(function (data) {
                console.log(data);
                $scope.proveidors = data;
            }).catch(function(response) {
                //notification of error
            }).finally(function() {
                //stop loader
            })        
    }
    
    function LoadFamilies() {
        //add loader
        return productesService.getAllFamilies()
            .then(function (data) {
                console.log(data);
                $scope.families = data;
            }).catch(function(response) {
                //notification of error
            }).finally(function() {
                //stop loader
            })        
    }
    
    $scope.LoadSubFamilies = function(famId) {
        //add loader
        return productesService.getAllSubFamilies(famId)
            .then(function (data) {
                console.log(data);
                $scope.subfamilies = data;
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
        LoadFamilies();        
        LoadProveidors();
    }
    
    $scope.AddProducte = function(producte) {
        console.log(producte);
        
        return productesService.createProducte(producte)
            .then(function (response) {
                console.log(response);
                Notification.primary(response);
                $('#modalProducte').modal('hide');    
                $scope.ProducteCreation.$setPristine();
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
        LoadFamilies();        
        $scope.producte.familia = $scope.producte.subfamilia.familia;
        $scope.LoadSubFamilies($scope.producte.familia.id);
        LoadProveidors();
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