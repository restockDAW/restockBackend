app.service("registerService", ["$q", "$http", registerService])
function registerService($q, $http) {
    
    var baseURL = "./organitzacio";    
    var service = {
        register: register
    };
    
    return service;
    
    function register(organitzacio) {
        var deferred = $q.defer();
        $http({
            method: 'POST',
            data: angular.toJson(organitzacio),
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
}