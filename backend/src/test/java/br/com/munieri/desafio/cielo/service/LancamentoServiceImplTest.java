package br.com.munieri.desafio.cielo.service;

import br.com.munieri.desafio.cielo.controller.dto.LancamentoDTO;
import br.com.munieri.desafio.cielo.repository.LancamentoRepository;
import br.com.munieri.desafio.cielo.repository.entity.LancamentoEtity;
import br.com.munieri.desafio.cielo.util.MockUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.List;

import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class LancamentoServiceImplTest {

    @Mock
    private LancamentoRepository repository;

    @InjectMocks
    private LancamentoServiceImpl lancamentoService;

    @Test
    public void deve_buscar_lancamentos_sem_fonte_de_dados() {
        when(repository.buscarLancamento()).thenReturn(null);
        List<LancamentoDTO> lancamentos = lancamentoService.getControleLancamento();
        Assert.assertNotNull(lancamentos);
        Assert.assertTrue(lancamentos.isEmpty());
    }

    @Test
    public void deve_buscar_lancamentos_com_sucesso() throws IOException {
        LancamentoEtity lancamento = MockUtil.getJsonMock("static/lancamento-conta-legado.json", LancamentoEtity.class);
        when(repository.buscarLancamento()).thenReturn(lancamento);
        List<LancamentoDTO> lancamentos = lancamentoService.getControleLancamento();
        Assert.assertNotNull(lancamentos);
        Assert.assertFalse(lancamentos.isEmpty());
        Assert.assertEquals(2, lancamentos.size());
    }
}