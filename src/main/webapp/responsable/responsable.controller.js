app.controller("PageController", function ($scope, $http, $window,$rootScope, $location, Auth) {
   
    console.log("PageController initialized");
    
    $scope.Pages = [
        {icon: "fas fa-layer-group", name:"Inventari", url:"#!inventari"},
        {icon: "fas fa-shopping-basket", name:"Comandes", url:"#!comandes"},
        {icon: "fas fa-file", name:"Informes", url:"#!informes"}
    ]
               
    this.$onInit = onInit();
    
    function onInit() {
            $('#menuCollapse').on('click', function () {
                $('#sidebar').toggleClass('active');
            });
        
    }
           
      $rootScope.logout = function(){
        Auth.logout();
                $window.location.href = "../";
      };
    
});

