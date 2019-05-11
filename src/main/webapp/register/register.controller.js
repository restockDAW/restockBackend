app.controller("RegisterCtrl", function($scope, $http, $window, Notification, registerService, loginService, Auth) {
        
    
    $scope.organitzacio = {};
    $scope.usuari = {};
    
    this.$onInit = onInit();
    
    function onInit() {
        console.log("Register controller initiatied!");
    }
        
    $scope.Register = function() {
                    
        //normalitzem la data i assignem el rol d'administrador a l'usuari que és dona d'alta
        $scope.usuari.dataNaixement = moment($scope.usuari.dataNaixement).format('DD/MM/YYYY');
        $scope.usuari.rol = 1;
        
        $scope.organitzacio.usuari = $scope.usuari;        
        
        return registerService.register($scope.organitzacio)
            .then(function (response) {
            console.log(response);
            var credentials = {
            user:$scope.usuari.user,
            password: $scope.usuari.password
        }
            loginService.login(credentials).then(function (response) {

                //Auth l'usuari i redirect a admin
                Auth.login(response);
                $window.location.href = "./admin/taulell.html";   
            })
            
                         
            
            }).catch(function(response) {
                Notification.error(response);          
            }).finally(function() {
                //stop loader
            })     
        
    }
    
    
});