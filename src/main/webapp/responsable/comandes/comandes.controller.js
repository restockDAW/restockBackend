app.controller("ResponsableComandesCtrl", function($scope, $http, $window, Notification, comandesService, inventariService, Auth) {
        
    $scope.comanda = {};
    $scope.comandes = [];
    $scope.modalType = null;
        
    $scope.producteToAdd = {
        producte: null,
        quantitat: 0
    };    
    $scope.productesList = [];
    
    $scope.proveidors = [];
    $scope.productes = [];

    
    
    this.$onInit = onInit();
    
    function onInit() {
        console.log("Comandes controller initiatied!");
        LoadComandes();
    }

    
    
    function LoadComandes() {
        //add loader
        return comandesService.getAllComandes(Auth.currentUser().botiga)
            .then(function (data) {
                console.log(data);
                $scope.comandes = data;
            }).catch(function(response) {
                Notification.error(response);
                $scope.comandes = [];
                
                //notification of error
            }).finally(function() {
                //stop loader
            })        
    }
    
    /* Netejem la botiga quan es tanqui el modal */
    $("#modalComanda").on('hidden.bs.modal', function(){
        $scope.comanda = {};
        //aprofitem per netejar el tipus de modal
        $scope.modalType = null;
        $scope.$apply();
    });
    
    $scope.OpenAddComandaModal = function() {
        $scope.comanda.botiga = Auth.currentUser().botiga;
        $scope.modalType = "alta";
        $('#modalComanda').modal('show');   
        LoadProveidors();
    }
    
    $scope.AddComanda = function(comanda) {
        console.log(comanda);        
        
        var comandaAlta = {
            botiga: comanda.botiga,
            detallComandaList: $scope.productesList
        }
        
        console.log(comandaAlta);
        
        
        return comandesService.createComanda(comandaAlta)
            .then(function (response) {
                console.log(response);
                Notification.primary(response);
                $('#modalComanda').modal('hide');    
                $scope.ComandaCreation.$setPristine();
                
                $scope.producteToAdd = {
                    producte: null,
                    quantitat: 0
                };    
                $scope.productesList = [];

                $scope.proveidors = [];
                $scope.productes = [];

            
                LoadComandes();
            }).catch(function(response) {
                Notification.error(response);
            }).finally(function() {
                //stop loader
            })       
        
        
    }
        
    $scope.resetProductes = function() {
        $scope.comanda.productes = [];
        $scope.productesList = [];
        LoadProductes();
    }
    
    $scope.AddProducteToList = function() {
        $scope.productesList.push($scope.producteToAdd);

        $scope.producteToAdd = {
            producte: null,
            quantitat: 0
        };    
    
        console.log($scope.productesList);
    }

    $scope.deleteProducte = function($index) {
        $scope.productesList.splice($index, 1);
        
    }
    
    
    $scope.OpenEditComandaModal = function(comanda) {
        
        return comandesService.getDetallComanda(comanda)
            .then(function (response) {
                $scope.modalType = "modificacio";
                $scope.comanda = angular.copy(comanda);
                $scope.productesList = response;
                $('#modalComanda').modal('show');    
                
                LoadProveidors();
                LoadProductes();
            
            }).catch(function(response) {
                Notification.error(response);
            }).finally(function() {
                //stop loader
            })      
           
    }
    
    $scope.UpdateComanda = function(comanda) {
         console.log(comanda);        
        
        var comandaAlta = {
            botiga: comanda.botiga,
            detallComandaList: $scope.productesList
        }
        
        console.log(comandaAlta);
        
        
        return comandesService.updateComanda(comandaAlta)
            .then(function (response) {
                console.log(response);
                Notification.primary(response);
                $('#modalComanda').modal('hide');    
                $scope.ComandaCreation.$setPristine();
                
                $scope.producteToAdd = {
                    producte: null,
                    quantitat: 0
                };    
                $scope.productesList = [];

                $scope.proveidors = [];
                $scope.productes = [];


            }).catch(function(response) {
                Notification.error(response);
            }).finally(function() {            
                LoadComandes();
                //stop loader
            })       
        
        
    }
        
    
    $scope.OpenDeleteComandaModal = function(comanda) {
        
        return comandesService.getDetallComanda(comanda)
            .then(function (response) {
                $scope.comanda = comanda;
                $scope.comanda.detallComandaList = response;
                $('#modalDeleteComanda').modal('show');  
            }).catch(function(response) {
                Notification.error(response);
            }).finally(function() {
                //stop loader
            })      
          
    }
    
    $scope.ConfirmDelete = function(comanda) {         
        return comandesService.deleteComanda(comanda)
            .then(function (response) {
                console.log(response);
                Notification.primary(response);
                $('#modalDeleteComanda').modal('hide');   
                LoadComandes();
            }).catch(function(response) {
                Notification.error(response);
            }).finally(function() {
                //stop loader
            })       
    }
    
    
    $scope.OpenUpdateComandaToInventariModal = function(comanda) {
        
        return comandesService.getDetallComanda(comanda)
            .then(function (response) {
                $scope.comanda = comanda;
                $scope.comanda.detallComandaList = response;
                $('#modalUpdateToInventari').modal('show');  
            }).catch(function(response) {
                Notification.error(response);
            }).finally(function() {
                //stop loader
            })      
          
    }
    
    $scope.ConfirmUpdateToInventari = function(comanda) {
        console.log(comanda);         
        
        return inventariService.updateInventari(comanda)
            .then(function (response) {
                Notification.primary("Comanda realitzada - inventari actualitzat!");
                $('#modalUpdateToInventari').modal('hide');    
            }).catch(function(response) {
                Notification.error(response);
            }).finally(function() {
                LoadComandes();
                //stop loader
            })       
        
    }
    
    
    //Auxiliar
    
    function LoadProductes() {
        //add loader
        return comandesService.getProductesOfProveedor($scope.comanda.proveidor)
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
        return comandesService.getAllProveidors(Auth.currentUser().botiga.organitzacio.id)
            .then(function (data) {
                console.log(data);
                $scope.proveidors = data;
            }).catch(function(response) {
                //notification of error
            }).finally(function() {
                //stop loader
            })        
    }
    
    
});