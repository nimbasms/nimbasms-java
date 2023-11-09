package com.nimbasms.nimbasms.sendernames;

import com.nimbasms.nimbasms.NimbaSMSClient;
import com.nimbasms.nimbasms.common.ApiImplBase;
import com.nimbasms.nimbasms.common.UriType;

public class SenderName extends ApiImplBase<SenderNameResponse>{
    public SenderName(NimbaSMSClient root) {
        super(root);
    }

    @Override
    protected UriType getUri() {
        return UriType.SENDER_NAMES;
    }

    @Override
    protected Class<SenderNameResponse> getClassType() {
        return SenderNameResponse.class;
    }


    @Override
    public String toString() {
        return "<Nimba.SenderName>";
    }
}
