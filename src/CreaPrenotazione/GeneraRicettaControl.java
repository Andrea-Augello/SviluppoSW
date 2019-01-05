package CreaPrenotazione;

import Oggetti.ErroreDialog;
import Oggetti.Ricetta;

public class GeneraRicettaControl {
	private Ricetta ricetta;

	private ScegliRegimeDialog regimeVisita;
    private FormRicetta datiRicetta;

	public GeneraRicettaControl() {
	    datiRicetta = new FormRicetta(this);
	}


	public void sceltaRegime() {
		regimeVisita = new ScegliRegimeDialog(this);
	}

	public void ottieniDati() {
		new ErroreDialog("Funzionalità non implementata");
		if(!controllaCorrettezzaDati()){
			new ErroreDialog("Impossibile procedere con la prenotazione:<br/>Nel sistema risulta già una prenotazione con questo numero di ricetta per la<br/>prestazione selezionata.");
			datiRicetta.reset();
		} else {
		    sceltaRegime();
		}
	}

	public void SSN() {
		new ErroreDialog("Funzionalità non implementata");
		new EffettuaPrenotazioneControl(0);
	}

	public void ALPI() {
		new ErroreDialog("Funzionalità non implementata");
		new EffettuaPrenotazioneControl(1);
	}

	public boolean controllaCorrettezzaDati() {
		new ErroreDialog("Funzionalità non implementata");
		return false;
	}
}
