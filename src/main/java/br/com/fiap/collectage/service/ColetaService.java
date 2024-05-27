package br.com.fiap.collectage.service;

import br.com.fiap.collectage.model.Coleta;
import br.com.fiap.collectage.repository.ColetaRepository;
import org.springframework.stereotype.Service;

@Service
public class ColetaService extends AbstractCRUDService<Coleta> {
    public ColetaService(ColetaRepository coletaRepository) {
        super(Coleta.class, coletaRepository);
    }
}
