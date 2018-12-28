package br.com.munieri.desafio.cielo.controller.dto;

import br.com.munieri.desafio.cielo.repository.entity.LancamentoEtity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.TimeZone;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LancamentoDTO implements Serializable {

    private LocalDateTime dataLancamento;

    private String descricao;

    private long numero;

    private String situacao;

    private LocalDateTime dataConfirmacao;

    private String dadosBancarios;

    private double valorFinal;

    public LancamentoDTO(LancamentoEtity.ListaControleLancamento lancamento) {
        ZoneId zoneId = TimeZone.getDefault().toZoneId();

        this.dataLancamento = LocalDateTime.ofInstant(
                Instant.ofEpochMilli(lancamento.dateLancamentoContaCorrenteCliente), zoneId);

        LancamentoEtity.ListaControleLancamento.LancamentoContaCorrenteCliente contaCorrente =
                lancamento.lancamentoContaCorrenteCliente;
        this.descricao = contaCorrente.nomeTipoOperacao;

        this.numero = contaCorrente.numeroRemessaBanco;

        this.situacao = contaCorrente.nomeSituacaoRemessa;

        this.dataConfirmacao = LocalDateTime.ofInstant(
                Instant.ofEpochMilli(lancamento.dateEfetivaLancamento), zoneId);

        LancamentoEtity.ListaControleLancamento.LancamentoContaCorrenteCliente.DadosDomicilioBancario domicilioBancario =
                contaCorrente.dadosDomicilioBancario;
        this.dadosBancarios = String.format("%s Ag %s CC %s", lancamento.nomeBanco.trim(),
                domicilioBancario.numeroAgencia, domicilioBancario.numeroContaCorrente);

        this.valorFinal = lancamento.valorLancamentoRemessa;
    }

}
