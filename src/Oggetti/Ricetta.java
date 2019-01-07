package Oggetti;

public class Ricetta {

	private int regime;
	private int prestazione;

	public Ricetta(int prestazione, String codiceRicetta) {
		this.prestazione = prestazione;
		this.codiceRicetta = codiceRicetta;
	}

	public int getPrestazione() {
		return prestazione;
	}

	public void setPrestazione(int prestazione) {
		this.prestazione = prestazione;
	}

	public String getCodiceRicetta() {
		return codiceRicetta;
	}

	public void setCodiceRicetta(String codiceRicetta) {
		this.codiceRicetta = codiceRicetta;
	}

	private String codiceRicetta;

	public void setRegime() {

	}

}
