package br.com.munieri.desafio.cielo.repository;

import br.com.munieri.desafio.cielo.repository.entity.LancamentoEtity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Repository
public class LancamentoRepositoryImpl implements LancamentoRepository {

    final String URI = "http://localhost:3001/lancamentos";

    @Override
    public LancamentoEtity buscarLancamento() {

        RestTemplate restTemplate = new RestTemplate();
        LancamentoEtity entity = restTemplate.getForObject(URI, LancamentoEtity.class);
        return entity;
    }
}
