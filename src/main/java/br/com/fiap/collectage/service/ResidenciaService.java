package br.com.fiap.collectage.service;

import br.com.fiap.collectage.dto.ResidenciaDTO;
import br.com.fiap.collectage.model.Residencia;
import br.com.fiap.collectage.repository.RecursoNaoEncontradoException;
import br.com.fiap.collectage.repository.ResidenciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResidenciaService  extends AbstractCRUDService<Residencia> {
    public ResidenciaService(ResidenciaRepository residenciaRepository) {
        super(Residencia.class, residenciaRepository);
    }

    public ResidenciaDTO buscarDTOPorId(Long id) throws RecursoNaoEncontradoException {
        return new ResidenciaDTO(super.buscarPorId(id));
    }

    public List<ResidenciaDTO> listarTodosDTO() {
        return super.listarTodos()
                .stream()
                .map(ResidenciaDTO::new)
                .toList();
    }
}
