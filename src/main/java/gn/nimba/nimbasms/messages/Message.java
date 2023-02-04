package gn.nimba.nimbasms.messages;

import gn.nimba.nimbasms.common.Pageable;

import java.io.IOException;
import java.util.List;

public interface Message extends Pageable<MessageResponse> {
    MessageResponse create (String senderName, List<String> to, String message) throws IOException;

    MessageDetails retrieve(String messageId) throws IOException;
}
