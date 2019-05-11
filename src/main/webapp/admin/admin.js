var app = angular.module('AdminDashboard',['ngRoute','ui-notification', 'AuthServices']);

//route configuration
app.config(function($routeProvider) {
  $routeProvider
  .when("/", {
      templateUrl : "dashboard/dashboard.html",
      controller: "dashboardCtrl",
      requiresAuthentication: true,
      permissions: ["ADMINISTRADOR"]
  })
  .when("/dashboard", {
    templateUrl : "dashboard/dashboard.html",
      controller: "dashboardCtrl",
      requiresAuthentication: true,
      permissions: ["ADMINISTRADOR"]
  })
  .when("/inventari", {
    templateUrl : "inventari/inventari.html",
      controller: "inventariCtrl",
      requiresAuthentication: true,
      permissions: ["ADMINISTRADOR"]
  })
  .when("/comandes", {
    templateUrl : "comandes/comandes.html",
      controller: "comandesCtrl",
      requiresAuthentication: true,
      permissions: ["ADMINISTRADOR"]
  })
  .when("/botigues", {
    templateUrl : "botigues/botigues.html",
      controller: "botiguesCtrl",   
      requiresAuthentication: true,
      permissions: ["ADMINISTRADOR"]
  })
  .when("/productes", {
    templateUrl : "productes/productes.html",
      controller: "productesCtrl",
      requiresAuthentication: true,
      permissions: ["ADMINISTRADOR"]
  })
  .when("/responsables", {
    templateUrl : "responsables/responsables.html",
      controller: "responsablesCtrl",
      requiresAuthentication: true,
      permissions: ["ADMINISTRADOR"]
  })
  .when("/proveidors", {
    templateUrl : "proveidors/proveidors.html",
      controller: "proveidorsCtrl",
      requiresAuthentication: true,
      permissions: ["ADMINISTRADOR"]
  })
  .when("/informes", {
    templateUrl : "informes/informes.html",
      controller: "informesCtrl",
      requiresAuthentication: true,
      permissions: ["ADMINISTRADOR"]
  })
  .when("/profile", {
      templateUrl : "profile/profile.html",
      controller: "profileCtrl",
      requiresAuthentication: true,
      permissions: ["ADMINISTRADOR"]
  })
  .when("/organization", {
      templateUrl : "organization/organization.html",
      controller: "organizationCtrl",
      requiresAuthentication: true,
      permissions: ["ADMINISTRADOR"]
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
