package DatabaseInterface;

import Oggetti.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.List;

public class DatabaseInterface {
    private Connection conn;
    //To update with PreparedStatement
    private Statement st;
    private ResultSet rs;

    
    
    private static DatabaseInterface instance = new DatabaseInterface();

    public static DatabaseInterface getInstance() {
        return instance;
    }


    private DatabaseInterface(){
        try{
            //Connection to our local server
            conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","prova");
            st=conn.createStatement();
        }catch(SQLException ex) {
            //System.out.println("Error: " + ex);
            new ErroreDialog("Errore nella connessione, riprovare più tardi.");
        }
    }

    public void aggiornaDettagliVisita(Prenotazione visita, String [] dettagli) {

    }

    public void inserisciPaziente(PazienteEntity paziente) {

    }

    public void inserisciPrenotazione(Prenotazione prenotazione) {

    }

    public void modificaPrenotazione(Prenotazione prenotazione) {

    }

    public String [] ottieniDettagliVisita(Prenotazione prenotazione) {
        return null;
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

    public List<Prenotazione> ottieniElencoVisite(PersonaleEntity medico) {
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

    public PersonaleEntity ottieniPersonale(String username, String password, boolean isMedico) {
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
