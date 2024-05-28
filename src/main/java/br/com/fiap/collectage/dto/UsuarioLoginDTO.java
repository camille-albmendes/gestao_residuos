package br.com.fiap.collectage.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioLoginDTO(
    @NotBlank(message = "O username é obrigatório")
    @Email(message = "O e-mail informado não é válido")
    String username,

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 6, max = 20, message = "A senha deve conter entre 6 e 20 caracteres")
    String senha
) {
}
