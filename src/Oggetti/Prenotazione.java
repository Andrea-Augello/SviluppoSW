package Oggetti;

import java.time.LocalDateTime;

public class Prenotazione {

    private Ricetta ricetta;

	private PersonaleEntity medico;

	private int id;

	private PazienteEntity paziente;

	private String descrizionePrestazione;

	private LocalDateTime dataOraAppuntamento;

	public Prenotazione(PazienteEntity paziente, Ricetta ricetta, LocalDateTime slotScelto, PersonaleEntity medico) {
	    this.paziente = paziente;
		this.ricetta = ricetta;
		this.dataOraAppuntamento = slotScelto;
		this.medico = medico;
	}

	public Prenotazione(Ricetta ricetta, PersonaleEntity medico, int id, PazienteEntity paziente, String descrizionePrestazione, LocalDateTime dataOraAppuntamento) {
		this.ricetta = ricetta;
		this.medico = medico;
		this.id = id;
		this.paziente = paziente;
		this.descrizionePrestazione = descrizionePrestazione;
		this.dataOraAppuntamento = dataOraAppuntamento;
	}

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
		return dataOraAppuntamento;
	}

	public int getCodicePrestazione() {
		return ricetta.getPrestazione();
	}

	public PersonaleEntity getMedico() {
		return medico;
	}

	public Ricetta getRicetta() {
		return ricetta;
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
