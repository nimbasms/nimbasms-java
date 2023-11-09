package com.nimbasms.nimbasms.accounts;

import com.nimbasms.nimbasms.NimbaSMSClient;
import com.nimbasms.nimbasms.common.ApiBase;
import com.nimbasms.nimbasms.common.UriType;

import java.io.IOException;

public class Account extends ApiBase {
    public Account(NimbaSMSClient root) {
        super(root);
    }

    @Override
    public String toString() {
        return "<Nimba.Account>";
    }

    public AccountResponse get() throws IOException {
        return executeGet(UriType.ACCOUNTS, null, AccountResponse.class);
    }
}
