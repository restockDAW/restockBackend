app.controller("LandingCtrl", function($scope, $http, $window, Notification, Auth) {
        
    this.$onInit = onInit();
    
    function onInit() {
        Auth.currentUser();
        console.log("Landing controller initiatied!");
    }
        
    
});