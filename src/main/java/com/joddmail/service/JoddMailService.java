
/*
package com.joddmail.service;

import java.io.IOException;
import java.util.Properties;

import jakarta.mail.Folder;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.NoSuchProviderException;
import jakarta.mail.Session;
import jakarta.mail.Store;

public class JoddMailService {

	public static void receiveEmail(String pop3Host, String storeType, String user, String password) {
		Properties properties = new Properties();
		properties.put("mail.pop3.host", pop3Host);
		properties.put("mail.pop3.port", "995");
		properties.put("mail.pop3.ssl.enable", "true"); // Enable SSL
		properties.put("mail.pop3.auth", "true");

		Session emailSession = Session.getInstance(properties);

		try {
			// Create the POP3 store object and connect with the POP server
			Store emailStore = emailSession.getStore(storeType);
			emailStore.connect(user, password);

			// Create the folder object and open it
			Folder emailFolder = emailStore.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);

			// Retrieve the messages from the folder in an array and print them
			Message[] messages = emailFolder.getMessages();
			for (int i = 0; i < messages.length; i++) {
				Message message = messages[i];
				System.out.println("---------------------------------");
				System.out.println("Email Number " + (i + 1));
				System.out.println("Subject: " + message.getSubject());

				System.out.println("From: " + message.getFrom()[0]);

				System.out.println("Text: " + message.getContent());
			}
			// Close the folder and store objects
			emailFolder.close(false);
			emailStore.close();

		} catch (NoSuchProviderException e) {
			System.err.println("No provider for POP3 protocol");
			e.printStackTrace();
		} catch (MessagingException e) {
			System.err.println("Messaging exception occurred");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("IO exception occurred");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String host = "outlook.office365.com";
		String mailStoreType = "pop3";
		String username = "narendrapallaki2607@outlook.com";
		String password = "mkxedepjfneqlonu";

		receiveEmail(host, mailStoreType, username, password);
	}
}
*/