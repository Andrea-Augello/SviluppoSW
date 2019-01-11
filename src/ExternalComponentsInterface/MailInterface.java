package ExternalComponentsInterface;

import Oggetti.ErroreDialog;
import Oggetti.Prenotazione;

public class MailInterface {
    private static MailInterface instance = new MailInterface();

    public static MailInterface getInstance() {
        return instance;
    }

    private MailInterface() {
        new ErroreDialog("Funzionalità mail non ancora abilitata");
    }

    public void notificaCreazionePrenotazione(Prenotazione prenotazione){
        //TODO qualcosa di utile
    }

    public void notificaSpostamentoPrenotazione(Prenotazione prenotazione){
        //TODO qualcosa di utile
    }

    public void notificaCancellazionePrenotazione(Prenotazione prenotazione){

    }

    public void notificaReminderPrenotazione(Prenotazione prenotazione){
        //TODO qualcosa di utile
    }
}
