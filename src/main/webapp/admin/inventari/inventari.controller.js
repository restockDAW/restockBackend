app.controller("inventariCtrl", function($scope, $http, $window, inventariService, Auth) {
        
    $scope.inventari = [];
        
    this.$onInit = onInit();
    
    function onInit() {
        console.log("Inventari controller initiatied!");
        LoadInventari();
    }
        
    function LoadInventari() {
        //add loader
        return inventariService.getInventari(Auth.currentUser().organitzacio)
            .then(function (data) {
                console.log(data);
                $scope.inventari = data;
            }).catch(function(response) {
                Notification.error(response);
                //notification of error
            }).finally(function() {
                //stop loader
            })        
    }
    
    
    
    
});