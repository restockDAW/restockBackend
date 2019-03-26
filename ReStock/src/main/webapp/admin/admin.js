var app = angular.module('AdminDashboard', ['ngRoute','ui-notification']);

//route configuration
app.config(function($routeProvider) {
  $routeProvider
  .when("/", {
      templateUrl : "dashboard/dashboard.html",
      controller: "dashboardCtrl"
  })
  .when("/dashboard", {
    templateUrl : "dashboard/dashboard.html",
      controller: "dashboardCtrl"
  })
  .when("/inventari", {
    templateUrl : "inventari/inventari.html",
      controller: "inventariCtrl"
  })
  .when("/comandes", {
    templateUrl : "comandes/comandes.html",
      controller: "comandesCtrl"
  })
  .when("/botigues", {
    templateUrl : "botigues/botigues.html",
      controller: "botiguesCtrl"
  })
  .when("/productes", {
    templateUrl : "productes/productes.html",
      controller: "productesCtrl"
  })
  .when("/responsables", {
    templateUrl : "responsables/responsables.html",
      controller: "responsablesCtrl"
  })
  .when("/proveidors", {
    templateUrl : "proveidors/proveidors.html",
      controller: "proveidorsCtrl"
  })
  .when("/informes", {
    templateUrl : "informes/informes.html",
      controller: "informesCtrl"
  })
  .when("/profile", {
      templateUrl : "profile/profile.html",
      controller: "profileCtrl"
  })
  .when("/organization", {
      templateUrl : "organization/organization.html",
      controller: "organizationCtrl"
  });
});
