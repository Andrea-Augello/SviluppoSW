package CreaPrenotazione;

import ExternalComponentsInterface.DatabaseInterface;
import Oggetti.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EffettuaPrenotazioneControl {
	private List<LocalDateTime> listaOrariDisponibili;
	private ScegliOrarioDialog sceltaOrarioForm;
	private Ricetta ricetta;
	private PersonaleEntity medico;
	private Prenotazione prenotazioneSpostata;

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
		medico = medicoScelto;
		listaOrariDisponibili = DatabaseInterface.getInstance().ottieniOrari(medicoScelto);
		sceltaOrarioForm = new ScegliOrarioDialog(this, listaOrariDisponibili );
	}

	public void finalizzaPrenotazione(LocalDateTime slotScelto) {
	    if(medico == null){
	    	medico = DatabaseInterface.getInstance().ottieniMedicoDisponibile(slotScelto, ricetta.getPrestazione());
		}
		Prenotazione prenotazione = new Prenotazione(PazienteEntity.getPaziente(),ricetta, slotScelto, medico);
		DatabaseInterface.getInstance().inserisciPrenotazione( prenotazione );
	}

	public void aggiungiOrario() {
		LocalDateTime orarioOttenibile;
		prenotazioneSpostata = DatabaseInterface.getInstance().ottieniPrenotazioneSpostabile(ricetta.getPrestazione(), ricetta.getLimiteMassimo());
		orarioOttenibile = ();

		if(orarioOttenibile == null){
			new ErroreDialog("Impossibile prenotare una visita entro i tempi previsti per il codice di urgenza immesso");
		} else {
			listaOrariDisponibili = new ArrayList<>();
			listaOrariDisponibili.add(orarioOttenibile);
		}
	}

}
