app.service("loginService", ["$q", "$http", loginService])
function loginService($q, $http) {
    
    var baseURL = "./loginUser";    
    var service = {
        login: login
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
}