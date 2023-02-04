package gn.nimba.nimbasms.accounts;

import gn.nimba.nimbasms.common.ApiBase;
import gn.nimba.nimbasms.NimbaSMSClient;
import gn.nimba.nimbasms.common.UriType;

import java.io.IOException;

public class AccountImpl extends ApiBase implements Account {
    public AccountImpl(NimbaSMSClient root) {
        super(root);
    }

    @Override
    public String toString() {
        return "<Nimba.Account>";
    }

    @Override
    public AccountResponse get() throws IOException {
        return executeGet(UriType.ACCOUNTS, null, AccountResponse.class);
    }
}
