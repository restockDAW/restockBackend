app.service("responsablesService", ["$q", "$http", responsablesService])
function responsablesService($q, $http) {
    
    var baseURL = "../usuari";    
    var service = {
        getAllResponsables: getAllResponsables, 
        createResponsable: createResponsable,
        updateResponsable: updateResponsable,
        deleteResponsable: deleteResponsable
    };
    
    return service;
    
    function getAllResponsables() {
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
        
    function createResponsable(responsable) {                
        var deferred = $q.defer();
        $http({
            method: 'POST',
            data: angular.toJson(responsable),
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
    
    function updateResponsable(responsable) {
        var deferred = $q.defer();
        $http({
            method: 'POST',
            data: angular.toJson(responsable),
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
    
    function deleteResponsable(responsable) {
        var deferred = $q.defer();
        $http({
            method: 'POST',
            data: angular.toJson(responsable),
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