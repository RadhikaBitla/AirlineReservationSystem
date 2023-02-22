/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mail;

/**
 *
 * @author radhika
 */
import com.mycompany.airlinereservationsystem.BookTicket;
import java.sql.SQLException;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import java.io.*;
import java.util.*;

public class SendMail {
 
    private static String emailAddressTo = new String();
    private static String msgSubject = new String();
    private static String msgText = new String();

    final String USER_NAME = "bitlaradhika3@gmail.com";   //User name of the Goole(gmail) account
    final String PASSSWORD = "tzrdxtwfaqtdcleb";  //Password of the Goole(gmail) account
    final String FROM_ADDRESS = "bitlaradhika3@gmail.com";  //From addresss
 
    public SendMail() throws ClassNotFoundException, SQLException
    {
        BookTicket bookTicket=new BookTicket();
        emailAddressTo=bookTicket.getEmailID();
        msgSubject="Flight_Ticket_Bill_Receipt";
        msgText="hello, your ticket is succesfully booked, please visit our site again!!";
    }
    
    public void sendEmailMessage() {
     
     EMail email = new EMail();
     //Sending test email
     email.createAndSendEmail(emailAddressTo, msgSubject,msgText);
     //Create email sending properties
     Properties props = new Properties();
     props.put("mail.smtp.auth", "true");
     props.put("mail.smtp.starttls.enable", "true");
     props.put("mail.smtp.host", "smtp.gmail.com");
     props.put("mail.smtp.port", "587");
  
    Session session = Session.getInstance(props,
    new javax.mail.Authenticator() {
    protected PasswordAuthentication getPasswordAuthentication() {
    return new PasswordAuthentication("bitlaradhika3@gmail.com", "tzrdxtwfaqtdcleb");
   }
    });
     System.out.println("Authentication Success!!");

  try {

     Message message = new MimeMessage(session);
     message.setFrom(new InternetAddress("bitlaradhika3@gmail.com")); //Set from address of the email
     message.setContent(msgText,"text/html"); //set content type of the email
     
    message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(emailAddressTo)); //Set email recipient
    System.out.println(emailAddressTo);
    message.setSubject(msgSubject); //Set email message subject
    Transport.send(message); //Send email message

   System.out.println("sent email successfully!");
   return;
  } catch (MessagingException e) {
       throw new RuntimeException(e);
  }
  }
    
}
