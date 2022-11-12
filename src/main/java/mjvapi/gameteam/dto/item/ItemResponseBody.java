package mjvapi.gameteam.dto.item;

import mjvapi.gameteam.model.ItemModel;

import java.util.ArrayList;
import java.util.List;

public class ItemResponseBody {
    private Long id;
    private Double valor;
    private Long produto;

    public static ItemResponseBody converterEmDto(ItemModel item) {
        ItemResponseBody itemDto = new ItemResponseBody();
        itemDto.setId(item.getId());
        itemDto.setValor(item.getProduto().getValor());
        itemDto.setProduto(item.getProduto().getId());

        return itemDto;
    }

    public static List<ItemResponseBody> converterEmListaDto(List<ItemModel> itens) {
        List<ItemResponseBody> itensDto = new ArrayList<ItemResponseBody>();

        for (ItemModel item: itens) {
            itensDto.add(ItemResponseBody.converterEmDto(item));
        }

        return itensDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Long getProduto() {
        return produto;
    }

    public void setProduto(Long produto) {
        this.produto = produto;
    }

}
