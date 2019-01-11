import ExternalComponentsInterface.DatabaseInterface;
import ExternalComponentsInterface.MailInterface;
import Oggetti.ErroreDialog;
import Oggetti.Prenotazione;

import java.io.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class SPRINTserver {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                SPRINTserver.inviaNotifiche();
            }
        }, 0,3600000);
    }

    private static void inviaNotifiche() {
        LocalDateTime upTo = LocalDateTime.now().plusHours(27);
        LocalDateTime lastNotified;
        try
        {
            FileInputStream fis = new FileInputStream("scheduler.ser");
            ObjectInputStream ois = new ObjectInputStream (fis);
            lastNotified = (LocalDateTime) ois.readObject();
        }
        catch (Exception e) {
            lastNotified = LocalDateTime.now();
        }
        List<Prenotazione> prenotazioniDaNotificare = DatabaseInterface.getInstance().ottieniElencoVisite(lastNotified, upTo);
        if(prenotazioniDaNotificare != null){
            MailInterface mail = MailInterface.getInstance();
            for (Prenotazione prenotazione : prenotazioniDaNotificare) {
                mail.notificaReminderPrenotazione(prenotazione);
                if (prenotazione.getDataOraAppuntamento().isAfter(lastNotified)) {
                    lastNotified = prenotazione.getDataOraAppuntamento();
                }
            }
            salvaOrario(lastNotified);
        }
    }

    private static void salvaOrario(LocalDateTime lastNotified) {
        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream("scheduler.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(lastNotified);

            out.close();
            file.close();

        }

        catch(IOException ex)
        {
            new ErroreDialog("Impossibile aggiornare i dati sulle notifiche inviate!");
        }
    }
}
