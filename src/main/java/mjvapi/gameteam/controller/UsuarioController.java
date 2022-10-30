package mjvapi.gameteam.controller;

import mjvapi.gameteam.dto.usuario.UsuarioRequestBody;
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
    public void novoUsuario(@RequestBody UsuarioModel usuarioBody) {
        usuarioService.novoUsuario(usuarioBody);
    }

    @PatchMapping("/{id}/atualizar")
    public void atualizarUsuario(@PathVariable(name = "id") Long id, @RequestBody UsuarioRequestBody usuarioBody) {
        usuarioService.atualizarUsuario(id, usuarioBody);
    }

}
