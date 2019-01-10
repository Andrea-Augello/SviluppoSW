package Oggetti;

import java.time.LocalDateTime;

public class Prenotazione {

    private Ricetta ricetta;
	private int id;

	private LocalDateTime data;

	private PazienteEntity paziente;

	private int codicePrestazione;

	private String descrizionePrestazione;

	private LocalDateTime dataOraAppuntamento;

	public LocalDateTime getDataOraAppuntamento() {
		return dataOraAppuntamento;
	}

	public void setDataOraAppuntamento(LocalDateTime dataOraAppuntamento) {
		this.dataOraAppuntamento = dataOraAppuntamento;
	}

	public PazienteEntity getPaziente() {
		return paziente;
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

	public LocalDateTime getLimiteMassimo(){
		return this.ricetta.getLimiteMassimo();
	}
	
	public String getCodiceRicetta() {
		return this.ricetta.getCodiceRicetta();
	}

}
