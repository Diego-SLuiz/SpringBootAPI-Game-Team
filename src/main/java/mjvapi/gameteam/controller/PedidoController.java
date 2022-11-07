package mjvapi.gameteam.controller;

import mjvapi.gameteam.dto.pedido.PedidoResponseBody;
import mjvapi.gameteam.enumeration.StatusPedido;
import mjvapi.gameteam.model.PedidoModel;
import mjvapi.gameteam.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/")
    public List<PedidoResponseBody> buscarPedidos() {
        return pedidoService.buscarPedidos();
    }

    @GetMapping("/{id}")
    public PedidoResponseBody buscarPedido(@PathVariable(name = "id") Long id) {
        return pedidoService.buscarPedido(id);
    }

    @PatchMapping("/{id}/adicionar")
    public PedidoResponseBody adicionarItemAoPedido(@PathVariable(name = "id") Long id, @RequestParam(name = "item") Long itemId) {
        return pedidoService.adicionarItemAoPedido(id, itemId);
    }

    @PatchMapping("/{id}/remover")
    public PedidoResponseBody removerItemDoPedido(@PathVariable(name = "id") Long id, @RequestParam(name = "item") Long itemId) {
        return pedidoService.removerItemDoPedido(id, itemId);
    }

}
