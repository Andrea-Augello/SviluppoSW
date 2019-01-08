package Oggetti;

import java.time.LocalDateTime;

public class Prenotazione {

	private LocalDateTime data;

	private PazienteEntity paziente;

	private int codicePrestazione;

	private String descrizionePrestazione;

	public PazienteEntity getPaziente() {
		return paziente;
	}

	public void setData() {

	}

	public LocalDateTime getData() {
		return data;
	}

	public int getCodicePrestazione() {
		return codicePrestazione;
	}

	public String getDescrizionePrestazione() {
		return descrizionePrestazione;
	}
}
