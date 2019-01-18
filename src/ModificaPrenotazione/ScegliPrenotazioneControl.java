package ModificaPrenotazione;

import ExternalComponentsInterface.DatabaseInterface;
import Oggetti.ErroreDialog;
import Oggetti.PazienteEntity;
import Oggetti.Prenotazione;

import java.util.List;

public class ScegliPrenotazioneControl {
	private ScegliPrenotazioneDialog form;

	public ScegliPrenotazioneControl() {
		List<Prenotazione> listaPrenotazioni = DatabaseInterface .getInstance().ottieniElencoPrenotazioni(PazienteEntity.getPaziente());
		if(listaPrenotazioni != null) {
			this.form = new ScegliPrenotazioneDialog(this, listaPrenotazioni);
		} else {
			new ErroreDialog("Non è presente nessuna prenotazione modificabile")
		}
	}

	public void estraiPrenotazione() {
		new ModificaPrenotazioneControl(form.getPrenotazioneSelezionata());
		form.dispose();
	}

/*
public void controllaPrenotazione() {
//Metodo non usato, va eliminato?
}
*/

}
