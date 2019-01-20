package CreaPrenotazione;

import ExternalComponentsInterface.DatabaseInterface;
import MainScreen.ErroreDialog;
import Entity.PersonaleEntity;
import Entity.Ricetta;

import java.util.List;

public class GeneraRicettaControl {
	private Ricetta ricetta;

	private ScegliRegimeDialog formRegimeVisita;
    private FormRicetta formDatiRicetta;

	public GeneraRicettaControl() {
		List<String> prestazioni = DatabaseInterface.getInstance().ottieniPrestazioniErogabili();
		if(PersonaleEntity.getMedico()!=null) {
			prestazioni.add("000 - RICOVERO");
		}
		formDatiRicetta = new FormRicetta(this, prestazioni);
	}

	void ottieniDati() {
	    String codiceRicetta = formDatiRicetta.getCodiceRicetta();
	    if(codiceRicetta.matches("\\d{15}")) {
			int codicePrestazione = formDatiRicetta.getCodicePrestazione();
			int urgenza = formDatiRicetta.getUrgenza();
			if(urgenza > 0) {
				ricetta = new Ricetta(codiceRicetta, urgenza, codicePrestazione);
				if (controllaCorrettezzaDati(ricetta)) {
					if(PersonaleEntity.getMedico() != null){
						formDatiRicetta.dispose();
						SSN();
					} else {
						sceltaRegime();
						formDatiRicetta.dispose();
					}
				} else {
					new ErroreDialog("Impossibile procedere con la prenotazione:<br/>Nel sistema risulta già una prenotazione con questo numero di ricetta per la<br/>prestazione selezionata.");
					formDatiRicetta.reset();
				}
			} else {
				new ErroreDialog("Indicare l'urgenza.");
			}
		} else {
	    	new ErroreDialog("Il codice inserito non è valido.<br/>Va inserito un codice di 15 numeri.");
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
	    return !DatabaseInterface.getInstance().verificaDuplicati(ricetta);
	}
}
