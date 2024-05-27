package br.com.fiap.collectage.service;

import br.com.fiap.collectage.model.Usuario;
import br.com.fiap.collectage.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends AbstractCRUDService<Usuario> {
    public UsuarioService(UsuarioRepository usuarioRepository) {
        super(Usuario.class, usuarioRepository);
    }
}
