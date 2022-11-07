package mjvapi.gameteam.dto.endereco;

import mjvapi.gameteam.model.EnderecoModel;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

public class EnderecoResponseBody {
    private Long id;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ddd;

    public static EnderecoResponseBody converterEmDto(EnderecoModel endereco) {
        EnderecoResponseBody enderecoDto = new EnderecoResponseBody();
        enderecoDto.setId(endereco.getId());
        enderecoDto.setCep(endereco.getCep());
        enderecoDto.setLogradouro(endereco.getLogradouro());
        enderecoDto.setComplemento(endereco.getComplemento());
        enderecoDto.setBairro(endereco.getBairro());
        enderecoDto.setLocalidade(endereco.getLocalidade());
        enderecoDto.setUf(endereco.getUf());
        enderecoDto.setDdd(endereco.getDdd());

        return enderecoDto;
    }

    public static List<EnderecoResponseBody> converterEmListaDto(List<EnderecoModel> enderecos) {
        ArrayList<EnderecoResponseBody> enderecosDto = new ArrayList<EnderecoResponseBody>();

        for (EnderecoModel endereco: enderecos) {
            enderecosDto.add(EnderecoResponseBody.converterEmDto(endereco));
        }

        return enderecosDto;
    }

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
