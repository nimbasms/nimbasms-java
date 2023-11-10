package com.nimbasms.nimbasms.contacts;

import com.nimbasms.nimbasms.NimbaSMSClient;
import com.nimbasms.nimbasms.common.ApiImplBase;
import com.nimbasms.nimbasms.common.UriType;

import java.io.IOException;
import java.util.List;

public class Contact extends ApiImplBase<ContactResponse>  {
    public Contact(NimbaSMSClient client) {
        super(client);
    }

    @Override
    protected UriType getUri() {
        return UriType.CONTACTS;
    }

    @Override
    protected Class<ContactResponse> getClassType() {
        return ContactResponse.class;
    }

    @Override
    public String toString() {
        return "<Nimba.Contact>";
    }

    public ContactDto create(String numero, String name, List<String> groups) throws IOException {
        ContactRequest contactRequest = ContactRequest.builder()
                .numero(numero)
                .name(name)
                .groups(groups)
                .build();

        return executePost(UriType.CONTACTS, contactRequest, ContactDto.class);
    }
}
