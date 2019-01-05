package Oggetti;

import Autenticazione.RegistrazioneForm;
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

	}

	public void inserisciDettagliVisita() {

	}

	public void updateInformazioniPaziente() {

	}

	public void individuaPaziente(){

	}

}
