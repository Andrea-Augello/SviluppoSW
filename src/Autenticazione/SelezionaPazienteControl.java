package Autenticazione;

import DatabaseInterface.DatabaseInterface;
import Oggetti.ErroreDialog;
import Oggetti.PazienteEntity;

public class SelezionaPazienteControl {
    IndividuaPazienteForm form;

	public SelezionaPazienteControl() {
		form = new IndividuaPazienteForm(this);
	}

	public void ottieniDati() {
	    PazienteEntity paziente = DatabaseInterface.getInstance().ottieniPaziente(form.getCodiceFiscale());
	    if(paziente == null){
	    	form.reset();
	    	new ErroreDialog("Non è registrato nessun paziente con il codice fiscale inserito");
		} else {
	    	form.dispose();
		}
	}

}
