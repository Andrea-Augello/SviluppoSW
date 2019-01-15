package CreaPrenotazione;

import ExternalComponentsInterface.DatabaseInterface;
import Oggetti.ErroreDialog;
import Oggetti.Ricetta;

import java.util.List;

public class GeneraRicettaControl {
	private Ricetta ricetta;

	private ScegliRegimeDialog formRegimeVisita;
    private FormRicetta formDatiRicetta;

	public GeneraRicettaControl() {
		List<String> prestazioni = DatabaseInterface.getInstance().ottieniPrestazioniErogabili();
		prestazioni.add("000 - RICOVERO");
	    formDatiRicetta = new FormRicetta(this, prestazioni);
	}

	void ottieniDati() {
	    String codiceRicetta = formDatiRicetta.getCodiceRicetta();
	    int codicePrestazione = formDatiRicetta.getCodicePrestazione();
	    int urgenza = formDatiRicetta.getUrgenza();
		ricetta = new Ricetta(codiceRicetta,urgenza,codicePrestazione);
		if(!controllaCorrettezzaDati(ricetta)){
			new ErroreDialog("Impossibile procedere con la prenotazione:<br/>Nel sistema risulta già una prenotazione con questo numero di ricetta per la<br/>prestazione selezionata.");
			formDatiRicetta.reset();
		} else {
		    sceltaRegime();
		}
	}

	private void sceltaRegime() {
		formRegimeVisita = new ScegliRegimeDialog(this);
	}


	void SSN() {
	    ricetta.setRegime(0);
		new EffettuaPrenotazioneControl(ricetta);
	}

	void ALPI() {
	    ricetta.setRegime(1);
		new EffettuaPrenotazioneControl(ricetta);
	}

	private boolean controllaCorrettezzaDati(Ricetta ricetta) {
	    return DatabaseInterface.getInstance().verificaDuplicati(ricetta);
	}
}
