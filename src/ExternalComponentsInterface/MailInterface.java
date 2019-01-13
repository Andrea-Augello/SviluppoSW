package ExternalComponentsInterface;

import Oggetti.ErroreDialog;
import Oggetti.Prenotazione;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.xml.crypto.Data;

public class MailInterface {
    private static MailInterface instance = new MailInterface();
    private Session session;
    private String destinationMail;
    private final String sourceMail, sourcePassword, username;
    
    public static MailInterface getInstance() {
        return instance;
    }

    private MailInterface() {
	username="OspedalePalermo";
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
        session = Session.getInstance(props,
           new javax.mail.Authenticator() {
              protected PasswordAuthentication getPasswordAuthentication() {
                 return new PasswordAuthentication(username,sourcePassword);
	      }
           });
    }
	
    private Message setMessage(){
        // Create a default MimeMessage object.
       Message message = new MimeMessage(session);

	   // Set From: header field of the header.
        try {
            message.setFrom(new InternetAddress(sourceMail));
        } catch (MessagingException e) {
            new ErroreDialog(e);
            return null;
        }

        // Set To: header field of the header.
        try {
            message.setRecipients(Message.RecipientType.TO,
InternetAddress.parse(destinationMail));
        } catch (MessagingException e) {
            new ErroreDialog(e);
            return null;
        }

        // Set Subject: header field
        try {
            message.setSubject("SPRINT - Notifica prenotazione");
        } catch (MessagingException e) {
            new ErroreDialog(e);
            return null;
        }

        return message;
    }

    public String documentsToString( List<String> lista){
	    String result="";
	    for(String documento: lista){
		    result+= (documento + "\n");
	    }    
    return result;
    }	    
	
    public void notificaCreazionePrenotazione(Prenotazione prenotazione){
	try{
		Message message = this.setMessage();
        	message.setText("Gentile utente, la informiamo che la vostra prenotazione è avvenuta con successo. La visita si terrà il "
                + prenotazione.getDataOraAppuntamento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:MM")) + ". Le sarà richiesta la seguente documentazione: " + this.documentsToString(DatabaseInterface.getInstance().ottieniDocumentiNecessari(prenotazione.getCodicePrestazione()))
                + "La prestazione verrà svolta presso "+DatabaseInterface.getInstance().ottieniPosizioneMedico(prenotazione.getMedico()));
		//Send Message
		Transport.send(message);
		System.out.println("Sent messagge successfully");
      	}catch (MessagingException e) {
        	 throw new RuntimeException(e);
      	} 
   }	

    public void notificaSpostamentoPrenotazione(Prenotazione prenotazione){
        try{
            Message message = this.setMessage();
        	message.setText("Gentile utente, è stata rilevata una modifica alla vostra prenotazione numero " + prenotazione.getId() +
                    "\nLa visita si terrà il " + prenotazione.getDataOraAppuntamento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:MM")) +
                    ".\n Le sarà richiesta la seguente documentazione:\n " + this.documentsToString(DatabaseInterface.getInstance().ottieniDocumentiNecessari(prenotazione.getCodicePrestazione()))
                    + "La prestazione verrà svolta presso "+DatabaseInterface.getInstance().ottieniPosizioneMedico(prenotazione.getMedico()));
            //Send Message
            Transport.send(message);
            System.out.println("Sent messagge successfully");
        }catch (MessagingException e) {
	        throw new RuntimeException(e);
        }
    }

    public void notificaCancellazionePrenotazione(Prenotazione prenotazione){
	try{
        Message message = this.setMessage();
        message.setText("Gentile utente, la informiamo che la sua prenotazione numero " + prenotazione.getId() +" che si sarebbe dovuta tenere il "
                + prenotazione.getDataOraAppuntamento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:MM")) +" è stata cancellata con successo. " );
		//Send Message
		Transport.send(message);
		System.out.println("Sent messagge successfully");
       	}catch (MessagingException e) {
         	throw new RuntimeException(e);
        }	
    }

    public void notificaReminderPrenotazione(Prenotazione prenotazione){
        try{
            Message message = this.setMessage();
        	message.setText("Gentile utente, le ricordiamo che la sua prenotazione numero " + prenotazione.getId() + " si terrà il " +
                    prenotazione.getDataOraAppuntamento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:MM"))+
                    ".\n Le sarà richiesta la seguente documentazione:\n " + this.documentsToString(DatabaseInterface.getInstance().ottieniDocumentiNecessari(prenotazione.getCodicePrestazione()))
                    + "La prestazione verrà svolta presso "+DatabaseInterface.getInstance().ottieniPosizioneMedico(prenotazione.getMedico()));
            //Send Message
            Transport.send(message);
            System.out.println("Sent messagge successfully");
       	}catch (MessagingException e) {
         	throw new RuntimeException(e);
        }	
    }
                       
}
