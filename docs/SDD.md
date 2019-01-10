# System Design Document

<!-- TOC depthFrom:1 depthTo:6 withLinks:1 updateOnSave:1 orderedList:0 -->

- [System Design Document](#system-design-document)
	- [1. Introduzione](#1-introduzione)
		- [1.1 Obbiettivi di progettazione](#12-obbiettivi-di-progettazione)
	- [2. Architettura software corrispondente](#2-architettura-software-corrispondente)
	- [3. Architettura software proposta](#3-architettura-software-proposta)
		- [3.1 Overview](#31-overview)
		- [3.2 Scomposizione in sottosistemi](#32-scomposizione-in-sottosistemi)
		- [3.3 Mappatura hardware/software](#33-mappatura-hardwaresoftware)
		- [3.4 Gestione dati persistenti](#34-gestione-dati-persistenti)
		- [3.5 Sicurezza e controllo degli accessi](#35-sicurezza-e-controllo-degli-accessi)
		- [3.6 Controllo globale del software](#36-controllo-globale-del-software)
		- [3.7 Condizioni di boundary](#37-condizioni-di-boundary)
	- [4. Servizi dei sottosistemi](#4-servizi-dei-sottosistemi)

<!-- /TOC -->

## 1. Introduzione

### 1.1 Obiettivi generali
Lo scopo del sistema proposto è quello di automatizzare le attività di gestione delle prenotazioni ospedaliere per aggevolare il cittadino e il personale nell'organizzazione delle operazioni desiderate.

### 1.2 Archittettura software corrente
Come già esplicato ampliamente nel documento RAD, si suppone non esista alcun software in grado di svolgere le operazioni complesse e automatiche proposte da questo sistema, precedentemente svolte quasi manualmente dagli impiegati.

### 1.3 Obiettivi di progettazione
- __Tempo di risposta__: il Sistema risponderà alle richieste impartite dall'utente in tempo reale, a meno che la pagina richiesta non sia particolarmente ricca di informazioni. In quest'ultimo caso potrà avvenire un ritardo di pochi secondi.  
- __Facilità di utilizzo__: l'utente effettuerà le proprie prenotazioni o modifiche di queste ultime in pochi e chiari passaggi.  
- __Memoria__: la dimensione della memoria è dinamica poichè dipendente dalla grandezza del DataBase.  
- __Estendibilità__: il sistema potrà essere esteso e modificato in futuro, secondo le nuove esigenze richieste, agendo sul codice.  
- __Affidabilità__: i risultati prodotti dalle pagine rispecchieranno istante per istante la situazione ospedaliera, in modo da permettere ai vari utenti di non incorrere ad errori di sistema e di organizzazione.  
- __Robustezza__: le interfacce ben definite comportano minima flessibilità per una minimizzazione di errori. L'inserimento dei dati verrà ogni volta verificato tramite svariati controlli.  
- __Disponibilità__: il sistema sarà disponibile ogni qual volta l'utente voglia utilizzarlo.  
- __Sicurezza__: i dati personali non verranno utilizzati a fini diversi dall'organizzazione ospedaliera, vigeranno le comuni regole di privacy. La sicurezza è garantita da login e password non criptate.  
- __Portabilità__: il sistema è portabile in diverse piattaforme, poichè realizzato in linguaggio Java.  
- __Leggibilità__: le funzionalità del sistema saranno facilmente comprensibili tramite la documentazione fornita, compresa di schemi intuibili e commenti al codice stilato.  
- __Utilità__: l'utente compierà facilmente le operazioni desiderate tramite un supporto continuo da parte del sistema.  
	  
## 2. Architettura software corrispondente
Poichè non è presente un sistema corrente da sostituire, si è preso in esame come riferimento il sistema descritto in [Implementing standards for the interoperability among healthcare providers in the public regionalized Healthcare Information System of the Lombardy Region, Barbarito et. al.](https://doi.org/10.1016/j.jbi.2012.01.006).  
![Fig. 4. System architecture for interoperability within hospital departments and its relationship with the regional information system.](https://ars.els-cdn.com/content/image/1-s2.0-S153204641200007X-gr4.jpg)  
Il sistema proposto prevede però un campo di applicazione molto più ridotto dovendo operare esclusivamente all'interno di un singolo ospedale per il supporto della gestione delle prenotazioni, sono state quindi prese in considerazione principalmente gli aspetti legati ai servizi di assistenza sanitaria digitale, in particolare il sistema di prenotazione degli esami e il PHR (Personal Health Record, corrispondente al Fascicolo Sanitario Elettronico preso in esame durante l'analisi dei requisiti), ma l'intero funzionamento del sistema è stato considerato come punto di partenza per la progettazione del sistema da sviluppare.
Inoltre dopo un'analisi costi-benefici è risultato che l'adozione di standard per l'interoperabilità quali HL7 fosse troppo onerosa per gli scopi proposti, risultando inoltre dal sistema di riferimento che è possibile implementare questa interoperabilità in un secondo momento senza stravolgere i sistemi informativi preesistenti.



## 3. Architettura software proposta
### 3.1 Overview
Per il sistema è stata scelta l'architettura a Layer, in modo tale da modellare l'interfacciamento dei sottosistemi descritti di sotto. Essa comporta la suddivisione di un insieme di livelli organizzati in modo tale da fornire specifici servizi in base al loro posizionamento. La gerarchia dei sottosistemi, inoltre, diminuisce la complessità.

### 3.2 Scomposizione in sottosistemi
Al fine di mostrare al meglio i sottosistemi e la loro funzionalità, sono stati utilizzati i component diagram di UML nel seguente modo:  

![?](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/System%20design/Architettura%20di%20sistema.png)    

Procediamo con la descrizione dettagliata dei sottosistemi dall'alto verso il basso e, quindi, dalla parte del sistema più vicina all'utente a quella più basale ed essenziale:  
- __UI__ >> _User Interface_, insieme di interfacce grafiche predisposte per l'interazione con l'utente.  
- __Application Logic__ >> include tutti gli oggetti control ed entity per eseguire, così, le funzionalità di un'applicazioni eseguendo 	                       elaborazioni dettagliate.  
- __Query Manager, DataBase Interaction, Data type conversion__ >> _DataBase Interface_ , gestisce le connessioni con il DataBase, rielaborando le risposte ricevute e le Query inviate.  
- __External components comunication, DBMS, MailServer__  >> gestisce i dati che sono necessari al funzionamento dell’intero sistema. Questi risiedono in un DataBase.  	  	
	
### 3.3 Mappatura hardware/software
La mappatura è stata effettuata sulla base del modello architetturale Repository, come illustrato in figura:

![?](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/System%20design/Mappatura.png)   

Come si può intuire sopra, sono presenti due nodi fondamentali:  
- ___UtentePC___  
- ___Server___  

Entrambi rappresentano dei _device_ fisici: il primo è un qualunque personal computer adibito all'installazione del sistema proposto, il secondo il _Server_ vero e proprio.  
  
_PersonaleAmministrativoApp, PersonaleMedicoApp e PazienteApp_ sono i nodi software contenenti tutte le componenti adibite alla gestione dei dati ospedalieri.  
_PAConnessioni, PMconnessioni_ e _PConnessioni_ sono le componenti destinate a gestire la connessione con il Server.   
  
_MySQLServer_ è un'istanza contenuta dal nodo _Server_ che gestirà i contenuti del _DataBase_. In base alle richieste dei nodi software, gestite tramite protocollo __TCP/IP__ e __JDBC__, _MySQL_ li fornirà e modificherà efficentemente.
 



### 3.4 Gestione dati persistenti
#### Progetto concettuale
![ERD](https://andrea-augello.github.io/SviluppoSW/media/Database/erd.png)  

#### Progetto logico  

![EERD](https://andrea-augello.github.io/SviluppoSW/media/Database/eerd.png)    

_Vincoli di Tupla_

- Ogni attributo delle varie classi sarà vincolato in dimensione e tipo. I vincoli sono espressi nel Progetto Logico mostrato sopra.  
- Non si potrà effettuare una _Prenotazione_ per un _Paziente_ ad un orario già previsto per altre _Prestazioni_ del medesimo.  
- Ogni indirizzo e-mail corrisponderà ad uno e un solo _Paziente_.  
- Non possono essere presenti più _Prenotazioni_ per la stessa _Prestazione_ all'interno della medesima _Ricetta_.  

### 3.5 Sicurezza e controllo degli accessi  

Per poter usufruire dei servizi proposti dal sistema è necessario eseguire un Login di autenticazione. A tal proposito, ogni utente creato sarà provvisto di password e vari identificativi caratterizzanti che potranno permettergli di accedere a varie aree del sistema. Alcune di queste ultime saranno esclusive ad alcune tipologie di utente. Le informazioni necessarie per tali operazioni risiedono in un DataBase.


### 3.6 Controllo globale del software
### 3.7 Condizioni di boundary
## 4. Servizi dei sottosistemi
