package Oggetti;

import java.time.LocalDateTime;

public class Ricetta {

	private String codiceRicetta;
	private int regime;
	private int prestazione;
	private int urgenza;
	private LocalDateTime limiteMassimo;

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
		limiteMassimo = LocalDateTime.now();
		switch (urgenza) {
			case 1:
				limiteMassimo = limiteMassimo.plusDays(3);
				break;
			case 2:
				limiteMassimo = limiteMassimo.plusDays(10);
				break;
			case 3:
				limiteMassimo = limiteMassimo.plusDays(60);
				break;
			case 4:
				limiteMassimo = limiteMassimo.plusDays(180);
				break;
		}
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

	public int getRegime() {
		return regime;
	}

	public void setRegime(int regime) {
		this.regime = regime;
	}

	public LocalDateTime getLimiteMassimo() {
		return limiteMassimo;
	}
}
