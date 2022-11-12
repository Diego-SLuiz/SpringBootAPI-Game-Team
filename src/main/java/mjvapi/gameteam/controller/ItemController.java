package mjvapi.gameteam.controller;

import mjvapi.gameteam.dto.item.ItemRequestBody;
import mjvapi.gameteam.dto.item.ItemResponseBody;
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
    public List<ItemResponseBody> buscarItens() {
        return itemService.buscarItens();
    }

    @GetMapping("/{id}")
    public ItemResponseBody buscarItem(@PathVariable(name = "id") Long id) {
        return itemService.buscarItem(id);
    }

    @PatchMapping("/{id}/atualizar")
    public ItemResponseBody atualizarItem(@PathVariable(name = "id") Long id, @RequestBody ItemRequestBody itemBody) {
        return itemService.atualizarItem(id, itemBody);
    }

}
