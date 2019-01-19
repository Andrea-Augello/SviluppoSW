package ModificaPrenotazione;

import ExternalComponentsInterface.DatabaseInterface;
import MainScreen.ErroreDialog;
import Entity.PazienteEntity;
import Entity.Prenotazione;

import java.util.List;

public class ScegliPrenotazioneControl {
	private ScegliPrenotazioneDialog form;

	public ScegliPrenotazioneControl() {
		List<Prenotazione> listaPrenotazioni = DatabaseInterface.getInstance().ottieniElencoPrenotazioni(PazienteEntity.getPaziente());
		if(listaPrenotazioni != null) {
			this.form = new ScegliPrenotazioneDialog(this, listaPrenotazioni);
		} else {
			new ErroreDialog("Non è presente nessuna prenotazione modificabile");
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
