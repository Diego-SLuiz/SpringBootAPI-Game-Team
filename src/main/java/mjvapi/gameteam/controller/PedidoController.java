package mjvapi.gameteam.controller;

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
    public List<PedidoModel> buscarTodos() {
        return pedidoService.buscarTodos();
    }

    @GetMapping("/{id}")
    public PedidoModel buscarPedido(@PathVariable(name = "id") Long id) {
        return pedidoService.buscarPedido(id);
    }

    @DeleteMapping("/{id}")
    public void deletarPedido(@PathVariable(name = "id") Long id) {
        pedidoService.deletarPedido(id);
    }

    @PostMapping("/novo")
    public void novoPedido(@RequestParam(name = "usuario") Long usuarioId) {
        pedidoService.novoPedido(usuarioId);
    }

    @PatchMapping("/{id}/adicionar")
    public void adicionarItemAoPedido(@PathVariable(name = "id") Long id, @RequestParam(name = "item") Long itemId) {
        pedidoService.adicionarItemAoPedido(id, itemId);
    }

    @PatchMapping("/{id}/remover")
    public void removerItemDoPedido(@PathVariable(name = "id") Long id, @RequestParam(name = "item") Long itemId) {
        pedidoService.removerItemDoPedido(id, itemId);
    }

    @PatchMapping("/{id}/atualizar")
    public void atualizarPedido(@PathVariable(name = "id") Long id, @RequestParam(name = "status") StatusPedido status) {
        pedidoService.atualizarPedido(id, status);
    }

}
