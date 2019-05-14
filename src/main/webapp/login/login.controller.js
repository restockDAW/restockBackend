app.controller("LoginCtrl", function($scope, $http, $window, Notification, loginService, Auth) {
        
    this.$onInit = onInit();
    
    function onInit() {
        console.log("Login controller initiatied!");
        if(Auth.isLoggedIn()) {     
            
              console.log("Logged in");   
            
            redirectToRolePath();
            
              
        } else {
            
              console.log("NOT Logged in");   
        }
        
    }
        
    $scope.Login = function(username, password) {
        var credentials = {
            user:username,
            password: password
        }
        
        var usuari = {};
        
        return loginService.login(credentials)
            .then(function (usuari) {
            
            console.log(usuari);
            
            loginService.getBotiga(usuari).then(function(botiga) {
                usuari.botiga = botiga;                
            }).finally(function() {
                loginService.getOrganitzacio(usuari).then(function(organitzacio) {
                usuari.organitzacio = organitzacio;                
                }).finally(function() {
                    

                    Auth.login(usuari);
                    Auth.currentUser();

                    //redirect to user app - depending on role

                    redirectToRolePath();

                });
            });
            
            
            }).catch(function(response) {
                Notification.error(response);          
            }).finally(function() {
                //stop loader
            })       
    }
   
    
    function redirectToRolePath() {        
            if(Auth.currentUser().rol.descripcio == "ADMINISTRADOR") {
                $window.location.href = "./admin/taulell.html";                
            } else if(Auth.currentUser().rol.descripcio == "RESPONSABLE") {
                $window.location.href = "./responsable/taulell.html";                
            }
    }
    
});