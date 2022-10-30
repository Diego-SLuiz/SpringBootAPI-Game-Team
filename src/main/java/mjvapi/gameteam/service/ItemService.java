package mjvapi.gameteam.service;

import mjvapi.gameteam.model.ItemModel;
import mjvapi.gameteam.model.PedidoModel;
import mjvapi.gameteam.model.ProdutoModel;
import mjvapi.gameteam.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private PedidoService pedidoService;

    public List<ItemModel> buscarTodos() {
        return itemRepository.findAll();
    }

    public ItemModel buscarItem(Long id) {
        return itemRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
    }

    public void salvarItem(ItemModel item) {
        itemRepository.save(item);
    }

    public void deletarItem(Long id) {
        itemRepository.deleteById(id);
    }

    public void novoItem(Long produtoId, Long pedidoId) {
        ProdutoModel produto = produtoService.buscarProduto(produtoId);
        PedidoModel pedido = pedidoService.buscarPedido(pedidoId);

        ItemModel item = new ItemModel();
        item.setProduto(produto);
        pedido.getItens().add(item);
        salvarItem(item);
        pedidoService.salvarPedido(pedido);
    }

    public void atualizarItem(Long id, Long produtoId) {
        ProdutoModel produto = produtoService.buscarProduto(produtoId);
        ItemModel item = buscarItem(id);
        item.setProduto(produto);
        salvarItem(item);
    }

}
