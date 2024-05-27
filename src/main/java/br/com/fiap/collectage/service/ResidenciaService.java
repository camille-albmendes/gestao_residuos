package br.com.fiap.collectage.service;

import br.com.fiap.collectage.dto.LogradouroExibicaoDTO;
import br.com.fiap.collectage.dto.ResidenciaCadastroDTO;
import br.com.fiap.collectage.dto.ResidenciaExibicaoDTO;
import br.com.fiap.collectage.model.Logradouro;
import br.com.fiap.collectage.model.Residencia;
import br.com.fiap.collectage.repository.RecursoNaoEncontradoException;
import br.com.fiap.collectage.repository.ResidenciaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResidenciaService  extends AbstractCRUDService<Residencia> {
    public ResidenciaService(ResidenciaRepository residenciaRepository) {
        super(Residencia.class, residenciaRepository);
    }

    public ResidenciaExibicaoDTO buscarPorId(Long id) throws RecursoNaoEncontradoException {
        return new ResidenciaExibicaoDTO(super.buscarModelPorId(id));
    }

    public List<ResidenciaExibicaoDTO> listarTodos() {
        return super.listarTodosModel()
                .stream()
                .map(ResidenciaExibicaoDTO::new)
                .toList();
    }

    public ResidenciaExibicaoDTO salvar(ResidenciaCadastroDTO residenciaCadastroDTO){
        Residencia residencia = new Residencia();
        BeanUtils.copyProperties(residenciaCadastroDTO, residencia);
        return new ResidenciaExibicaoDTO(super.salvarModel(residencia));
    }
}
