package ExternalComponentsInterface;

import Oggetti.ErroreDialog;
import Oggetti.Prenotazione;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailInterface {
    private static MailInterface instance = new MailInterface();
    private String destinationMail;
    private final sourceMail, sourcePassword, username;		
    
    public static MailInterface getInstance() {
        return instance;
    }

    private MailInterface() {
	username="OspedalePalermo"
        sourceMail="cup_ospedalePalermo@gmail.com";
	sourcePassword= "password";
        // Assuming you are sending email through localhost
        String host = "localhost";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "25");

	// Get the Session object.
        Session session = Session.getInstance(props,
           new javax.mail.Authenticator() {
              protected PasswordAuthentication getPasswordAuthentication() {
                 return new PasswordAuthentication(username,sourcePassword);
	      }
           });
         // Create a default MimeMessage object.
         Message message = new MimeMessage(session);
    }
	
    private  void setMessage(){
	
	   // Set From: header field of the header.
	   message.setFrom(new InternetAddress(sourceMail);
	
	   // Set To: header field of the header.
	   message.setRecipients(Message.RecipientType.TO,
               InternetAddress.parse(destinationMail));
	
	   // Set Subject: header field
	   message.setSubject("Testing Subject");
    }

    	
    public void notificaCreazionePrenotazione(Prenotazione prenotazione){
	try{
		this.setMessage();
        	message.setText("Gentile utente, la informiamo che la vostra prenotazione è avvenuta con successo. La visita si terrà il " + Prenotazione.getDataOraAppuntamento() );
		//Send Message
		Transport.send(message);
		System.out.println("Sent messagge successfully");
      	}catch (MessagingException e) {
        	 throw new RuntimeException(e);
      	} 
   }	

    public void notificaSpostamentoPrenotazione(Prenotazione prenotazione){
        try{
		this.setMessage();
        	message.setText("Gentile utente, è stata rilevata una modifica alla vostra prenotazione numero " + prenotazione.getId() + " è stata modificata correttamente. La visita si terrà il " + prenotazione.getDataOraAppuntamento() );
		//Send Message
		Transport.send(message);
		System.out.println("Sent messagge successfully");
        }catch (MessagingException e) {
	        throw new RuntimeException(e);
        }
    }

    public void notificaCancellazionePrenotazione(Prenotazione prenotazione){
	try{
  		this.setMessage();
        	message.setText("Gentile utente, la informiamo che la sua prenotazione numero " + prenotazione.getId() +" che si sarebbe tenuta il " + prenotazione.getDataOraAppuntamento() +" è stata cancellata con successo. " );
		//Send Message
		Transport.send(message);
		System.out.println("Sent messagge successfully");
       	}catch (MessagingException e) {
         	throw new RuntimeException(e);
        }	
    }

    public void notificaReminderPrenotazione(Prenotazione prenotazione){
        try{
  		this.setMessage();
        	message.setText("Gentile utente, le ricordiamo che la sua prenotazione numero " + prenotazione.getId() + " si terrà il " + prenotazione.getDataOraAppuntamento() );
		//Send Message
		Transport.send(message);
		System.out.println("Sent messagge successfully");
       	}catch (MessagingException e) {
         	throw new RuntimeException(e);
        }	
    }
                       
}
