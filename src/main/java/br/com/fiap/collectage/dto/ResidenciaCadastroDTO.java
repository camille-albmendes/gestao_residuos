package br.com.fiap.collectage.dto;

import br.com.fiap.collectage.model.Logradouro;
import jakarta.validation.constraints.NotNull;

public record ResidenciaCadastroDTO(
    @NotNull(message = "O logradouro da residência é obrigatório")
    Logradouro logradouro
) {
}
