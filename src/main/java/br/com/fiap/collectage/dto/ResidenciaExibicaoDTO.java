package br.com.fiap.collectage.dto;

import br.com.fiap.collectage.model.Residencia;

import java.util.Date;

public record ResidenciaExibicaoDTO(
    Long id,
    LogradouroExibicaoDTO logradouro,
    Date dataUltimaColeta
) {
    public ResidenciaExibicaoDTO(Residencia residencia) {
        this(
            residencia.getId(),
            new LogradouroExibicaoDTO(residencia.getLogradouro()),
            residencia.getDataUltimaColeta()
        );
    }
}
