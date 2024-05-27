package br.com.fiap.collectage.dto;

import br.com.fiap.collectage.model.Coleta;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record ColetaCadastroDTO(
    @NotNull(message = "A data da coleta é obrigatória")
    Date data,

    @NotNull(message = "O tipo de resíduo da coleta é obrigatório")
    Coleta.TipoResiduo tipoResiduo,

    @NotNull(message = "É obrigatório informar se a coleta já foi concluída")
    boolean concluida
) {
}
