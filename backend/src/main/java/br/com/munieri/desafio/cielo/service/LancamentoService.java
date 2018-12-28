package br.com.munieri.desafio.cielo.service;

import br.com.munieri.desafio.cielo.controller.dto.LancamentoDTO;

import java.util.List;

public interface LancamentoService {

    List<LancamentoDTO> getControleLancamento();
}
