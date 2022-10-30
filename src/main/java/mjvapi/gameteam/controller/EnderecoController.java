package mjvapi.gameteam.controller;

import mjvapi.gameteam.model.EnderecoModel;
import mjvapi.gameteam.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/")
    public List<EnderecoModel> buscarTodos() {
        return enderecoService.buscarTodos();
    }

    @GetMapping("/{id}")
    public EnderecoModel buscarEndereco(@PathVariable("id") Long id) {
        return enderecoService.buscarEndereco(id);
    }

    @DeleteMapping("/{id}")
    public void deletarEndereco(@PathVariable(name = "id") Long id) {
        enderecoService.deletarEndereco(id);
    }

    @PostMapping("/novo")
    public void novoEndereco(@RequestBody EnderecoModel enderecoBody) {
        enderecoService.novoEndereco(enderecoBody);
    }

    @PatchMapping("/{id}/atualizar")
    public void atualizarEndereco(@PathVariable(name = "id") Long id, @RequestBody EnderecoModel enderecoBody) {
        enderecoService.atualizarEndereco(id, enderecoBody);
    }

}
