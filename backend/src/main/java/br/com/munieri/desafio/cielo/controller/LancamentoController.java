package br.com.munieri.desafio.cielo.controller;

import br.com.munieri.desafio.cielo.controller.dto.LancamentoDTO;
import br.com.munieri.desafio.cielo.service.LancamentoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class LancamentoController {

    @Autowired
    private LancamentoService lancamentoService;

    @GetMapping("/lancamentos")
    public ResponseEntity<List<LancamentoDTO>> getControleLancamento() {
        log.info("Listando lancamentos atuais.");
        return ResponseEntity.ok(lancamentoService.getControleLancamento());
    }
}
