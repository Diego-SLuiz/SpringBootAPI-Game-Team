package mjvapi.gameteam.controller;

import mjvapi.gameteam.model.ProdutoModel;
import mjvapi.gameteam.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/")
    public List<ProdutoModel> buscarTodos() {
        return produtoService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ProdutoModel buscarProduto(@PathVariable(name = "id") Long id) {
        return produtoService.buscarProduto(id);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable(name = "id") Long id) {
        produtoService.deletarProduto(id);
    }

    @PostMapping("/novo")
    public void novoProduto(@RequestBody ProdutoModel produtoBody) {
        produtoService.novoProduto(produtoBody);
    }

    @PatchMapping("/{id}/atualizar")
    public void atualizarProduto(@PathVariable(name = "id") Long id, @RequestBody ProdutoModel produtoBody) {
        produtoService.atualizarProduto(id, produtoBody);
    }

}
