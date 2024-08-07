package hanghae.pre.bnbnac.service;

import hanghae.pre.bnbnac.domain.Item;
import hanghae.pre.bnbnac.domain.ItemEditor;
import hanghae.pre.bnbnac.exception.ItemNotFound;
import hanghae.pre.bnbnac.repository.ItemRepository;
import hanghae.pre.bnbnac.request.EditItem;
import hanghae.pre.bnbnac.request.PostItem;
import hanghae.pre.bnbnac.response.SimpleMsgResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    public Item editItem(Long id, EditItem editItem) {
        Item item = findItem(id);
        ItemEditor itemEditor = createEditor(editItem, item);
        item.edit(itemEditor);

        return itemRepository.save(item);
    }

    private Item findItem(Long id) {
        return itemRepository.findById(id).orElseThrow(() -> new ItemNotFound(id));
    }

    private ItemEditor createEditor(EditItem editItem, Item item) {
        return item.toEditorBuilder()
                .content(editItem.getContent())
                .title(editItem.getTitle())
                .price(editItem.getPrice())
                .username(editItem.getUsername())
                .build();
    }

    public SimpleMsgResponse deleteItem(Long id) {
        Item item = findItem(id);

        itemRepository.delete(item);
        return new SimpleMsgResponse("삭제완료");
    }
}
