var app = angular.module("RestockApp",  ['ngRoute','ui-notification', 'AuthServices']);

//route configuration
app.config(function($routeProvider) {
  $routeProvider
  .when("/", {
      templateUrl : "landing/landing.html",
      controller: "LandingCtrl"
  })
  .when("/landing/", {
      templateUrl : "landing/landing.html",
      controller: "LandingCtrl"
  })
  .when("/login/", {
    templateUrl : "login/login.html",
      controller: "LoginCtrl"
  })
  .when("/register/", {
    templateUrl : "register/register.html",
      controller: "RegisterCtrl"
  })
    
  .otherwise({ redirectTo: '/' });
});


app.controller("MainCtrl", function ($scope, $http, $window,$rootScope, $location, Auth) {
   
    console.log("Main Controller initialized");
               
    console.log(Auth.currentUser());
    
});


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