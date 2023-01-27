package gn.nimba.nimbasms;

import gn.nimba.nimbasms.accounts.Account;
import gn.nimba.nimbasms.accounts.AccountImpl;
import gn.nimba.nimbasms.contacts.Contact;
import gn.nimba.nimbasms.contacts.ContactImpl;
import gn.nimba.nimbasms.groups.Group;
import gn.nimba.nimbasms.groups.GroupImpl;
import gn.nimba.nimbasms.messages.Message;
import gn.nimba.nimbasms.messages.MessageImpl;
import gn.nimba.nimbasms.sendernames.SenderName;
import gn.nimba.nimbasms.sendernames.SenderNameImpl;
import okhttp3.Credentials;

public class NimbaSMSClient {
    private final String token;

    private final Account account;
    private final Contact contact;
    private final Group group;
    private final SenderName senderName;
    private final Message message;

    public NimbaSMSClient(String username, String password) {
        token = Credentials.basic(username, password);
        account = new AccountImpl(this);
        contact = new ContactImpl(this);
        group = new GroupImpl(this);
        senderName = new SenderNameImpl(this);
        message = new MessageImpl(this);
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
