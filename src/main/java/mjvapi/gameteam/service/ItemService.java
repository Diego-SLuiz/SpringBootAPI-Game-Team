package mjvapi.gameteam.service;

import mjvapi.gameteam.dto.item.ItemRequestBody;
import mjvapi.gameteam.dto.item.ItemResponseBody;
import mjvapi.gameteam.dto.produto.ProdutoRequestBody;
import mjvapi.gameteam.dto.produto.ProdutoResponseBody;
import mjvapi.gameteam.model.ItemModel;
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

    public List<ItemModel> findAll() {
        return itemRepository.findAll();
    }

    public ItemModel findById(Long id) {
        return itemRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Item {%s} não encontrado", id)));
    }

    public ItemModel save(ItemModel item) {
        return itemRepository.save(item);
    }

    public void deleteById(Long id) {
        findById(id);
        itemRepository.deleteById(id);
    }

    public List<ItemResponseBody> buscarItens() {
        return ItemResponseBody.converterEmListaDto(findAll());
    }

    public ItemResponseBody buscarItem(Long id) {
        return ItemResponseBody.converterEmDto(findById(id));
    }

    public ItemModel novoItem(Long produtoId) {
        ProdutoModel produto = produtoService.findById(produtoId);
        ItemModel item = new ItemModel();
        item.setProduto(produto);

        return save(item);
    }

    public ItemResponseBody atualizarItem(Long id, ItemRequestBody itemBody) {
        ItemModel item = findById(id);

        if (itemBody.getProduto() != null) {
            ProdutoModel produto = produtoService.findById(itemBody.getProduto());
            item.setProduto(produto);
        }

        return ItemResponseBody.converterEmDto(save(item));
    }

}
