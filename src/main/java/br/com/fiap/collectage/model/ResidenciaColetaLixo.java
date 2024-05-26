import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "T_RESIDENCIAS_PARA_COLETAR_LIXO")
public class ResidenciaColetaLixo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "cod_residencia_id")
    private Residencia residencia;

    @Column(name = "dat_hora")
    private Timestamp hora;

    // Getter para o id
    public int getId() {
        return id;
    }

    // Setter para o id
    public void setId(int id) {
        this.id = id;
    }

    // Getter para a residência
    public Residencia getResidencia() {
        return residencia;
    }

    // Setter para a residência
    public void setResidencia(Residencia residencia) {
        this.residencia = residencia;
    }

    // Getter para a hora
    public Timestamp getHora() {
        return hora;
    }

    // Setter para a hora
    public void setHora(Timestamp hora) {
        this.hora = hora;
    }
}
