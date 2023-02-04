package gn.nimba.nimbasms.contacts;

import gn.nimba.nimbasms.common.ApiBase;
import gn.nimba.nimbasms.NimbaSMSClient;
import gn.nimba.nimbasms.common.RootResult;
import gn.nimba.nimbasms.common.UriType;

import java.io.IOException;
import java.util.List;

public class ContactImpl extends ApiBase implements Contact {
    public ContactImpl(NimbaSMSClient client) {
        super(client);
    }

    @Override
    public String toString() {
        return "<Nimba.Contact>";
    }
    @Override
    public RootResult<ContactResponse> next() throws IOException {
        if (this.next == null) {
            return null;
        }
        return this.requestMessage(this.next, null);
    }

    @Override
    public RootResult<ContactResponse>  previous() throws IOException {
        if (this.previous == null) {
            return null;
        }
        return this.requestMessage(this.previous, null);
    }

    @Override
    public RootResult<ContactResponse> list() throws IOException {
        return this.requestMessage(BASE_URL + UriType.CONTACTS.getPath(), null);
    }

    @Override
    public RootResult<ContactResponse> list(Integer limit, Integer offset) throws IOException {
        return this.requestMessage(BASE_URL + UriType.CONTACTS.getPath(), createPaginationQueryParams(limit, offset));
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
