package br.com.fiap.collectage.service;

import br.com.fiap.collectage.model.Coleta;
import br.com.fiap.collectage.model.Usuario;
import br.com.fiap.collectage.repository.ColetaRepository;
import br.com.fiap.collectage.repository.RecursoNaoEncontradoException;
import br.com.fiap.collectage.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService extends AbstractCRUDService<Usuario> {
    public UsuarioService(UsuarioRepository usuarioRepository) {
        super(Usuario.class, usuarioRepository);
    }

//    @Autowired
//    private UsuarioRepository usuarioRepository;
//
//    public Usuario salvarUsuario(Usuario usuario){
//        return usuarioRepository.save(usuario);
//    }
//
//    public Usuario buscarPorId(Long id) throws RecursoNaoEncontradoException {
//        Optional<Usuario> usuarioOptional =
//                usuarioRepository.findById(id);
//
//        if (usuarioOptional.isPresent()){
//            return usuarioOptional.get();
//        } else {
//            throw new RecursoNaoEncontradoException(Usuario.class);
//        }
//    }
//
//    public List<Usuario> listarTodos(){
//        return usuarioRepository.findAll();
//    }
//
//    public void excluir(Long id) throws RecursoNaoEncontradoException {
//        Optional<Usuario> usuarioOptional =
//                usuarioRepository.findById(id);
//
//        if (usuarioOptional.isPresent()){
//            usuarioRepository.delete(usuarioOptional.get());
//        } else {
//            throw new RecursoNaoEncontradoException(Usuario.class);
//        }
//    }
//
//    public Usuario atualizar(Usuario usuario) throws RecursoNaoEncontradoException {
//        Optional<Usuario> usuarioOptional =
//                usuarioRepository.findById(usuario.getId());
//
//        if (usuarioOptional.isPresent()){
//            return usuarioRepository.save(usuario);
//        } else {
//            throw new RecursoNaoEncontradoException(Usuario.class);
//        }
//    }

}
