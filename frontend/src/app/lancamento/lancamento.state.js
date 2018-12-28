(function () {
    'use strict';

    angular
        .module('desafio-cielo-web')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
            .state('lancamentos', {
                parent: 'app',
                url: '/',
                data: {
                    pageTitle: 'Lançamentos'
                },
                views: {
                    'content@': {
                        templateUrl: 'src/app/lancamento/lancamento.html',
                        controller: 'LancamentoController',
                        controllerAs: 'vm'
                    }
                },
            });
    }

})();