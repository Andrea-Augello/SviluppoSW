package ExternalComponentsInterface;

import Oggetti.*;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DatabaseInterface {
    private Connection conn;
    private PreparedStatement st;
    private ResultSet rs;

    
    
    private static DatabaseInterface instance = new DatabaseInterface();

    public static DatabaseInterface getInstance() {
        return instance;
    }


    private DatabaseInterface(){
        try{
            //Connection to our local server: DO NOT TOUCH
            conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","prova");
            //st=conn.createStatement();
        }catch(SQLException ex) {
            //System.out.println("Error: " + ex);
            new ErroreDialog("Errore nella connessione, riprovare più tardi.");
        }
    }

    public void aggiornaDettagliVisita(Prenotazione visita, String [] dettagli) {
        try {
            st = conn.prepareStatement("UPDATE `mydb`.`Visita` SET `Diagnosi` = ?, `Referti` = ?, `Osservazioni` = ?  WHERE (`Prenotazione_ID` = ?);");
            st.setString(1, dettagli[0]);
            st.setString(2, dettagli[1]);
            st.setString(3, dettagli[2]);
            st.setInt(4,visita.getCodicePrestazione());
            st.execute();
        } catch (SQLException e) {
            new ErroreDialog(""+e);
        }
   }

    public void inserisciPaziente(PazienteEntity paziente) {
        try {
            //Prepare statement
            st = conn.prepareStatement("INSERT INTO Paziente (`CF`, `Password`, `Nome`, `Cognome`, `Data_di_nascita`, `Telefono`, `Indirizzo_email`) VALUES (?, ?, ?, ?, ?, ?, ?)\n");
            //Set field
            st.setString(1, paziente.getCodiceFiscale());
            st.setString(2, paziente.getPassword());
            st.setString(3, paziente.getNome());
            st.setString(4, paziente.getCognome());
            st.setString(5, paziente.getDataDiNascita().format(DateTimeFormatter.ISO_LOCAL_DATE));
            st.setString(6, paziente.getTelefono());
            st.setString(7, paziente.getIndirizzoMail());
            //Execute
            st.execute();
        }catch(SQLException ex) {
            new ErroreDialog(ex);
        }
    }

  public void inserisciPrenotazione(Prenotazione prenotazione) {
        try {
            //Prepare statement
            st = conn.prepareStatement("INSERT INTO Prenotazione (`ID`, `Regime`, `Limite_massimo`, `Paziente_CF`,`FasciaOraria_Data_e_ora`,`Prestazione_ID`, `Ricetta_Numero_ricetta`) VALUES (?, ?, ?, ?, ?, ?,?)\n");
            //Set field
            st.setString(2, prenotazione.getDescrizionePrestazione());
            st.setString(3, prenotazione.getLimiteMassimo().format(DateTimeFormatter.ISO_LOCAL_DATE));
            st.setString(4, prenotazione.getPaziente().getCodiceFiscale());
            st.setString(5,prenotazione.getDataOraAppuntamento().format(DateTimeFormatter.ISO_LOCAL_DATE));
            st.setInt(6, prenotazione.getCodicePrestazione());
            st.setString(7,prenotazione.getCodiceRicetta());
            //Execute
            st.execute();
        }catch(SQLException ex) {
            new ErroreDialog(ex);
        }
    }

    public void modificaPrenotazione(Prenotazione prenotazione) {

    }

    public String [] ottieniDettagliVisita(Prenotazione prenotazione) {
        try {
            //Prepare statement
            st = conn.prepareStatement("SELECT Diagnosi,Referti,Osservazioni FROM Visita WHERE ID=? ");
            //Set field
            st.setInt(1,prenotazione.getId());
            //Execute
            rs=st.executeQuery();
            String[] dettagli=new String[3];
            dettagli[0]=rs.getString("Diagnosi");
            dettagli[1]=rs.getString("Referti");
            dettagli[2]=rs.getString("Osservazioni");
            return dettagli;
        }catch(SQLException ex) {
            new ErroreDialog(ex);
        }
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

    public List<LocalDateTime> ottieniOrari(int prestazione, LocalDateTime limiteMassimo) {
        return null;
    }

    public List<LocalDateTime> ottieniOrari(PersonaleEntity medico) {
        return null;
    }

    public PazienteEntity ottieniPaziente(String cf) {
        try {
            //Prepare statement
            st = conn.prepareStatement("SELECT * FROM Paziente WHERE CF=? ");
            //Set field
            st.setString(1, cf);
            //Execute
            rs=st.executeQuery();
            return parserPaziente(rs);
        }catch(SQLException ex) {
            new ErroreDialog(ex);
        }
        return null;
    }

    public PazienteEntity ottieniPaziente(String cf, String password) {
        try {
            //Prepare statement
            st = conn.prepareStatement("SELECT * FROM Paziente WHERE CF=? AND Password = ?");
            //Set field
            st.setString(1, cf);
            st.setString(2, password);
            //Execute
            rs=st.executeQuery();
            return parserPaziente(rs);
        }catch(SQLException ex) {
            new ErroreDialog(ex);
        }
        return null;
    }

    public PersonaleEntity ottieniPersonale(String username, String password, boolean isMedico) {
        try {
            //Prepare statement
            if(isMedico) {
                st = conn.prepareStatement("SELECT * FROM PersonaleMedico WHERE ID=? AND Password = ?");
            } else {
                st = conn.prepareStatement("SELECT * FROM PersonaleAmministrativo WHERE ID=? AND Password = ?");
            }
            //Set field
            st.setString(1, username);
            st.setString(2, password);
            //Execute
            rs=st.executeQuery();
            return parserPersonale(rs);
        }catch(SQLException ex) {
            new ErroreDialog(ex);
        }
        return null;
    }

    public Prenotazione ottieniPrenotazione(int id) {
        return null;
    }

    public LocalDateTime ottieniPrenotazioneSpostabile(int prestazione, LocalDateTime limiteTemporale) {
        return null;
    }

    public void rimuoviPrenotazione(Prenotazione prenotazione) {
        try {
            st = conn.prepareStatement("DELETE FROM Prenotazione WHERE ID=?;\n");
            st.setInt(1, prenotazione.getId());
            st.execute();
        } catch (SQLException e) {
            new ErroreDialog(""+e);
        }
    }

    public String ottieniStoricoVisite(PazienteEntity paziente, LocalDateTime now) {
        return null;
    }

    public PersonaleEntity ottieniMedicoDisponibile(LocalDateTime slotScelto, int prestazione) {
        return null;
    }

    public boolean verificaDuplicati(Ricetta ricetta) {
        return false;
    }

    private PazienteEntity parserPaziente(ResultSet queryResult) {
        try{
            queryResult.next();
            String codiceFiscale=queryResult.getString("CF");
            String password = queryResult.getString("Password");
            String nome = queryResult.getString("Nome");
            String cognome = queryResult.getString("Cognome");
            LocalDate dataDiNascita = queryResult.getDate("Data_di_nascita").toLocalDate();
            String telefono = queryResult.getString("Telefono");
            String indirizzoEmail = queryResult.getString("Indirizzo_email");

            return PazienteEntity.createInstance(codiceFiscale,nome,cognome,dataDiNascita,telefono,indirizzoEmail, password);

        } catch(Exception ex){
            //new ErroreDialog("Shit happened:<br/>"+ex);
            return null;
        }


    }

    private PersonaleEntity parserPersonale(ResultSet queryResult) {
        try{
            queryResult.next();
            int matricola =queryResult.getInt("ID");
            String password = queryResult.getString("Password");

            return new PersonaleEntity(matricola,password);
        } catch(Exception ex){
            //new ErroreDialog("Shit happened:<br/>"+ex);
            return null;
        }
    }

    private Prenotazione parserPrenotazioni(ResultSet queryResult) {
        return null;
    }
}
