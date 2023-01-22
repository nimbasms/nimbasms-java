package gn.nimba.nimbasms.sendernames;

import gn.nimba.nimbasms.common.RootResult;
import gn.nimba.nimbasms.groups.GroupResponse;

import java.io.IOException;

public interface SenderName {
    RootResult<SenderNameResponse> list() throws IOException;
    RootResult<SenderNameResponse> list(Integer limit, Integer offset) throws IOException;
}
