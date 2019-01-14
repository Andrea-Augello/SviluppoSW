# Object Design Document

<!-- TOC depthFrom:1 depthTo:6 withLinks:1 updateOnSave:1 orderedList:0 -->

- [Object Design Document](#object-design-document)
	- [1. Introduzione](#1-introduzione)
		- [1.1 Trade-off e scelte nella progettazione degli oggetti](#11-trade-off-e-scelte-nella-progettazione-degli-oggetti)
		- [1.2 Linee guida della documentazione delle interfacce](#12-linee-guida-della-documentazione-delle-interfacce)
	- [2. Packages](#2-packages)
		- [2.1 CreaPrenotazione](#21-creaprenotazione)
		- [2.2 ModificaPrenotazione](#22-modificaprenotazione)
		- [2.3 VisualizzaFSE](#23-visualizzafse)
		- [2.4 InserisciDettagliVisita](#24-inseriscidettaglivisita)
		- [2.5 Autenticazione](#25-autenticazione)
		- [2.6 Entity](#26-entity)
		- [2.7 MainScreen](#27-mainscreen)
	- [3. Interfacce delle classi](#3-interfacce-delle-classi)
		- [3.1 Package CreaPrenotazione](#31-package-creaprenotazione)
		- [3.2 Package ModificaPrenotazione](#32-package-modificaprenotazione)
		- [3.3 Package VisualizzaFSE](#33-package-visualizzafse)
		- [3.4 Package InserisciDettagliVisita](#34-package-inseriscidettaglivisita)
		- [3.5 Package Autenticazione](#35-package-autenticazione)
		- [3.6 Package Entity](#36-package-entity)
		- [3.7 Package MainScreen](#37-package-mainscreen)

<!-- /TOC -->

## 1. Introduzione

### 1.1 Trade-off e scelte nella progettazione degli oggetti
- __Prestazioni vs Costi :__  
Il sistema realizzato con un budget ristretto ha permesso la realizzazione di un prodotto creato a partire da librerie open source, minimizzando i costi ma al contempo permettendo di realizzare un sistema molto soddisfacente.  
  
- __Interfaccia vs Facilità d'utilizzo :__  
Le interfacce utilizzate per il software, grazie all'utilizzo di form e di un layout semplice e minimale, permettono la migliore interazione possibile anche con un utente meno esperto nel campo informatico. Il tutto è facilitato da una semplice gestione del database.  
  
- __Interfaccia vs Tempo di risposta :__  
I tempi di risposta tra server e interfaccia sono molto rapidi e soddisfano a pieno le esigenze del sistema. Naturalmente all'aumentare della dimensione del Database aumentano anche i corrispettivi tempi di risposta e di ricerca nello stesso.  
   
Per quanto riguarda la gestione e la progettazione delle interfacce grafiche sono state scelte le API di Java offerte da Oracle, tra le quali:
- __Swing widget toolkit :__ Framework appartenente alla Java Foundation Classes (JFC), utilizzato per strutturare la maggior parte delle interfacce grafice presenti nel software.  
- __UI Designer :__ Plugin di IntelliJIdea messo a disposizione da jetbrains. Fornisce un supporto interattivo per l'editing delle Swing UI.  
- __JCalendar :__ Libreria di Java utilizzata per semplificare la selezione delle date tramite un calendario.  
- __JavaMail :__ Package realizzato da Oracle che fornisce le classi necessarie per la gestione della posta elettronica in linguaggio Java. Supporta tutti i protocolli di posta elettronica tra i quali POP3 e SMTP.  
  
A livello di User Interface il sottosistema relativo, dato l'elevatissimo coupling, è stato smembrato e distribuito nei package della logica dell'applicazione.  

### 1.2 Linee guida della documentazione delle interfacce  
Il sistema è multi-utente: può accedervi qualsiasi tipo di utenza, dal paziente al personale dell'ospedale (sia medico che amministrativo).
A tutta l'utenza vengono nascosti i meccanismi interni di prenotazione e più nello specifico l'algoritmo utilizzato per spostare le varie prenotazioni.
Al paziente viene fornita una semplice e intuitiva schermata dalla quale può gestire comodamente tutte le sue prenotazioni ed eventualmente visualizzare anche lo storico delle prestazioni effettuate.
Il personale amministrativo, tramite un'interfaccia simile a quella fornita al paziente, è in grado di effettuare le stesse operazioni ma con permessi più ampi come stampare lo storico delle visite di un determinato paziente.
Infine, l'interfaccia a disposizione del personale medico è stata realizzata in modo da facilitare la sua professione permettendo di riempire completamente da software la cartella clinica di un suo paziente.  
  
Di seguito viene illustrata la vista d'insieme che racchiude tutte le classi utilizzate per lo sviluppo del nostro software.
![Package "TutteLeClassi"](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Object%20Design/TutteLeClassi.png)  

## 2. Packages

### 2.1 CreaPrenotazione
Questo package contiene tutte le classi relative alla gestione della creazione di una prenotazione presso la struttura ospedaliera.  
   
![Package "CreaPrenotazione"](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Object%20Design/CreaPrenotazionePackage.png)  
  
- [__EffettuaPrenotazioneControl :__](#classe-effettuaprenotazionecontrol) Control che gestisce le operazioni riguardanti la prenotazione di una nuova visita da effettuare.  
- [__GeneraRicettaControl :__](#classe-generaricettacontrol) Control che gestisce le operazioni per la memorizzazione delle informazioni relative ad una ricetta.  
- [__ScegliRegimeDialog :__](#classe-scegliregimedialog) Schermata che nelle operazioni di prenotazione consente di scegliere tra regime ALPI e regime SSN.  
- [__FormRicetta :__](#classe-formricetta) Form che permette l’inserimento dei dati relativi alla ricetta.  
- [__ScegliOrarioDialog :__](#classe-scegliorariodialog) Schermata attraverso la quale, durante le operazioni di prenotazione, l’utente può selezionare data e ora della visita tra quelli proposti dal sistema.  
- [__SceltaMedicoDialog :__](#classe-sceltamedicodialog) Schermata che appare nelle operazioni di prenotazione se si sceglie il regime ALPI. Permette di scegliere il medico dal quale farsi visitare.  
  
### 2.2 ModificaPrenotazione
Questo package racchiude tutte le classi relative alla modifica di un'eventuale prenotazione già effettuata.  
  
![Package "CreaPrenotazione"](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Object%20Design/ModificaPrenotazionePackage.png)  
  
- [__ScegliPrenotazioneControl :__](#classe-scegliprenotazionecontrol) Control che gestisce le operazioni per la corretta realizzazione della scelta della visita da modificare da parte dell’utente.  
- [__ModificaPrenotazioneControl :__](#classe-modificaprenotazionecontrol) Control che gestisce le operazioni necessarie per la modifica di una prenotazione.  
- [__ConfermaModificaControl :__](#classe-confermamodificacontrol) Control che gestisce le operazioni riguardanti la conferma di una modifica da effettuare.  
- [__ScegliPrenotazioneDialog :__](#classe-scegliprenotazionedialog) Schermata che presenta l’elenco delle prenotazioni per visite ancora non effettuate dal paziente, da qui è possibile selezionarne una per modificarla.  
- [__ModificaPrenotazioneDialog :__](#classe-modificaprenotazionedialog) Interfaccia che permette all’utente di modificare la Prenotazione selezionata.  
- [__ConfermaDialog :__](#classe-confermadialog) Questa schermata, nelle operazioni di modifica di una prenotazione già effettuata, riassume le modifiche e consente di confermarle o annullarle.  
  
### 2.3 VisualizzaFSE
Questo package contiene tutte le classi adibite a far visualizzare a video il fascicolo sanitario elettronico.  
  
![Package "CreaPrenotazione"](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Object%20Design/VisualizzaFSEPackage.png)  
  
- [__FSEControl :__](#classe-fsecontrol) Control che gestisce le operazioni per l’ottenimento del Fascicolo Sanitario Elettronico da parte dell’utente.  
- [__FSEDialog :__](#classe-fsedialog) Schermata che presenta lo Storico Visite richiesto precedentemente dal Paziente o il Fascicolo Sanitario richiesto dal personale.  
  
### 2.4 InserisciDettagliVisita
Package che contiene le classi che permettono al personale medico di inserire ulteriori informazioni relative alla visita di un paziente.  
  
![Package "CreaPrenotazione"](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Object%20Design/InserisciDettagliVisitaPackage.png)  
  
- [__InserisciDettagliVisitaControl :__](#classe-inseriscidettaglivisitacontrol) Control che gestisce le operazioni per il corretto inserimento della diagnosi da parte del medico.  
- [__InserisciDettagliVisitaDialog :__](#classe-inseriscidettaglivisitadialog) Interfaccia per l’inserimento e l’eventuale conferma della diagnosi della visita precedentemente effettuata.  
  
### 2.5 Autenticazione
Questo package raggruppa le classi che permettono a tutta l'utenza di effettuare il login e/o registrarsi.  
  
![Package "CreaPrenotazione"](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Object%20Design/AutenticazionePackage.png)  
  
- [__LoginControl :__](#classe-logincontrol) Control che gestisce le operazioni di verifica della correttezza di un eventuale login da parte di un utente.  
- [__RegistrazioneControl :__](#classe-registrazionecontrol) Control che gestisce le operazioni necessarie per la registrazione di un nuovo paziente.  
- [__SelezionaPazienteControl :__](#classe-selezionapazientecontrol) Control che gestisce le operazioni per selezionare un paziente da parte del PersonaleAmministrativo.  
- [__PazienteLoginForm :__](#classe-pazienteloginform) Form attraverso cui Paziente può inserire il proprio codice fiscale e proseguire le procedure di autenticazione.  
- [__PersonaleLoginForm :__](#classe-personaleloginform) Form attraverso cui PersonaleMedico e PersonaleAmministrativo possono inserire la propria matricola e proseguire le procedure di autenticazione.  
- [__IndividuaPazienteForm :__](#classe-individuapazienteform) Schermata che presenta un box dove scrivere il CF del paziente che PersonaleAmministrativo vuole scegliere per continuare le operazioni desiderate.  
- [__RegistrazioneForm :__](#classe-registrazioneform) Il form che permette di immettere i dati personali di un paziente la prima volta che questo utilizza i servizi di SPRINT.  
  
### 2.6 Entity
Questo package raggruppa le classi entity che si occupano di gestire i dati permanenti all'interno del database. Tutte le classi che fanno parte di questo package implementano l'interfaccia Comparable.
  
![Package "CreaPrenotazione"](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Object%20Design/EntityPackage.png)  
  
- [__Prenotazione :__](#classe-prenotazione) Questa classe contiene i dati rilevanti della prenotazione mentre viene elaborata dal sistema.  
- [__Ricetta :__](#classe-ricetta) Questa classe contiene i dati relativi alle ricetta mentre viene inserita nel DBMS.  
- [__PazienteEntity :__](#classe-pazienteentity) All’interno del sistema i dati dei pazienti sono racchiusi in questa classe.  
- [__PersonaleEntity :__](#classe-personaleentity) All’interno del sistema i dati del personale sono racchiusi in questa classe.  
  
### 2.7 MainScreen
Questo package contiene le classi responsabili del corretto funzionamento delle schermate principali del software e gestisce le finestre di errore.  
  
![Package "CreaPrenotazione"](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Object%20Design/MainScreenPackage.png)  
  
- [__MainScreen :__](#classe-mainscreen) Schermata principale per l’avvio di varie procedure.  
- [__MainScreenPaziente :__](#classe-mainscreenpaziente) Schermata principale personalizzata per essere visualizzata solo dall'utente "Paziente".
- [__MainScreenAmministrativo :__](#classe-mainscreenamministrativo) Schermata principale personalizzata per essere visualizzata solo dall'utente "Personale Amministrativo".  
- [__MainScreenMedico :__](#classe-mainscreenmedico) Schermata principale personalizzata per essere visualizzata solo dall'utente "Personale Medico".  
- [__ErroreDialog :__](#classe-erroredialog) Mostra a video all’utente che l’operazione da lui intrapresa non è andata a buon fine.  
  

## 3. Interfacce delle classi
Di seguito vengono documentati i metodi public relativi a tutte le classi raggruppate nei vari package.

### 3.1 Package CreaPrenotazione

#### Classe EffettuaPrenotazioneControl

Metodo | Descrizione
-|-|
EffettuaPrenotazioneControl | Costruttore della classe che riceve in input un oggetto di tipo Ricetta. Dopo aver correttamente memorizzato l'oggetto Ricetta, effettua un controllo per decidere se si tratta di una prenotazione di tipo ALPI o SSN.
prenotaMedico | Accetta in input l'entity Medico. Metodo che ottiene gli orari disponibili e permette di sceglierne uno all'utente inizializzando il form apposito.
finalizzaPrenotazione | Metodo che si occupa di creare una prenotazione. Se ne è presente già una gestisce lo spostamento di quest'ultima. Se invece non è stato selezionato nessun medico provvede a farlo scegliere.
  
#### Classe ScegliOrarioDialog

Metodo | Descrizione
-|-|
ScegliOrarioDialog | Costruttore della classe che riceve in input la control EffettuaPrenotazione e la lista di orari disponibili. Si occupa di creare correttamente l'interfaccia dalla quale l'utente potrà scegliere gli orari disponibili.
scegliOrario | Metodo che si occupa della corretta memorizzazione dei campi selezionati dall'interfaccia di gestione dell'orario.

#### Classe SceltaMedicoDialog

Metodo | Descrizione
-|-|
SceltaMedicoDialog | Costruttore della classe che riceve in input la control EffettuaPrenotazione e la lista dei medici disponibili. Si occupa di creare correttamente l'interfaccia dalla quale l'utente potrà scegliere il medico con cui effettuare la visita secondo il regime ALPI.
scegliMedico | Metodo che si occupa della corretta memorizzazione del medico scelto tramite l'interfaccia apposita.
[Vai alla descrizione della classe](#sceltamedicodialog)

#### Classe GeneraRicettaControl

Metodo | Descrizione
-|-|
GeneraRicettaControl | Costruttore della classe che crea un'istanza del form che gestisce i dati di una ricetta con i dati passati alla control stessa.
ottieniDati | Metodo che memorizza correttamente i dati della ricetta e controlla che non ce ne sia una con lo stesso numero.
SSN | Metodo che inizializza il regime di prenotazione in SSN.
ALPI | Metodo che inizializza il regime di prenotazione in ALPI.

#### Classe FormRicetta

Metodo | Descrizione
-|-|
FormRicetta | Costruttore della classe che istanzia correttamente il form per inserire i dati di una ricetta.
reset | Metodo che fa il refesh del campo "codice ricetta".
getCodiceRicetta | Metodo getter che restituisce il codice di una ricetta.
getCodicePrestazione | Metodo getter che restituisce il codice della prestazione richiesta.
getUrgenza | Metodo getter che restituisce il tipo di urgenza di una relativa ricetta.

#### Classe ScegliRegimeDialog

Metodo | Descrizione
-|-|
ScegliRegimeDialog | Costruttore della classe che riceve in input la control GeneraRicetta. Predispone e crea l'interfaccia dalla quale l'utente può scegliere il regime di prenotazione desiderato.
  
### 3.2 Package ModificaPrenotazione

#### Classe ScegliPrenotazioneControl

Metodo | Descrizione
-|-|
ScegliPrenotazioneControl | Costruttore della classe che acquisisce la lista delle prenotazioni effettuate da un utente.
estraiPrenotazione | Metodo che predispone la prenotazione selezionata per eventuali altre operazioni.

#### Classe ScegliPrenotazioneDialog

Metodo | Descrizione
-|-|
ScegliPrenotazioneDialog | Costruttore della classe che riceve in input la control ScegliPrenotazione e la lista delle prenotazioni. Crea correttamente l'interfaccia dalla quale l'utente può scegliere la prenotazione da modificare.
selezionaPrenotazione | Metodo che seleziona la prenotazione scelta e la passa alla control ScegliPrenotazione per essere gestita.
dispose | Metodo che agisce sullo stato della finestra dell'interfaccia di scelta della prenotazione chiudendola.
getPrenotazioneSelezionata | Metodo getter che restituisce la prenotazione selezionata dall'utente.

#### Classe ModificaPrenotazioneControl

Metodo | Descrizione
-|-|
ModificaPrenotazioneControl | Costruttore della classe che prende in input la prenotazione selezionata dall'utente. Si occupa di inizalizzare la schermata di modifica in base alla prenotazione scelta passata come parametro.
spostaPrenotazione | Metodo che dopo aver ottenuto una lista degli orari disponibili li usa per inizializzare la schermata relativa ai nuovi orari data una prenotazione da spostare.
aggiornaPrenotazione | Metodo che si occupa di predisporre il dialog relativo alla conferma dell'operazione che avrà esito positivo, spostando la prenotazione selezionata.
eliminaPrenotazione | Metodo che si occupa di predisporre il dialog relativo alla conferma dell'operazione che avrà esito negativo, cancellando la prenotazione selezionata.

#### Classe ModificaPrenotazioneDialog

Metodo | Descrizione
-|-|
ModificaPrenotazioneDialog | Costruttore della classe che prende in input la control ModificaPrenotazione e la prenotazione selezionata. Crea correttamente l'interfaccia necessaria a modificare una prenotazione.
cancellaPrenotazione | Metodo che chiama la control ModificaPrenotazione che si occuperà di cancellare la prenotazione selezionata.
modificaPrenotazione | Metodo che chiama la control ModificaPrenotazione che si occuperà di modificare la prenotazione selezionata, spostandola.
confermaOrario | Metodo che chiama la control ModificaPrenotazione che si occuperà di aggiornare i dati relativi alla prenotazione selezionata precedentemente.
mostraOrari | Metodo che crea l'interfaccia relativa all'orario da selezionare da parte dell'utente in caso di modifica di una prenotazione.

#### Classe ConfermaDialog

Metodo | Descrizione
-|-|
ConfermaDialog | Costruttore della classe che prende in input una prenotazione selezionata e un flag. Crea l'interfaccia relativa al popup di conferma operazione che porterà ad un'operazione o ad un'altra a seconda del valore della flag.
prosegui | Metodo che tramite un opportuno controllo gestisce la prenotazione nel database a seconda che sia stata cancellata o modificata. In caso di errore gestirà una schermata dove verrà notificato.

### 3.3 Package VisualizzaFSE

#### Classe FSEControl

Metodo | Descrizione
-|-|
FSEControl | Costruttore della classe che dopo essersi fatto passare i dati necessari, predispone la creazione dell'interfaccia relativa al Fascicolo Sanitario Elettronico.
stampa | Metodo che gestisce la stampa del FSE.

#### Classe FSEDialog

Metodo | Descrizione
-|-|
FSEDialog | Costruttore della classe che prende in input la control FSE. Crea l'interfaccia adibita alla visualizzazione del fascicolo sanitario elettronico specifico di un utente. Inoltre si occupa anche della funzione di visualizzazione dello storico visite di un dato utente.
stampaFSE | Metodo che chiama la control FSE che inizierà la procedura di stampa del fasciolo sanitario elettronico.

### 3.4 Package InserisciDettagliVisita

#### Classe InserisciDettagliVisitaControl

Metodo | Descrizione
-|-|
InserisciDettagliVisita | Costruttore della classe che prende in input una prenotazione. Dopo aver acquisito i dati necessari predispone l'interfaccia per inserire i dettagli di una visita.
aggiornaDettagli | Aggiorna correttamente i dettagli inseriti.

#### Classe InserisciDettagliVisitaDialog

Metodo | Descrizione
-|-|
InserisciDettagliVisitaDialog | Costruttore della classe che accetta come parametri la control InserisciDettagliVisita e la stringa contenente i dettagli. Inizializza e crea correttamente l'interfaccia dalla quale l'utente potrà inserire i dettagli relativi ad una visita negli appositi box.
conferma | Metodo che conferma i dati inseriti e comunica alla control di aggiornarli.

### 3.5 Package Autenticazione

#### Classe LoginControl

Metodo | Descrizione
-|-|
LoginControl | Costruttore della classe che riceve un parametro di tipo int per identificare il tipo di utenza. Predispone il login a seconda del valore dell'input passatogli.
controllaDati | Metodo che si occupa di effettuare un controllo sulla correttezza dei dati inseriti da parte di tutte le tipologie di utente.

#### Classe LoginForm

Metodo | Descrizione
-|-|
LoginForm | Costruttore della classe che accetta in input la control Login memorizzandola correttamente.
dispose | Metodo che predispone la finestra relativa al login.
getUsername | Metodo astratto che verrà implementato in una sottoclasse di LoginForm.
getPassword | Metodo astratto che verrà implementato in una sottoclasse di LoginForm.
reset | Metodo astratto che verrà implementato in una sottoclasse di LoginForm.

#### Classe PazienteLoginForm

Metodo | Descrizione
-|-|
PazienteLoginForm | Costruttore della classe che accetta in input la control Login. Crea la schermata adibita al login per gli utenti di tipo "Paziente".
conferma | Metodo che conferma i dati inseriti dall'utente facendo partire il controllo degli stessi gestito dalla control Login.
RegistraPaziente | Metodo che predispone la registrazione di un nuovo utente di tipo "Paziente" inizializzando la control Registrazione.
getUsername | Metodo getter che restituisce l'username inserito.
getPassword | Metodo getter che restituisce la password inserita.
reset | Metodo che aggiorna i campi relativi a username e password predisponendoli per un nuovo utilizzo.

#### Classe PersonaleLoginForm

Metodo | Descrizione
-|-|
PersonaleLoginForm | Costruttore della classe che accetta in input la control Login. Crea la schermata adibita al login per gli utenti di tipo "Personale Amministrativo" e "Personale Medico".
conferma | Metodo che conferma i dati inseriti dall'utente facendo partire il controllo degli stessi gestito dalla control Login.
getUsername | Metodo getter che restituisce l'username inserito.
getPassword | Metodo getter che restituisce la password inserita.
reset | Metodo che aggiorna i campi relativi a username e password predisponendoli per un nuovo utilizzo.

#### Classe RegistrazioneControl

Metodo | Descrizione
-|-|
RegistrazioneControl | Costruttore della classe che istanzia correttamente il form che verrà utilizzato.
registraPaziente | Metodo che inizializza e predispone il form nel quale verranno inseriti i dati del nuovo utente di tipo "Paziente".

#### Classe RegistrazioneForm

Metodo | Descrizione
-|-|
RegistrazioneForm | Costruttore della classe che crea l'interfaccia nella quale l'utente potrà inserire i dati che verranno memorizzati per la registrazione.
conferma | Metodo che conferma i dati inseriti dall'utente facendo partire il controllo degli stessi gestito dalla control Login.
getPasswordConfirmation | Metodo getter che restituisce la conferma della password.
getPassword | Metodo getter che restituisce la password inserita.
getTelefono | Metodo getter che restituisce il numero di telefono inserito.
getIndirizzoMail | Metodo getter che restituisce l'indirizzo email inserito.
getCognome | Metodo getter che restituisce il cognome del paziente.
getNome | Metodo getter che restituisce il nome del paziente.
getCodiceFiscale | Metodo getter che restituisce il codice fiscale del paziente.
getDataDiNascita | Metodo getter che restituisce la data di nascita del paziente.
dispose | Metodo che agisce sullo stato della finestra dell'interfaccia di registrazione chiudendola.

#### Classe SelezionaPazienteControl

Metodo | Descrizione
-|-|
SelezionaPazienteControl | Costruttore della classe che istanzia correttamente il form che verrà utilizzato.
ottieniDati | Metodo che si occupa di recuperare dal database i dati del paziente scelto.

#### Classe IndividuaPazienteForm

Metodo | Descrizione
-|-|
IndividuaPazienteForm | Costruttore della classe che crea l'interfaccia nella quale l'utente di tipo "Personale Amministrativo" potrà inserire il codice fiscale di un paziente per accedere alla sua area servizi.
dispose | Metodo che agisce sullo stato della finestra dell'interfaccia di individuazione chiudendola.
getCodiceFiscale | Metodo getter che restituisce il codice fiscale del paziente.

### 3.6 Package Entity

#### Classe PazienteEntity

Metodo | Descrizione
-|-|
PazienteEntity | Costruttore della classe che inizializza tutti i campi presenti nella classe stessa.
createInstance | Metodo che crea un'istanza corretta dell'oggetto "Paziente"
setPaziente | Metodo setter che memorizza in "pazienteSelezionato" l'oggetto "Paziente" passatogli in input.
getCodiceFiscale | Metodo getter che restituisce il codice fiscale del paziente.
setCodiceFiscale | Metodo setter che memorizza correttamente il codice fiscale passatogli in input.
getNome | Metodo getter che restituisce il nome del paziente.
setNome | Metodo setter che memorizza correttamente il nome del paziente passatogli in input.
getCognome | Metodo getter che restituisce il cognome del paziente.
setCognome | Metodo setter che memorizza correttamente il cognome del paziente passatogli in input.
getDataDiNascita | Metodo getter che restituisce la data di nascita del paziente.
setDataDiNascita | Metodo setter che memorizza correttamente la data di nascita del paziente passata in input.
getIndirizzoMail | Metodo getter che restituisce l'indirizzo email inserito.
setIndirizzoMail | Metodo setter che memorizza correttamente l'indirizzo email passatogli in input.
getTelefono | Metodo getter che restituisce il numero di telefono inserito.
setTelefono | Metodo setter che memorizza correttamente il numero di telefono del paziente passatogli in input.
getPassword | Metodo getter che restituisce la password inserita.
setPassword | Metodo setter che memorizza correttamente la password passata in input.

#### Classe PersonaleEntity

Metodo | Descrizione
-|-|
PersonaleEntity | Costruttore della classe che inizializza tutti i campi presenti nella classe stessa.
getMatricola | Metodo getter che restituisce la matricola dell'utente.
getMedico | Metodo getter che restituisce un utente di tipo "PersonaleMedico".
setMedico | Metodo setter che memorizza un utente di tipo "PersonaleMedico" passatogli in input.

#### Classe Prenotazione

Metodo | Descrizione
-|-|
Prenotazione | Costruttore della classe che inizializza tutti i campi presenti nella classe stessa.
getDataOraAppuntamento | Metodo getter che restituisce la data e l'ora della prenotazione.
getId | Metodo getter che restituisce l'ID della prenotazione.
setDataOraAppuntamento | Metodo setter che memorizza correttamente la data e l'ora della prenotazione passata in input.
getPaziente | Metodo getter che restituisce l'utente di tipo "Paziente" associato alla prenotazione.
getCodicePrestazione | Metodo getter che restituisce il codice della prestazione relativa ad una prenotazione.
getMedico | Metodo getter che restituisce l'utente di tipo "PersonaleMedico" associato alla prenotazione.
getRicetta | Metodo getter che restituisce la ricetta specifica di una data visita legata alla prenotazione.
getDescrizionePrestazione | Metodo getter che restituisce la descrizione della prestazione correlata alla prenotazione.
getLimiteMassimo | Metodo getter che restituisce la data massima entro la quale la prenotazione può essere spostata.
getCodiceRicetta | Metodo getter che restituisce il codice della ricetta specifica di una data visita legata alla prenotazione.

#### Classe Ricetta

Metodo | Descrizione
-|-|
Ricetta | Costruttore della classe che inizializza tutti i campi presenti nella classe stessa.
getUrgenza | Metodo getter che restituisce il tipo di urgenza di una relativa ricetta.
setUrgenza | Metodo setter che inizializza la data massima entro la quale la prenotazione può essere spostata in base al tipo di urgenza passatogli in input.
getPrestazione | Metodo getter che restituisce la prestazione relativa ad una ricetta.
setPrestazione | Metodo setter che memorizza la prestazione di una ricetta.
getCodiceRicetta | Metodo getter che restituisce il codice di una ricetta.
setCodiceRicetta | Metodo setter che memorizza il codice di una ricetta passatogli in input.
getRegime | Metodo getter che restituisce il regime di prenotazione.
setRegime | Metodo setter che memorizza il regime di prenotazione passatogli in input.
getLimiteMassimo | Metodo getter che restituisce la data massima entro la quale la prenotazione può essere spostata.

### 3.7 Package MainScreen

#### Classe MainScreen

Metodo | Descrizione
-|-|
creaPrenotazioni | Metodo che crea una prenotazione chiamando la control GeneraRicetta che la gestirà.
modificaPrenotazione | Metodo che modifica una prenotazione chiamando la control ScegliPrenotazione.
visualizzaStoricoVisite | Metodo che fa visualizzare a schermo lo storico delle visite chiamando la control FSE.
visualizzaCartellaClinica | Metodo che fa visualizzare la cartella clinica chiamando la control FSE.
inserisciDettagliVisita | Metodo che accettando in input una visita permette di inserirne i dettagli chiamando la control InserisciDettagliVisita.
individuaPaziente | Metodo che permette all'utente di tipo "Personale Amministrativo" di accedere all'area riservata di un paziente chiamando la control SelezionaPaziente.

#### Classe MainScreenPaziente

Metodo | Descrizione
-|-|
MainScreenPaziente | Costruttore della classe che crea l'interfaccia della schermata principale personalizzata per l'utente di tipo "Paziente".

#### Classe MainScreenAmministrativo

Metodo | Descrizione
-|-|
MainScreenAmministrativo | Costruttore della classe che crea l'interfaccia della schermata principale personalizzata per l'utente di tipo "PersonaleAmministrativo".

#### Classe MainScreenMedico

Metodo | Descrizione
-|-|
MainScreenMedico | Costruttore della classe che crea l'interfaccia della schermata principale personalizzata per l'utente di tipo "PersonaleMedico".

#### Classe ErroreDialog
ErroreDialog | Costruttore della classe che crea l'interfaccia del popup di errore. Ce ne sono quattro all'interno della classe che variano a seconda dei parametri passati in input.