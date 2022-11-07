package mjvapi.gameteam.controller;

import mjvapi.gameteam.dto.biblioteca.BibliotecaResponseBody;
import mjvapi.gameteam.model.BibliotecaModel;
import mjvapi.gameteam.service.BibliotecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/biblioteca")
public class BibliotecaController {
    @Autowired
    private BibliotecaService bibliotecaService;

    @GetMapping("/")
    public List<BibliotecaResponseBody> buscarBibliotecas() {
        return bibliotecaService.buscarBibliotecas();
    }

    @GetMapping("/{id}")
    public BibliotecaResponseBody buscarBiblioteca(@PathVariable("id") Long id) {
        return bibliotecaService.buscarBiblioteca(id);
    }

    @PatchMapping("/{id}/adicionar")
    public BibliotecaResponseBody adicionarJogoParaBiblioteca(@PathVariable(name = "id") Long id, @RequestParam(name = "jogo") Long jogoId) {
        return bibliotecaService.adicionarJogoParaBiblioteca(id, jogoId);
    }

    @PatchMapping("/{id}/remover")
    public BibliotecaResponseBody removerJogoDaBiblioteca(@PathVariable(name = "id") Long id, @RequestParam(name = "jogo") Long jogoId) {
        return bibliotecaService.removerJogoDaBiblioteca(id, jogoId);
    }

}
