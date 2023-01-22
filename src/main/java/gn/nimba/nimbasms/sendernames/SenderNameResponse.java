package gn.nimba.nimbasms.sendernames;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SenderNameResponse {
    @JsonProperty("sendername_id")
    private String sendernameId;
    private String name;
    private String status;
    @JsonProperty("added_at")
    private Integer addedAt;
}
