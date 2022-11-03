package mjvapi.gameteam.controller;

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
    public List<BibliotecaModel> buscarTodos() {
        return bibliotecaService.buscarTodos();
    }

    @GetMapping("/{id}")
    public BibliotecaModel buscarBiblioteca(@PathVariable("id") Long id) {
        return bibliotecaService.buscarBiblioteca(id);
    }

    @DeleteMapping("/{id}")
    public void deletarBiblioteca(@PathVariable(name = "id") Long id) {
        bibliotecaService.deletarBiblioteca(id);
    }

    @PostMapping("/nova")
    public void novaBiblioteca() {
        bibliotecaService.novaBiblioteca();
    }

    @PatchMapping("/{id}/adicionar")
    public void adicionarJogoParaBiblioteca(@PathVariable(name = "id") Long id, @RequestParam(name = "jogo") Long jogoId) {
        bibliotecaService.adicionarJogoParaBiblioteca(id, jogoId);
    }

    @PatchMapping("/{id}/remover")
    public void removerJogoDaBiblioteca(@PathVariable(name = "id") Long id, @RequestParam(name = "jogo") Long jogoId) {
        bibliotecaService.removerJogoDaBiblioteca(id, jogoId);
    }

}
