package mjvapi.gameteam.service;

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

    @Autowired
    private PedidoService pedidoService;

    public List<ProdutoModel> buscarTodos() {
        return produtoRepository.findAll();
    }

    public ProdutoModel buscarProduto(Long id) {
        return produtoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
    }

    public void salvarProduto(ProdutoModel produto) {
        produtoRepository.save(produto);
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }

    public void novoProduto(ProdutoModel produtoBody) {
        salvarProduto(produtoBody);
    }

    public ProdutoModel atualizarProduto(Long id, ProdutoModel produtoBody) {
        ProdutoModel produto = buscarProduto(id);

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

        return produtoRepository.save(produto);
    }

}
