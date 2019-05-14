app.controller("PageController", function ($scope, $http, $window, $rootScope, $location, Auth, Notification) {

    console.log("PageController initialized");

    $scope.Pages = [
        {
            icon: "fas fa-layer-group",
            name: "Inventari",
            url: "#!inventari"
        },
        {
            icon: "fas fa-shopping-basket",
            name: "Comandes",
            url: "#!comandes"
        },
        {
            icon: "fas fa-file",
            name: "Informes",
            url: "#!informes"
        }
    ]

    this.$onInit = onInit();

    function onInit() {
        $('#menuCollapse').on('click', function () {
            $('#sidebar').toggleClass('active');
        });

    }
    
    $scope.exportToExcel = function(tableId, nomInforme) {        
        var fileName = 'Informe' + nomInforme + '_' + Auth.currentUser().botiga.nom + '_' + moment().format("DD-MM-YYYY") + "_Setmana_" + moment().isoWeek();
        alasql("SELECT * INTO XLSX('" + fileName + ".xlsx',{headers:true}) \
                    FROM HTML('" + tableId + "',{headers:true})");
        Notification.primary("Informe Excel exportat!");
    }
    
    $scope.exportToCsv = function(tableId, nomInforme) {                 
        var fileName = 'Informe' + nomInforme + '_' + Auth.currentUser().botiga.nom + '_' + moment().format("DD-MM-YYYY") + "_Setmana_" + moment().isoWeek() + '.csv';
		$(tableId).tableHTMLExport({
		  type:'csv',
		  filename:fileName
		});
        Notification.primary("Informe CSV exportat!");
    }
    
    $scope.exportToPdf = function(tableId, nomInforme) {        
        var fileName = 'Informe' + nomInforme + '_' + Auth.currentUser().botiga.nom + '_' + moment().format("DD-MM-YYYY") + "_Setmana_" + moment().isoWeek();
		$(tableId).tableHTMLExport({
		  type:'pdf',
		  filename:fileName
		});
        Notification.primary("Informe PDF exportat!");
    }
    
    
    

    $rootScope.logout = function () {
        Auth.logout();
        $window.location.href = "../";
    };




});
