package Oggetti;

import Autenticazione.LoginControl;
import Autenticazione.RegistrazioneForm;
import Autenticazione.SelezionaPazienteControl;
import CreaPrenotazione.GeneraRicettaControl;
import InserisciDettagliVisita.InserisciDettagliVisitaControl;
import ModificaPrenotazione.ScegliPrenotazioneControl;
import VisualizzaFSE.FSEControl;

import javax.swing.*;

public abstract class MainScreen {

	public void creaPrenotazioni() {
		new GeneraRicettaControl();
	}

	public void modificaPrenotazione() {
		new ScegliPrenotazioneControl();
	}

	public void sceltaPrenotazione() {

	}

	public void visualizzaStoricoVisite() {
		new FSEControl();
	}

	public void visualizzaCartellaClinica() {
		new FSEControl();
	}

	public void inserisciDettagliVisita(Prenotazione visita) {
		new InserisciDettagliVisitaControl(visita);
	}

	public void updateInformazioniPaziente() {

	}

	public void individuaPaziente(){
	    new SelezionaPazienteControl();
	}

}
