package br.com.fiap.collectage.dto;

import br.com.fiap.collectage.model.Coleta;

import java.util.Date;

public record ColetaExibicaoDTO(
        Long id,
        Date data,
        Coleta.TipoResiduo tipoResiduo,
        boolean concluida
) {
    public ColetaExibicaoDTO(Coleta coleta) {
        this(
            coleta.getId(),
            coleta.getData(),
            coleta.getTipoResiduo(),
            coleta.isConcluida()
        );
    }
}
