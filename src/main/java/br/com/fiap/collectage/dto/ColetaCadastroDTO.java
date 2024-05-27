package br.com.fiap.collectage.dto;

import br.com.fiap.collectage.model.Coleta;

import java.util.Date;

public record ColetaCadastroDTO(
    Date data,
    Coleta.TipoResiduo tipoResiduo,
    boolean concluida
) {
}
