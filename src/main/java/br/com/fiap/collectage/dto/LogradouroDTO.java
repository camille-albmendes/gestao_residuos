package br.com.fiap.collectage.dto;

import br.com.fiap.collectage.model.Logradouro;

public record LogradouroDTO(
    Long id,
    String nome,
    String cidade,
    String estado,
    String cep
) {
    public LogradouroDTO(Logradouro logradouro) {
        this(
            logradouro.getId(),
            logradouro.getNome(),
            logradouro.getCidade(),
            logradouro.getEstado(),
            logradouro.getCep()
        );
    }
}
