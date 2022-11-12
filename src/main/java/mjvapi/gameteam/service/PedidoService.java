package mjvapi.gameteam.service;

import mjvapi.gameteam.dto.pedido.PedidoResponseBody;
import mjvapi.gameteam.enumeration.StatusPedido;
import mjvapi.gameteam.model.ItemModel;
import mjvapi.gameteam.model.PedidoModel;
import mjvapi.gameteam.model.ProdutoModel;
import mjvapi.gameteam.model.UsuarioModel;
import mjvapi.gameteam.repository.ItemRepository;
import mjvapi.gameteam.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ItemService itemService;

    public List<PedidoModel> findAll() {
        return pedidoRepository.findAll();
    }

    public PedidoModel findById(Long id) {
        return pedidoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Pedido {%s} não encontrado", id)));
    }

    public PedidoModel save(PedidoModel pedido) {
        return pedidoRepository.save(pedido);
    }

    public List<PedidoResponseBody> buscarPedidos() {
        return PedidoResponseBody.converterEmListaDto(findAll());
    }

    public PedidoResponseBody buscarPedido(Long id) {
        return PedidoResponseBody.converterEmDto(findById(id));
    }

    public PedidoModel novoPedido() {
        PedidoModel pedido = new PedidoModel();
        pedido.setValor(0.0);
        pedido.setData(LocalDateTime.now());
        pedido.setStatus(StatusPedido.PENDENTE);

        return save(pedido);
    }

    public PedidoResponseBody adicionarItemAoPedido(Long id, Long produtoId) {
        PedidoModel pedido = findById(id);

        for (ItemModel item: pedido.getItens()) {
            if (item.getProduto().getId() == produtoId) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Item com Produto {%s} já existe no Pedido {%s}", item.getProduto().getId(), id));
            }
        }

        ItemModel item = itemService.novoItem(produtoId);
        itemService.save(item);
        pedido.getItens().add(item);
        pedido.setValor(pedido.getValor() + item.getProduto().getValor());

        return PedidoResponseBody.converterEmDto(save(pedido));
    }

    public PedidoResponseBody removerItemDoPedido(Long id, Long produtoId) {
        PedidoModel pedido = findById(id);
        Long itemId = null;

        for (ItemModel item: pedido.getItens()) {
            if (item.getProduto().getId() == produtoId) {
                itemId = item.getId();
            }
        }

        if (itemId == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Item com Produto {%s} não existe no Pedido {%s}", produtoId, id));
        }

        ItemModel item = itemService.findById(itemId);
        pedido.getItens().remove(item);
        pedido.setValor(pedido.getValor() - item.getProduto().getValor());
        save(pedido);
        itemService.deleteById(itemId);

        return PedidoResponseBody.converterEmDto(pedido);
    }

}
