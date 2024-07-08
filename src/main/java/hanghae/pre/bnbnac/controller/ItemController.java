package hanghae.pre.bnbnac.controller;

import hanghae.pre.bnbnac.entity.Item;
import hanghae.pre.bnbnac.request.PostItem;
import hanghae.pre.bnbnac.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/post")
    public Item postItem(@RequestBody PostItem postItem) {
        return itemService.post(postItem);
    }
}
