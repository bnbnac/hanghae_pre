package hanghae.pre.bnbnac.response;

import lombok.Getter;

@Getter
public class SimpleMsgResponse {

    private final String msg;

    public SimpleMsgResponse(String msg) {
        this.msg = msg;
    }

}
