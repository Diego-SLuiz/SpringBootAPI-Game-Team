package mjvapi.gameteam.controller;

import mjvapi.gameteam.dto.usuario.UsuarioRequestBody;
import mjvapi.gameteam.dto.usuario.UsuarioResponseBody;
import mjvapi.gameteam.model.UsuarioModel;
import mjvapi.gameteam.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public List<UsuarioModel> buscarTodos() {
        return usuarioService.buscarTodos();
    }

    @GetMapping("/{id}")
    public UsuarioModel buscarUsuario(@PathVariable(name = "id") Long id) {
        return usuarioService.buscarUsuario(id);
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable(name = "id") Long id) {
        usuarioService.deletarUsuario(id);
    }

    @PostMapping("/novo")
    public void novoUsuario(@RequestBody UsuarioRequestBody usuarioRequest) {
        usuarioService.novoUsuario(usuarioRequest);
    }

    @PatchMapping("/{id}/atualizar")
    public void atualizarUsuario(@PathVariable(name = "id") Long id, @RequestBody UsuarioRequestBody usuarioRequest) {
        usuarioService.atualizarUsuario(id, usuarioRequest);
    }

    @PatchMapping("/{id}/pedidos/adicionar")
    public void adicionarPedido(@PathVariable(name = "id") Long id, @RequestParam(name = "pedido") Long pedidoId) {
        usuarioService.adicionarPedido(id, pedidoId);
    }

    @PatchMapping("/{id}/pedidos/remover")
    public void removerPedido(@PathVariable(name = "id") Long id, @RequestParam(name = "pedido") Long pedidoId) {
        usuarioService.removerPedido(id, pedidoId);
    }
}
