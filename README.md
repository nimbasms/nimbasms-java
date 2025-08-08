# nimbasms-java

A Java module for communicating with the **Nimba SMS API**.

[![](https://jitpack.io/v/nimbasms/nimbasms-java.svg)](https://jitpack.io/#nimbasms/nimbasms-java)

---

## Table of Contents

- [Installation](#installation)
- [JitPack Setup](#jitpack-setup)
- [Credentials Setup](#credentials-setup)
- [Usage](#usage)
    - [Access Token](#access-token)
    - [Accounts](#accounts)
    - [Groups](#groups)
    - [Sender Names](#sender-names)
    - [Contacts](#contacts)
    - [Messages](#messages)
    - [Purchases](#purchases)

---

## <a name="installation"></a> Installation

### System Requirements
- JDK 11 or higher.
- subscription via Nimba SMS Partner portal

- Java 11 or higher
- Subscription via [Nimba SMS Partner Portal](https:///www.nimbasms.com)

### Maven (Default - Maven Central)
### Add Maven Dependency
If you use Maven, add the following configuration to your project's `pom.xml`
```maven
<dependency>
  <groupId>com.nimbasms</groupId>
  <artifactId>nimbasms</artifactId>
  <version>0.0.1</version>
</dependency>
```
## <a name="jitpack-setup"></a> JitPack Setup
> ⚠️ If the package is not yet on Maven Central, you can use JitPack

```xml
<repositories>
  <repository>
  <id>jitpack.io</id>
  <url>https://jitpack.io</url>
  </repository>
</repositories>
```
### Add Dependency
Using the latest release tag (recommended):

```xml
<dependency>
    <groupId>com.github.nimbasms</groupId>
    <artifactId>nimbasms-java</artifactId>
    <version>v0.0.1</version> <!-- Replace with the latest tag -->
</dependency>
```
If no release exists:

```xml
<dependency>
    <groupId>com.github.nimbasms</groupId>
    <artifactId>nimbasms-java</artifactId>
    <version>master-SNAPSHOT</version> <!-- Or use commit hash -->
</dependency>
```
## Configuration of Credentials

Before instantiating a `NimbaSMSClient` object, ensure you have the required credentials. Obtain these credentials (ACCOUNT_SID and AUTH_TOKEN) from your SMS service provider.

```java
String ACCOUNT_SID = "Your_ACCOUNT_SID";
String AUTH_TOKEN = "Your_AUTH_TOKEN";
```

## <a name="accesToken"></a> Get your Access token
```java
import com.nimbasms.nimbasms.NimbaSMSClient;

NimbaSMSClient client = new NimbaSMSClient(ACCOUNT_SID, AUTH_TOKEN)
```

## <a name="account"></a> Accounts
Retrieve the account information using the getAccount() method:
```java
AccountResponse account = client.getAccount().get();
System.out.println(account);
```
Check balance
```java
AccountResponse account = client.getAccount().get();
System.out.println(account.getBalance());
```

## <a name="group"></a> Groups
This code retrieves a list of all groups.
```java
GroupResponse groups = client.getGroup().list();
System.out.println(groups);
```

You can also retrieve the last 10 Group by passing in the limit and offset:
```java
GroupResponse last10groups = client.getGroup().list(10, 1);
System.out.println(last10groups);
```
The next method returns the next item in a list.
```java
GroupResponse nextGroups = client.getGroup().next();
System.out.println(nextGroups);
```
The previous method returns the previous item in the list.
```java
GroupResponse previousGroups = client.getGroup().previous();
System.out.println(previousGroups);
```

## <a name="sendername"></a> Sendernames
Retrieve the sender names using the getSenderName() method:

```java
SenderNameResponse senderNames = client.getSenderName().list();
System.out.println(senderNames);
```
You can also retrieve the last 10 sender names by passing in the limit and offset:

```java
SenderNameResponse last10SenderNames = client.getSenderName().list(10, 1);
System.out.println(last10SenderNames);
```

The next method returns the next item in a list.

```java
SenderNameResponse nextSenderNames = client.getSenderName().next();
System.out.println(nextSenderNames);
```
The previous method returns the previous item in the list.

```java
SenderNameResponse previousSenderNames = client.getSenderName().previous();
System.out.println(previousSenderNames);
```

## <a name="contact"></a> Contacts
This code retrieves a list of all contacts.
```java
ContactResponse contacts = client.getContact().list();
System.out.println(contacts);
```
You can also retrieve the last 10 contacts by passing in the limit and offset:
```java
ContactResponse last10contacts = client.getContact().list(10, 1);
System.out.println(last10contacts);
```
The next method returns the next item in a list.
```java
ContactResponse nextContacts = client.getContact().next();
System.out.println(nextContacts);
```
The previous method returns the previous item in the list.
```java
ContactResponse previousContacts = client.getContact().previous();
System.out.println(previousContacts);
```

Create Contact. This contact will be added to the default contact list:
```java
ContactDto createContactResponse = client.getContact().create("+224XXXXXXXXX", null, null);
System.out.println(createContactResponse)
```
Create with groups and name - name and groups are optional.
```java
ContactDto contactResponseWithGroupsAndName = client.getContact().create("+224XXXXXXXXX", "Foo", List.of("API", "Facebook Client"));
System.out.println(contactResponseWithGroupsAndName);
```

## <a name="message"></a> Messages
Get All messages
```java
MessageResponse messages = client.getMessage().list();
System.out.println(messages);
```
Get only last 10 messages
```java
MessageResponse last10Messages = client.getMessage().list(10, 1);
System.out.println(last10Messages);
```
The next method returns the next item in a list.
```java
MessageResponse nextMessages = client.getMessage().next();
System.out.println(nextMessages);
```
The previous method returns the previous item in the list.
```java
MessageResponse previousMessages = client.getMessage().previous();
System.out.println(previousMessages);
```

Send a message
```java
MessageResponse messageResponse = client.getMessage().create("sender_name", List.of("+224XXXXXXXXX"), "Hello nimba");
System.out.println(messageResponse);
```
Retrieve message
```java
MessageDetails messageDetails = client.getMessage().retrieve("123");
System.out.println(messageDetails);
```

## <a name="purchase"></a> Purchases
List all purchases
```java
PurchaseResponse purchases = client.getPurchase().list();
```
Retrieve the last 10 purchases
```java
PurchaseResponse last10Purchases = client.getPurchase().list(10, 1);
```
The next method returns the next item in a list.
```java
PurchaseResponse nextPurchases = client.getPurchase().next();
```
The previous method returns the previous item in a list.
```java
PurchaseResponse previousPurchases = client.getPurchase().previous();
```
---

## License

This project is licensed under the MIT License – see the [LICENSE](LICENSE) file for details.

---

## Author & Contributions

Contributions to the official Java client for [Nimba SMS](https://nimbasms.com)

> 💡 Feel free to open issues or pull requests to improve the SDK.