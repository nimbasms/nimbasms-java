package gn.nimba.nimbasms.groups;

import gn.nimba.nimbasms.common.ApiBase;
import gn.nimba.nimbasms.NimbaSMSClient;
import gn.nimba.nimbasms.common.RootResult;
import gn.nimba.nimbasms.common.UriType;

import java.io.IOException;

public class GroupImpl extends ApiBase implements Group {
    public GroupImpl(NimbaSMSClient client) {
        super(client);
    }

    @Override
    public String toString() {
        return "<Nimba.Group>";
    }
    @Override
    public RootResult<GroupResponse> next() throws IOException {
        if (this.next == null) {
            return null;
        }
        return this.requestMessage(this.next, null);
    }

    @Override
    public RootResult<GroupResponse>  previous() throws IOException {
        if (this.previous == null) {
            return null;
        }
        return this.requestMessage(this.previous, null);
    }

    @Override
    public RootResult<GroupResponse> list() throws IOException {
        return this.requestMessage(BASE_URL + UriType.GROUPS.getPath(), null);
    }

    @Override
    public RootResult<GroupResponse> list(Integer limit, Integer offset) throws IOException {
        return this.requestMessage(BASE_URL + UriType.GROUPS.getPath(), createPaginationQueryParams(limit, offset));
    }
}
