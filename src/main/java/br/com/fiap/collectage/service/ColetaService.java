package br.com.fiap.collectage.service;

import br.com.fiap.collectage.dto.ColetaDTO;
import br.com.fiap.collectage.model.Coleta;
import br.com.fiap.collectage.repository.ColetaRepository;
import br.com.fiap.collectage.repository.RecursoNaoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColetaService extends AbstractCRUDService<Coleta> {
    public ColetaService(ColetaRepository coletaRepository) {
        super(Coleta.class, coletaRepository);
    }

    public ColetaDTO buscarPorId(Long id) throws RecursoNaoEncontradoException {
        return new ColetaDTO(super.buscarModelPorId(id));
    }

    public List<ColetaDTO> listarTodos() {
        return super.listarTodosModel()
                .stream()
                .map(ColetaDTO::new)
                .toList();
    }
}
