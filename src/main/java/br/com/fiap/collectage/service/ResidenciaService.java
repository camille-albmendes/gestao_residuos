package br.com.fiap.collectage.service;

import br.com.fiap.collectage.model.Residencia;
import br.com.fiap.collectage.repository.ResidenciaRepository;
import org.springframework.stereotype.Service;

@Service
public class ResidenciaService  extends AbstractCRUDService<Residencia> {
    public ResidenciaService(ResidenciaRepository residenciaRepository) {
        super(Residencia.class, residenciaRepository);
    }
}
