package gn.nimba.nimbasms.messages;

import gn.nimba.nimbasms.common.ApiBase;
import gn.nimba.nimbasms.NimbaSMSClient;
import gn.nimba.nimbasms.common.RootResult;
import gn.nimba.nimbasms.common.UriType;

import java.io.IOException;
import java.util.List;

public class MessageImpl extends ApiBase implements Message {
    public MessageImpl(NimbaSMSClient root) {
        super(root);
    }

    @Override
    public RootResult<MessageResponse> list() throws IOException {
        return executeGet(UriType.MESSAGES, null, null, RootResult.class);
    }

    @Override
    public RootResult<MessageResponse> list(Integer limit, Integer offset) throws IOException {
        return executeGet(UriType.MESSAGES, createPaginationQueryParams(limit, offset), null, RootResult.class);

    }

    @Override
    public MessageResponse create(String senderName, List<String> to, String message) throws IOException {
        MessageRequest messageRequest= MessageRequest.builder()
                .senderName(senderName)
                .to(to)
                .message(message)
                .build();

        return executePost(UriType.MESSAGES, messageRequest, MessageResponse.class);
    }

    @Override
    public MessageDetails retrieve(String messageId) throws IOException {
        return executeGet(UriType.MESSAGES,null, List.of(messageId), MessageDetails.class);
    }
}
