package br.com.fiap.collectage.repository;

import br.com.fiap.collectage.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
