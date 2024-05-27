package br.com.fiap.collectage.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TBL_USUARIOS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Usuario implements DBEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_USUARIOS"
    )
    @SequenceGenerator(
            name = "SEQ_USUARIOS",
            sequenceName = "SEQ_USUARIOS",
            allocationSize = 1
    )
    @Column(name = "USUARIO_ID")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "SENHA")
    private String senha;

    @Override
    public Long getId() {
        return this.id;
    }
}
