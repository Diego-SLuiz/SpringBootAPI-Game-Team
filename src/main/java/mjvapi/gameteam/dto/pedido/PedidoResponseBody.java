package mjvapi.gameteam.dto.pedido;

import mjvapi.gameteam.dto.item.ItemResponseBody;
import mjvapi.gameteam.enumeration.StatusPedido;
import mjvapi.gameteam.model.ItemModel;
import mjvapi.gameteam.model.PedidoModel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PedidoResponseBody {
    private Long id;
    private LocalDateTime data;
    private Double valor;
    private StatusPedido status;
    private List<ItemResponseBody> itens = new ArrayList<ItemResponseBody>();

    public static PedidoResponseBody converterEmDto(PedidoModel pedido) {
        PedidoResponseBody pedidoDto = new PedidoResponseBody();
        pedidoDto.setId(pedidoDto.getId());
        pedidoDto.setData(pedido.getData());
        pedidoDto.setValor(pedidoDto.getValor());
        pedidoDto.setStatus(pedidoDto.getStatus());
        pedidoDto.setItens(ItemResponseBody.converterEmListaDto(pedido.getItens()));

        return pedidoDto;
    }

    public static List<PedidoResponseBody> converterEmListaDto(List<PedidoModel> pedidos) {
        ArrayList<PedidoResponseBody> pedidosDto = new ArrayList<PedidoResponseBody>();

        for (PedidoModel pedido: pedidos) {
            pedidosDto.add(PedidoResponseBody.converterEmDto(pedido));
        }

        return pedidosDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public List<ItemResponseBody> getItens() {
        return itens;
    }

    public void setItens(List<ItemResponseBody> itens) {
        this.itens = itens;
    }

}
