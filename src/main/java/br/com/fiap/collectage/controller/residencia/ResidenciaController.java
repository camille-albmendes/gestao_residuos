package br.com.fiap.collectage.controller.residencia;

import br.com.fiap.collectage.controller.URLs;
import br.com.fiap.collectage.dto.ResidenciaCadastroDTO;
import br.com.fiap.collectage.dto.ResidenciaExibicaoDTO;
import br.com.fiap.collectage.model.Residencia;
import br.com.fiap.collectage.repository.RecursoNaoEncontradoException;
import br.com.fiap.collectage.service.ResidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResidenciaController {

    @Autowired
    private ResidenciaService residenciaService;

    @PostMapping(URLs.RESIDENCIAS)
    @ResponseStatus(HttpStatus.CREATED)
    public ResidenciaExibicaoDTO salvar(@RequestBody ResidenciaCadastroDTO residenciaCadastroDTO){
        return residenciaService.salvar(residenciaCadastroDTO);
    }

    @GetMapping(URLs.RESIDENCIAS)
    @ResponseStatus(HttpStatus.OK)
    public List<ResidenciaExibicaoDTO> listarTodos(){
        return residenciaService.listarTodos();
    }

    @GetMapping(URLs.RESIDENCIA)
    public ResponseEntity<ResidenciaExibicaoDTO> buscarPorId(@PathVariable Long residenciaId){
        try {
            return ResponseEntity.ok(residenciaService.buscarPorId(residenciaId));
        } catch (RecursoNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(URLs.RESIDENCIA)
    public ResponseEntity<Void> excluir(@PathVariable Long residenciaId){
        try {
            residenciaService.excluir(residenciaId);
            return ResponseEntity.ok().build();
        } catch (RecursoNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(URLs.RESIDENCIAS)
    public ResponseEntity<Residencia> atualizar(@RequestBody Residencia residencia){
        try {
            return ResponseEntity.ok(residenciaService.atualizar(residencia));
        } catch (RecursoNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
