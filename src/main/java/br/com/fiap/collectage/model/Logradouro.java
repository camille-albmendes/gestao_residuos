import javax.persistence.*;

@Entity
@Table(name = "T_LOGRADOUROS")
public class Logradouro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_id")
    private int id;

    @Column(name = "nom_nome")
    private String nome;

    @Column(name = "txt_cidade")
    private String cidade;

    @Column(name = "txt_estado")
    private String estado;

    @Column(name = "txt_cep")
    private String cep;

    // Getter para o id
    public int getId() {
        return id;
    }

    // Setter para o id
    public void setId(int id) {
        this.id = id;
    }

    // Getter para o nome
    public String getNome() {
        return nome;
    }

    // Setter para o nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter para a cidade
    public String getCidade() {
        return cidade;
    }

    // Setter para a cidade
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    // Getter para o estado
    public String getEstado() {
        return estado;
    }

    // Setter para o estado
    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Getter para o cep
    public String getCep() {
        return cep;
    }

    // Setter para o cep
    public void setCep(String cep) {
        this.cep = cep;
    }
}
