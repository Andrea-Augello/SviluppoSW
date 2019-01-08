package InserisciDettagliVisita;

import DatabaseInterface.DatabaseInterface;
import Oggetti.Prenotazione;

public class InserisciDettagliVisitaControl {
	private InserisciDettagliVisitaDialog form;
	private String [] dettagli;
	private Prenotazione visita;

	public InserisciDettagliVisitaControl(Prenotazione visita) {
		this.visita = visita;
		dettagli = DatabaseInterface.getInstance().ottieniDettagliVisita(visita);
		if(dettagli == null){
			dettagli = new String[]{" ", " ", " "};
		}
		form = new InserisciDettagliVisitaDialog(this, dettagli);
	}

	public void aggiornaDettagli(String diagnosi, String referti, String osservazioni) {
		dettagli[0] = diagnosi;
		dettagli[1] = referti;
		dettagli[2] = osservazioni;
		DatabaseInterface.getInstance().aggiornaDettagliVisita(visita, dettagli);
	}
}
