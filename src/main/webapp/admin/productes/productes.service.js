var baseURL = "http://localhost:8081/restock/usuari";

app.service("articlesService", ["$q", "$http", articlesService])

function articlesService($q, $http) {
    
    var service = {
        getAllArticles: getAllArticles, 
        createArticle: createArticle,
        updateArticle: updateArticle,
        deleteArticle: deleteArticle
    };
    
    return service;
    
    function getAllArticles() {
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
        
    function createArticle(article) {
        var deferred = $q.defer();
        $http({
            method: 'POST',
            data: "{article:" + angular.toJson(article) + "}",
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
    
    function updateArticle(article) {
        var deferred = $q.defer();
        $http({
            method: 'POST',
            data: "{article:" + angular.toJson(article) + "}",
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
    
    function deleteArticle(responsable) {
        var deferred = $q.defer();
        $http({
            method: 'POST',
            data: "{article:" + angular.toJson(article) + "}",
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