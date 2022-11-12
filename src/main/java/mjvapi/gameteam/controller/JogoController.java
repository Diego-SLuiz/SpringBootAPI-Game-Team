package mjvapi.gameteam.controller;

import mjvapi.gameteam.dto.jogo.JogoRequestBody;
import mjvapi.gameteam.dto.jogo.JogoResponseBody;
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
    public List<JogoResponseBody> buscarJogos() {
        return jogoService.buscarJogos();
    }

    @GetMapping("/{id}")
    public JogoResponseBody buscarJogo(@PathVariable(name = "id") Long id) {
        return jogoService.buscarJogo(id);
    }

    @PatchMapping("/{id}/atualizar")
    public JogoResponseBody atualizarJogo(@PathVariable(name = "id") Long id, @RequestBody JogoRequestBody jogoBody) {
        return jogoService.atualizarJogo(id, jogoBody);
    }

}
