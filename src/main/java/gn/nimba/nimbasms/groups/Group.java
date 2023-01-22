package gn.nimba.nimbasms.groups;

import gn.nimba.nimbasms.common.RootResult;

import java.io.IOException;

public interface Group {
    RootResult<GroupResponse> list() throws IOException;
    RootResult<GroupResponse> list(Integer limit, Integer offset) throws IOException;
}
