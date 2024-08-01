package com.joddmail.controller;

import jodd.mail.*;

import java.io.File;
import java.util.List;

public class JoddMailCotroller {

	public static void main(String[] args) {

		String username = "narendrapallaki2607@outlook.com";
		String password = "mkxedepjfneqlonu";

		Pop3Server popServer = MailServer.create()
				.host("outlook.office365.com")
				.ssl(true)
				.port(995)
				.auth(username, password).buildPop3MailServer();

		ReceiveMailSession session = popServer.createSession();
		 session.open();
		ReceivedEmail[] emails = session.receiveEmailAndMarkSeen();
		if (emails != null) {
			for (ReceivedEmail email : emails) {

				// common info
				System.out.println("FROM:" + email.from());
				System.out.println("TO:" + email.to()[0]);

				System.out.println("SUBJECT:" + email.subject());
				System.out.println("PRIORITY:" + email.priority());
				System.out.println("SENT DATE:" + email.sentDate());
				// System.out.println("RECEIVED DATE: " + email.receiveDate());


			/*	List<EmailAttachment> attachments = email.getAttachments();
				  if (attachments != null)
				  {
					  for (EmailAttachment attachment : attachments)
					  {
						  System.out.println("name: " + attachment.getName());
				          System.out.println("cid: " + attachment.getContentId());
				         System.out.println("size: " + attachment.getSize());
						 attachment.writeToFile(new File("C:\\Html", attachment.getName()));

				      }
				  }*/
			}
		}
		session.close();
	}

}
