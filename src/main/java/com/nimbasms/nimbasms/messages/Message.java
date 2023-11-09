package com.nimbasms.nimbasms.messages;

import com.nimbasms.nimbasms.NimbaSMSClient;
import com.nimbasms.nimbasms.common.ApiImplBase;
import com.nimbasms.nimbasms.common.UriType;

import java.io.IOException;
import java.util.List;

public class Message extends ApiImplBase<MessageResponse> {
    public Message(NimbaSMSClient client) {
        super(client);
    }

    @Override
    protected UriType getUri() {
        return UriType.MESSAGES;
    }

    @Override
    protected Class<MessageResponse> getClassType() {
        return MessageResponse.class;
    }

    @Override
    public String toString() {
        return "<Nimba.Message>";
    }

    public MessageResponse create(String senderName, List<String> to, String message) throws IOException {
        MessageRequest messageRequest = MessageRequest.builder()
                .senderName(senderName)
                .to(to)
                .message(message)
                .build();

        return executePost(UriType.MESSAGES, messageRequest, MessageResponse.class);
    }

    public MessageDetailsResponse retrieve(String messageId) throws IOException {
        return executeGet(UriType.MESSAGES, List.of(messageId), MessageDetailsResponse.class);
    }
}
