package mjvapi.gameteam.service;

import mjvapi.gameteam.enumeration.StatusPedido;
import mjvapi.gameteam.model.ItemModel;
import mjvapi.gameteam.model.PedidoModel;
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

    public List<PedidoModel> buscarTodos() {
        return pedidoRepository.findAll();
    }

    public PedidoModel buscarPedido(Long id) {
        return pedidoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
    }

    public void salvarPedido(PedidoModel pedido) {
        pedidoRepository.save(pedido);
    }

    public void deletarPedido(Long id) {
        pedidoRepository.deleteById(id);
    }

    public void novoPedido() {
        PedidoModel pedido = new PedidoModel();
        pedido.setValor(0.0);
        pedido.setData(LocalDateTime.now());
        pedido.setStatus(StatusPedido.PENDENTE);
        salvarPedido(pedido);
    }

    public void adicionarItemAoPedido(Long id, Long itemId) {
        PedidoModel pedido = buscarPedido(id);
        ItemModel item = itemService.buscarItem(itemId);

        if (pedido.getItens().contains(item)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Item {%s} já existe no Pedido {%s}", itemId, id));
        }

        pedido.getItens().add(item);
        pedido.setValor(pedido.getValor() + item.getProduto().getValor());
        salvarPedido(pedido);
    }

    public void removerItemDoPedido(Long id, Long itemId) {
        PedidoModel pedido = buscarPedido(id);
        ItemModel item = itemService.buscarItem(itemId);

        if (!pedido.getItens().contains(item)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Item {%s} não existe no Pedido {%s}", itemId, id));
        }

        pedido.getItens().remove(item);
        pedido.setValor(pedido.getValor() - item.getProduto().getValor());
        salvarPedido(pedido);
    }

    public void atualizarPedido(Long id, StatusPedido status) {
        PedidoModel pedido = buscarPedido(id);
        pedido.setStatus(status);
        salvarPedido(pedido);
    }

}
