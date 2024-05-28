package br.com.fiap.collectage.controller.auth;

import br.com.fiap.collectage.controller.URLs;
import br.com.fiap.collectage.dto.UsuarioCadastroDTO;
import br.com.fiap.collectage.dto.UsuarioExibicaoDTO;
import br.com.fiap.collectage.dto.UsuarioLoginDTO;
import br.com.fiap.collectage.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(URLs.LOGIN)
    public ResponseEntity<Void> login(
            @RequestBody
            @Valid
            UsuarioLoginDTO usuarioDto
    ){
        UsernamePasswordAuthenticationToken usernamePassword =
                new UsernamePasswordAuthenticationToken(
                        usuarioDto.username(),
                        usuarioDto.senha()
                );

        try {
            Authentication auth = this.authenticationManager.authenticate(usernamePassword);
        } catch (AuthenticationException e) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();
    }

    @PostMapping(URLs.CADASTRAR_USUARIO)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UsuarioExibicaoDTO> registrar(@RequestBody @Valid UsuarioCadastroDTO usuarioCadastroDTO){
        UsuarioExibicaoDTO usuarioSalvo = usuarioService.salvar(usuarioCadastroDTO);
        return ResponseEntity.ok(usuarioSalvo);
    }

}
