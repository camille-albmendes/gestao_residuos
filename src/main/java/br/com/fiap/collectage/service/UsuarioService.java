package br.com.fiap.collectage.service;

import br.com.fiap.collectage.dto.ResidenciaExibicaoDTO;
import br.com.fiap.collectage.dto.UsuarioCadastroDTO;
import br.com.fiap.collectage.dto.UsuarioExibicaoDTO;
import br.com.fiap.collectage.model.Residencia;
import br.com.fiap.collectage.model.Usuario;
import br.com.fiap.collectage.repository.RecursoNaoEncontradoException;
import br.com.fiap.collectage.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService extends AbstractCRUDService<Usuario> {
    public UsuarioService(UsuarioRepository usuarioRepository) {
        super(Usuario.class, usuarioRepository);
    }

    public UsuarioExibicaoDTO buscarPorId(Long id) throws RecursoNaoEncontradoException {
        return new UsuarioExibicaoDTO(super.buscarModelPorId(id));
    }

    public List<UsuarioExibicaoDTO> listarTodos() {
        return super.listarTodosModel()
                .stream()
                .map(UsuarioExibicaoDTO::new)
                .toList();
    }

    public UsuarioExibicaoDTO salvar(UsuarioCadastroDTO usuarioCadastroDTO){
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioCadastroDTO, usuario);
        return new UsuarioExibicaoDTO(super.salvarModel(usuario));
    }
}
