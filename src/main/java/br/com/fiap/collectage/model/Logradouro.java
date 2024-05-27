package br.com.fiap.collectage.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TBL_LOGRADOUROS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Logradouro implements DBEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_LOGRADOUROS"
    )
    @SequenceGenerator(
            name = "SEQ_LOGRADOUROS",
            sequenceName = "SEQ_LOGRADOUROS",
            allocationSize = 1
    )
    @Column(name = "COD_ID")
    private Long id;

    @Column(name = "NOM_NOME")
    private String nome;

    @Column(name = "TXT_CIDADE")
    private String cidade;

    @Column(name = "TXT_ESTADO")
    private String estado;

    @Column(name = "TXT_CEP")
    private String cep;

    @Override
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
