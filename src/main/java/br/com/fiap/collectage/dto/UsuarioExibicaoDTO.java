package br.com.fiap.collectage.dto;

import br.com.fiap.collectage.model.Usuario;

public record UsuarioExibicaoDTO(
        Long id,
        String nome,
        String email) {

    public UsuarioExibicaoDTO(Usuario usuario) {
        this(
            usuario.getId(),
            usuario.getNome(),
            usuario.getEmail()
        );
    }
}
