package gn.nimba.nimbasms.messages;

import gn.nimba.nimbasms.common.RootResult;

import java.io.IOException;
import java.util.List;

public interface Message {
    RootResult<MessageResponse> list() throws IOException;
    RootResult<MessageResponse> list(Integer limit, Integer offset) throws IOException;
    MessageResponse create (String senderName, List<String> to, String message) throws IOException;

    MessageDetails retrieve(String messageId) throws IOException;
}
