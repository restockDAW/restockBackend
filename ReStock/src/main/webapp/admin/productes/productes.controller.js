app.controller("productesCtrl", function($scope, $http, $window) {
        
    $scope.producte = {};
    $scope.productes = [];
        
    this.$onInit = onInit();
    
    function onInit() {
        console.log("Productes controller initiatied!");
    }
        
    
    
    
});