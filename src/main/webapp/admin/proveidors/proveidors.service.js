app.service("proveidorsService", ["$q", "$http", proveidorsService])
function proveidorsService($q, $http) {
    
    var baseURL = "../proveidor";    
    var service = {
        getAllProveidors: getAllProveidors, 
        createProveidor: createProveidor,
        updateProveidor: updateProveidor,
        deleteProveidor: deleteProveidor
    };
    
    return service;
    
    function getAllProveidors(orgId) {
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
        
    function createProveidor(proveidor) {                
        var deferred = $q.defer();
        $http({
            method: 'POST',
            data: angular.toJson(proveidor),
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
    
    function updateProveidor(proveidor) {
        var deferred = $q.defer();
        $http({
            method: 'POST',
            data: angular.toJson(proveidor),
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
    
    function deleteProveidor(proveidor) {
        var deferred = $q.defer();
        $http({
            method: 'POST',
            data: angular.toJson(proveidor),
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