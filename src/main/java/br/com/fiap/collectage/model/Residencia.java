import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "T_RESIDENCIAS")
public class Residencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "cod_logradouro_id")
    private Logradouro logradouro;

    @Column(name = "dat_data_ultima_coleta")
    private Date dataUltimaColeta;

    // Getter para o id
    public int getId() {
        return id;
    }

    // Setter para o id
    public void setId(int id) {
        this.id = id;
    }

    // Getter para o logradouro
    public Logradouro getLogradouro() {
        return logradouro;
    }

    // Setter para o logradouro
    public void setLogradouro(Logradouro logradouro) {
        this.logradouro = logradouro;
    }

    // Getter para a data da última coleta
    public Date getDataUltimaColeta() {
        return dataUltimaColeta;
    }

    // Setter para a data da última coleta
    public void setDataUltimaColeta(Date dataUltimaColeta) {
        this.dataUltimaColeta = dataUltimaColeta;
    }
}
