package com.nimbasms.nimbasms.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageRequest {
    @JsonProperty("sender_name")
    private String senderName;
    private List<String> to;
    private String message;
}
