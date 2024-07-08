package hanghae.pre.bnbnac.controller;

import hanghae.pre.bnbnac.domain.Item;
import hanghae.pre.bnbnac.request.EditItem;
import hanghae.pre.bnbnac.request.PostItem;
import hanghae.pre.bnbnac.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return ResponseEntity.status(HttpStatus.OK).body("{\"msg\": \"삭제완료\"}");
    }
}
