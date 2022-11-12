package mjvapi.gameteam.dto.jogo;

import mjvapi.gameteam.model.JogoModel;
import mjvapi.gameteam.service.ProdutoService;

public class JogoRequestBody {
    private Long produto;

    public static JogoModel converterEmJogo(JogoRequestBody jogoDto) {
        ProdutoService produtoService = new ProdutoService();
        JogoModel jogo = new JogoModel();
        jogo.setProduto(produtoService.findById(jogoDto.getProduto()));

        return jogo;
    }

    public Long getProduto() {
        return produto;
    }

    public void setProduto(Long produto) {
        this.produto = produto;
    }

}
