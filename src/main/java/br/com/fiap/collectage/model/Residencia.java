package br.com.fiap.collectage.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "TBL_RESIDENCIAS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Residencia implements DBEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_RESIDENCIAS"
    )
    @SequenceGenerator(
            name = "SEQ_RESIDENCIAS",
            sequenceName = "SEQ_RESIDENCIAS",
            allocationSize = 1
    )
    @Column(name = "COD_ID")
    private Long id;

    @JoinColumn(name = "COD_LOGRADOURO_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Logradouro logradouro;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DAT_DATA_ULTIMA_COLETA")
    private Date dataUltimaColeta;

    @Override
    public Long getId() {
        return this.id;
    }
}
