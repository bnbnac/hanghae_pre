package hanghae.pre.bnbnac.exception;


public class ItemNotFound extends RuntimeException {

    public ItemNotFound(Long id) {
        super("존재하지 않는 아이템입니다. id: " + id);
    }

}
