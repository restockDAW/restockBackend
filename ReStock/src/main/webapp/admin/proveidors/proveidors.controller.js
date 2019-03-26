app.controller("proveidorsCtrl", function($scope, $http, $window) {
        
    $scope.proveidor = {};
    $scope.proveidors = [];
        
    this.$onInit = onInit();
    
    function onInit() {
        console.log("Proveidors controller initiatied!");
    }
        
    $scope.AddProveidor = function(proveidor) {
        console.log(proveidor);
        $scope.proveidors.push(proveidor);
        $('#modalNewProveidor').modal('hide');    
        $scope.proveidor = {};
        $scope.ProveidorCreation.$setPristine();
    }
    
});