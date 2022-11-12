package mjvapi.gameteam.dto.produto;

import mjvapi.gameteam.model.ProdutoModel;

import java.util.ArrayList;
import java.util.List;

public class ProdutoResponseBody {
    private Long id;
    private String nome;
    private String descricao;
    private String desenvolvedora;
    private Double valor;

    public static ProdutoResponseBody converterEmDto(ProdutoModel produto) {
        ProdutoResponseBody produtoDto = new ProdutoResponseBody();
        produtoDto.setId(produto.getId());
        produtoDto.setNome(produto.getNome());
        produtoDto.setDescricao(produto.getDescricao());
        produtoDto.setDesenvolvedora(produto.getDesenvolvedora());
        produtoDto.setValor(produto.getValor());

        return produtoDto;
    }

    public static List<ProdutoResponseBody> converterEmListaDto(List<ProdutoModel> produtos) {
        ArrayList<ProdutoResponseBody> produtosDto = new ArrayList<ProdutoResponseBody>();

        for (ProdutoModel produto: produtos) {
            produtosDto.add(ProdutoResponseBody.converterEmDto(produto));
        }

        return produtosDto;
    }

    public Long getId() {
        return id;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDesenvolvedora() {
        return desenvolvedora;
    }

    public void setDesenvolvedora(String desenvolvedora) {
        this.desenvolvedora = desenvolvedora;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
