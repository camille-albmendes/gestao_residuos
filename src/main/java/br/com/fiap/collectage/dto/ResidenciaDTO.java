package br.com.fiap.collectage.dto;

import br.com.fiap.collectage.model.Residencia;

import java.util.Date;

public record ResidenciaDTO(
    Long id,
    LogradouroDTO logradouro,
    Date dataUltimaColeta
) {
    public ResidenciaDTO(Residencia residencia) {
        this(
            residencia.getId(),
            new LogradouroDTO(residencia.getLogradouro()),
            residencia.getDataUltimaColeta()
        );
    }
}
