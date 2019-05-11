app.controller("comandesCtrl", function($scope, $http, $window, comandesService) {
        
    $scope.responsable = {};
    $scope.responsables = [];
        
    this.$onInit = onInit();
    
    function onInit() {
        console.log("Comandes controller initiatied!");
        //LoadResponsables(); 
    }
        
    
    
});