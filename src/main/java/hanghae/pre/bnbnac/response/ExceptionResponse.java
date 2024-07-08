package hanghae.pre.bnbnac.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ExceptionResponse {

    private int status;
    private String message;

    @Builder
    public ExceptionResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

}
