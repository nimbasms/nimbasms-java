package com.nimbasms.nimbasms.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MessageDetailsResponse {
    @JsonProperty("messageid")
    private String messageid;
    @JsonProperty("sender_name")
    private String senderName;
    private String message;
    private String status;
    @JsonProperty("sent_at")
    private Integer sentAt;

    private List<Number> numbers;
}
