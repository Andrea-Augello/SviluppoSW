package Autenticazione;

import Oggetti.ErroreDialog;
import Oggetti.MainScreenPaziente;

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
			case 0:
				new ErroreDialog("Funzionalità non implementata per Paziente");
				break;
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

	public static void main(String[] args) {
	    new LoginControl(1);
    }

    private PazienteLoginForm setupPaziente(){
		return new PazienteLoginForm(this);
	}

	private PersonaleLoginForm setupPersonale(){
		return new PersonaleLoginForm(this);

	}

	private void controllaLoginPaziente(){
		new ErroreDialog("Funzionalità non implementata per Paziente");

		//Solo per motivi di test, questa cosa è l'orrore!
		if(true){
			new MainScreenPaziente();
			form.dispose();
		}
	}


	private void controllaLoginAmministrativo(){
		new ErroreDialog("Funzionalità non implementata per PersonaleAmministrativo");
    }
    private void controllaLoginMedico(){
		new ErroreDialog("Funzionalità non implementata per PersonaleMedico");
	}
}
