package hanghae.pre.bnbnac.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private Integer price;

    private String username;

    @Builder
    public Item(String title, String content, Integer price, String username) {
        this.title = title;
        this.content = content;
        this.price = price;
        this.username = username;
    }

    public ItemEditor.ItemEditorBuilder toEditorBuilder() {
        return ItemEditor.builder()
                .content(content)
                .title(title)
                .username(username)
                .price(price);
    }

    public void edit(ItemEditor itemEditor) {
        this.title = itemEditor.getTitle();
        this.content = itemEditor.getContent();
        this.price = itemEditor.getPrice();
        this.username = itemEditor.getUsername();
    }
}
