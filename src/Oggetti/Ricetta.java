package Oggetti;

public class Ricetta {

	private String codiceRicetta;
	private int regime;
	private int prestazione;
	private int urgenza;

	public Ricetta(String codiceRicetta, int urgenza, int prestazione) {
	    setCodiceRicetta(codiceRicetta);
	    setUrgenza(urgenza);
	    setPrestazione(prestazione);
	}

	public int getUrgenza() {
		return urgenza;
	}

	public void setUrgenza(int urgenza) {
		this.urgenza = urgenza;
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

	public void setRegime(int regime) {
		this.regime = regime;
	}

}
