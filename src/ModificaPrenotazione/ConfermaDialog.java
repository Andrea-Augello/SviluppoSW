package ModificaPrenotazione;

import ExternalComponentsInterface.DatabaseInterface;
import Oggetti.ErroreDialog;
import Oggetti.Prenotazione;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfermaDialog {

    private boolean isDestroying;
    private Prenotazione prenotazioneSelezionata;
    private JButton confermaButton;
    private JButton annullaButton;
    private JPanel panel;
    private JFrame frame;

    public ConfermaDialog(boolean isDestroying, Prenotazione prenotazioneSelezionata) {
        this.isDestroying = isDestroying;
        this.prenotazioneSelezionata = prenotazioneSelezionata;

		frame = new JFrame("SPRINT - Conferma operazione");
		frame.setContentPane(panel);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);

        confermaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prosegui();
                frame.dispose();
            }
        });
        annullaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }

    public void prosegui() {
        if (isDestroying) {
            DatabaseInterface.getInstance().rimuoviPrenotazione(prenotazioneSelezionata);
        }else{
            DatabaseInterface.getInstance().modificaPrenotazione(prenotazioneSelezionata);
        }
        new ErroreDialog("Operazione fallita");
        }
	}


