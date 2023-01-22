package gn.nimba.nimbasms.contacts;

import gn.nimba.nimbasms.common.ApiBase;
import gn.nimba.nimbasms.NimbaSmsClient;
import gn.nimba.nimbasms.common.RootResult;
import gn.nimba.nimbasms.common.UriType;

import java.io.IOException;
import java.util.List;

public class ContactImpl extends ApiBase implements Contact {
    public ContactImpl(NimbaSmsClient root) {
        super(root);
    }

    @Override
    public RootResult<ContactResponse> list() throws IOException {
        return executeGet(UriType.CONTACTS, null, null, RootResult.class);
    }

    @Override
    public RootResult<ContactResponse> list(Integer limit, Integer offset) throws IOException {
        return executeGet(UriType.CONTACTS, createPaginationQueryParams(limit, offset), null, RootResult.class);
    }

    @Override
    public ContactResponse create(String numero, String name, List<String> groups) throws IOException {
        ContactRequest contactRequest = ContactRequest.builder()
                .numero(numero)
                .name(name)
                .groups(groups)
                .build();

        return executePost(UriType.CONTACTS, contactRequest, ContactResponse.class);
    }
}
