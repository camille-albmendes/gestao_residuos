package br.com.fiap.collectage.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioCadastroDTO(
    @NotBlank(message = "O nome do usuário é obrigatório!")
    @Size(min = 2, max = 100, message = "O nome do usuário deve conter entre 2 e 100 caracteres")
    String nome,

    @NotBlank(message = "O e-mail do usuário é obrigatório")
    @Email(message = "O e-mail do usuário não é válido")
    String email,

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 6, max = 20, message = "A senha deve conter entre 6 e 20 caracteres")
    String senha
) {
}
