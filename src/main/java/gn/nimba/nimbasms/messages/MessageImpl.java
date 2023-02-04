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
    public String toString() {
        return "<Nimba.Message>";
    }

    @Override
    public RootResult<MessageResponse> next() throws IOException {
        if (this.next == null) {
            return null;
        }
        return this.requestMessage(this.next, null);
    }

    @Override
    public RootResult<MessageResponse>  previous() throws IOException {
        if (this.previous == null) {
            return null;
        }
        return this.requestMessage(this.previous, null);
    }

    @Override
    public RootResult<MessageResponse> list() throws IOException {
        return this.requestMessage(BASE_URL + UriType.MESSAGES.getPath(), null);

    }

    @Override
    public RootResult<MessageResponse> list(Integer limit, Integer offset) throws IOException {
        return this.requestMessage(BASE_URL + UriType.MESSAGES.getPath(), createPaginationQueryParams(limit, offset));
    }

    @Override
    public MessageResponse create(String senderName, List<String> to, String message) throws IOException {
        MessageRequest messageRequest = MessageRequest.builder()
                .senderName(senderName)
                .to(to)
                .message(message)
                .build();

        return executePost(UriType.MESSAGES, messageRequest, MessageResponse.class);
    }

    @Override
    public MessageDetails retrieve(String messageId) throws IOException {
        return executeGet(UriType.MESSAGES, List.of(messageId), MessageDetails.class);
    }
}
