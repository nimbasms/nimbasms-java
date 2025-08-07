package com.nimbasms.nimbasms;

import com.nimbasms.nimbasms.accounts.Account;
import com.nimbasms.nimbasms.contacts.Contact;
import com.nimbasms.nimbasms.groups.Group;
import com.nimbasms.nimbasms.messages.Message;
import com.nimbasms.nimbasms.purchase.Purchase;
import com.nimbasms.nimbasms.sendernames.SenderName;
import lombok.Getter;
import okhttp3.Credentials;

@Getter
public class NimbaSMSClient {
    private final String token;

    private final Account account;
    private final Contact contact;
    private final Group group;
    private final SenderName senderName;
    private final Message message;
    private final Purchase purchase;
    public NimbaSMSClient(String serviceId, String secretToken) {
        token = Credentials.basic(serviceId, secretToken);
        account = new Account(this);
        contact = new Contact(this);
        group = new Group(this);
        senderName = new SenderName(this);
        message = new Message(this);
        purchase = new Purchase(this);
    }
}
