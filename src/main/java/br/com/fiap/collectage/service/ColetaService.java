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

    public ColetaDTO buscarDTOPorId(Long id) throws RecursoNaoEncontradoException {
        return new ColetaDTO(super.buscarPorId(id));
    }

    public List<ColetaDTO> listarTodosDTO() {
        return super.listarTodos()
                .stream()
                .map(ColetaDTO::new)
                .toList();
    }
}
