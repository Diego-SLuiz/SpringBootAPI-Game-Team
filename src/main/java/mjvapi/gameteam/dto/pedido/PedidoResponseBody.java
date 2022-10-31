package mjvapi.gameteam.dto.pedido;

import mjvapi.gameteam.enumeration.StatusPedido;
import mjvapi.gameteam.model.ItemModel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PedidoResponseBody {
    private Long id;
    private LocalDateTime data;
    private Double valor;
    private StatusPedido status;
    private List<ItemModel> itens = new ArrayList<ItemModel>();

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

    public List<ItemModel> getItens() {
        return itens;
    }

    public void setItens(List<ItemModel> itens) {
        this.itens = itens;
    }

}
