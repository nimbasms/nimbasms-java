package gn.nimba.nimbasms.sendernames;

import gn.nimba.nimbasms.common.ApiBase;
import gn.nimba.nimbasms.NimbaSmsClient;
import gn.nimba.nimbasms.common.RootResult;
import gn.nimba.nimbasms.common.UriType;

import java.io.IOException;

public class SenderNameImpl extends ApiBase implements SenderName {
    public SenderNameImpl(NimbaSmsClient root) {
        super(root);
    }

    @Override
    public RootResult<SenderNameResponse> list() throws IOException {
        return executeGet(UriType.SENDER_NAMES, null, null, RootResult.class);
    }

    @Override
    public RootResult<SenderNameResponse> list(Integer limit, Integer offset) throws IOException {
        return executeGet(UriType.SENDER_NAMES, createPaginationQueryParams(limit, offset), null, RootResult.class);
    }
}
