app.controller("PageController", function ($scope, $http, $window) {
   
    console.log("PageController initialized");
    
    $scope.Pages = [
        {icon: "fas fa-chart-bar", name:"Taulell", url: "#/!"},
        {icon: "fas fa-layer-group", name:"Inventari", url:"#!inventari"},
        {icon: "fas fa-shopping-basket", name:"Comandes", url:"#!comandes"},
        {icon: "fas fa-store", name:"Botigues", url:"#!botigues"},
        {icon: "fas fa-tags", name:"Productes", url:"#!productes"},
        {icon: "fas fa-user-tie", name:"Responsables", url:"#!responsables"},
        {icon: "fas fa-user-tag", name:"Proveïdors", url:"#!proveidors"},
        {icon: "fas fa-file", name:"Informes", url:"#!informes"}
    ]
               
          /*     
    $scope.Pages = [
        {icon: "fas fa-chart-bar", name:"Taulell", url: "Dashboard.html"},
        {icon: "fas-fa-layer-group", name:"Inventari", url:"inventari/inventari.html"},
        {icon: "fas fa-shopping-basket", name:"Comandes", url:"comandes/comandes.html"},
        {icon: "fas fa-store", name:"Botigues", url:"botigues/botigues.html"},
        {icon: "fas fa-cubes", name:"Articles", url:"articles/articles.html"},
        {icon: "fas fa-user-tie", name:"Responsables", url:"resposanbles/responsables.html"},
        {icon: "fas fa-user-tag", name:"Proveïdors", url:"proveidors/proveidors.html"},
        {icon: "fas fa-paper-plane", name:"Contactar", url:"contactar/contactar.html"}
    ]
               
               
               */
            
    this.$onInit = onInit();
    
    function onInit() {
            $('#menuCollapse').on('click', function () {
                $('#sidebar').toggleClass('active');
            });
    }
           
});