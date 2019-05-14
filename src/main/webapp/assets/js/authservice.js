angular.module('AuthServices', ['ngStorage'])
.factory('Auth', function($rootScope, $sessionStorage, $q, $localStorage){
    
    var auth = {};
     
    /**
     *  Saves the current user in the root scope
     *  Call this in the app run() method
     */
    auth.init = function(){
        if (auth.isLoggedIn()){
            $rootScope.user = auth.currentUser();
        }
    };
         
    auth.login = function(user){
        $localStorage.user = user;    
        $rootScope.user = $localStorage.user;
    };
     
 
    auth.logout = function() {
        delete $localStorage.user;
        delete $rootScope.user;
    };
     
     
    auth.checkPermissionForView = function(view) {
        if (!view.requiresAuthentication) {
            return true;
        }
         
        return userHasPermissionForView(view);
    };
     
     
    var userHasPermissionForView = function(view){
        if(!auth.isLoggedIn()){
            return false;
        }
         
        if(!view.permissions || !view.permissions.length){
            return true;
        }
         
        return auth.userHasPermission(view.permissions);
    };
     
     
    auth.userHasPermission = function(permissions){
        if(!auth.isLoggedIn()){
            return false;
        }
         
        
        //funció pel futur - en cas de tenir varios permisos per usuari
        /*var found = false;
        angular.forEach(permissions, function(permission, index){
            if ($localStorage.user.permissions.indexOf(permission) >= 0){
                found = true;
                return;
            }                        
        });
         */
        
        //funció per un usuari un rol
        if(permissions.indexOf($localStorage.user.rol.descripcio) >= 0) {
           return true;
        }
        return false;
    };
     
     
    auth.currentUser = function(){
        return $localStorage.user;
    };
     
     
    auth.isLoggedIn = function(){
        return $localStorage.user != null;
    };
     
 
    return auth;
});