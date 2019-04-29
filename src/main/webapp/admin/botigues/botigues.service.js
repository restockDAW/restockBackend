app.service("botiguesService", ["$q", "$http", botiguesService])

function botiguesService($q, $http) {
    
    var baseURL = "../botiga";    
    var service = {
        getAllBotigues: getAllBotigues, 
        createBotiga: createBotiga,
        updateBotiga: updateBotiga,
        updateResponsableBotiga: updateResponsableBotiga,
        deleteBotiga: deleteBotiga
    };
    
    return service;
    
    function getAllBotigues(orgId) {
        var deferred = $q.defer();
        $http({
            method: 'POST',
            data: orgId,
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
            data: angular.toJson(botiga),
            url: baseURL + '/alta',
            dataType: "json",
            contentType: 'application/json',
            timeout: 120000,
            transformResponse: undefined
        }).then(function (response) {
            deferred.resolve(response.data);
        }, function (response) {
            deferred.reject(response.data);
        });
        return deferred.promise;
    }
    
    function updateBotiga(botiga) {
        var deferred = $q.defer();
        $http({
            method: 'POST',
            data: angular.toJson(botiga),
            url: baseURL + '/modificacio',
            dataType: "json",
            contentType: 'application/json',
            timeout: 120000,
            transformResponse: undefined
        }).then(function (response) {
            deferred.resolve(response.data);
        }, function (response) {
            deferred.reject(response.data);
        });
        return deferred.promise;
    }
    
    function updateResponsableBotiga(botiga) {
        var deferred = $q.defer();
        $http({
            method: 'POST',
            data: angular.toJson(botiga),
            url: baseURL + '/modificacioResponsable',
            dataType: "json",
            contentType: 'application/json',
            timeout: 120000,
            transformResponse: undefined
        }).then(function (response) {
            deferred.resolve(response.data);
        }, function (response) {
            deferred.reject(response.data);
        });
        return deferred.promise;
    }
    
    function deleteBotiga(botiga) {
        var deferred = $q.defer();
        $http({
            method: 'POST',
            data: angular.toJson(botiga),
            url: baseURL + '/baixa',
            dataType: "json",
            contentType: 'application/json',
            timeout: 120000,
            transformResponse: undefined
        }).then(function (response) {
            deferred.resolve(response.data);
        }, function (response) {
            deferred.reject(response.data);
        });
        return deferred.promise;
    }
}