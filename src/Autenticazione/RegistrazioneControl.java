package Autenticazione;

import ExternalComponentsInterface.DatabaseInterface;
import Oggetti.ErroreDialog;
import Oggetti.PazienteEntity;

public class RegistrazioneControl {
    RegistrazioneForm form;
    PazienteEntity nuovoPaziente;

	public RegistrazioneControl() {
		form = new RegistrazioneForm(this);
	}

	public void registraPaziente() {
		String errore = controllaDati();
		if(errore == null){
			DatabaseInterface.getInstance().inserisciPaziente(nuovoPaziente);
			form.dispose();
		} else {
		    new ErroreDialog("Errore nella registrazione:<br/>"+errore);
		}
	}

	private String controllaDati(){
		nuovoPaziente = PazienteEntity.createInstance(form.getCodiceFiscale(), form.getNome(), form.getCognome(), form.getDataDiNascita(), form.getIndirizzoMail(), form.getTelefono(), form.getPassword());
		if (DatabaseInterface.getInstance().ottieniPaziente(nuovoPaziente.getCodiceFiscale()) != null){
			return "Il codice fiscale inserito risulta già registrato nel sistema.";
		}
		if (!nuovoPaziente.getPassword().equals(form.getPasswordConfirmation())) {
			return "Le due password inserite non coincidono.";
		}
		if (!nuovoPaziente.getCodiceFiscale().matches("^[A-Z]{6}[A-Z0-9]{2}[A-Z][A-Z0-9]{2}[A-Z][A-Z0-9]{3}[A-Z]$")){
			return "Codice fiscale non valido.";
		}
		if (!nuovoPaziente.getIndirizzoMail().matches("^([0-9a-zA-Z]([-\\.\\w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-\\w]*[0-9a-zA-Z]\\.)+[a-zA-Z]{2,9})$")){
			return "L'indirizzo mail inserito non è valido.";
		}
		return null;
	}
}
