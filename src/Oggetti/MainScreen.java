package Oggetti;

import Autenticazione.LoginControl;
import Autenticazione.RegistrazioneForm;
import Autenticazione.SelezionaPazienteControl;
import CreaPrenotazione.GeneraRicettaControl;
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

	public void inserisciDettagliVisita() {

	}

	public void updateInformazioniPaziente() {

	}

	public void individuaPaziente(){
	    new SelezionaPazienteControl();
	}

}
