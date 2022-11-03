package mjvapi.gameteam.controller;

import mjvapi.gameteam.model.ItemModel;
import mjvapi.gameteam.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public List<ItemModel> buscarTodos() {
        return itemService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ItemModel buscarItem(@PathVariable(name = "id") Long id) {
        return itemService.buscarItem(id);
    }

    @DeleteMapping("/{id}")
    public void deletarItem(@PathVariable(name = "id") Long id) {
        itemService.deletarItem(id);
    }

    @PostMapping("/novo")
    public void novoItem() {
        itemService.novoItem();
    }

    @PatchMapping("/{id}/atualizar")
    public void atualizarItem(@PathVariable(name = "id") Long id, @RequestParam(name = "produto") Long produtoId) {
        itemService.atualizarItem(id, produtoId);
    }

}
