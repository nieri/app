(function () {
    'use strict';

    angular
        .module('desafio-cielo-web')
        .controller('LancamentoController', LancamentoController);

    LancamentoController.$inject = ['LancamentoService'];

    function LancamentoController(LancamentoService) {
        var vm = this;

        function init() {
            LancamentoService.buscarLancamentos().then(resp => {
                if (resp && resp.data) {
                vm.lancamentos = resp.data;
            }
        });
        }

        init();
    }

})();