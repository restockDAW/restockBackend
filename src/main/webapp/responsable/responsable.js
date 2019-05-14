var app = angular.module('ResponsableApp', ['ngRoute','ui-notification', 'AuthServices']);

//route configuration
app.config(function($routeProvider) {
  $routeProvider
  .when("/", {
      templateUrl : "inventari/inventari.html",
      controller: "ResponsableInventariCtrl",
      requiresAuthentication: true,
      permissions: ["RESPONSABLE"]
  })
  .when("/inventari/", {
    templateUrl : "inventari/inventari.html",
      controller: "ResponsableInventariCtrl",
      requiresAuthentication: true,
      permissions: ["RESPONSABLE"]
  })
  .when("/comandes/", {
    templateUrl : "comandes/comandes.html",
      controller: "ResponsableComandesCtrl",
      requiresAuthentication: true,
      permissions: ["RESPONSABLE"]
  })
  .when("/informes/", {
    templateUrl : "informes/informes.html",
      controller: "ResponsableInformesCtrl",
      requiresAuthentication: true,
      permissions: ["RESPONSABLE"]
  })
  .when("/perfil/", {
    templateUrl : "./common/profile.html",
      controller: "botiguesCtrl",     
  })
    
  .otherwise({ redirectTo: '/' });
});

app.run(['$rootScope', '$location', 'Auth', '$window', function ($rootScope, $location, Auth, $window) {
    Auth.init();
     
    $rootScope.$on('$routeChangeStart', function (event, next) {
        if (!Auth.checkPermissionForView(next)){
            event.preventDefault();
                $window.location.href = "../";
        }
    });
  }]);

app.directive('permission', ['Auth', function(Auth) {
   return {
       restrict: 'A',
       scope: {
          permission: '='
       },
 
       link: function (scope, elem, attrs) {
            scope.$watch(Auth.isLoggedIn, function() {
                if (Auth.userHasPermission(scope.permission)) {
                    elem.show();
                } else {
                    elem.hide();
                }
            });                
       }
   }
}]);
