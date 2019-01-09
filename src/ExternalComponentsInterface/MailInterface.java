package ExternalComponentsInterface;

import Oggetti.Prenotazione;

public class MailInterface {
    private static MailInterface instance = new MailInterface();

    public static MailInterface getInstance() {
        return instance;
    }

    private MailInterface() {
    }

    public void notificaCreazionePrenotazione(Prenotazione prenotazione){
        //TODO qualcosa di utile
    }

    public void notificaSpostamentoPrenotazione(Prenotazione prenotazione){
        //TODO qualcosa di utile
    }

    public void notificaReminderPrenotazione(Prenotazione prenotazione){
        //TODO qualcosa di utile
    }
}
