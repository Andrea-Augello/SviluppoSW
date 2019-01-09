package ModificaPrenotazione;

import Oggetti.Prenotazione;

public class ModificaPrenotazioneControl {
	private Prenotazione prenotazioneSelezionata;
	private ModificaPrenotazioneDialog form;

	public ModificaPrenotazioneControl(Prenotazione prenotazioneSelezionata) {
		this.prenotazioneSelezionata = prenotazioneSelezionata;
		form = new ModificaPrenotazioneDialog(prenotazioneSelezionata, this);

	}

	public void spostaPrenotazione(){
		form.mostraOrari();
	}

	public void aggiornaPrenotazione() {
		new ConfermaDialog(false, prenotazioneSelezionata);
	}

	public void eliminaPrenotazione() {
		new ConfermaDialog(true, prenotazioneSelezionata);
	}

}
