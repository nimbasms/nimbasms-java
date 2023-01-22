package gn.nimba.nimbasms.accounts;

import java.io.IOException;

public interface Account {
    AccountResponse get() throws IOException;
}
