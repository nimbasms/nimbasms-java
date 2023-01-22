package gn.nimba.nimbasms.contacts;

import gn.nimba.nimbasms.common.RootResult;

import java.io.IOException;
import java.util.List;

public interface Contact {
    RootResult<ContactResponse> list() throws IOException;
    RootResult<ContactResponse> list(Integer limit, Integer offset) throws IOException;
    ContactResponse create(String numero, String name, List<String> groups) throws IOException;

}
