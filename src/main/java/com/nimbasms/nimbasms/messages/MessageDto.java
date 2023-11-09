package com.nimbasms.nimbasms.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageDto {
    @JsonProperty("messageid")
    private String messageId;
    @JsonProperty("sender_name")
    private String senderName;
    private String message;
    private String status;
    @JsonProperty("sent_at")
    private Integer sentAt;
    private String url;
}
