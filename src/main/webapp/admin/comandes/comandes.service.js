app.service("comandesService", ["$q", "$http", comandesService])

function comandesService($q, $http) {
    
    var baseURL = "../comanda";    
    var service = {
        getAllComandes: getAllComandes, 
        getDetallComanda: getDetallComanda, 
        createComanda: createComanda,
        updateComanda: updateComanda,
        deleteComanda: deleteComanda
    };
    
    return service;
    
    function getAllComandes(organitzacio) {
        var deferred = $q.defer();
        $http({
            method: "POST",
            data: angular.toJson(organitzacio),
            url: baseURL + '/cercarPendentsPerOrganitzacio',
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
    
    function getDetallComanda(comanda) {
        var deferred = $q.defer();
        $http({
            method: 'POST',
            data: angular.toJson(comanda),
            url: baseURL + '/veureDetallComanda',
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
        
    function createComanda(comanda) {
        var deferred = $q.defer();
        $http({
            method: 'POST',
            data: angular.toJson(comanda),
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
    
    function updateComanda(comanda) {
        var deferred = $q.defer();
        $http({
            method: 'POST',
            data: angular.toJson(comanda),
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
    
    function deleteComanda(comanda) {
        var deferred = $q.defer();
        $http({
            method: 'POST',
            data: angular.toJson(comanda),
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