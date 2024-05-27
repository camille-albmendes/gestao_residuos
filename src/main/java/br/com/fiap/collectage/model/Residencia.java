package br.com.fiap.collectage.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "COD_LOGRADOURO_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Logradouro logradouro;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DAT_DATA_ULTIMA_COLETA")
    private Date dataUltimaColeta;

    @Column(name = "IND_CAPACIDADE")
    private Integer capacidade;

    @Override
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Logradouro getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(Logradouro logradouro) {
        this.logradouro = logradouro;
    }

    public Date getDataUltimaColeta() {
        return dataUltimaColeta;
    }

    public void setDataUltimaColeta(Date dataUltimaColeta) {
        this.dataUltimaColeta = dataUltimaColeta;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }
}
