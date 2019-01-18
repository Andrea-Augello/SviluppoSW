package ModificaPrenotazione;

import ExternalComponentsInterface.DatabaseInterface;
import Oggetti.Prenotazione;

import java.time.LocalDateTime;
import java.util.List;

public class ModificaPrenotazioneControl {
	private Prenotazione prenotazioneSelezionata;
	private ModificaPrenotazioneDialog form;

	public ModificaPrenotazioneControl(Prenotazione prenotazioneSelezionata) {
		this.prenotazioneSelezionata = prenotazioneSelezionata;
		form = new ModificaPrenotazioneDialog(prenotazioneSelezionata, this);

	}

	public void spostaPrenotazione(){
		List<LocalDateTime> orariDisponibili;
		if(prenotazioneSelezionata.getRicetta().getRegime() == 0) {
			orariDisponibili = DatabaseInterface.getInstance().ottieniOrari(prenotazioneSelezionata.getCodicePrestazione(), prenotazioneSelezionata.getLimiteMassimo());
		} else {
			orariDisponibili = DatabaseInterface.getInstance().ottieniOrari(prenotazioneSelezionata.getMedico());
		}
		form.mostraOrari(orariDisponibili);
	}

	public void aggiornaPrenotazione() {
		if(prenotazioneSelezionata.getRicetta().getRegime()==0){
			prenotazioneSelezionata.setMedico(DatabaseInterface.getInstance().ottieniMedicoDisponibile(prenotazioneSelezionata.getDataOraAppuntamento(), prenotazioneSelezionata.getCodicePrestazione()));
		}
		new ConfermaDialog( false, prenotazioneSelezionata);
	}

	public void eliminaPrenotazione() {
		new ConfermaDialog(true, prenotazioneSelezionata);
	}

}
