/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mail;

/**
 *
 * @author radhika
 */
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import javax.swing.JOptionPane;

public class SendMail {
 
    private String emailAddressTo = new String();
    private String CustomerName = new String();
    private String Tickets = new String();
    private String TicketID = new String();
    private String totalCost = new String();
    
    private String msgSubject = new String();
    private String msgText = new String();

    final String USER_NAME = "AirLine Reservation System";   //User name of the Goole(gmail) account
    final String PASSSWORD = "**************";  //Password of the Goole(gmail) account
    final String FROM_ADDRESS = "************";  //From addresss
 
   public SendMail(String email,String customer,String TicketID, String Tickets,String totalcost)
    {
        this.emailAddressTo=email;
        this.CustomerName=customer;
        this.Tickets=Tickets;
        this.totalCost=totalcost;
        this.TicketID=TicketID;
    }
    public void sendEmailMessage() {
     
     //Create email sending properties
     Properties props = new Properties();
     props.put("mail.smtp.auth", "true");
     props.put("mail.smtp.starttls.enable", "true");
     props.put("mail.smtp.host", "*******");
     props.put("mail.smtp.port", "###");
  
    Session session = Session.getInstance(props,
    new javax.mail.Authenticator() {
    protected PasswordAuthentication getPasswordAuthentication() {
    return new PasswordAuthentication(FROM_ADDRESS, PASSSWORD);
   }
    });

  try {

    // BookTicket
     Message message = new MimeMessage(session);
     message.setFrom(new InternetAddress(FROM_ADDRESS)); //Set from address of the email
     message.setContent("Dear "+CustomerName+", \n Your Ticket ID : "+TicketID+"\n No of Tickets: "+Tickets+"\n Total Bill cost: "+totalCost+"\n Please arrive to the airport before 40 mins of your flight departure..","text/html"); //set content type of the email  
    message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(emailAddressTo)); //Set email recipient
    
    message.setSubject("Flight_Ticket_Receipt"); //Set email message subject
    Transport.send(message); //Send email message

   JOptionPane.showMessageDialog(null, "Email Sent, check your mail box!");
   System.out.println("sent email successfully!");

  } catch (MessagingException e) {
       throw new RuntimeException(e);
  }
    }

    public void setEmailAddressTo(String emailAddressTo) {
        this.emailAddressTo = emailAddressTo;
    }

    public void setSubject(String subject) {
        this.msgSubject = subject;
    }

    public void setMessageText(String msgText) {
        this.msgText = msgText;
    }
 
}
