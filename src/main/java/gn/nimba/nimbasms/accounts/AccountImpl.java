package gn.nimba.nimbasms.accounts;

import gn.nimba.nimbasms.common.ApiBase;
import gn.nimba.nimbasms.NimbaSmsClient;
import gn.nimba.nimbasms.common.UriType;

import java.io.IOException;

public class AccountImpl extends ApiBase implements Account {
    public AccountImpl(NimbaSmsClient root) {
        super(root);
    }

    @Override
    public AccountResponse get() throws IOException {
        return executeGet(UriType.ACCOUNTS, null, null, AccountResponse.class);
    }
}
