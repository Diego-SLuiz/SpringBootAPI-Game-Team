package mjvapi.gameteam.dto.item;

import mjvapi.gameteam.model.ItemModel;
import mjvapi.gameteam.service.ProdutoService;

public class ItemRequestBody {
    private Long produto;

    public static ItemModel converterEmItem(ItemRequestBody itemDto) {
        ProdutoService produtoService = new ProdutoService();
        ItemModel item = new ItemModel();
        item.setProduto(produtoService.findById(itemDto.getProduto()));

        return item;
    }

    public Long getProduto() {
        return produto;
    }

    public void setProduto(Long produto) {
        this.produto = produto;
    }

}
