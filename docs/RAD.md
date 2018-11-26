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
		- [3.4.4 Interfaccia utente - navigazione e mock-up](#344-interfaccia-utente-navigazione-e-mock-up)
	- [4. Glossario](#4-glossario)

<!-- /TOC -->

---
# 1. Introduzione
## 1.1 Obiettivo del Sistema
## 1.2 Scopo del sistema
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
	2. Il sistema chiede di identificare il paziente per cui si
	   sta prenotando la visita.
3. PersonaleAmministrativo o Paziente inserisce in un box di testo
   il CF del paziente per cui si sta prenotando la visita
   OPPURE
   PersonaleMedico seleziona il paziente dalla lista delle visite
   del giorno.
	4. Il sistema chiede al DBMS i dati relativi a quel paziente.
5. Il DBMS comunica al sistema i dati.
	6. Il sistema chiede all'utente di compilare un form
	   con i dati della ricetta.
7. L'utente inserisce il numero di ricetta, il codice di urgenza e
   la prestazione richiesta.
	8. Il sistema chiede se si voglia prenotare in convenzione col
 	   SSN o in regime ALPI
9. L'utente mette una spunta su "Servizio sanitario nazionale" o su
   "Attività di libera professione intramoenia"
	10. Se l'utente seleziona SSN il sistema mostra il costo del
	    ticket.
 	11. Il sistema chiede al DBMS, tenendo conto del codice di
 	    urgenza, quali giorni e orari non sono disponibili.
12. Il DBMS comunica al sistema l'elenco delle prenotazioni.
	13. Il sistema mostra all'utente giorni e orari in cui è
	    possibile effettuare la prenotazione.
14. L'utente seleziona e conferma giorno e ora.
	15. Il sistema comunica la nuova prenotazione al DBMS.
	16. Il sistema manda una notifica di avvenuta prenotazione
	    all'utente.
```  
__Flusso alternativo__:
```
	9. Se l'utente seleziona ALPI il sistema mostra l'elenco dei
	   professionisti che eseguono quel tipo di visite e il loro
	   onorario.
10. L'utente seleziona il medico da cui vuole farsi visitare
 	11. Il sistema chiede al DBMS i giorni e gli orari in cui il
	    medico non può effettuare visite.
12. Il DBMS comunica al sistema l'elenco delle prenotazioni relative
    al medico scelto dall'utente.
	13. Il sistema chiede all'utente di scegliere giorno e ora tra
	    quelli in cui il medico è disponibile.
14. L'utente seleziona e conferma giorno e ora.
	15. Il sistema comunica la nuova prenotazione al DBMS.
	16. Il sistema manda una notifica di avvenuta prenotazione
	    all'utente.
```
__Postcondizioni:__  `L'utente è nuovamente nella schermata principale`  
[_Vista dettagliata_](#crea-prenotazione)

---
##### ModificaPrenotazione
__Attori:__ _Paziente, PersonaleAmministrativo_, DBMS  
__Precondizioni:__ ` `  
__Flusso degli eventi:__
```
1. Il caso d'uso inizia quando Paziente o PersonaleAmministrativo
   seleziona l'opzione "Modifica Prenotazione" dalla schermata
   principale.
	2. Il sistema mostra l'elenco di tutte le prenotazioni con
	   data successiva a quella corrente + 24 ore.
3. L'attore che ha iniziato il caso d'uso seleziona la prenotazione
   che desidera modificare.
	4. Il sistema mostra i dati relativi alla Prenotazione.
5. L'attore principale modifica la data e l'ora scegliendo tra
   quelle proposte OPPURE elimina la Prenotazione e conferma.
	6. Il sistema chiede un ulteriore conferma specificando le
	   differenze con la precedente prenotazione.
7. L'attore principale conferma o annulla le modifiche.
	8. Se l'utente conferma le modifiche il sistema le comunica
	   al DBMS e invia al Paziente a cui è collegata la
	   prenotazione una notifica, altrimenti mostra il messaggio
	   "Modifiche annullate"
```  
__Postcondizioni:__  `Il sistema mostra nuovamente la schermata principale`  
[_Vista dettagliata_](#modifica-prenotazione)

---
##### VisualizzaFSE
__Attori:__  _Paziente, PersonaleMedico, PersonaleAmministrativo_, DBMS  
__Precondizioni:__ ` `  
__Flusso degli eventi:__
```
1.
	2.
3.
```  
__Postcondizioni:__  ` `  
[_Vista dettagliata_](#visualizza-fse))

---
##### EffettuaAutenticazione
__Attori:__  _AttorePrincipale_, DBMS  
__Precondizioni:__ ` `  
__Flusso degli eventi:__
```
1.  
	2.
3.
```  
__Postcondizioni:__  ` `  
[_Vista dettagliata_](#effettua-autenticazione)

---
##### InserisciDettagliVisita
__Attori:__  _PersonaleMedico_, DBMS  
__Precondizioni:__ `Il sistema mostra la schermata principale`  
__Flusso degli eventi:__
```
1. Il caso d'uso inizia quando PersonaleMedico seleziona una delle visite
   della giornata.
	2. Il sistema mostra i dettagli già presenti.
3. PersonaleMedico insersce ulteriori dati.
4. PersonaleMedico conferma le modifiche effettuate.
	5. Il sistema comunica al DBMS le informazioni sulla visita
	   aggiornate.
```  
__Postcondizioni:__  `Il sistema mostra un messaggio di conferma delle modifiche `  
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
### 3.4.4 Interfaccia utente - navigazione e mock-up
## 4. Glossario
