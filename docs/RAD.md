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
			- [Diagramma dei casi d'uso di alto livello.](#diagramma-dei-casi-duso-di-alto-livello)
			- [Descrizione dei casi d'uso di alto livello](#descrizione-dei-casi-duso-di-alto-livello)
				- [CreaPrenotazione](#creaprenotazione)
				- [ModificaPrenotazione](#modificaprenotazione)
				- [VisualizzaFSE](#visualizzafse)
				- [InserisciDettagliVisita](#inseriscidettaglivisita)
				- [NotificaPrenotazione](#notificaprenotazione)
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
Personale Amministrativo	| Permettono al paziente di effettuare le prenotazioni senza dovere utilizzare il computer
Personale Medico |    
Ricetta  |  
SSN  | Servizio Sanitario Nazionale  
Ticket  |   Il ticket sanitario è una quota di partecipazione diretta dei cittadini alla spesa pubblica come controprestazione per l'assistenza sanitaria fornita dallo Stato. Esiste inoltre un sistema di esenzioni per reddito, fasce di età e servizi considerati "salvavita".



## 1.5 Riferimenti

# 2. Sistema corrente

# 3. Sistema proposto
## 3.1 Panoramica
## 3.2 Requisiti funzionali
## 3.3 Requisiti non funzionali
## 3.4 Modelli del sistema
### 3.4.1 Casi d'uso
#### Diagramma dei casi d'uso di alto livello.
![Casi d'uso generali](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/Casi%20d'uso/Casi%20d'uso%20generali.png)
#### Descrizione dei casi d'uso di alto livello
---
##### CreaPrenotazione
__Attori:__ _Paziente, PersonaleMedico, PersonaleAmministrativo_, DBMS  
__Precondizioni:__ ` `  
__Flusso degli eventi:__ ``` ```  
__Postcondizioni:__  ` `

---
##### ModificaPrenotazione
__Attori:__ _Paziente, PersonaleAmministrativo_, DBMS  
__Precondizioni:__ ` `  
__Flusso degli eventi:__ ``` ```  
__Postcondizioni:__  ` `

---
##### VisualizzaFSE
__Attori:__  _Paziente, PersonaleMedico, PersonaleAmministrativo_, DBMS  
__Precondizioni:__ ` `  
__Flusso degli eventi:__ ``` ```  
__Postcondizioni:__  ` `

---
##### InserisciDettagliVisita
__Attori:__  _PersonaleMedico_, DBMS  
__Precondizioni:__ ` `  
__Flusso degli eventi:__
```
	1. Il caso d'uso inizia quando PersonaleMedico seleziona una delle visite della giornata.
 		2. Il sistema mostra i dettagli già presenti.
	3. PersonaleMedico insersce ulteriori dati.
	4. PersonaleMedico conferma le modifiche effettuate.
		5. Il sistema aggiorna le informazioni sulla visita.
```  
__Postcondizioni:__  ` `

---
##### NotificaPrenotazione
__Attori:__  _Tempo_, DBMS  
__Precondizioni:__ ` `  
__Flusso degli eventi:__ ``` ```  
__Postcondizioni:__  ` `

---
### 3.4.2 Modello degli oggetti
### 3.4.3 Modello dinamico
### 3.4.4 Interfaccia utente - navigazione e mock-up
## 4. Glossario
