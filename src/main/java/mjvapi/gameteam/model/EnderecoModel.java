package mjvapi.gameteam.model;

import javax.persistence.*;

@Entity
@Table(name = "endereco")
public class EnderecoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cep", length = 8, nullable = false)
    private String cep;

    @Column(name = "logradouro", length = 50, nullable = false)
    private String logradouro;

    @Column(name = "complemento", length = 50, nullable = true)
    private String complemento;

    @Column(name = "bairro", length = 50, nullable = false)
    private String bairro;

    @Column(name = "localidade", length = 50, nullable = false)
    private String localidade;

    @Column(name = "uf", length = 2, nullable = false)
    private String uf;

    @Column(name = "ddd", length = 2, nullable = false)
    private String ddd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

}
