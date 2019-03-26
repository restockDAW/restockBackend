app.controller("botiguesCtrl", function($scope, $http, $window, botiguesService) {
        
    $scope.botiga = {};
    $scope.botigues = [];
        
    this.$onInit = onInit();
    
    function onInit() {
        console.log("Botigues controller initiatied!");
        //LoadResponsables(); 
    }
        
    
});