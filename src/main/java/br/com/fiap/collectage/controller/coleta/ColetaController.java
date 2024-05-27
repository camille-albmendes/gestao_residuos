package br.com.fiap.collectage.controller.coleta;

import br.com.fiap.collectage.controller.URLs;
import br.com.fiap.collectage.dto.ColetaDTO;
import br.com.fiap.collectage.model.Coleta;
import br.com.fiap.collectage.repository.RecursoNaoEncontradoException;
import br.com.fiap.collectage.service.ColetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ColetaController {
    @Autowired
    private ColetaService coletaService;

    @PostMapping(URLs.COLETAS)
    @ResponseStatus(HttpStatus.CREATED)
    public Coleta salvar(@RequestBody Coleta coleta){
        return coletaService.salvar(coleta);
    }

    @GetMapping(URLs.COLETAS)
    @ResponseStatus(HttpStatus.OK)
    public List<ColetaDTO> listarTodos(){
        return coletaService.listarTodosDTO();
    }

    @GetMapping(URLs.COLETA)
    public ResponseEntity<ColetaDTO> buscarPorId(@PathVariable Long coletaId){
        try {
            return ResponseEntity.ok(coletaService.buscarDTOPorId(coletaId));
        } catch (RecursoNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(URLs.COLETA)
    public ResponseEntity<Void> excluir(@PathVariable Long coletaId){
        try {
            coletaService.excluir(coletaId);
            return ResponseEntity.ok().build();
        } catch (RecursoNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(URLs.COLETAS)
    public ResponseEntity<Coleta> atualizar(@RequestBody Coleta coleta){
        try {
            return ResponseEntity.ok(coletaService.atualizar(coleta));
        } catch (RecursoNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
