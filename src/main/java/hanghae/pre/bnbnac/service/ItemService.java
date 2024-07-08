package hanghae.pre.bnbnac.service;

import hanghae.pre.bnbnac.entity.Item;
import hanghae.pre.bnbnac.repository.ItemRepository;
import hanghae.pre.bnbnac.request.PostItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public Item post(PostItem postItem) {
        Item item = buildItem(postItem);

        return itemRepository.save(item);
    }

    private Item buildItem(PostItem postItem) {
        return Item.builder()
                .title(postItem.getTitle())
                .price(postItem.getPrice())
                .content(postItem.getContent())
                .username(postItem.getUsername())
                .build();
    }
}
