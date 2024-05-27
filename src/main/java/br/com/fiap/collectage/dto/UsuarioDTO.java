package br.com.fiap.collectage.dto;

import br.com.fiap.collectage.model.Usuario;

public record UsuarioDTO(
        Long id,
        String nome,
        String email) {

    public UsuarioDTO(Usuario usuario) {
        this(
            usuario.getId(),
            usuario.getNome(),
            usuario.getEmail()
        );
    }
}
