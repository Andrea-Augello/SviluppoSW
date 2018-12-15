# Requirement Analysis Document
---
<!-- TOC depthFrom:1 depthTo:6 withLinks:1 updateOnSave:1 orderedList:0 -->

- [Requirement Analysis Document](#requirement-analysis-document)
- [1. Introduzione](#1-introduzione)
	- [1.1 Obiettivo del Sistema](#11-obiettivo-del-sistema)
	- [1.2 Scopo del sistema](#12-scopo-del-sistema)
	- [1.4 Definizioni, acronimi, e abbreviazioni](#14-definizioni-acronimi-e-abbreviazioni)
	- [1.5 Riferimenti](#15-riferimenti)
- [2. Sistema corrente](#2-sistema-corrente)
- [3. Sistema proposto](#3-sistema-proposto)
	- [3.1 Panoramica](#31-panoramica)
	- [3.2 Requisiti funzionali](#32-requisiti-funzionali)
	- [3.3 Requisiti non funzionali](#33-requisiti-non-funzionali)
	- [3.4 Modelli del sistema](#34-modelli-del-sistema)
		- [3.4.1 Casi d'uso](#341-casi-duso)
			- [Casi d'uso di alto livello.](#casi-duso-di-alto-livello)
				- [EffettuaAutenticazione](#effettuaautenticazione)
				- [CreaPrenotazione](#creaprenotazione)
				- [ModificaPrenotazione](#modificaprenotazione)
				- [VisualizzaFSE](#visualizzafse)
				- [InserisciDettagliVisita](#inseriscidettaglivisita)
				- [NotificaPrenotazione](#notificaprenotazione)
			- [Effettua Autenticazione](#effettua-autenticazione)
				- [AutenticaPersonale](#autenticapersonale)
				- [AutenticaPaziente](#autenticapaziente)
				- [RegistraPaziente](#registrapaziente)
			- [Crea Prenotazione](#crea-prenotazione)
				- [IndividuaPaziente](#individuapaziente)
				- [RegistraPaziente ¹](#registrapaziente-)
				- [InserisciDettagliRicetta](#inseriscidettagliricetta)
				- [ScegliRegimeVisita](#scegliregimevisita)
				- [PrenotaVisitaSSN](#prenotavisitassn)
				- [PrenotaVisitaALPI](#prenotavisitaalpi)
			- [Modifica Prenotazione](#modifica-prenotazione)
				- [ScegliPrenotazione](#scegliprenotazione)
				- [SpostaPrenotazione](#spostaprenotazione)
				- [EliminaPrenotazione](#eliminaprenotazione)
				- [ConfermaModifica](#confermamodifica)
				- [AutorizzazionePaziente](#autorizzazionepaziente)
			- [Visualizza FSE](#visualizza-fse)
				- [VisualizzaStoricoVisite](#visualizzastoricovisite)
				- [StampaCartellaClinica](#stampacartellaclinica)
				- [VisualizzaCartellaClinica](#visualizzacartellaclinica)
				- [IndividuaPaziente ²](#individuapaziente-)
			- [Inserisci Dettagli Visita](#inserisci-dettagli-visita)
				- [InserisciDettagli](#inseriscidettagli)
			- [Notifica Prenotazione](#notifica-prenotazione)
		- [3.4.2 Modello degli oggetti](#342-modello-degli-oggetti)
			- [Lista delle classi](#lista-delle-classi)
			- [Diagramma delle entity](#diagramma-delle-entity)
			- [Diagramma delle classi](#diagramma-delle-classi)
		- [3.4.3 Modello dinamico](#343-modello-dinamico)
			- [Diagrammi delle sequenze](#diagrammi-delle-sequenze)
				- [Sequenza AutenticaPersonale](#sequenza-autenticapersonale)
				- [Sequenza AutenticaPaziente](#sequenza-autenticapaziente)
				- [Sequenza RegistraPaziente](#sequenza-registrapaziente)
				- [Sequenza IndividuaPaziente](#sequenza-individuapaziente)
				- [Sequenza InserisciDettagliRicetta](#sequenza-inseriscidettagliricetta)
				- [Sequenza ScegliRegimeVisita](#sequenza-scegliregimevisita)
				- [Sequenza PrenotaVisitaSSN](#sequenza-prenotavisitassn)
				- [Sequenza PrenotaVisitaALPI](#sequenza-prenotavisitaalpi)
				- [Sequenza ScegliPrenotazione](#sequenza-scegliprenotazione)
				- [Sequenza SpostaPrenotazione](#sequenza-spostaprenotazione)
				- [Sequenza EliminaPrenotazione](#sequenza-eliminaprenotazione)
				- [Sequenza ConfermaModifica](#sequenza-confermamodifica)
				- [Sequenza AutorizzazionePaziente](#sequenza-autorizzazionepaziente)
				- [Sequenza VisualizzaStoricoVisite](#sequenza-visualizzastoricovisite)
				- [Sequenza StampaCartellaClinica](#sequenza-stampacartellaclinica)
				- [Sequenza VisualizzaCartellaClinica](#sequenza-visualizzacartellaclinica)
				- [Sequenza InserisciDettagliVisita](#sequenza-inseriscidettaglivisita)
				- [Sequenza NotificaPrenotazione](#sequenza-notificaprenotazione)
		- [3.4.4 Interfaccia utente: navigazione e mock-up](#344-interfaccia-utente-navigazione-e-mock-up)
	- [4. Glossario](#4-glossario)

<!-- /TOC -->

---
# 1. Introduzione
## 1.1 Obiettivo del Sistema
Il sistema si propone di gestire l'intera offerta delle prenotazioni sanitarie con efficienza,strutturando razionalmente le procedure di accesso alle informazioni e supportando modalità di comunicazioni con gli utenti.

## 1.2 Scopo del sistema

Lo scopo del sistema è di fornire ai cittadini un servizio che migliori drasticamente l'esperienza di interfacciarsi con il sistema sanitario attraverso una reale informatizzazione ed automatizzazione dei processi. Questi ultimi, trazionalmente eseguiti da operatori, al fine di essere migliorati necessitano di una profonda digitalizzazione.  
La conseguenza della maggiore efficienza si traduce in significative riduzioni dei costi e nel miglioramento dell'esperienza del cittadino in senso lato.


## 1.4 Definizioni, acronimi, e abbreviazioni

Definizione/Acronimo  | 	Descrizione  
----------------------|------------  
ALPI  | Per _Attività Libero Professionista Intramoenia_ si intende l’attività che il personale aziendale, individualmente o in équipe, esercita fuori dell’impegno di servizio in regime ambulatoriale, ivi comprese le attività di diagnostica strumentale e di laboratorio, in favore e su libera scelta dell’assistito e con oneri a carico dello stesso. Tale attività è finalizzata a garantire l’espressione di una libera scelta dell’utente.  
CUP|  Il servizio del _Centro Unico di Prenotazioni_ effettua prenotazioni di visite ed esami specialistici in regime di Servizio Sanitario Nazionale con l'Impegnativa del Medico, oppure in regime di libera professione.  
FSE  | Il _Fascicolo Sanitario Elettronico_ è lo strumento attraverso il quale il cittadino può tracciare e consultare tutta la storia della propria vita sanitaria, condividendola con i professionisti sanitari per garantire un servizio più efficace ed efficiente.  
Personale Amministrativo	| Personale dell'ospedale impiegato allo sportello del CUP per permettere la fruizione dei servizi anche ai pazienti che non utilizzano direttamente il software
Personale Medico | Personale dell'ospedale, esperto in medicina, che si occupa della salute dei pazienti prevenendo, diagnosticando e curando le malattie. Può accedere alla loro cartella clinica personale.
Ricetta  | La ricetta medica è un documento, redatto da un medico abilitato, che consente al paziente di prenotare visite specialistiche, esami diagnostici e di poter ritirare o acquistare farmaci che richiedono una prestazione medica.
SSN  | Servizio Sanitario Nazionale  
Ticket  |   Il ticket sanitario è una quota di partecipazione diretta dei cittadini alla spesa pubblica come controprestazione per l'assistenza sanitaria fornita dallo Stato. Esiste inoltre un sistema di esenzioni per reddito, fasce di età e servizi considerati "salvavita".


## 1.5 Riferimenti
- [Sanità digitale - Agenzia per l'Italia digitale](https://www.agid.gov.it/it/piattaforme/sanita-digitale)  
- [Tarifari nazionale delle prestazioni del SSN](http://www.salute.gov.it/portale/temi/p2_6.jsp?id=3662&area=programmazioneSanitariaLea&menu=vuoto)  

# 2. Sistema corrente

# 3. Sistema proposto
## 3.1 Panoramica
## 3.2 Requisiti funzionali
## 3.3 Requisiti non funzionali
## 3.4 Modelli del sistema
### 3.4.1 Casi d'uso
#### Casi d'uso di alto livello.
![Casi d'uso generali](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Casi%20d'uso/Casi%20d'uso%20generali.png)

---
##### EffettuaAutenticazione
__Attori:__  _Paziente, PersonaleMedico, PersonaleAmministrativo_, DBMS  
__Precondizioni:__ `L'utente non si è ancora autenticato in questa sessione`  
__Flusso degli eventi:__
```
1. Il caso d'uso inizia quando l'utente avvia il software.
	2. Il sistema chiede di inserire un codice univoco di
	   indentificazione
3. Paziente inserisce il CF
   OPPURE
   PersonaleMedico o PersonaleAmministrativo inserisce il
   suo codice identificativo.
	4. Il sistema chiede al DBMS informazioni sull'utente individuato
	   in modo univoco dal dato inserito.
5. Il DBMS comunica al sistema che l'utente è presente nel database ed
   eventuali informazioni connesse.
	6. L'utente è presente nel database e il sistema richiede
	   l'inserimento di password.
7. L'utente inserisce la propria password.
	8. Il sistema controlla che la password inserita corrisponda a
	   quella nota, se non lo è chiede nuovamente di autenticarsi.
```  
__Flusso alternativo 1:__
```
5. Il DBMS comunica al sistema che Paziente non è presente nel database
	6. Il sistema presenta un form per far registrare Paziente.
7. L'utente compila il form.
 	8. Il sistema comunica al DBMS i dati del nuovo utente.
9. Il DBMS registra il nuovo paziente.
```
__Flusso alternativo 2:__
```
5. Il DBMS comunica al sistema che l'utente non è presente nel database
	6. PersonaleMedico o PersonaleAmministrativo non è
	   presente nel database, il sistema avvisa dell'errato
	   inserimento del codice e ne chiede il corretto
	   reinserimento.
```
__Postcondizioni:__  `Il sistema mostra la schermata principale`  
[_Vista dettagliata_](#effettua-autenticazione)

---
##### CreaPrenotazione
__Attori:__ _Paziente, PersonaleMedico, PersonaleAmministrativo_, DBMS  
__Precondizioni:__ `L'utente si trova nella schermata principale `  
__Flusso degli eventi:__
```
1. Il caso d'uso inizia quando l'attore principale seleziona
   l'opzione "Crea Prenotazione"
	2. Il sistema chiede all'utente di compilare un form
	   con i dati della ricetta.
3. L'utente inserisce il numero di ricetta, il codice di urgenza e
   la prestazione richiesta.
	4. Il sistema chiede con quale regime si voglia effettuare
	   la visita
5. L'utente seleziona "Servizio sanitario nazionale".
 	6. Il sistema chiede al DBMS, tenendo conto del codice di
 	    urgenza, quali giorni e orari sono disponibili.
7. Il DBMS comunica al sistema le informazioni richeiste.
	8. Il sistema mostra all'utente giorni e orari in cui è
	    possibile effettuare la prenotazione.
9. L'utente seleziona e conferma giorno e ora.
	10. Il sistema comunica la nuova prenotazione al DBMS e manda
	    una notifica di avvenuta prenotazione all'utente.
```  
__Flusso alternativo__:
```
5. L'utente seleziona "Intramoenia".
	4. Il sistema mostra l'elenco dei professionisti che eseguono
	   quel tipo di visite e il loro onorario.
5. L'utente seleziona il medico da cui vuole farsi visitare
 	6. Il sistema chiede al DBMS i giorni e gli orari in cui il
	    medico può effettuare visite.
7. Il DBMS comunica al sistema i dati richiesti.
	8. Il sistema chiede all'utente di scegliere giorno e ora tra
	    quelli in cui il medico è disponibile.
9. L'utente seleziona e conferma giorno e ora.
	10. Il sistema comunica la nuova prenotazione al DBMS e manda
	    una notifica di avvenuta prenotazione all'utente.
```
__Postcondizioni:__  `L'utente è nuovamente nella schermata principale`  
[_Vista dettagliata_](#crea-prenotazione)

---
##### ModificaPrenotazione
__Attori:__ _Paziente, PersonaleAmministrativo_, DBMS  
__Precondizioni:__ `Il sistema è nella schermata iniziale`  
__Flusso degli eventi:__
```
1. Il caso d'uso inizia quando Paziente o PersonaleAmministrativo
   seleziona l'opzione "Modifica Prenotazione" dalla schermata principale.
   	2. Il sistema chiede al DBMS l'elenco di tutte le prenotazioni
	   relative al paziente con data successiva a quella corrente
	   le relative informazioni.
3. Il DBMS comunica al sistema le prenotazioni richieste.
  	4. Il sistema fa scegliere all'utente la prenotazione da
	   modificare.
5. L'utente individua la prenotazione che desidera modificare.
	6. Il sistema mostra i dati relativi alla Prenotazione selezionata
7. L'utente modifica la data e l'ora scegliendo tra le opzioni proposte
   e conferma OPPURE elimina la Prenotazione.
	8. Il sistema richiede un ulteriore conferma riassumendo i
	   cambiamenti fatti.
9. L'utente conferma o annulla le modifiche.
	10. Se l'utente conferma le modifiche il sistema le comunica
	   al DBMS e invia al Paziente opportuno una notifica
```  
__Postcondizioni:__  `Il sistema mostra nuovamente la schermata principale`  
[_Vista dettagliata_](#modifica-prenotazione)

---
##### VisualizzaFSE
__Attori:__  _Paziente, PersonaleMedico, PersonaleAmministrativo_, DBMS  
__Precondizioni:__ `Il sistema è nella schermata principale`  
__Flusso degli eventi:__
```
1. Il caso d'uso inizia quando l'attore principale  seleziona l'opzione
   "Visualizza Storico Visite" relativamente ad un paziente.
	2. Il sistema chiede al DBMS i dati relativi a tutte le visite
	   precedentemente effettuate dal paziente.
3. Il DBMS comunica al sistema i dati.
	4. Il sistema restituisce un documento o una schermata con
	   delle informazioni sulle visite.
```  
__Postcondizioni:__  `Il sistema torna nella schermata principale`  
[_Vista dettagliata_](#visualizza-fse)

---
##### InserisciDettagliVisita
__Attori:__  _PersonaleMedico_, DBMS  
__Precondizioni:__ `Il sistema mostra la schermata principale`  
__Flusso degli eventi:__
```
1. Il caso d'uso inizia quando PersonaleMedico seleziona una delle visite
   della giornata.
	2. Il sistema mostra all'utente le eventuali informazioni
	   riguardanti la visita selezionata.
3. PersonaleMedico inserisce/modifica i dettagli della visita.
	4. Il sistema comunica eventualmente al DBMS le informazioni
	   aggiornate sulla visita.
```  
__Postcondizioni:__  `Il sistema torna alla schermata principale`  
[_Vista dettagliata_](#inserisci-dettagli-visita)

---
##### NotificaPrenotazione
__Attori:__  _Tempo_, DBMS  
__Precondizioni:__ `Nella giornata corrente non sono ancora state inviate le notifiche per le visite previste due giorni dopo`  
__Flusso degli eventi:__
```
1. Il caso d'uso inizia quando mancano meno di 48 ore alla prima visita di
   due giorni dopo.
	2. Il sistema chiede al DBMS l'elenco di tutti i pazienti che
	   hanno una visita tra due giorni e le informazioni relative ad
	   ogni visita.
3. Il DBMS restituisce al sistema le informazioni richieste
	4. Il sistema invia ad ogni paziente una notifica contenente le
	   informazioni relative alle sue prenotazioni.
```  
__Postcondizioni:__  `Tutti i pazienti con visite in programma dopo due giorni hanno ricevuto un promemoria`  
[_Vista dettagliata_](#notifica-prenotazione)

---
#### Effettua Autenticazione
![Use case "EffettuaAutenticazione"](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Casi%20d'uso/Effettua%20Autenticazione.png)
[_Vista di alto livello_](#effettuaautenticazione)

---
##### AutenticaPersonale
__Attori:__  _PersonaleMedico, PersonaleAmministrativo_, DBMS  
__Precondizioni:__ `L'utente non si è ancora autenticato in questa sessione`  
__Flusso degli eventi:__
```
1. Il caso d'uso inizia quando un utente avvia il software.
	2. Il sistema chiede all'utente di inserire il suo codice
	   identificativo.
3. L'utente inserisce il proprio codice identificativo e conferma.
	4. Il sistema chiede al DBMS informazioni sull'utente individuato
	   univocamente attraverso il codice.
5. Il DBMS comunica al sistema se l'utente è presente nel database ed
   eventuali informazioni connesse.
	6. Se l'utente non è presente nel database il sistema informa che
      il codice inserito è errato e chiede di reinserirlo.
	  ALTRIMENTI
	  Il sistema chiede all'utente di inserire la password.
7. L'utente inserisce e conferma la password.
	8. Il sistema controlla che la password inserita corrisponda a
	   quella nota, se non lo è chiede nuovamente di autenticarsi.
```  
__Postcondizioni:__  `Il sistema è nella schermata principale`  
[_Diagramma delle sequenze_](#sequenza-AutenticaPersonale)

---
##### AutenticaPaziente
__Attori:__  _Paziente_, DBMS  
__Precondizioni:__ `Paziente non si è ancora autenticato in questa sessione`  
__Flusso degli eventi:__
```
1. Il caso d'uso inizia quando Paziente avvia il software.
	2. Il sistema chiede a Paziente di inserire il suo codice
	   fiscale.
3. Paziente inserisce il proprio CF e conferma.
	4. Il sistema chiede al DBMS informazioni sul Paziente individuato
	   univocamente attraverso il codice.
5. Il DBMS comunica al sistema se il Paziente è presente nel database ed
   eventuali informazioni connesse.
	6. Se l'utente è presente nel database il sistema chiede
	   all'utente di inserire la password.
7. L'utente inserisce e conferma la password.
	8. Il sistema controlla che la password inserita corrisponda a
	   quella nota, se non lo è chiede nuovamente di autenticarsi.
```  
__Postcondizioni:__  `Il sistema è nella schermata principale`  
[_Diagramma delle sequenze_](#sequenza-autenticapaziente)

---
##### RegistraPaziente
__Attori:__ _PersonaleAmministrativo, Paziente_, DBMS  
__Precondizioni:__ `Nel sistema non è registrato nessun Paziente con il CF uguale a quello del paziente per cui si sta operando`  
__Flusso degli eventi:__
```
1. Il caso d'uso inizia quando durante un'autenticazione Paziente o
   PersonaleAmministrativo inserisce un CF che non corrisponde a nessun
   paziente nel database.
	2. Il sistema mostra un form per inserire i dati necessari
	   all'inserimento nel sistema
3. L'utente compila il modulo, eventualmente non riempiendo i campi
   facoltativi e invia i dati.
	4. Il sistema comunica i dati del nuovo paziente al DBMS.
```
__Postcondizioni:__  `L'utente può proseguire l'operazione che aveva iniziato`  
[_Diagramma delle sequenze_](#sequenza-registrapaziente)

---

#### Crea Prenotazione
![Use case "CreaPrenotazione"](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Casi%20d'uso/CreaPrenotazione.png)  
[_Vista di alto livello_](#creaprenotazione)

---
##### IndividuaPaziente
__Attori:__ _PersonaleAmministrativo_, DBMS
__Precondizioni:__ ` `
__Flusso degli eventi:__
```

```
__Postcondizioni:__ ` `
[_Diagramma delle sequenze_](#sequenza-IndividuaPaziente)

---
##### RegistraPaziente ¹  
[_¹Descrizione già presente qui_](#registrapaziente)  
[_Diagramma delle sequenze_](#sequenza-registrapaziente)  
---
##### InserisciDettagliRicetta
__Attori:__  _Paziente, PersonaleMedico, PersonaleAmministrativo_, DBMS  
__Precondizioni:__ `L'utente si trova nella schermata principale `  
__Flusso degli eventi:__
```
1. Il caso d'uso inizia quando l'attore principale seleziona
   l'opzione "Crea Prenotazione".
	2. Il sistema chiede all'utente di compilare un form
	   con i dati della ricetta.
3. L'utente inserisce il numero di ricetta, il codice di urgenza e
   la prestazione richiesta e conferma.
	4. Il sistema controlla la correttezza sintattica dei dati
	   inseriti.
	   Se non sono corretti lo notifica all'utente e chiede di
	   immettere dati corretti.
	   ALTRIMENTI
	   Chiede al DBMS il numero di prenotazioni con lo stesso
	   numero di ricetta per la stessa prestazione.
5. Il DBMS restituisce le informazioni richieste.
	6. Se esiste almeno una ricetta che soddisfa i parametri
	   il sistema notifica che quella prenotazione è già stata
	   effettuata e richiede di inserire i dati corretti.
```  
__Postcondizioni:__  `Il sistema ha immagazzinato le informazioni sulla prenotazione `  
[_Diagramma delle sequenze_](#sequenza-inseriscidettagliricetta)  

---
##### ScegliRegimeVisita
__Attori:__ _Paziente, PersonaleAmministrativo_    
__Precondizioni:__ `Il sistema ha immagazzinato i dettagli della ricetta `  
__Flusso degli eventi:__
```
1. Il caso d'uso inizia quando l'utente conferma i dati della ricetta
   senza errori.
	2. Il sistema chiede se si voglia prenotare in convenzione col
 	   SSN o in regime ALPI
3. L'utente seleziona su "Servizio sanitario nazionale" o
   "Attività di libera professione intramoenia"
```  
__Postcondizioni:__  `Il sistema ha registrato la scelta dell'utente `  
[_Diagramma delle sequenze_](#sequenza-scegliregimevisita)  

---
##### PrenotaVisitaSSN
__Attori:__ _Paziente, PersonaleAmministrativo, PersonaleMedico_ DBMS      
__Precondizioni:__ `È in corso una procedura di prenotazione con una ricetta valida`  
__Flusso degli eventi:__
```
1. Il caso d'uso inizia quando l'utente comunica al sistema di volere
   prenotare una visita in convenzione con il sistema sanitario nazionale.
	2. Il sistema, tenendo conto del codice di urgenza, chiede al DBMS
	   quali giorni e orari sono disponibili per la nuova prenotazione.  
3. Il DBMS comunica al sistema l'elenco degli orari disponibili.
	4. Il sistema propone al paziente le date disponibili per
	   effettuare la visita.
5. Il paziente sceglie tra le opzioni proposte e conferma la scelta.
	6. Il sistema comunica la nuova prenotazione al DBMS, e chiede
	   al DBMS il costo della prestazione e i documenti richiesti.
7. Il DBMS comunica le informazioni richieste.
	8. Il sistema invia una notifica di avvenuta prenotazione
	   all'utente, riportando il costo del ticket e i documenti
	   da portare.
```  
__Flusso alternativo:__
```
3. Il DBSM comunica che non ci sono orari disponibili
   4. Il sistema cerca un orario in cui è possibile effettuare
      la vista spostandone una meno urgente e lo propone al paziente.
5. Il paziente accetta la proposta del sistema
	6. Il sistema comunica la nuova prenotazione al DBMS e lo spostamento
	   della prenotazioni meno urgente, e chiede al DBMS il costo
	   della prestazione e i documenti richiesti.
7. Il DBMS comunica le informazioni richieste.
	8. Il sistema invia una notifica di avvenuta prenotazione
	   all'utente, riportando il costo del ticket e i documenti
	   da portare.
```
__Postcondizioni:__  `Il sistema torna alla schermata principale`  
[_Diagramma delle sequenze_](#sequenza-prenotavisitassn)  

---
##### PrenotaVisitaALPI
__Attori:__ _Paziente, PersonaleAmministrativo,_ DBMS      
__Precondizioni:__ `È in corso una procedura di prenotazione con una ricetta valida`  
__Flusso degli eventi:__
```
1. Il caso d'uso inizia quando l'utente comunica al sistema di volere
   prenotare una visita in regime intramoenia.
	2. Il sistema chiede al DBMS quali medici effettuano il tipo di
	   visita richiesto e il loro onorario.
3. Il DBMS trasmette al sistema i dati richiesti.
	4. Il sistema mostra la lista di medici all'utente chiedendo di
	   indicarne uno.
5. Il paziente seleziona il medico presso il quale vuole sottoporsi alla
   visita.
	6. Il sistema chiede al DBMS giorni e orari in cui il medico
	   selezionato non può effettuare ulteriori visite.
7. Il DBMS comunica al sistema l'elenco delle prenotazioni relative
   al medico scelto dall'utente.	 
	8. Il sistema chiede all'utente di scegliere giorno e ora tra
       quelli in cui il medico è disponibile.
9. L'utente seleziona e conferma giorno e ora.	   
	10. Il sistema comunica la nuova prenotazione al DBMS.
	11. Il sistema chiede al DBMS i documenti richiesti per la visita.
12. Il DBMS comunica le informazioni richieste.
	13. Il sistema invia una notifica di avvenuta prenotazione
	   all'utente, riportando i documenti
	   da portare.

```  
__Flusso alternativo:__
```
7. Il DBMS comunica che non ci sono orari disponibili
	8. Il sistema avvisa che non è possibile evadere la richiesta.
```
__Postcondizioni:__  `Il sistema torna alla schermata principale`  
[_Diagramma delle sequenze_](#sequenza-prenotavisitaalpi)

---

#### Modifica Prenotazione
![Use case "ModificaPrenotazione"](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Casi%20d'uso/ModificaPrenotazione.png)
[_Vista di alto livello_](#modificaprenotazione)

---
##### ScegliPrenotazione
__Attori:__  _Paziente_, DBMS  
__Precondizioni:__  `Paziente si trova nella schermata prinicpale`  
__Flusso degli eventi:__  
```
1. Il caso d'uso inizia quando Paziente seleziona l'opzione "Modifica
   Prenotazione" dalla schermata principale
	2. Il sistema chiede al DBMS l'elenco di tutte le prenotazioni
	   relative al paziente con data successiva a quella corrente
	   +24 ore e le relative informazioni.
3. Il DBMS comunica al sistema le prenotazioni richieste.
	4. Il sistema mostra all'utente la lista di prenotazioni
	   ottenuta, se la lista è vuota viene mostrato un messaggio
	   di errore.
5. L'attore che ha iniziato il caso d'uso seleziona la prenotazione
   che desidera modificare.
	6. Il sistema mostra i dati relativi alla Prenotazione selezionata
```
__Postcondizioni:__ `Paziente si trova nella schermata di modifica prenotazione`  
[_Diagramma delle sequenze_](#sequenza-scegliprenotazione)

---
##### SpostaPrenotazione  
__Attori:__ _PersonaleAmministrativo, Paziente_, DBMS  
__Precondizioni:__ `L'utente è nella schermata di modifica prenotazione`  
__Flusso degli eventi:__  
```
1. Il caso d'uso inizia quando l'utente seleziona l'opzione "Sposta
prenotazione".
	2. Il sistema chiede al DBMS le informazioni necessarie per
       fornire all'utente i giorni disponibili in cui spostare la
	   prenotazione.
3. Il DBMS restituisce le informazioni richieste.
	4. Il sistema mostra all'utente le opzioni disponibili per la
	   nuova data.
4. L'utente sceglie il giorno e l'ora tra quelli proposti.
	5. Il sistema da inizio al caso d'uso ConfermaModifica.
```
__Postcondizioni:__ `L'utente torna alla schermata principale`  
[_Diagramma delle sequenze_](#sequenza-spostaprenotazione)

---
##### EliminaPrenotazione
__Attori:__ _Paziente, PersonaleAmministrativo_  
__Precondizioni:__ `L'utente è nella schermata di modifica prenotazione`  
__Flusso degli eventi:__  
```
1. Il caso d'uso inizia quando l'utente seleziona l'opzione "Elimina
prenotazione"
	2. Il sistema predispone la cancellazione della prenotazione e
	   da inizio al caso d'uso ConfermaModifica.
```
__Postcondizioni:__ `L'utente torna alla schermata principale`  
[_Diagramma delle sequenze_](#sequenza-eliminaprenotazione)

---
##### ConfermaModifica
__Attori:__ _PersonaleAmministrativo, Paziente_, DBMS  
__Precondizioni:__ `L'utente ha apportato modifiche ad una prenotazione `  
__Flusso degli eventi:__  
```
	1. Il sistema riassume le modifiche effettuate dall'utente e
	   chiede di confermarle o annullarle.
2. L'utente conferma l'operazione.
	3. Il sistema comunica al DBMS la modifica.
4.Il DBMS attua le modifiche richieste.
	5. Il sistema manda all'utente una notifica per segnalare
	   l'avvenuta modifica.	   

```
__Flusso alternativo:__  
```
3. L'utente annulla l'operazione.
	4. Il sistema mostra all'utente un messaggio di avviso
	   annullamento.
```
__Postcondizioni:__ `L'utente è nuovamente nella schermata principale`  
[_Diagramma delle sequenze_](#sequenza-confermamodifica)

---

##### AutorizzazionePaziente
__Attori:__ _PersonaleAmministrativo,_ DBMS  
__Precondizioni:__ `PersonaleAmministrativo si trova nella schermata principale`  
__Flusso degli eventi:__
```
1. Il caso d'uso inizia quando PersonaleAmministrativo seleziona "Modifica
   Prenotazione".
	2. Il sistema chiede di inserire il CF del paziente la cui
	   prenotazione va modificata.
3. PersonaleAmministrativo inserisce il CF.
	4. Il sistema chiede al DBMS tutte le prenotazioni relative
	   al paziente.
5. Il DBMS restituisce tutte le prenotazioni relative al paziente.
	6. Se non ve ne sono il sistema comunica che non sono presenti
	   prenotazioni a nome del Paziente
	   ALTRIMENTI
	   Il sistema chiede di inserire il codice identificativo della
	   prenotazione
7. PersonaleAmministrativo inserisce il codice
	8. Se non c'è nessuna prenotazione corrispondente a quel codice
	   il sistema comunica un messaggio di errore
	   ALTRIMENTI
	   Il sistema autorizza l'operazione
```
__Postcondizioni:__ `PersonaleAmministrativo si trova nella schermata di modifica prenotazione`  
[_Diagramma delle sequenze_](#sequenza-autorizzazionepaziente)

---
#### Visualizza FSE
![Use case "VisualizzaFSE"](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Casi%20d'uso/VisualizzaFSE.png)  
[_Vista di alto livello_](#visualizzafse)

---
##### VisualizzaStoricoVisite
__Attori:__  _Paziente, PersonaleAmministrativo_, DBMS  
__Precondizioni:__ `L'utente si trova nella schermata principale`  
__Flusso degli eventi:__
```
1. Il caso d'uso inizia quando l'utente seleziona l'opzione "Visualizza
   storico visite"
	2. Il sistema chiede al DBMS tutte le visite già effettuate dal
	   paziente per cui si sta operando.
3. Il DBMS restituisce i dati richiesti.
	4. Il sistema mostra in una schermata l'elenco di tutte le
	   visite riportando tipo di visita, data e costo.
```  
__Postcondizioni:__  `L'utente è in grado di accedere correttamente al suo storico visite`  
[_Diagramma delle sequenze_](#sequenza-visualizzastoricovisite)

---
##### StampaCartellaClinica
__Attori:__  _PersonaleAmministrativo_, DBMS  
__Precondizioni:__ `L'utente ha visualizzato correttamente lo storico visite`  
__Flusso degli eventi:__
```
1. Il caso d'uso inizia quando l'utente seleziona l'opzione "Stampa FSE".
	2. Il sistema produce un file in formato PDF riportante i dati
	   anagrafici del paziente e l'elenco in ordine cronologico di
	   tutte le visite effettuate, specificando per ognuna data,
	   costo, tipo di visita, nome del medico che se ne è occupato
	   e le sue annotazioni.
```  
__Postcondizioni:__  `L'utente è in grado di stampare correttamente il documento FSE`  
[_Diagramma delle sequenze_](#sequenza-stampacartellaclinica)

---
##### VisualizzaCartellaClinica
__Attori:__  _PersonaleMedico_, DBMS  
__Precondizioni:__ `PersonaleMedico ha selezionato un paziente dalla schermata principale`  
__Flusso degli eventi:__
```
1. PersonaleMedico seleziona l'opzione "Visualizza Cartella Clinica"
	2. Il sistema chiede al DBMS le visite, comprese di tutte le
	   informazioni allegate, già effettuate dal paziente per cui
	   si sta operando.
3. Il DBMS restituisce i dati richiesti.
	4. Il sistema mostra una schermata riportante i dati anagrafici
	   del paziente e l'elenco in ordine cronologico di tutte le
	   visite effettuate, specificando per ognuna data, costo
	   tipo di visita,nome del medico che se ne è occupato e le
	   sue annotazioni.
```  
__Postcondizioni:__  `PersonaleMedico può visualizzare i dettagli sulle visite passate del paziente`  
[_Diagramma delle sequenze_](#sequenza-visualizzacartellaclinica)

---
##### IndividuaPaziente ²  
[_²Descrizione già presente qui_](#individuapaziente)  
[_Diagramma delle sequenze_](#sequenza-individuapaziente)  

---

#### Inserisci Dettagli Visita
![Use case "InserisciDettagliVisita"](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Casi%20d'uso/InserisciDettagliVisita.png)
[_Vista di alto livello_](#inseriscidettaglivisita)

---
##### InserisciDettagli
__Attori:__ _PersonaleMedico_, DBMS
__Precondizioni:__ `Il sistema mostra la schermata principale `
__Flusso degli eventi:__
```
1. Il caso d'uso inizia quando l'utente seleziona un paziente dalla
   schermata principale e clicca "Inserisci Dettagli Visita".
	2. Il sistema richiede al DBMS le eventuali informazioni relative
	   alla visita connessa al paziente precedentemente selezionato.
3. Il DBMS restituisce le informazioni richieste
  4. Il sistema mostra una schermata con box di testo modificabili
     contenenti le eventuali informazioni già presenti.
5. PersonaleMedico modifica/aggiunge informazioni e conferma le modifiche.
  6. Il sistema comunica al DBMS le informazioni aggiornate sulla visita.	  
```
__Postcondizioni:__ `Il sistema ritorna alla schermata principale`  
[_Diagramma delle sequenze_](#sequenza-inseriscidettaglivisita)

---

#### Notifica Prenotazione
![Use case "NotificaPrenotazione"](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Casi%20d'uso/NotificaPrenotazione.png)

---
### 3.4.2 Modello degli oggetti
#### Lista delle classi

Classe | Descrizione
-|-|
ConfermaDialog | Nelle operazioni di modifica di una prenotazione già effettuata questa schermata riassume le modifiche e consente di confermarle o annullarle.
ConfermaModificaControl |
EffettuaPrenotazioneControl |
ErroreDialog | Mostra a video all'utente che l'operazione da lui intrapresa non è andata a buon fine.
FormRicetta | Permette l'inserimento dei dati relativi alla ricetta.
FSEControl |
FSEDialog |
GeneraRicettaControl |
IndividuaPrenotazioneControl |
IndividuaPrenotazioneDialog | Questa schermata permette all'utente di visualizzare le prenotazioni modificabili e scegliere su quale agire.
InviaNotificaControl |
LoginControl |
MainScreen | La schermata principale, da questa si possono avviare le varie procedure.
ModificaPrenotazioneControl |
ModificaPrenotazioneDialog |
PasswordForm | Questa schermata presenta un box di testo in cui gli utenti possono inserire la propria password.
PazienteEntity | All'interno del sistema i dati dei pazienti sono racchiusi in questa classe.
PazienteLoginForm | Il form attraverso cui Paziente può inserire il proprio codice fiscale e proseguire le procedure di autenticazione.
PersonaleLoginForm | Il form attraverso cui PersonaleMedico e PersonaleAmministrativo possono inserire la propria matricola e proseguire le procedure di autenticazione.
Prenotazione | Questa classe contiene i dati rilevanti della prenotazione mentre viene elaborata dal sistema.
RegistrazioneForm | Il form che permette  di immettere i dati personali di un paziente la prima volta che questo utilizza i servizi di SPRINT.
RegistrazioneControl |
Ricetta |
ScegliOrarioDialog | Durante le operazioni di prenotazione attraverso questa schermata l'utente può selezionare data e ora della visita tra quelli proposti dal sistema.
ScegliPrenotazioneDialog | Questa schermata presenta l'elenco delle prenotazioni per visite ancora non effettuate dal paziente, da qui è possibile selezionarne una per modificarla.
ScegliRegimeDialog | Nelle operazioni di  prenotazione questa schermata consente di scegliere tra regime ALPI e regime SSN.
SceltaMedicoDialog | Nelle operazioni di prenotazione se si sceglie il regime ALPI questa schermata permette di scegliere il medico dal quale farsi visitare.


#### Diagramma delle entity
![Entity](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Diagrammi%20delle%20classi/Entity.png)
#### Diagramma delle classi
![Classi](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Diagrammi%20delle%20classi/Tutte%20le%20classi.png)
### 3.4.3 Modello dinamico
#### Diagrammi delle sequenze
---
##### Sequenza AutenticaPersonale
 ![AutenticaPersonale](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Diagrammi%20delle%20sequenze/AutenticaPersonale.png)
 [_Caso d'uso_](#autenticapersonale)

 ---
##### Sequenza AutenticaPaziente
 ![AutenticaPaziente](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Diagrammi%20delle%20sequenze/AutenticaPaziente.png)
 [_Caso d'uso_](#autenticapaziente)

 ---
##### Sequenza RegistraPaziente
 ![RegistraPaziente](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Diagrammi%20delle%20sequenze/RegistraPaziente.png)
 [_Caso d'uso_](#registrapaziente)

---
##### Sequenza IndividuaPaziente
![IndividuaPaziente](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Diagrammi%20delle%20sequenze/IndividuaPaziente.png)
[_Caso d'uso_](#individuapaziente)

---

##### Sequenza InserisciDettagliRicetta
![InserisciDettagliRicetta](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Diagrammi%20delle%20sequenze/InserisciDettagliRicetta.png)  
[_Caso d'uso_](#inseriscidettagliricetta)

 ---
##### Sequenza ScegliRegimeVisita
![InserisciDettagliRicetta](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Diagrammi%20delle%20sequenze/ScegliRegimeVisita.png)  
[_Caso d'uso_](#scegliregimevisita)

 ---
##### Sequenza PrenotaVisitaSSN
![InserisciDettagliRicetta](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Diagrammi%20delle%20sequenze/PrenotaVisitaSSN.png)  
[_Caso d'uso_](#prenotavisitassn)

 ---
##### Sequenza PrenotaVisitaALPI
![InserisciDettagliRicetta](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Diagrammi%20delle%20sequenze/PrenotaVisitaALPI.png)  
[_Caso d'uso_](#prenotavisitaalpi)

 ---
##### Sequenza ScegliPrenotazione
 ![ScegliPrenotazione](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Diagrammi%20delle%20sequenze/ScegliPrenotazione.png)
 [_Caso d'uso_](#scegliprenotazione)

 ---
##### Sequenza SpostaPrenotazione
 ![SpostaPrenotazione](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Diagrammi%20delle%20sequenze/SpostaPrenotazione.png)
 [_Caso d'uso_](#spostaprenotazione)

 ---
##### Sequenza EliminaPrenotazione
 ![EliminaPrenotazione](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Diagrammi%20delle%20sequenze/EliminaPrenotazione.png)
 [_Caso d'uso_](#eliminaprenotazione)

 ---
##### Sequenza ConfermaModifica
 ![ConfermaModifica](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Diagrammi%20delle%20sequenze/ConfermaModifica.png)
 [_Caso d'uso_](#confermamodifica)

 ---
##### Sequenza AutorizzazionePaziente
 ![AutorizzazionePaziente](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Diagrammi%20delle%20sequenze/AutorizzazionePaziente.png)
 [_Caso d'uso_](#autorizzazionepaziente)

 ---
##### Sequenza VisualizzaStoricoVisite
 ![VisualizzaStoricoVisite](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Diagrammi%20delle%20sequenze/VisualizzaStoricoVisite.png)
 [_Caso d'uso_](#visualizzastoricovisite)

 ---
##### Sequenza StampaCartellaClinica
 ![StampaCartellaClinica](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Diagrammi%20delle%20sequenze/StampaCartellaClinica.png)
 [_Caso d'uso_](#stampacartellaclinica)

 ---
##### Sequenza VisualizzaCartellaClinica
 ![VisualizzaCartellaClinica](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Diagrammi%20delle%20sequenze/VisualizzaCartellaClinica.png)
 [_Caso d'uso_](#visualizzacartellaclinica)

  ---
##### Sequenza InserisciDettagliVisita
 ![InserisciDettagliVisita](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Diagrammi%20delle%20sequenze/InserisciDettagliVisita.png)
 [_Caso d'uso_](#inseriscidettagli)

 ---
##### Sequenza NotificaPrenotazione
 ![NotificaPrenotazione](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Diagrammi%20delle%20sequenze/NotificaPrenotazione.png)
 [_Caso d'uso_](#notificaprenotazione)

 ---
### 3.4.4 Interfaccia utente: navigazione e mock-up
## 4. Glossario
