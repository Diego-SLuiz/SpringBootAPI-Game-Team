package mjvapi.gameteam.controller;

import mjvapi.gameteam.dto.produto.ProdutoRequestBody;
import mjvapi.gameteam.dto.produto.ProdutoResponseBody;
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
    public List<ProdutoResponseBody> buscarProdutos() {
        return produtoService.buscarProdutos();
    }

    @GetMapping("/{id}")
    public ProdutoResponseBody buscarProduto(@PathVariable(name = "id") Long id) {
        return produtoService.buscarProduto(id);
    }

    @PostMapping("/novo")
    public ProdutoResponseBody novoProduto(@RequestBody ProdutoRequestBody produtoBody) {
        return produtoService.novoProduto(produtoBody);
    }

    @PatchMapping("/{id}/atualizar")
    public ProdutoResponseBody atualizarProduto(@PathVariable(name = "id") Long id, @RequestBody ProdutoRequestBody produtoBody) {
        return produtoService.atualizarProduto(id, produtoBody);
    }

}
