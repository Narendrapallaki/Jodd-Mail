package com.joddmail.entity;
import jodd.mail.*;

import java.io.File;
import java.util.List;

public class MailForm {

    public static void main(String[] args) {

        String username = "narendrapallaki2607@outlook.com";
        String password = "mkxedepjfneqlonu";
        Pop3Server popServer = MailServer.create()
                .host("outlook.office365.com")
                .ssl(true)
                .port(995)
                .auth(username, password)
                .buildPop3MailServer();
        // Create and open the session
        ReceiveMailSession session = popServer.createSession();
        session.open();
        try {

            ReceivedEmail[] emails = session.receiveEmailAndMarkSeen();
            if (emails != null) {
                System.out.println("Number of emails received: " + emails.length);
                for (ReceivedEmail email : emails) {

                    System.out.println("FROM: " + email.from());
                    System.out.println("TO: " + email.to()[0]);

                    System.out.println("SUBJECT: " + email.subject());
                    System.out.println("PRIORITY: " + email.priority());
                    System.out.println("SENT DATE: " + email.sentDate());

                    // Process the body of the email
                    List<EmailMessage> messages = email.messages();
                    if (messages != null && !messages.isEmpty()) {
                        for (EmailMessage message : messages) {
                            System.out.println("------");
                            System.out.println("Message Encoding: " + message.getEncoding());
                            System.out.println("Message MimeType: " + message.getMimeType());
                            System.out.println("Message Content: " + message.getContent());
                        }
                    } else {
                        System.out.println("No messages found in this email.");
                    }

                    // Process attachments
                    List<EmailAttachment> attachments = (List) email.attachments();
                    
                    if (attachments != null && !attachments.isEmpty()) {
                        System.out.println("Attachments found: " + attachments.size());
                        for (EmailAttachment attachment : attachments) {
                            System.out.println("Attachment name: " + attachment.getName());
                            System.out.println("Attachment CID: " + attachment.getContentId());
                            System.out.println("Attachment size: " + attachment.getSize());
                            attachment.writeToFile(new File("C:\\Html", attachment.getName()));
                            System.out.println("Attachment saved to: C:\\Html\\" + attachment.getName());
                        }
                    } else {
                        System.out.println("No attachments found for this email.");
                    }
                }
            } else {
                System.out.println("No emails received.");
            }
        } catch (Exception e) {
            System.err.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close the session
            session.close();
            System.out.println("Session closed.");
        }
    }


}
