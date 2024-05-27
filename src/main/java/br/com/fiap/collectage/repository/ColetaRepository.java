package br.com.fiap.collectage.repository;

import br.com.fiap.collectage.model.Coleta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColetaRepository  extends JpaRepository<Coleta, Long> {
}
