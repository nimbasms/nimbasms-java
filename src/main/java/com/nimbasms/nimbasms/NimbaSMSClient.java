package com.nimbasms.nimbasms;

import com.nimbasms.nimbasms.accounts.Account;
import com.nimbasms.nimbasms.contacts.Contact;
import com.nimbasms.nimbasms.groups.Group;
import com.nimbasms.nimbasms.messages.Message;
import com.nimbasms.nimbasms.sendernames.SenderName;
import okhttp3.Credentials;

public class NimbaSMSClient {
    private final String token;

    private final Account account;
    private final Contact contact;
    private final Group group;
    private final SenderName senderName;
    private final Message message;

    public NimbaSMSClient(String serviceId, String secretToken) {
        token = Credentials.basic(serviceId, secretToken);
        account = new Account(this);
        contact = new Contact(this);
        group = new Group(this);
        senderName = new SenderName(this);
        message = new Message(this);
    }

    public String getToken() {
        return token;
    }

    public Account getAccount() {
        return account;
    }

    public Contact getContact() {
        return contact;
    }

    public Group getGroup() {
        return group;
    }

    public SenderName getSenderName() {
        return senderName;
    }

    public Message getMessage() {
        return message;
    }
}
