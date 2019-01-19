package MainScreen;

import Autenticazione.SelezionaPazienteControl;
import CreaPrenotazione.GeneraRicettaControl;
import Entity.Prenotazione;
import InserisciDettagliVisita.InserisciDettagliVisitaControl;
import ModificaPrenotazione.ScegliPrenotazioneControl;
import VisualizzaFSE.FSEControl;


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
		new FSEControl(false);
	}

	public void visualizzaCartellaClinica() {
		new FSEControl(true);
	}

	public void inserisciDettagliVisita(Prenotazione visita) {
		new InserisciDettagliVisitaControl(visita);
	}

	public void individuaPaziente(){
	    new SelezionaPazienteControl();
	}

}
