package mjvapi.gameteam.controller;

import mjvapi.gameteam.dto.endereco.EnderecoRequestBody;
import mjvapi.gameteam.dto.endereco.EnderecoResponseBody;
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
    public EnderecoResponseBody novoEndereco(@RequestBody EnderecoRequestBody enderecoRequest) {
        return enderecoService.novoEndereco(enderecoRequest);
    }

    @PatchMapping("/{id}/atualizar")
    public EnderecoResponseBody atualizarEndereco(@PathVariable(name = "id") Long id, @RequestBody EnderecoRequestBody enderecoRequest) {
        return enderecoService.atualizarEndereco(id, enderecoRequest);
    }

}
