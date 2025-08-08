package com.nimbasms.nimbasms.purchase;

import com.nimbasms.nimbasms.NimbaSMSClient;
import com.nimbasms.nimbasms.common.ApiImplBase;
import com.nimbasms.nimbasms.common.UriType;

public class Purchase extends ApiImplBase<PurchaseResponse> {
    public Purchase(NimbaSMSClient client) {
        super(client);
    }

    @Override
    protected UriType getUri() {
        return UriType.PURCHASES;
    }

    @Override
    protected Class<PurchaseResponse> getClassType() {
        return PurchaseResponse.class;
    }

    @Override
    public String toString() {
        return "<Nimba.Purchase>";
    }
}
