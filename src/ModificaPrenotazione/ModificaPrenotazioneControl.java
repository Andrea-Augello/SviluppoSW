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
		List<LocalDateTime> orariDisponibili = DatabaseInterface.getInstance().ottieniOrari(prenotazioneSelezionata.getCodicePrestazione(), prenotazioneSelezionata.getLimiteMassimo());
		form.mostraOrari(orariDisponibili);
	}

	public void aggiornaPrenotazione() {
		new ConfermaDialog( false, prenotazioneSelezionata);
	}

	public void eliminaPrenotazione() {
		new ConfermaDialog(true, prenotazioneSelezionata);
	}

}
