package ModificaPrenotazione;

import ExternalComponentsInterface.DatabaseInterface;
import Oggetti.PazienteEntity;
import Oggetti.Prenotazione;

import java.util.List;

public class ScegliPrenotazioneControl {
	private ScegliPrenotazioneDialog form;

	public ScegliPrenotazioneControl() {
		List<Prenotazione> listaPrenotazioni = DatabaseInterface .getInstance().ottieniElencoPrenotazioni(PazienteEntity.getPaziente());
		if(listaPrenotazioni == null) {
			this.form = new ScegliPrenotazioneDialog(this, listaPrenotazioni);
		}
	}

	public void estraiPrenotazione() {
		new ModificaPrenotazioneDialog(form.getPrenotazioneSelezionata());
	}

/*
public void controllaPrenotazione() {
//Metodo non usato, va eliminato?
}
*/

}
