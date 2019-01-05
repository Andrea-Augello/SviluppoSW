package DatabaseInterface;

import Oggetti.PazienteEntity;
import Oggetti.Prenotazione;
import Oggetti.PersonaleEntity;
import Oggetti.Ricetta;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.List;

public class DatabaseInterface {

	public void aggiornaDettagliVisita(String Diagnosi, String Referti, String Osservazioni) {

	}

	public void inserisciPaziente(PazienteEntity paziente) {

	}

	public void inserisciPrenotazione(Prenotazione prenotazione) {

	}

	public void modificaPrenotazione(Prenotazione prenotazione) {

	}

	public void ottieniDettagliVisita() {

	}

	public List<String> ottieniDocumentiNecessari(int prestazione) {
		return null;
	}

	public List<Prenotazione> ottieniElencoPrenotazioni(PazienteEntity paziente) {
		return null;
	}

	public List<Prenotazione> ottieniElencoVisite(PazienteEntity paziente) {
		return null;
	}

	public List<Prenotazione> ottieniElencoVisite(LocalDateTime inizio, LocalDateTime fine) {
		return null;
	}

	public List<PersonaleEntity> ottieniListaMedici(int prestazione) {
		return null;
	}

	public List<LocalDateTime> ottieniOrari(int prestazione) {
		return null;
	}

	public List<LocalDateTime> ottieniOrari(PersonaleEntity medico) {
		return null;
	}

	public PazienteEntity ottieniPaziente(String cf) {
		return null;
	}

	public PazienteEntity ottieniPaziente(String cf, String password) {
		return null;
	}

	public PersonaleEntity ottieniPersonale(int username, String password) {
		return null;
	}

	public Prenotazione ottieniPrenotazione(int id) {
		return null;
	}

	public LocalDateTime ottieniPrenotazioneSpostabile(int prestazione, LocalDateTime limiteTemporale) {
		return null;
	}

	public void rimuoviPrenotazione(Prenotazione prenotazione) {

	}

	public boolean verificaDuplicati(Ricetta ricetta) {
		return false;
	}

	private PazienteEntity parserPaziente(ResultSet queryResult) {
		return null;
	}

	private List<PersonaleEntity> parserPersonale(ResultSet queryResult) {
		return null;
	}

	private List<Prenotazione> parserPrenotazioni(ResultSet queryResult) {
		return null;
	}

}
