var baseURL = "http://localhost:8081/restock/usuari";

app.service("comandesService", ["$q", "$http", comandesService])

function comandesService($q, $http) {
    
    var service = {
        getAllComandes: getAllComandes, 
        createComandes: createComandes,
        updateComandes: updateComandes,
        deleteComandes: deleteComandes
    };
    
    return service;
    
    function getAllComandes() {
        var deferred = $q.defer();
        $http({
            method: "GET",
            url: baseURL + '/getAll',
            dataType: "json",
            contentType: 'application/json',
            timeout: 120000
        }).then(function (response) {
            deferred.resolve(angular.fromJson(response.data));
        }, function (error) {
            deferred.reject(error);
        });
        return deferred.promise;
    }
        
    function createComandes(comanda) {
        var deferred = $q.defer();
        $http({
            method: 'POST',
            data: "{comanda:" + angular.toJson(comanda) + "}",
            url: baseURL + '/alta',
            dataType: "json",
            contentType: 'application/json',
            timeout: 120000
        }).then(function (response) {
            deferred.resolve(angular.fromJson(response.data.d));
        }, function (error) {
            deferred.reject(error);
        });
        return deferred.promise;
    }
    
    function updateComandes(comanda) {
        var deferred = $q.defer();
        $http({
            method: 'POST',
            data: "{comanda:" + angular.toJson(comanda) + "}",
            url: baseURL + '/modificacio',
            dataType: "json",
            contentType: 'application/json',
            timeout: 120000
        }).then(function (response) {
            deferred.resolve(angular.fromJson(response.data.d));
        }, function (error) {
            deferred.reject(error);
        });
        return deferred.promise;
    }
    
    function deleteComandes(comanda) {
        var deferred = $q.defer();
        $http({
            method: 'POST',
            data: "{comanda:" + angular.toJson(comanda) + "}",
            url: baseURL + '/baixa',
            dataType: "json",
            contentType: 'application/json',
            timeout: 120000
        }).then(function (response) {
            deferred.resolve(angular.fromJson(response.data.d));
        }, function (error) {
            deferred.reject(error);
        });
        return deferred.promise;
    }
}