package hanghae.pre.bnbnac.controller;

import hanghae.pre.bnbnac.domain.Item;
import hanghae.pre.bnbnac.request.EditItem;
import hanghae.pre.bnbnac.request.PostItem;
import hanghae.pre.bnbnac.response.SimpleMsgResponse;
import hanghae.pre.bnbnac.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/post")
    public Item postItem(@RequestBody PostItem postItem) {
        return itemService.post(postItem);
    }

    @GetMapping("/post")
    public List<Item> getItems() {
        return itemService.getItems();
    }

    @PutMapping("/post/{id}")
    public Item editItem(@PathVariable Long id, @RequestBody EditItem editItem) {
        return itemService.editItem(id, editItem);
    }

    @DeleteMapping("/post/{id}")
    public SimpleMsgResponse deleteItem(@PathVariable Long id) {
        return itemService.deleteItem(id);
    }
}
