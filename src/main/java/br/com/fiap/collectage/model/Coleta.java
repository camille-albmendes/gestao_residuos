import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "T_COLETA")
public class Coleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_id")
    private int id;

    @Column(name = "dat_data_coleta")
    private Timestamp dataColeta;

    @Column(name = "txt_tipo_residuo")
    private String tipoResiduo;

    @Column(name = "idn_concluida")
    private int concluida;

    // Getter para o id
    public int getId() {
        return id;
    }

    // Setter para o id
    public void setId(int id) {
        this.id = id;
    }

    // Getter para a data de coleta
    public Timestamp getDataColeta() {
        return dataColeta;
    }

    // Setter para a data de coleta
    public void setDataColeta(Timestamp dataColeta) {
        this.dataColeta = dataColeta;
    }

    // Getter para o tipo de resíduo
    public String getTipoResiduo() {
        return tipoResiduo;
    }

    // Setter para o tipo de resíduo
    public void setTipoResiduo(String tipoResiduo) {
        this.tipoResiduo = tipoResiduo;
    }

    // Getter para o status de conclusão
    public int getConcluida() {
        return concluida;
    }

    // Setter para o status de conclusão
    public void setConcluida(int concluida) {
        this.concluida = concluida;
    }
}
