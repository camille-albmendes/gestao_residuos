package br.com.fiap.collectage.controller.logradouro;

import br.com.fiap.collectage.controller.URLs;
import br.com.fiap.collectage.dto.LogradouroDTO;
import br.com.fiap.collectage.model.Logradouro;
import br.com.fiap.collectage.repository.RecursoNaoEncontradoException;
import br.com.fiap.collectage.service.LogradouroService;
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
    public Logradouro salvar(@RequestBody Logradouro logradouro){
        return logradouroService.salvar(logradouro);
    }

    @GetMapping(URLs.LOGRADOUROS)
    @ResponseStatus(HttpStatus.OK)
    public List<LogradouroDTO> listarTodos(){
        return logradouroService.listarTodosDTO();
    }

    @GetMapping(URLs.LOGRADOURO)
    public ResponseEntity<LogradouroDTO> buscarPorId(@PathVariable Long logradouroId){
        try {
            return ResponseEntity.ok(logradouroService.buscarDTOPorId(logradouroId));
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
