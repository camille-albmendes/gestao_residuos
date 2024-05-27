package br.com.fiap.collectage.service;

import br.com.fiap.collectage.dto.ColetaExibicaoDTO;
import br.com.fiap.collectage.dto.LogradouroCadastroDTO;
import br.com.fiap.collectage.dto.LogradouroExibicaoDTO;
import br.com.fiap.collectage.model.Coleta;
import br.com.fiap.collectage.model.Logradouro;
import br.com.fiap.collectage.repository.LogradouroRepository;
import br.com.fiap.collectage.repository.RecursoNaoEncontradoException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogradouroService extends AbstractCRUDService<Logradouro> {
    public LogradouroService(LogradouroRepository logradouroRepository) {
        super(Logradouro.class, logradouroRepository);
    }

    public LogradouroExibicaoDTO buscarPorId(Long id) throws RecursoNaoEncontradoException {
        return new LogradouroExibicaoDTO(super.buscarModelPorId(id));
    }

    public List<LogradouroExibicaoDTO> listarTodos() {
        return super.listarTodosModel()
                .stream()
                .map(LogradouroExibicaoDTO::new)
                .toList();
    }

    public LogradouroExibicaoDTO salvar(LogradouroCadastroDTO logradouroCadastroDTO){
        Logradouro logradouro = new Logradouro();
        BeanUtils.copyProperties(logradouroCadastroDTO, logradouro);
        return new LogradouroExibicaoDTO(super.salvarModel(logradouro));
    }
}
