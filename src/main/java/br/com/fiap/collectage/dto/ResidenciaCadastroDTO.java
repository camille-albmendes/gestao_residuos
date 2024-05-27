package br.com.fiap.collectage.dto;

import br.com.fiap.collectage.model.Logradouro;

import java.util.Date;

public record ResidenciaCadastroDTO(
    Logradouro logradouro,
    Date dataUltimaColeta
) {
}
