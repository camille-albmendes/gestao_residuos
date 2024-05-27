package br.com.fiap.collectage.service;

import br.com.fiap.collectage.dto.ColetaCadastroDTO;
import br.com.fiap.collectage.dto.ColetaExibicaoDTO;
import br.com.fiap.collectage.model.Coleta;
import br.com.fiap.collectage.repository.ColetaRepository;
import br.com.fiap.collectage.repository.RecursoNaoEncontradoException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColetaService extends AbstractCRUDService<Coleta> {
    public ColetaService(ColetaRepository coletaRepository) {
        super(Coleta.class, coletaRepository);
    }

    public ColetaExibicaoDTO buscarPorId(Long id) throws RecursoNaoEncontradoException {
        return new ColetaExibicaoDTO(super.buscarModelPorId(id));
    }

    public List<ColetaExibicaoDTO> listarTodos() {
        return super.listarTodosModel()
                .stream()
                .map(ColetaExibicaoDTO::new)
                .toList();
    }

    public ColetaExibicaoDTO salvar(ColetaCadastroDTO coletaCadastroDTO){
        Coleta coleta = new Coleta();
        BeanUtils.copyProperties(coletaCadastroDTO, coleta);
        return new ColetaExibicaoDTO(super.salvarModel(coleta));
    }
}
