package gn.nimba.nimbasms.contacts;

import gn.nimba.nimbasms.common.Pageable;

import java.io.IOException;
import java.util.List;

public interface Contact extends Pageable<ContactResponse> {
    ContactResponse create(String numero, String name, List<String> groups) throws IOException;

}
