package com.nimbasms.nimbasms.groups;

import com.nimbasms.nimbasms.NimbaSMSClient;
import com.nimbasms.nimbasms.common.ApiImplBase;
import com.nimbasms.nimbasms.common.UriType;

public class Group extends ApiImplBase<GroupResponse>  {
    public Group(NimbaSMSClient client) {
        super(client);
    }

    @Override
    protected UriType getUri() {
        return UriType.MESSAGES;
    }

    @Override
    protected Class<GroupResponse> getClassType() {
        return GroupResponse.class;
    }

    @Override
    public String toString() {
        return "<Nimba.Group>";
    }
}
