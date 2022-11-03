package mjvapi.gameteam.controller;

import mjvapi.gameteam.model.JogoModel;
import mjvapi.gameteam.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogo")
public class JogoController {
    @Autowired
    private JogoService jogoService;

    @GetMapping("/")
    public List<JogoModel> buscarTodos() {
        return jogoService.buscarTodos();
    }

    @GetMapping("/{id}")
    public JogoModel buscarJogo(@PathVariable(name = "id") Long id) {
        return jogoService.buscarJogo(id);
    }

    @DeleteMapping("/{id}")
    public void deletarJogo(@PathVariable(name = "id") Long id) {
        jogoService.deletarJogo(id);
    }

    @PostMapping("/novo")
    public void novoJogo() {
        jogoService.novoJogo();
    }

    @PatchMapping("/{id}/atualizar")
    public void atualizarJogo(@PathVariable(name = "id") Long id, @RequestParam(name = "produto") Long produtoId) {
        jogoService.atualizarJogo(id, produtoId);
    }

}
