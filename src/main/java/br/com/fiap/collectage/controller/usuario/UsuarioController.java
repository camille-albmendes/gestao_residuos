package br.com.fiap.collectage.controller.usuario;

import br.com.fiap.collectage.controller.URLs;
import br.com.fiap.collectage.dto.UsuarioCadastroDTO;
import br.com.fiap.collectage.dto.UsuarioExibicaoDTO;
import br.com.fiap.collectage.model.Usuario;
import br.com.fiap.collectage.repository.RecursoNaoEncontradoException;
import br.com.fiap.collectage.service.UsuarioService;
import jakarta.validation.Valid;
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
    public UsuarioExibicaoDTO salvar(@Valid @RequestBody UsuarioCadastroDTO usuarioCadastroDTO){
        return usuarioService.salvar(usuarioCadastroDTO);
    }

    @GetMapping(URLs.USUARIOS)
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioExibicaoDTO> listarTodos(){
        return usuarioService.listarTodos();
    }

    @GetMapping(URLs.USUARIO)
    public ResponseEntity<UsuarioExibicaoDTO> buscarPorId(@PathVariable Long usuarioId){
        try {
            return ResponseEntity.ok(usuarioService.buscarPorId(usuarioId));
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
