package br.com.fiap.collectage.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "TBL_COLETA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Coleta implements DBEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_COLETA"
    )
    @SequenceGenerator(
            name = "SEQ_COLETA",
            sequenceName = "SEQ_COLETA",
            allocationSize = 1
    )
    @Column(name = "COD_ID")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DAT_DATA_COLETA")
    private Date data;

    @Enumerated(EnumType.STRING)
    @Column(name = "TXT_TIPO_RESIDUO")
    private TipoResiduo tipoResiduo;

    @Column(name = "IDN_CONCLUIDA")
    private boolean concluida;

    /* GETTERS and SETTERS */

    @Override
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public TipoResiduo getTipoResiduo() {
        return tipoResiduo;
    }

    public void setTipoResiduo(TipoResiduo tipoResiduo) {
        this.tipoResiduo = tipoResiduo;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public enum TipoResiduo {
        RECICLAVEL,
        ORGANICO;

        TipoResiduo() {}
    }
}
