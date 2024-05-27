package br.com.fiap.collectage.controller.usuario;

import br.com.fiap.collectage.controller.URLs;
import br.com.fiap.collectage.dto.UsuarioDTO;
import br.com.fiap.collectage.model.Usuario;
import br.com.fiap.collectage.repository.RecursoNaoEncontradoException;
import br.com.fiap.collectage.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(URLs.USUARIOS)
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario salvar(@RequestBody Usuario usuario){
        return usuarioService.salvar(usuario);
    }

    @GetMapping(URLs.USUARIOS)
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioDTO> listarTodos(){
        return usuarioService.listarTodosDTO();
    }

    @GetMapping(URLs.USUARIO)
    public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable Long usuarioId){
        try {
            return ResponseEntity.ok(usuarioService.buscarDTOPorId(usuarioId));
        } catch (RecursoNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(URLs.USUARIO)
    public ResponseEntity<Void> excluir(@PathVariable Long usuarioId){
        try {
            usuarioService.excluir(usuarioId);
            return ResponseEntity.ok().build();
        } catch (RecursoNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(URLs.USUARIOS)
    public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario){
        try {
            return ResponseEntity.ok(usuarioService.atualizar(usuario));
        } catch (RecursoNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
