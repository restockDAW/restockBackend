app.service("inventariService", ["$q", "$http", inventariService])

function inventariService($q, $http) {
    
    var baseURL = "../inventari";    
    var service = {
        getInventari: getInventari, 
        updateInventari: updateInventari
    };
    
    return service;
 
    
    
    function getInventari(botiga) {
        var deferred = $q.defer();
        $http({
            method: 'POST',
            data: angular.toJson(botiga),
            url: baseURL + '/cercarPerBotiga',
            dataType: "json",
            contentType: 'application/json',
            timeout: 120000,
            transformResponse: undefined
        }).then(function (response) {
            deferred.resolve(angular.fromJson(response.data));
        }, function (error) {
            deferred.reject(error);
        });
        return deferred.promise;
    }
    function updateInventari(comanda) {
        var deferred = $q.defer();
        $http({
            method: 'POST',
            data: angular.toJson(comanda),
            url: baseURL + '/actualitzarInventari',
            dataType: "json",
            contentType: 'application/json',
            timeout: 120000,
            transformResponse: undefined
        }).then(function (response) {
            deferred.resolve(response.data);
        }, function (error) {
            deferred.reject(error);
        });
        return deferred.promise;
    }
    
}