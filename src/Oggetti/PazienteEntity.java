package Oggetti;

public class PazienteEntity {
	private static PazienteEntity pazienteSelezionato = null;
	private String codiceFiscale;

	private String password;

	public static PazienteEntity getPaziente(){
		return pazienteSelezionato;
	}

	public static void setPaziente(PazienteEntity paziente){
		pazienteSelezionato = paziente;
	}

}
