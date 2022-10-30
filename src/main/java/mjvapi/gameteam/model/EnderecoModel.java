package mjvapi.gameteam.model;

import javax.persistence.*;

@Entity
@Table(name = "endereco")
public class EnderecoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pais", length = 50, nullable = false)
    private String pais;

    @Column(name = "cidade", length = 50, nullable = false)
    private String cidade;

    @Column(name = "logradouro", length = 50, nullable = false)
    private String logradouro;

    @Column(name = "bairro", length = 50, nullable = false)
    private String bairro;

    @Column(name = "complemento", length = 50, nullable = true)
    private String complemento;

    @Column(name = "cep", length = 8, nullable = false)
    private String cep;

    @Column(name = "numero", length = 8, nullable = false)
    private String numero;

    @Column(name = "uf", length = 2, nullable = false)
    private String uf;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
