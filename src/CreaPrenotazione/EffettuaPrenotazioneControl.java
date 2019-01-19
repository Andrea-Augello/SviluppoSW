package CreaPrenotazione;

import ExternalComponentsInterface.DatabaseInterface;
import ExternalComponentsInterface.MailInterface;
import Oggetti.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EffettuaPrenotazioneControl {
	private List<LocalDateTime> listaOrariDisponibili;
	private ScegliOrarioDialog sceltaOrarioForm;
	private Ricetta ricetta;
	private PersonaleEntity medico;
	private Prenotazione prenotazioneSpostata = null;

	public EffettuaPrenotazioneControl(Ricetta ricetta) {
		this.ricetta = ricetta;
		if(ricetta.getRegime() == 1){
			new SceltaMedicoDialog(this, DatabaseInterface.getInstance().ottieniListaMedici(ricetta.getPrestazione()));
		} else {
		    listaOrariDisponibili = DatabaseInterface.getInstance().ottieniOrari(ricetta.getPrestazione(), ricetta.getLimiteMassimo());
		    if(listaOrariDisponibili == null || listaOrariDisponibili.isEmpty()) {
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
		if(prenotazioneSpostata != null){
			LocalDateTime nuovoOrario = DatabaseInterface.getInstance().ottieniOrari(prenotazioneSpostata.getCodicePrestazione(), prenotazioneSpostata.getLimiteMassimo()).get(0);
			prenotazioneSpostata.setDataOraAppuntamento(nuovoOrario);
			boolean success = DatabaseInterface.getInstance().modificaPrenotazione(prenotazioneSpostata);
			if(success) {
				sceltaOrarioForm.dispose();
				MailInterface.getInstance().notificaSpostamentoPrenotazione(prenotazioneSpostata);
			}
		}
	    if(medico == null){
	    	medico = DatabaseInterface.getInstance().ottieniMedicoDisponibile(slotScelto, ricetta.getPrestazione());
		}
		Prenotazione prenotazione = new Prenotazione(PazienteEntity.getPaziente(),ricetta, slotScelto, medico);
		boolean success = DatabaseInterface.getInstance().inserisciPrenotazione( prenotazione );
		if(success) {
			MailInterface.getInstance().notificaCreazionePrenotazione(prenotazione);
		}
		sceltaOrarioForm.dispose();
	}

	public void aggiungiOrario() {
		prenotazioneSpostata = DatabaseInterface.getInstance().ottieniPrenotazioneSpostabile(ricetta.getPrestazione(), ricetta.getLimiteMassimo());
		LocalDateTime orarioOttenibile = null;
		if(prenotazioneSpostata != null){
			orarioOttenibile = prenotazioneSpostata.getDataOraAppuntamento();
		}
		if(orarioOttenibile == null){
			new ErroreDialog("Impossibile prenotare una visita entro i tempi previsti per il codice di urgenza immesso");
		} else {
			listaOrariDisponibili = new ArrayList<>();
			listaOrariDisponibili.add(orarioOttenibile);
		}
	}

}
