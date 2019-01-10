package CreaPrenotazione;

import ExternalComponentsInterface.DatabaseInterface;
import Oggetti.ErroreDialog;
import Oggetti.PersonaleEntity;
import Oggetti.Ricetta;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EffettuaPrenotazioneControl {
	private List<LocalDateTime> listaOrariDisponibili;
	private ScegliOrarioDialog sceltaOrarioForm;
	private Ricetta ricetta;

	public EffettuaPrenotazioneControl(Ricetta ricetta) {
		this.ricetta = ricetta;
		if(ricetta.getRegime() == 1){
			new SceltaMedicoDialog(this, DatabaseInterface.getInstance().ottieniListaMedici(ricetta.getPrestazione()));
		} else {
		    listaOrariDisponibili = DatabaseInterface.getInstance().ottieniOrari(ricetta.getPrestazione(), ricetta.getLimiteMassimo());
		    if(listaOrariDisponibili == null) {
		    	aggiungiOrario();
			}
			sceltaOrarioForm = new ScegliOrarioDialog(this, listaOrariDisponibili );
		}
	}

	public void prenotaMedico(PersonaleEntity medicoScelto) {
		listaOrariDisponibili = DatabaseInterface.getInstance().ottieniOrari(medicoScelto);
		sceltaOrarioForm = new ScegliOrarioDialog(this, listaOrariDisponibili );
	}

	public void finalizzaPrenotazione(LocalDateTime slotScelto) {
		new ErroreDialog("Funzionalità non ancora implementata");
		//DatabaseInterface.getInstance().inserisciPrenotazione( null );
	}

	public void aggiungiOrario() {
		LocalDateTime orarioOttenibile = (DatabaseInterface.getInstance().ottieniPrenotazioneSpostabile(ricetta.getPrestazione(), ricetta.getLimiteMassimo()));

		if(orarioOttenibile == null){
			new ErroreDialog("Impossibile prenotare una visita entro i tempi previsti per il codice di urgenza immesso");
		} else {
			listaOrariDisponibili = new ArrayList<>();
			listaOrariDisponibili.add(orarioOttenibile);
		}
	}

}
