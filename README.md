# nimbasms-java
A Java module for communicating with Nimba SMS API. 

## Usage
First, instantiate the client using your API key:

```java

NimbaSmsClient client = new NimbaSmsClient("ACCOUNT_SID", "AUTH_TOKEN")
```

## Accounts
Retrieve the account information using the getAccount() method:
```java
AccountResponse accountResponse = client.getAccount().get();
System.out.println(accountResponse);
```
## Sender Names
Retrieve the sender names using the getSenderName() method:

```java
RootResult<SenderNameResponse> senderNameResponse = client.getSenderName().list();
System.out.println(senderNameResponse);
```
You can also retrieve the last 10 sender names by passing in the limit and offset:

```java
RootResult<SenderNameResponse> last10SenderNameResponse = client.getSenderName().list(10, 1);
System.out.println(last10SenderNameResponse);
```
## Contacts
This code retrieves a list of all contacts.
```java
RootResult<ContactResponse> contacts = client.getContact().list();
System.out.println(contacts);
```
You can also retrieve the last 10 contacts by passing in the limit and offset:
```java
RootResult<ContactResponse> last10contacts = client.getContact().list(10, 1);
System.out.println(last10contacts);
```
Create Contact. This contact will be added to the default contact list:
```java
ContactResponse defaultContactResponse = client.getContact().create("+224XXXXXXXXX", null, null);
System.out.println(defaultContactResponse)
```


## Groups
This code retrieves a list of all groups.
```java
RootResult<GroupResponse> groups = client.getGroup().list();
System.out.println(groups);
```

You can also retrieve the last 10 Group by passing in the limit and offset:
```java
RootResult<GroupResponse> last10groups = client.getGroup().list(10, 1);
System.out.println(last10groups);
```
