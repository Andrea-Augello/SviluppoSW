package Oggetti;

public class PersonaleEntity implements Comparable<PersonaleEntity> {
	private static PersonaleEntity medicoSelezionato = null;

	private int matricola;
	private String nome;
	private String cognome;
	private String password;

	public int getMatricola() {
		return matricola;
	}

	public PersonaleEntity(int matricola, String password) {
		this.matricola = matricola;
		this.password = password;
	}

	public PersonaleEntity(int matricola, String nome, String cognome, String password) {
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.password = password;
	}

	public static PersonaleEntity getMedico(){
		if(medicoSelezionato == null){
			new ErroreDialog("Impossibile procedere con l'operazione selezionata", true);
		}
		return medicoSelezionato;
	}

	public static void setMedico(PersonaleEntity medico){
		medicoSelezionato = medico;
	}

	@Override
	public int compareTo(PersonaleEntity o) {
	    return 0;
	}

	@Override
	public String toString(){
		return cognome + " " + nome;
	}
}
