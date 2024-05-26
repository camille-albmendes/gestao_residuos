package br.com.fiap.collectage.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Usuario {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_USUARIOS"
    )
    @SequenceGenerator(
            name = "SEQ_USUARIOS",
            sequenceName = "SEQ_USUARIOS",
            allocationSize = 50
    )
    @Column(name = "usuario_id")
    private Long usuarioId;

    private String nome;
    private String email;
    private String senha;

    public Long getUsuarioId() {
        return this.usuarioId;
    }
}
