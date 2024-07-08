package hanghae.pre.bnbnac.domain;

import lombok.Getter;

@Getter
public class ItemEditor {

    private final String title;
    private final String content;
    private final Integer price;

    private ItemEditor(String title, String content, Integer price) {
        this.title = title;
        this.content = content;
        this.price = price;
    }

    public static ItemEditorBuilder builder() {
        return new ItemEditorBuilder();
    }

    public static class ItemEditorBuilder {

        private String title;
        private String content;
        private Integer price;

        ItemEditorBuilder() {}

        public ItemEditorBuilder title(String title) {
            if (title != null) {
                this.title = title;
            }
            return this;
        }

        public ItemEditorBuilder content(String content) {
            if (content != null) {
                this.content = content;
            }
            return this;
        }

        public ItemEditorBuilder price(Integer price) {
            if (price != null) {
                this.price = price;
            }
            return this;
        }

        public ItemEditor build() {
            return new ItemEditor(title, content, price);
        }

    }
}
