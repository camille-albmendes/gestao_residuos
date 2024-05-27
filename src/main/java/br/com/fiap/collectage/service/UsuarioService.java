package br.com.fiap.collectage.service;

import br.com.fiap.collectage.dto.UsuarioDTO;
import br.com.fiap.collectage.model.Usuario;
import br.com.fiap.collectage.repository.RecursoNaoEncontradoException;
import br.com.fiap.collectage.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService extends AbstractCRUDService<Usuario> {
    public UsuarioService(UsuarioRepository usuarioRepository) {
        super(Usuario.class, usuarioRepository);
    }

    public UsuarioDTO buscarPorId(Long id) throws RecursoNaoEncontradoException {
        return new UsuarioDTO(super.buscarModelPorId(id));
    }

    public List<UsuarioDTO> listarTodos() {
        return super.listarTodosModel()
                .stream()
                .map(UsuarioDTO::new)
                .toList();
    }
}
