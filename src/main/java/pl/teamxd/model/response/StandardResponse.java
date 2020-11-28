package pl.teamxd.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
public class StandardResponse {
    private final Type type;
    private final String message;
    private final Object data;

}
