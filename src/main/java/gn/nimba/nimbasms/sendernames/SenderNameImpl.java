package gn.nimba.nimbasms.sendernames;

import gn.nimba.nimbasms.common.ApiBase;
import gn.nimba.nimbasms.NimbaSMSClient;
import gn.nimba.nimbasms.common.RootResult;
import gn.nimba.nimbasms.common.UriType;

import java.io.IOException;

public class SenderNameImpl extends ApiBase implements SenderName {
    public SenderNameImpl(NimbaSMSClient root) {
        super(root);
    }

    @Override
    public String toString() {
        return "<Nimba.SenderName>";
    }

    @Override
    public RootResult<SenderNameResponse> next() throws IOException {
        if (this.next == null) {
            return null;
        }
        return this.requestMessage(this.next, null);
    }

    @Override
    public RootResult<SenderNameResponse> previous() throws IOException {
        if (this.previous == null) {
            return null;
        }
        return this.requestMessage(this.previous, null);
    }
    @Override
    public RootResult<SenderNameResponse> list() throws IOException {
        return this.requestMessage(BASE_URL + UriType.SENDER_NAMES.getPath(), null);
    }

    @Override
    public RootResult<SenderNameResponse> list(Integer limit, Integer offset) throws IOException {
        return this.requestMessage(BASE_URL + UriType.SENDER_NAMES.getPath(), createPaginationQueryParams(limit, offset));
    }
}
