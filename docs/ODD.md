# Object Design Document

<!-- TOC depthFrom:1 depthTo:6 withLinks:1 updateOnSave:1 orderedList:0 -->

- [Object Design Document](#object-design-document)
	- [1. Introduzione](#1-introduzione)
		- [1.1 Trade-off della progettazione degli oggetti](#11-trade-off-della-progettazione-degli-oggetti)
		- [1.2 Linee guida della documentazione delle interfacce](#12-linee-guida-della-documentazione-delle-interfacce)
	- [2. Packages](#2-packages)
		- [2.1 CreaPrenotazione](#21-creaprenotazione)
		- [2.2 ModificaPrenotazione](#22-modificaprenotazione)
		- [2.3 VisualizzaFSE](#23-visualizzafse)
		- [2.4 InserisciDettagliVisita](#24-inseriscidettaglivisita)
		- [2.5 Autenticazione](#25-autenticazione)
		- [2.6 Entity](#26-entity)
	- [3. Interfacce delle classi](#3-interfacce-delle-classi)

<!-- /TOC -->

## 1. Introduzione

### 1.1 Trade-off della progettazione degli oggetti
- __Prestazioni vs Costi :__  
Il sistema realizzato con un budget ristretto ha permesso la realizzazione di un prodotto creato a partire da librerie open source, minimizzando i costi ma comunque al contempo permettendo di realizzare un sistema molto soddisfacente.  
  
- __Interfaccia vs Facilità d'utilizzo :__  
Le interfacce utilizzate per il software, grazie all'utilizzo di form e di un layout semplice e minimale, permettono la migliore interazione possibile anche con un utente meno esperto nel campo informatico. Il tutto è facilitato da una semplice gestione del database.  
  
- __Interfaccia vs Tempo di risposta :__  
I tempi di risposta tra server e interfaccia sono molto rapidi e soddisfano a pieno le esigenze del sistema. Naturalmente all'aumentare della dimensione del Database aumentano anche i corrispettivi tempi di risposta e di ricerca nello stesso.  
    
### 1.2 Linee guida della documentazione delle interfacce  
Il sistema è multi-utente: può accedervi qualsiasi tipo di utenza, dal paziente al personale dell'ospedale (sia medico che amministrativo).
A tutta l'utenza vengono nascosti i meccanismi interni di prenotazione e più nello specifico l'algoritmo utilizzato per spostare le varie prenotazioni.
Al paziente viene fornita una semplice e intuitiva schermata dalla quale può gestire comodamente tutte le sue prenotazioni ed eventualmente visualizzare anche lo storico delle prestazioni effettuate.
Il personale amministrativo, tramite un'interfaccia simile a quella fornita al paziente, è in grado di effettuare le stesse operazioni ma con permessi più ampi come stampare lo storico delle visite di un determinato paziente.
Infine, l'interfaccia a disposizione del personale medico è stata realizzata in modo da facilitare la sua professione permettendo di riempire completamente da software la cartella clinica di un suo paziente.  

## 2. Packages

### 2.1 CreaPrenotazione
Questo package contiene tutte le classi relative alla gestione della creazione di una prenotazione presso la struttura ospedaliera.  
   
![Package "CreaPrenotazione"](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Object%20Design/CreaPrenotazionePackage.png)  
  
- __EffettuaPrenotazioneControl :__ Control che gestisce le operazioni riguardanti la prenotazione di una nuova visita da effettuare.  
- __GeneraRicettaControl :__ Control che gestisce le operazioni per la memorizzazione delle informazioni relative ad una ricetta.  
- __ScegliRegimeDialog :__ Schermata che nelle operazioni di prenotazione consente di scegliere tra regime ALPI e regime SSN.  
- __FormRicetta :__ Form che permette l’inserimento dei dati relativi alla ricetta.  
- __ScegliOrarioDialog :__ Schermata attraverso la quale, durante le operazioni di prenotazione, l’utente può selezionare data e ora della visita tra quelli proposti dal sistema.  
- __SceltaMedicoDialog :__ Schermata che appare nelle operazioni di prenotazione se si sceglie il regime ALPI. Permette di scegliere il medico dal quale farsi visitare.  
  
### 2.2 ModificaPrenotazione
Questo package racchiude tutte le classi relative alla modifica di un'eventuale prenotazione già effettuata.  
  
![Package "CreaPrenotazione"](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Object%20Design/ModificaPrenotazionePackage.png)  
  
- __ScegliPrenotazioneControl :__ Control che gestisce le operazioni per la corretta realizzazione della scelta della visita da modificare da parte dell’utente.  
- __ModificaPrenotazioneControl :__ Control che gestisce le operazioni necessarie per la modifica di una prenotazione.  
- __ConfermaModificaControl :__ Control che gestisce le operazioni riguardanti la conferma di una modifica da effettuare.  
- __ScegliPrenotazioneDialog :__ Schermata che presenta l’elenco delle prenotazioni per visite ancora non effettuate dal paziente, da qui è possibile selezionarne una per modificarla.  
- __ModificaPrenotazioneDialog :__ Interfaccia che permette all’utente di modificare la Prenotazione selezionata.  
- __ConfermaDialog :__ Questa schermata, nelle operazioni di modifica di una prenotazione già effettuata, riassume le modifiche e consente di confermarle o annullarle.  
  
### 2.3 VisualizzaFSE
Questo package contiene tutte le classi adibite a far visualizzare a video il fascicolo sanitario elettronico.  
  
![Package "CreaPrenotazione"](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Object%20Design/VisualizzaFSEPackage.png)  
  
- __FSEControl :__ Control che gestisce le operazioni per l’ottenimento del Fascicolo Sanitario Elettronico da parte dell’utente.  
- __FSEDialog :__ Schermata che presenta lo Storico Visite richiesto precedentemente dal Paziente o il Fascicolo Sanitario richiesto dal personale.  
  
### 2.4 InserisciDettagliVisita
Package che contiene le classi che permettono al personale medico di inserire ulteriori informazioni relative alla visita di un paziente.  
  
![Package "CreaPrenotazione"](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Object%20Design/InserisciDettagliVisitaPackage.png)  
  
- __InserisciDettagliVisitaControl :__ Control che gestisce le operazioni per il corretto inserimento della diagnosi da parte del medico.  
- __InserisciDettagliVisitaDialog :__ Interfaccia per l’inserimento e l’eventuale conferma della diagnosi della visita precedentemente effettuata.  
  
### 2.5 Autenticazione
Questo package raggruppa le classi che permettono a tutta l'utenza di effettuare il login e/o registrarsi.  
  
![Package "CreaPrenotazione"](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Object%20Design/AutenticazionePackage.png)  
  
- __LoginControl :__ Control che gestisce le operazioni di verifica della corretteza di un eventuale login da parte di un utente.  
- __RegistrazioneControl :__ Control che gestisce le operazioni necessarie per la registrazione di un nuovo paziente.  
- __SelezionaPazienteControl :__ Control che gestisce le operazioni per selezionare un paziente da parte del PersonaleAmministrativo.  
- __PazienteLoginForm :__ Form attraverso cui Paziente può inserire il proprio codice fiscale e proseguire le procedure di autenticazione.  
- __PersonaleLoginForm :__ Form attraverso cui PersonaleMedico e PersonaleAmministrativo possono inserire la propria matricola e proseguire le procedure di autenticazione.  
- __IndividuaPazienteForm :__ Schermata che presenta un box dove scrivere il CF del paziente che PersonaleAmministrativo vuole scegliere per continuare le operazioni desiderate.  
- __RegistrazioneForm :__ Il form che permette di immettere i dati personali di un paziente la prima volta che questo utilizza i servizi di SPRINT.  
  
### 2.6 Entity
Questo package raggruppa le classi entity che si occupano di gestire i dati permanenti all'interno del database.  
  
![Package "CreaPrenotazione"](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Object%20Design/EntityPackage.png)  
  
- __Prenotazione :__ Questa classe contiene i dati rilevanti della prenotazione mentre viene elaborata dal sistema.  
- __Ricetta :__ Questa classe contiene i dati relativi alle ricetta mentre viene inserita nel DBMS.  
- __PazienteEntity :__ All’interno del sistema i dati dei pazienti sono racchiusi in questa classe.  
- __PersonaleEntity :__ All’interno del sistema i dati del personale sono racchiusi in questa classe.  
  


## 3. Interfacce delle classi
