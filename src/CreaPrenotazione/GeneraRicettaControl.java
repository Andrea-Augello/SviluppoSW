package CreaPrenotazione;

import DatabaseInterface.DatabaseInterface;
import Oggetti.ErroreDialog;
import Oggetti.Ricetta;

public class GeneraRicettaControl {
	private Ricetta ricetta;

	private ScegliRegimeDialog formRegimeVisita;
    private FormRicetta formDatiRicetta;

	public GeneraRicettaControl() {
	    formDatiRicetta = new FormRicetta(this);
	}


	private void sceltaRegime() {
		formRegimeVisita = new ScegliRegimeDialog(this);
	}

	void ottieniDati() {
	    String codiceRicetta = formDatiRicetta.getCodiceRicetta();
	    int codicePrestazione = formDatiRicetta.getCodicePrestazione();
	    int urgenza = formDatiRicetta.getUrgenza();

		if(!controllaCorrettezzaDati(new Ricetta(codicePrestazione, codiceRicetta))){
			new ErroreDialog("Impossibile procedere con la prenotazione:<br/>Nel sistema risulta già una prenotazione con questo numero di ricetta per la<br/>prestazione selezionata.");
			formDatiRicetta.reset();
		} else {
		    sceltaRegime();
		}
	}

	void SSN() {
		new ErroreDialog("Funzionalità non implementata");
		new EffettuaPrenotazioneControl(0);
	}

	void ALPI() {
		new ErroreDialog("Funzionalità non implementata");
		new EffettuaPrenotazioneControl(1);
	}

	private boolean controllaCorrettezzaDati(Ricetta ricetta) {
	    return DatabaseInterface.getInstance().verificaDuplicati(ricetta);
	}
}
