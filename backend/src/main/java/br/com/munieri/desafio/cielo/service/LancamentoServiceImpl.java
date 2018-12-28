package br.com.munieri.desafio.cielo.service;

import br.com.munieri.desafio.cielo.controller.dto.LancamentoDTO;
import br.com.munieri.desafio.cielo.repository.LancamentoRepository;
import br.com.munieri.desafio.cielo.repository.entity.LancamentoEtity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class LancamentoServiceImpl implements LancamentoService {

    @Autowired
    private LancamentoRepository repository;

    @Override
    public List<LancamentoDTO> getControleLancamento() {
        LancamentoEtity lancamento = repository.buscarLancamento();
        if (lancamento == null) {
            log.warn("Nao foi possivel obter os lancamentos.");
            return Collections.emptyList();
        }
        return Stream.of(lancamento.listaControleLancamento)
                .map(LancamentoDTO::new)
                .collect(Collectors.toList());
    }
}
