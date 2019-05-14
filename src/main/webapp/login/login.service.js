app.service("loginService", ["$q", "$http", loginService])
function loginService($q, $http) {
    
    var baseURL = "./loginUser";    
    var service = {
        login: login,getBotiga: getBotiga,
        getOrganitzacio: getOrganitzacio        
    };
    
    return service;
    
    function login(credentials) {
        var deferred = $q.defer();
        $http({
            method: 'POST',
            data: angular.toJson(credentials),
            url: baseURL,
            dataType: "json",
            contentType: 'application/json',
            timeout: 120000,
            transformResponse: undefined
        }).then(function (response) {
            deferred.resolve(angular.fromJson(response.data));
        }, function (response) {
            deferred.reject(response.data);
        });
        return deferred.promise;
    }
    
    function getBotiga(usuari) {
        var deferred = $q.defer();
        $http({
            method: 'POST',
            data: angular.toJson(usuari),
            url: baseURL + '/getBotiga',
            dataType: "json",
            contentType: 'application/json',
            timeout: 120000
        }).then(function (response) {
            try {
                deferred.resolve(angular.fromJson(response.data));                
            } catch(err) {
                deferred.resolve(null);
            }
        }, function (error) {
            deferred.reject(error);
        });
        return deferred.promise;
    }
    
    function getOrganitzacio(usuari) {
        var deferred = $q.defer();
        $http({
            method: 'POST',
            data: angular.toJson(usuari),
            url: baseURL + '/getOrganitzacio',
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
}