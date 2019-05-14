app.service("productesService", ["$q", "$http", productesService])

function productesService($q, $http) {
    
    var baseURL = "../producte";    
    var service = {
        getAllProductes:  getAllProductes, 
        getProductesOfProveedor: getProductesOfProveedor,
        createProducte: createProducte,
        updateProducte: updateProducte,
        deleteProducte: deleteProducte,
        getAllFamilies: getAllFamilies,
        getAllSubFamilies: getAllSubFamilies
    };
    
    return service;
    
    function getAllProductes(orgId) {
        var deferred = $q.defer();
        $http({
            method: 'POST',
            data: orgId,
            url: baseURL + '/getProductes',
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
    
    function getProductesOfProveedor(proveedor) {
        var deferred = $q.defer();
        $http({
            method: 'POST',
            data: angular.toJson(proveedor),
            url: baseURL + '/getProductesOfProveedor',
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
        
    function createProducte(producte) {
        var deferred = $q.defer();
        $http({
            method: 'POST',
            data: angular.toJson(producte),
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
        
    function updateProducte(producte) {
        var deferred = $q.defer();
        $http({
            method: 'POST',
            data: angular.toJson(producte),
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
    
    
    function deleteProducte(producte) {
        var deferred = $q.defer();
        $http({
            method: 'POST',
            data: angular.toJson(producte),
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
    function deleteProducte(producte) {
        var deferred = $q.defer();
        $http({
            method: 'POST',
            data: angular.toJson(producte),
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
    
    function getAllFamilies() {
        var deferred = $q.defer();
        $http({
            method: 'GET',
            url: baseURL + '/families',
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
    
    function getAllSubFamilies(famId) {
        var deferred = $q.defer();
        $http({
            method: 'GET',
            url: baseURL + '/subfamilia/' + famId,
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