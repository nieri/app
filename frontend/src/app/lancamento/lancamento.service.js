(function () {
    'use strict';

    angular
        .module('desafio-cielo-web')
        .service('LancamentoService', LancamentoService);

    LancamentoService.$inject = ['$http'];

    function LancamentoService($http) {

        const host = 'http://127.0.0.1:8080/';

        return {

            buscarLancamentos() {
                return $http({
                    url: host + 'api/lancamentos',
                    method: 'GET'
                });
            }
        }
    }

})();