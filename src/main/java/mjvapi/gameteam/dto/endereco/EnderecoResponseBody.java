package mjvapi.gameteam.dto.endereco;

import mjvapi.gameteam.model.EnderecoModel;

public class EnderecoResponseBody {
    private Long id;
    private String pais;
    private String cidade;
    private String logradouro;
    private String bairro;
    private String complemento;
    private String cep;
    private String numero;
    private String uf;

    public EnderecoResponseBody() {

    }

    public EnderecoResponseBody(EnderecoModel endereco) {
        id = endereco.getId();
        pais = endereco.getPais();
        cidade = endereco.getCidade();
        logradouro = endereco.getLogradouro();
        bairro = endereco.getBairro();
        complemento = endereco.getComplemento();
        cep = endereco.getCep();
        numero = endereco.getNumero();
        uf = endereco.getUf();
    }

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
