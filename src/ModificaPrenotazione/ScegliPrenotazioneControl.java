package ModificaPrenotazione;

import DatabaseInterface.DatabaseInterface;
import Oggetti.PazienteEntity;
import Oggetti.Prenotazione;

import java.util.List;

public class ScegliPrenotazioneControl {
	private ScegliPrenotazioneDialog form;

	public ScegliPrenotazioneControl() {
		List<Prenotazione> listaPrenotazioni = DatabaseInterface .getInstance().ottieniElencoPrenotazioni(PazienteEntity.getPaziente());
		this.form = new ScegliPrenotazioneDialog(this, listaPrenotazioni);
	}

	public void estraiPrenotazione() {

	}

	public void controllaPrenotazione() {

	}

}
