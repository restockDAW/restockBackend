var baseURL = "http://localhost:8081/restock/usuari";

app.service("botiguesService", ["$q", "$http", botiguesService])

function botiguesService($q, $http) {
    
    var service = {
        getAllBotigues: getAllBotigues, 
        createBotiga: createBotiga,
        updateBotiga: updateBotiga,
        deleteBotiga: deleteBotiga
    };
    
    return service;
    
    function getAllBotigues() {
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
        
    function createBotiga(botiga) {
        var deferred = $q.defer();
        $http({
            method: 'POST',
            data: "{botiga:" + angular.toJson(botiga) + "}",
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
    
    function updateBotiga(responsable) {
        var deferred = $q.defer();
        $http({
            method: 'POST',
            data: "{botiga:" + angular.toJson(botiga) + "}",
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
    
    function deleteBotiga(responsable) {
        var deferred = $q.defer();
        $http({
            method: 'POST',
            data: "{botiga:" + angular.toJson(botiga) + "}",
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