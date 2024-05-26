package br.com.fiap.collectage.controller.usuario;

import br.com.fiap.collectage.controller.URLs;
import br.com.fiap.collectage.model.Usuario;
import br.com.fiap.collectage.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(URLs.USUARIOS)
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario salvar(@RequestBody Usuario usuario){
        return usuarioService.salvarUsuario(usuario);
    }

    @GetMapping(URLs.USUARIOS)
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> litarTodos(){
        return usuarioService.listarTodos();
    }

    @GetMapping(URLs.USUARIO)
    @ResponseStatus(HttpStatus.OK)
    public Usuario buscarPorId(@PathVariable Long usuarioId){
        return usuarioService.buscarPorId(usuarioId);
    }

    @DeleteMapping(URLs.USUARIO)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long usuarioId){
        usuarioService.excluir(usuarioId);
    }

    @PutMapping(URLs.USUARIOS)
    @ResponseStatus(HttpStatus.OK)
    public Usuario atualizar(@RequestBody Usuario usuario){
        return usuarioService.atualizar(usuario);
    }

}
