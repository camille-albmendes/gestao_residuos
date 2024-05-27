package br.com.fiap.collectage.controller.logradouro;

import br.com.fiap.collectage.controller.URLs;
import br.com.fiap.collectage.dto.LogradouroCadastroDTO;
import br.com.fiap.collectage.dto.LogradouroExibicaoDTO;
import br.com.fiap.collectage.model.Logradouro;
import br.com.fiap.collectage.repository.RecursoNaoEncontradoException;
import br.com.fiap.collectage.service.LogradouroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LogradouroController {

    @Autowired
    private LogradouroService logradouroService;

    @PostMapping(URLs.LOGRADOUROS)
    @ResponseStatus(HttpStatus.CREATED)
    public LogradouroExibicaoDTO salvar(@Valid @RequestBody LogradouroCadastroDTO logradouroCadastroDTO){
        return logradouroService.salvar(logradouroCadastroDTO);
    }

    @GetMapping(URLs.LOGRADOUROS)
    @ResponseStatus(HttpStatus.OK)
    public List<LogradouroExibicaoDTO> listarTodos(){
        return logradouroService.listarTodos();
    }

    @GetMapping(URLs.LOGRADOURO)
    public ResponseEntity<LogradouroExibicaoDTO> buscarPorId(@PathVariable Long logradouroId){
        try {
            return ResponseEntity.ok(logradouroService.buscarPorId(logradouroId));
        } catch (RecursoNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(URLs.LOGRADOURO)
    public ResponseEntity<Void> excluir(@PathVariable Long logradouroId){
        try {
            logradouroService.excluir(logradouroId);
            return ResponseEntity.ok().build();
        } catch (RecursoNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(URLs.LOGRADOUROS)
    public ResponseEntity<Logradouro> atualizar(@RequestBody Logradouro logradouro){
        try {
            return ResponseEntity.ok(logradouroService.atualizar(logradouro));
        } catch (RecursoNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
