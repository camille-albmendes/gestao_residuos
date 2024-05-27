package br.com.fiap.collectage.service;

import br.com.fiap.collectage.model.Logradouro;
import br.com.fiap.collectage.repository.LogradouroRepository;
import org.springframework.stereotype.Service;

@Service
public class LogradouroService extends AbstractCRUDService<Logradouro> {
    public LogradouroService(LogradouroRepository logradouroRepository) {
        super(Logradouro.class, logradouroRepository);
    }
}
