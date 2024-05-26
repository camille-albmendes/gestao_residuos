import javax.persistence.*;

@Entity
@Table(name = "T_COLETA_LOGRADOUROS")
public class ColetaLogradouro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "cod_coleta_id")
    private Coleta coleta;

    @ManyToOne
    @JoinColumn(name = "cod_logradouro_id")
    private Logradouro logradouro;

    // Getter para o id
    public int getId() {
        return id;
    }

    // Setter para o id
    public void setId(int id) {
        this.id = id;
    }

    // Getter para a coleta
    public Coleta getColeta() {
        return coleta;
    }

    // Setter para a coleta
    public void setColeta(Coleta coleta) {
        this.coleta = coleta;
    }

    // Getter para o logradouro
    public Logradouro getLogradouro() {
        return logradouro;
    }

    // Setter para o logradouro
    public void setLogradouro(Logradouro logradouro) {
        this.logradouro = logradouro;
    }
}
