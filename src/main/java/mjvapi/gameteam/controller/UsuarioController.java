package mjvapi.gameteam.controller;

import mjvapi.gameteam.dto.pedido.PedidoResponseBody;
import mjvapi.gameteam.dto.usuario.UsuarioRequestBody;
import mjvapi.gameteam.dto.usuario.UsuarioResponseBody;
import mjvapi.gameteam.service.PedidoService;
import mjvapi.gameteam.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/")
    public List<UsuarioResponseBody> buscarUsuarios() {
        return usuarioService.buscarUsuarios();
    }

    @GetMapping("/{id}")
    public UsuarioResponseBody buscarUsuario(@PathVariable(name = "id") Long id) {
        return usuarioService.buscarUsuario(id);
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable(name = "id") Long id) {
        usuarioService.deletarUsuario(id);
    }

    @PostMapping("/novo")
    public UsuarioResponseBody novoUsuario(@RequestBody UsuarioRequestBody usuarioRequest) {
        return usuarioService.novoUsuario(usuarioRequest);
    }

    @PatchMapping("/{id}/atualizar")
    public UsuarioResponseBody atualizarUsuario(@PathVariable(name = "id") Long id, @RequestBody UsuarioRequestBody usuarioRequest) {
        return usuarioService.atualizarUsuario(id, usuarioRequest);
    }

    @GetMapping("/{id}/pedidos")
    public List<PedidoResponseBody> buscarPedidos(@PathVariable(name = "id") Long id) {
        return usuarioService.buscarPedidos(id);
    }

    @PatchMapping("/{id}/pedidos/adicionar")
    public List<PedidoResponseBody> adicionarPedido(@PathVariable(name = "id") Long id) {
        return usuarioService.adicionarPedido(id);
    }

    @PatchMapping("/{id}/pedidos/remover")
    public List<PedidoResponseBody> removerPedido(@PathVariable(name = "id") Long id, @RequestParam(name = "pedido") Long pedidoId) {
        return usuarioService.removerPedido(id, pedidoId);
    }

}
