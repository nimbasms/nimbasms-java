package gn.nimba.nimbasms;

import gn.nimba.nimbasms.accounts.AccountResponse;
import gn.nimba.nimbasms.common.RootResult;
import gn.nimba.nimbasms.contacts.ContactResponse;
import gn.nimba.nimbasms.groups.GroupResponse;
import gn.nimba.nimbasms.messages.MessageResponse;
import gn.nimba.nimbasms.messages.MessageDetails;
import gn.nimba.nimbasms.sendernames.SenderNameResponse;

import java.io.IOException;
import java.util.List;

public class CodeUsage {

	public static void main(String[] args) throws IOException {
		NimbaSMSClient client = new NimbaSMSClient("XXXX", "XXXX");

		AccountResponse accountResponse = client.getAccount().get();
		System.out.println(accountResponse);

		// Get Sendernames
		RootResult<SenderNameResponse> senderNameResponse = client.getSenderName().list();
		System.out.println(senderNameResponse);

		// Get last 1O Sendernames
		RootResult<SenderNameResponse> last10SenderNameResponse = client.getSenderName().list(20, 1);
		System.out.println(last10SenderNameResponse);

		// Get Contact
		RootResult<ContactResponse> contacts = client.getContact().list();
		System.out.println(contacts);

		// Get last 1O Contact
		RootResult<ContactResponse> last10contacts = client.getContact().list(10, 1);
		System.out.println(last10contacts);

		RootResult<GroupResponse> groups = client.getGroup().list();
		System.out.println(groups);

		RootResult<GroupResponse> last10groups = client.getGroup().list(10, 1);
		System.out.println(last10groups);

		//Get all messages
		RootResult<MessageResponse> messages = client.getMessage().list();
		System.out.println(messages);

		//Get only last 10 messages
		RootResult<MessageResponse> last10Messages = client.getMessage().list(10, 1);
		System.out.println(last10Messages);

		//retrieve message...
		MessageDetails messageDetails = client.getMessage().retrieve("123");
		System.out.println(messageDetails);

		//Create with groups and name - name and groups are optional.
		ContactResponse contactResponseWithGroupsAndName = client.getContact().create("+224XXXXXXXXX", "Foo", List.of("API", "Facebook Client"));
		System.out.println(contactResponseWithGroupsAndName);

		//create message...
		MessageResponse messageResponse = client.getMessage().create("sender_name", List.of("+224XXXXXXXXX"), "Hello nimba");
		System.out.println(messageResponse);

		// Create Contact
		//This contact will be added to the default contact list
		ContactResponse defaultContactResponse = client.getContact().create("+224XXXXXXXXX", null, null);
		System.out.println(defaultContactResponse);

	}

}
