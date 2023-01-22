package gn.nimba.nimbasms.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageRequest {
    @JsonProperty("sender_name")
    private String senderName;
    private List<String> to;
    private String message;
}
