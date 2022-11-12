package mjvapi.gameteam.service;

import mjvapi.gameteam.dto.produto.ProdutoRequestBody;
import mjvapi.gameteam.dto.produto.ProdutoResponseBody;
import mjvapi.gameteam.model.ProdutoModel;
import mjvapi.gameteam.repository.PedidoRepository;
import mjvapi.gameteam.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoModel> findAll() {
        return produtoRepository.findAll();
    }

    public ProdutoModel findById(Long id) {
        return produtoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Produto {%s} não encontrado", id)));
    }

    public ProdutoModel save(ProdutoModel produto) {
        return produtoRepository.save(produto);
    }

    public List<ProdutoResponseBody> buscarProdutos() {
        return ProdutoResponseBody.converterEmListaDto(findAll());
    }

    public ProdutoResponseBody buscarProduto(Long id) {
        return ProdutoResponseBody.converterEmDto(findById(id));
    }

    public ProdutoResponseBody novoProduto(ProdutoRequestBody produtoBody) {
        ProdutoModel produto = save(ProdutoRequestBody.converterEmProduto(produtoBody));

        return ProdutoResponseBody.converterEmDto(produto);
    }

    public ProdutoResponseBody atualizarProduto(Long id, ProdutoRequestBody produtoBody) {
        ProdutoModel produto = findById(id);

        if (produtoBody.getNome() != null) {
            produto.setNome(produtoBody.getNome());
        }

        if (produtoBody.getDescricao() != null) {
            produto.setDescricao(produtoBody.getDescricao());
        }

        if (produtoBody.getDesenvolvedora() != null) {
            produto.setDesenvolvedora(produtoBody.getDesenvolvedora());
        }

        if (produtoBody.getValor() != null) {
            produto.setValor(produtoBody.getValor());
        }

        return ProdutoResponseBody.converterEmDto(save(produto));
    }

}
