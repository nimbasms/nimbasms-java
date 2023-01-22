package gn.nimba.nimbasms.groups;

import gn.nimba.nimbasms.common.ApiBase;
import gn.nimba.nimbasms.NimbaSmsClient;
import gn.nimba.nimbasms.common.RootResult;
import gn.nimba.nimbasms.common.UriType;

import java.io.IOException;

public class GroupImpl extends ApiBase implements Group {
    public GroupImpl(NimbaSmsClient root) {
        super(root);
    }

    @Override
    public RootResult<GroupResponse> list() throws IOException {
        return executeGet(UriType.GROUPS, null, null, RootResult.class);
    }

    @Override
    public RootResult<GroupResponse> list(Integer limit, Integer offset) throws IOException {
        return executeGet(UriType.GROUPS, createPaginationQueryParams(limit, offset), null, RootResult.class);
    }
}
