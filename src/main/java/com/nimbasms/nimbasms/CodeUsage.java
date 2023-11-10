package com.nimbasms.nimbasms;

import com.nimbasms.nimbasms.contacts.ContactResponse;
import com.nimbasms.nimbasms.accounts.AccountResponse;
import com.nimbasms.nimbasms.contacts.ContactDto;
import com.nimbasms.nimbasms.groups.GroupResponse;
import com.nimbasms.nimbasms.messages.MessageResponse;
import com.nimbasms.nimbasms.messages.MessageDetailsResponse;

import com.nimbasms.nimbasms.sendernames.SenderNameResponse;
import java.io.IOException;
import java.util.List;

public class CodeUsage {

	public static void main(String[] args) throws IOException {
		NimbaSMSClient client = new NimbaSMSClient("XXXX", "XXXX");

		AccountResponse accountResponse = client.getAccount().get();
		System.out.println(accountResponse);

		// Get Sendernames
		SenderNameResponse senderNameResponse = client.getSenderName().list();
		System.out.println(senderNameResponse);

		// Get last 1O Sendernames
		SenderNameResponse last10SenderNameResponse = client.getSenderName().list(20, 1);
		System.out.println(last10SenderNameResponse);

		// Get Contact
		ContactResponse contacts = client.getContact().list();
		System.out.println(contacts);

		// Get last 1O Contact
		ContactResponse last10contacts = client.getContact().list(10, 1);
		System.out.println(last10contacts);

		GroupResponse groups = client.getGroup().list();
		System.out.println(groups);

		GroupResponse last10groups = client.getGroup().list(10, 1);
		System.out.println(last10groups);

		//Get all messages
		MessageResponse messages = client.getMessage().list();
		System.out.println(messages);

		//Get only last 10 messages
		MessageResponse last10Messages = client.getMessage().list(10, 1);
		System.out.println(last10Messages);

		//retrieve message...
		MessageDetailsResponse messageDetails = client.getMessage().retrieve("XXXXXXXXX");
		System.out.println(messageDetails);

		//Create with groups and name - name and groups are optional.
		ContactDto contactResponseWithGroupsAndName = client.getContact().create("+224XXXXXXXXX", "Foo", List.of("API", "Facebook Client"));
		System.out.println(contactResponseWithGroupsAndName);

		//create message...
		MessageResponse messageResponse = client.getMessage().create("Nimba API", List.of("+224XXXXXXXXX"), "Hello test");
		System.out.println(messageResponse);

		// Create Contact
		//This contact will be added to the default contact list
		ContactDto defaultContactResponse = client.getContact().create("+224XXXXXXXXX", null, null);
		System.out.println(defaultContactResponse);

	}

}
