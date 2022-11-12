package mjvapi.gameteam.dto.produto;

import mjvapi.gameteam.model.ProdutoModel;

public class ProdutoRequestBody {
    private String nome;
    private String descricao;
    private String desenvolvedora;
    private Double valor;

    public static ProdutoModel converterEmProduto(ProdutoRequestBody produtoDto) {
        ProdutoModel produto = new ProdutoModel();
        produto.setNome(produtoDto.getNome());
        produto.setDescricao(produtoDto.getDescricao());
        produto.setDesenvolvedora(produtoDto.getDesenvolvedora());
        produto.setValor(produtoDto.getValor());

        return produto;
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
