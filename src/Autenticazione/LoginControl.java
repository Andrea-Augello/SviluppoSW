package Autenticazione;

import DatabaseInterface.DatabaseInterface;
import Oggetti.*;

public class LoginControl {
    int userType;
    LoginForm form;

	public LoginControl(int userType) {
	    this.userType = userType;
	    if(userType > 1){
	    	form = setupPersonale();
		} else {
	    	form = setupPaziente();
		}
	}

	public void controllaDati() {
		switch (userType){
			case 1:
			    controllaLoginPaziente();
				break;
			case 2:
			    controllaLoginAmministrativo();
				break;
			case 3:
				controllaLoginMedico();
				break;
			default:
				new ErroreDialog("Login non previsto per il tipo di utente selezionato");
        }
	}

    private PazienteLoginForm setupPaziente(){
		return new PazienteLoginForm(this);
	}

	private PersonaleLoginForm setupPersonale(){
		return new PersonaleLoginForm(this);
	}

	private void controllaLoginPaziente(){

		PazienteEntity.setPaziente(DatabaseInterface.getInstance().ottieniPaziente(form.getUsername(), form.getPassword()));
		if(PazienteEntity.getPaziente() != null){
			new MainScreenPaziente();
			form.dispose();
		} else {
			new ErroreDialog("Username o password errati!");
			form.reset();
		}
	}


	private void controllaLoginAmministrativo(){
		if(( DatabaseInterface.getInstance().ottieniPersonale(form.getUsername(), form.getPassword(), false) )!= null){
			new MainScreenAmministrativo();
			form.dispose();
		} else {
			new ErroreDialog("Username o password errati!");
			form.reset();
		}

    }

    private void controllaLoginMedico(){
		PersonaleEntity.setMedico(DatabaseInterface.getInstance().ottieniPersonale(form.getUsername(), form.getPassword(), true));
		if(PersonaleEntity.getMedico() != null){
			new MainScreenMedico();
			form.dispose();
		} else {
			new ErroreDialog("Username o password errati!");
			form.reset();
		}
	}
}
