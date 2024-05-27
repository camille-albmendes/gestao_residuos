package br.com.fiap.collectage.service;

import br.com.fiap.collectage.dto.LogradouroDTO;
import br.com.fiap.collectage.model.Logradouro;
import br.com.fiap.collectage.repository.LogradouroRepository;
import br.com.fiap.collectage.repository.RecursoNaoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogradouroService extends AbstractCRUDService<Logradouro> {
    public LogradouroService(LogradouroRepository logradouroRepository) {
        super(Logradouro.class, logradouroRepository);
    }

    public LogradouroDTO buscarDTOPorId(Long id) throws RecursoNaoEncontradoException {
        return new LogradouroDTO(super.buscarPorId(id));
    }

    public List<LogradouroDTO> listarTodosDTO() {
        return super.listarTodos()
                .stream()
                .map(LogradouroDTO::new)
                .toList();
    }
}
