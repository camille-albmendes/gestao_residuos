package br.com.fiap.collectage.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LogradouroCadastroDTO(
    @NotBlank(message = "O nome do logradouro é obrigatório")
    @Size(min = 2, max = 100, message = "O nome do logradouro deve conter entre 2 e 100 caracteres")
    String nome,

    @NotBlank(message = "A cidade é obrigatória")
    @Size(min = 2, max = 100, message = "A cidade deve conter entre 2 e 100 caracteres")
    String cidade,

    @NotBlank(message = "O estado é obrigatório")
    @Size(min = 2, max = 2, message = "A UF estado deve conter exatamente 2 caracteres")
    String estado,

    @NotBlank(message = "O nome do usuário é obrigatório")
    @Size(min = 8, max = 8, message = "O cep deve conter exatamente 8 caracteres")
    String cep
) {
}
