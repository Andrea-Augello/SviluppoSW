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
				- [CreaPrenotazione](#creaprenotazione)
				- [ModificaPrenotazione](#modificaprenotazione)
				- [VisualizzaFSE](#visualizzafse)
				- [EffettuaAutenticazione](#effettuaautenticazione)
				- [InserisciDettagliVisita](#inseriscidettaglivisita)
				- [NotificaPrenotazione](#notificaprenotazione)
			- [Crea Prenotazione](#crea-prenotazione)
			- [Modifica Prenotazione](#modifica-prenotazione)
			- [Visualizza FSE](#visualizza-fse)
			- [Effettua Autenticazione](#effettua-autenticazione)
			- [Inserisci Dettagli Visita](#inserisci-dettagli-visita)
			- [Notifica Prenotazione](#notifica-prenotazione)
		- [3.4.2 Modello degli oggetti](#342-modello-degli-oggetti)
		- [3.4.3 Modello dinamico](#343-modello-dinamico)
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
Personale Medico |    
Ricetta  |  
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
##### CreaPrenotazione
__Attori:__ _Paziente, PersonaleMedico, PersonaleAmministrativo_, DBMS  
__Precondizioni:__ `L'utente si trova nella schermata principale `  
__Flusso degli eventi:__
```
1. Il caso d'uso inizia quando l'attore principale seleziona
   l'opzione "Crea Prenotazione"
	2. Il sistema chiede al DBMS i dati relativi al paziente per il
	   quale si sta prenotando.
3. Il DBMS comunica al sistema i dati.
	4. Il sistema chiede all'utente di compilare un form
	   con i dati della ricetta.
5. L'utente inserisce il numero di ricetta, il codice di urgenza e
   la prestazione richiesta.
	6. Il sistema chiede se si voglia prenotare in convenzione col
 	   SSN o in regime ALPI
7. L'utente mette una spunta su "Servizio sanitario nazionale" o su
   "Attività di libera professione intramoenia"
	8. Se l'utente seleziona SSN il sistema mostra il costo del
	    ticket.
 	9. Il sistema chiede al DBMS, tenendo conto del codice di
 	    urgenza, quali giorni e orari non sono disponibili.
10. Il DBMS comunica al sistema l'elenco delle prenotazioni.
	11. Il sistema mostra all'utente giorni e orari in cui è
	    possibile effettuare la prenotazione.
12. L'utente seleziona e conferma giorno e ora.
	13. Il sistema comunica la nuova prenotazione al DBMS.
	14. Il sistema manda una notifica di avvenuta prenotazione
	    all'utente.
```  
__Flusso alternativo__:
```
	7. Se l'utente seleziona ALPI il sistema mostra l'elenco dei
	   professionisti che eseguono quel tipo di visite e il loro
	   onorario.
8. L'utente seleziona il medico da cui vuole farsi visitare
 	9. Il sistema chiede al DBMS i giorni e gli orari in cui il
	    medico non può effettuare visite.
10. Il DBMS comunica al sistema l'elenco delle prenotazioni relative
    al medico scelto dall'utente.
	11. Il sistema chiede all'utente di scegliere giorno e ora tra
	    quelli in cui il medico è disponibile.
12. L'utente seleziona e conferma giorno e ora.
	13. Il sistema comunica la nuova prenotazione al DBMS.
	14. Il sistema manda una notifica di avvenuta prenotazione
	    all'utente.
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
   seleziona l'opzione "Modifica Prenotazione" dalla schermata principale
	2. Il sistema chiede al DBMS l'elenco di tutte le prenotazioni
	   relative al paziente con data successiva a quella corrente
	   +24 ore e le relative informazioni.
3. Il DBSM comunica al sistema le prenotazioni richieste.
	4. Il sistema mostra all'utente la lista di prenotazioni
	   ottenuta.
5. L'attore che ha iniziato il caso d'uso seleziona la prenotazione
   che desidera modificare.
	6. Il sistema mostra i dati relativi alla Prenotazione selezionata.
7. L'attore principale modifica la data e l'ora scegliendo tra
   le opzioni proposte OPPURE elimina la Prenotazione e conferma.
	8. Il sistema richiede un ulteriore conferma specificando le
	   differenze con la precedente prenotazione.
9. L'attore principale conferma o annulla le modifiche.
	10. Se l'utente conferma le modifiche il sistema le comunica
	   al DBMS e invia al Paziente a cui è collegata la
	   prenotazione una notifica, altrimenti mostra il messaggio
	   "Modifiche annullate"
```  
__Postcondizioni:__  `Il sistema mostra nuovamente la schermata principale`  
[_Vista dettagliata_](#modifica-prenotazione)

---
##### VisualizzaFSE
__Attori:__  _Paziente, PersonaleMedico, PersonaleAmministrativo_, DBMS  
__Precondizioni:__ `Il sistema è nella schermata iniziale`  
__Flusso degli eventi:__
```
1. Il caso d'uso inizia quando l'attore principale  seleziona l'opzione
   "Visualizza FSE" relativamente ad un paziente.
	2. IL sistema chiede al DBMS i dati relativi a tutte le visite
	   precedentemente effettuate dal paziente.
3. Il DBMS comunica al sistema i dati.
	4. Il sistema restituisce un documento con le informazioni del
	   paziente e l'elenco in ordine cronologico delle visite
	   effettuate completo dei relativi dettagli rilevanti.
```  
__Postcondizioni:__  `L'utente è nuovamente nella schermata iniziale.`  
[_Vista dettagliata_](#visualizza-fse))

---
##### EffettuaAutenticazione
__Attori:__  _Paziente, PersonaleMedico, PersonaleAmministrativo_, DBMS  
__Precondizioni:__ `L'utente non si è ancora autenticato in questa sessione`  
__Flusso degli eventi:__
```
1. Il caso d'uso inizia quando un utente non autenticato cerca di
   eseguire una operazione.
	2. Il sistema chiede di inserire un codice univoco di indentificazione
3. Il Paziente o PersonaleAmministrativo inserisce il CF
   OPPURE
   PersonaleMedico inserisce il suo codice identificativo.
	4. Il sistema chiede al DBMS informazioni sull'utente individuato
	   in modo univoco dai dati inseriti.
5. Il DBMS comunica al sistema se l'utente è presente nel database ed
   eventuali informazioni connesse.
	6. Se l'utente è presente nel database il sistema richiede
	   l'inserimento di password.
           ALTRIMENTI
	   Se l'utente è Paziente o PersonaleAmministrativo il Sistema
	   richiede le ulteriori informazioni necessarie ad inserire nel
	   database il Paziente.
7. L'utente inserisce in un form i dati richiesti dal sistema.
	8. Il sistema controlla che la password inserita corrisponda a
	   quella nota, se non lo è chiede nuovamente di autenticarsi.
```  
__Flusso alternativo:__
```
  8. Il sistema comunica al DBMS i dati dell'utente.
9. Il DBMS registra il nuovo utente
```
__Postcondizioni:__  `L'utente prosegue l'operazione iniziata precedetemente `  
[_Vista dettagliata_](#effettua-autenticazione)

---
##### InserisciDettagliVisita
__Attori:__  _PersonaleMedico_, DBMS  
__Precondizioni:__ `Il sistema mostra la schermata principale`  
__Flusso degli eventi:__
```
1. Il caso d'uso inizia quando PersonaleMedico seleziona una delle visite
   della giornata.
	2. Il sistema mostra i dettagli già presenti sulla visita selezionata.
3. PersonaleMedico insersce ulteriori dati o modifica quelli presenti.
   Eventualmente conferma i cambiamenti.
	 4. Il sistema mostra a PersonaleMedico una schermata riassuntiva
	    delle modifiche effettuate.
5. PersonaleMedico conferma o annulla le modifiche effettuate.
	6. Se PersonaleMedico ha confermato il sistema comunica al
	   DBMS le informazioni aggiornate sulla visita.
7. Il DBMS aggiorna i dati riguardanti la visita immagazzinati.
 	8. Il sistema mostra un messaggio relativo all'esito dell'operazione.
```  
__Postcondizioni:__  `Il sistema torna alla schermata principale`  
[_Vista dettagliata_](#inserisci-dettagli-visita)

---
##### NotificaPrenotazione
__Attori:__  _Tempo_, DBMS  
__Precondizioni:__ ` `  
__Flusso degli eventi:__ ``` ```  
__Postcondizioni:__  ` `  
[_Vista dettagliata_](#inserisci-dettagli-visita)

---

#### Crea Prenotazione
![Use case "CreaPrenotazione"](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Casi%20d'uso/CreaPrenotazione.png)

### InserisciDettagliRicetta
__Attori:__  _Paziente, PersonaleMedico, PersonaleAmministrativo_, DBMS  
__Precondizioni:__ `L'utente si trova nella schermata principale `  
__Flusso degli eventi:__ 
```
1. Il caso d'uso inizia quando l'attore principale seleziona
   l'opzione "Crea Prenotazione". 
	2. Il sistema chiede all'utente di compilare un form
	   con i dati della ricetta.
3. L'utente inserisce il numero di ricetta, il codice di urgenza e
   la prestazione richiesta.
	4. Il sistema chiede al DBMS il numero di prenotazioni
	   con lo stesso numero di ricetta per la stessa prestazione.
5. Il DBMS restituisce le informazioni richieste.
	6. Se esiste almeno una ricetta che soddisfa i parametri
	   il sistema notifica che quella prenotazione è già stata 
	   effettuata e richiede di inserire i dati corretti,
	   ALTRIMENTI 
	   Il sistema chiede di confermare i dettagli inseriti.
```  
__Postcondizioni:__  `Il sistema ha immagazzinato le informazioni sulla prenotazione `  
[Diagramma delle sequenze](#)  

#### ScegliRegimeVisita
__Attori:__ _Paziente, PersonaleAmministrativo_    
__Precondizioni:__ `Il sistema ha immagazzinato i dettagli della ricetta `  
__Flusso degli eventi:__ 
```
1. Il caso d'uso inizia quando l'utente conferma i dati della ricetta .
	2. Il sistema chiede se si voglia prenotare in convenzione col
 	   SSN o in regime ALPI
3. L'utente seleziona su "Servizio sanitario nazionale" o 
   "Attività di libera professione intramoenia"
```  
__Postcondizioni:__  `Il sistema ha registrato la scelta dell'utente `  
[Diagramma delle sequenze](#)  

#### PrenotaVisitaSSN
__Attori:__ _Paziente, PersonaleAmministrativo, PersonaleMedico_ DBMS      
__Precondizioni:__ ` `  
__Flusso degli eventi:__ 
```
1. Il caso d'uso inizia
```  
__Postcondizioni:__  ` `  
[Diagramma delle sequenze](#)  

#### PrenotaVisitaALPI
__Attori:__ _Paziente, PersonaleAmministrativo,_ DBMS      
__Precondizioni:__ ` `  
__Flusso degli eventi:__ 
``` 
```  
__Postcondizioni:__  ` `  
[Diagramma delle sequenze](#)  
#### Modifica Prenotazione
![Use case "ModificaPrenotazione"](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Casi%20d'uso/ModificaPrenotazione.png)

#### Visualizza FSE
![Use case "VisualizzaFSE"](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Casi%20d'uso/VisualizzaFSE.png)

#### Effettua Autenticazione
![Use case "EffettuaAutenticazione"](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Casi%20d'uso/EffettuaAutenticazione.png)

#### Inserisci Dettagli Visita
![Use case "InserisciDettagliVisita"](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Casi%20d'uso/InserisciDettagliVisita.png)

#### Notifica Prenotazione
![Use case "NotificaPrenotazione"](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Casi%20d'uso/NotificaPrenotazione.png)

### 3.4.2 Modello degli oggetti
### 3.4.3 Modello dinamico
### 3.4.4 Interfaccia utente: navigazione e mock-up
## 4. Glossario
