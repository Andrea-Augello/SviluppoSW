# System Design Document

<!-- TOC depthFrom:1 depthTo:6 withLinks:1 updateOnSave:1 orderedList:0 -->

- [System Design Document](#system-design-document)
	- [1. Introduzione](#1-introduzione)
		- [1.1 Obiettivi generali](#11-obiettivi-generali)
		- [1.2 Archittettura software corrente](#12-archittettura-software-corrente)
		- [1.3 Obiettivi di progettazione](#13-obiettivi-di-progettazione)
	- [2. Architettura software corrispondente](#2-architettura-software-corrispondente)
	- [3. Architettura software proposta](#3-architettura-software-proposta)
		- [3.1 Overview](#31-overview)
		- [3.2 Scomposizione in sottosistemi](#32-scomposizione-in-sottosistemi)
		- [3.3 Mappatura hardware/software](#33-mappatura-hardwaresoftware)
		- [3.4 Gestione dati persistenti](#34-gestione-dati-persistenti)
			- [Progetto concettuale](#progetto-concettuale)
			- [Progetto logico](#progetto-logico)
		- [3.5 Sicurezza e controllo degli accessi](#35-sicurezza-e-controllo-degli-accessi)
		- [3.6 Condizioni di boundary](#36-condizioni-di-boundary)
	- [3.7 Flusso controllo globale](#37-flusso-controllo-globale)

<!-- /TOC -->

## 1. Introduzione

### 1.1 Obiettivi generali
Lo scopo del sistema proposto è quello di automatizzare le attività di gestione delle prenotazioni ospedaliere per aggevolare il cittadino e il personale nell'organizzazione delle operazioni desiderate.

### 1.2 Archittettura software corrente
Come già esplicato ampliamente in fase di analisi dei requisiti, si suppone che all'interno dell'ospedale non  venga utilizzato alcun software in grado di svolgere le operazioni complesse e automatiche proposte da questo sistema, che sono al momento svolte manualmente dagli impiegati.

### 1.3 Obiettivi di progettazione
- __Tempo di risposta__: il Sistema risponderà alle richieste impartite dall'utente in tempo reale, a meno che la pagina richiesta non sia particolarmente ricca di informazioni. In quest'ultimo caso potrà avvenire un ritardo di pochi secondi.  
- __Facilità di utilizzo__: l'utente effettuerà le proprie prenotazioni o modifiche di queste ultime nel minor numero possibile di passaggi.  
- __Memoria__: Database escluso il sistema deve occupare uno spazio su disco inferiore ai 100 MB.  
- __Estendibilità__: il sistema potrà essere esteso e modificato in futuro, secondo le nuove esigenze richieste, agendo sul codice.  
- __Affidabilità__: i risultati prodotti dalle pagine rispecchieranno istante per istante la situazione ospedaliera, in modo da permettere ai vari utenti di non incorrere in errori di sistema e di organizzazione.  
- __Robustezza__: il sistema tramite dei controlli deve impedire l'inserimento da parte degli utenti di input non validi.  
- __Disponibilità__: il sistema sarà disponibile ogni qual volta l'utente voglia utilizzarlo.  
- __Sicurezza__: i dati personali non verranno utilizzati a fini diversi dall'organizzazione ospedaliera, vigeranno gli standard dell'industria nel campo della protezione dei dati. La sicurezza è garantita da login e password.  
- __Portabilità__: il sistema è portabile in diverse piattaforme, in quanto realizzato in linguaggio Java.  

## 2. Architettura software corrispondente
Poichè non è presente un sistema corrente da sostituire, si è preso in esame come riferimento il sistema descritto in [Implementing standards for the interoperability among healthcare providers in the public regionalized Healthcare Information System of the Lombardy Region, Barbarito et. al.](https://doi.org/10.1016/j.jbi.2012.01.006).  
![Fig. 4. System architecture for interoperability within hospital departments and its relationship with the regional information system.](https://ars.els-cdn.com/content/image/1-s2.0-S153204641200007X-gr4.jpg)  
Il sistema proposto prevede però un campo di applicazione molto più ridotto dovendo operare esclusivamente all'interno di un singolo ospedale per il supporto della gestione delle prenotazioni, sono state quindi prese in considerazione principalmente gli aspetti legati ai servizi di assistenza sanitaria digitale, in particolare il sistema di prenotazione degli esami e il PHR (Personal Health Record, corrispondente al Fascicolo Sanitario Elettronico preso in esame durante l'analisi dei requisiti), ma l'intero funzionamento del sistema è stato considerato come punto di partenza per la progettazione del sistema da sviluppare.
Inoltre dopo un'analisi costi-benefici è risultato che l'adozione di standard per l'interoperabilità quali HL7 fosse troppo onerosa per gli scopi proposti, risultando inoltre dal sistema di riferimento che è possibile implementare questa interoperabilità in un secondo momento senza stravolgere i sistemi informativi preesistenti.



## 3. Architettura software proposta
### 3.1 Overview
Per il sistema è stata scelta un'architettura a layer. Essa comporta la suddivisione di un insieme di livelli organizzati in modo tale da fornire specifici servizi in base al loro posizionamento. La gerarchia dei sottosistemi, inoltre, diminuisce la complessità.

### 3.2 Scomposizione in sottosistemi
Al fine di mostrare al meglio i sottosistemi e la loro funzionalità, sono stati utilizzati i component diagram di UML nel seguente modo:  

![?](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/System%20design/Architettura%20di%20sistema.png)    

Procediamo con la descrizione dettagliata dei sottosistemi dall'alto verso il basso e, quindi, dalla parte del sistema più vicina all'utente a quella più basale ed essenziale:  
- __User Interface__ >> Insieme di interfacce grafiche predisposte per permettere all'utente di interagire con il sistema.  
- __Funzionalità__ >>  Vista la complessità questo sottosistema è stato a sua volta scomposto in sottosistemi a basso coupling, ognuno di questi gestisce la logica di funzionamento di uno dei casi d'uso di alto livello individuati in fase di analisi dei requisiti.  
- __Invio notifiche__  >>  Gestisce la connessione con il server mail, si occupa anche di ottenere le informazioni necessarie a generare i messaggi da inviare tramite posta elettronica ai pazienti.
- __Recupero e modifica delle informazioni__ >> Gestisce le connessioni con il DataBase, si occupa anche della conversione tra il formato in cui i dati sono rappresentati nel database e le entity nel sistema.  


In fase di progettazione si è deciso di creare una nuova classe appartenente al sottosistema "Recupero e modifica delle informazioni" alla quale assegnare le operazioni che, nei diagrammi delle sequenza in analisi dei requisiti, risultavano essere messaggi mandati al DBSM.  
Questa classe di fatto sostituirà il DBSM in tutte le interazioni con il sistema, per completezza si riporta la classe insieme ai suoi metodi.  
![DatabaseInterface](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/System%20design/DatabaseInterface.png)

### 3.3 Mappatura hardware/software
Nella mappatura si è deciso di concentrare la complessità del sistema sui calcolatori degli utenti per permettere una migliore scalabilità.

![Deployment_diagram](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/System%20design/Mappatura.png)   

Come si evince dal precedente  diagramma di deployment, sono presenti due nodi fondamentali:  
- ___PC utente___  
- ___Server___  

Entrambi rappresentano dei _device_ fisici: il primo è un qualunque personal computer adibito all'installazione del sistema proposto, il secondo il _Server_ (o i server).  

_SPRINT-paziente, SPRINT-medico e SPRINT-amministrativo_ sono i nodi software contenenti i layer di interfaccia utente, funzionalità e connessioni a database e mail server, questi nodi sono installabili ed utilizzabili su qualunque calcolatore in cui sia presente una Java Virtual Machine.  

Nel nodo _Server_, oltre al nodo software adibito all'invio di notifiche promemoria (_SPRINT-server_), sono presenti anche un'istanza di _MySQL Server_, che gestirà i contenuti del _DataBase_, e di _SMTP Server_, che gestirà l'invio dei messaggi di posta elettronica in base alle richieste dei nodi software.
Le richieste dei nodi software sono gestite tramite protocollo __TCP/IP__ e, a livello applicativo rispettivamente tramite __JDBC__ ed __SMTP__.   


### 3.4 Gestione dati persistenti
#### Progetto concettuale
Diagramma entità-relazione:  
![ERD](https://andrea-augello.github.io/SviluppoSW/media/Database/erd.png)  

_Vincoli di Tupla_

- Ogni attributo delle varie classi sarà vincolato in dimensione e tipo. I vincoli sono espressi nel successivo Progetto Logico.  
- Non si potrà effettuare una _Prenotazione_ per un _Paziente_ ad un orario già previsto per altre _Prestazioni_ del medesimo.  
- Ogni password dovrà contenere almeno 8 caratteri.
- Una _Prenotazione_ può essere associata ad una _Fascia Oraria_ solo se c'è un _Medico_ che _esercita_ in quella _fascia oraria_ in grado di _erogare_ quella _prestazione_.
- Non possono essere presenti più _Prenotazioni_ per la stessa _Prestazione_ all'interno della medesima _Ricetta_.  

#### Progetto logico  

![EERD](https://andrea-augello.github.io/SviluppoSW/media/Database/eerd.png)    

### 3.5 Sicurezza e controllo degli accessi  


Vista la natura sensibile dei dati gestiti dal sistema, per poter usufruire dei servizi proposti è necessario eseguire una procedura di autenticazione. Per tale scopo, ogni utente sarà provvisto di una password e vari identificativi caratterizzanti che potranno permettergli di accedere alle diverse aree del sistema. Alcune funzionalità del sistema, inoltre, saranno accessibili esclusivamente per determinate tipologie di utente.  

### 3.6 Condizioni di boundary  

_Accensione_  
Dal momento in cui il sistema verrà avviato per la prima volta, il server rimarrà attivo per tutte le ventiquattro ore giornaliere, senza mai terminare.  
Il software usato degli utenti, all'avvio, richiederà sempre di effettuare l'autenticazione e mostrerà la schermata principale soltanto dopo che questa verrà completata con successo.

_Spegnimento_  
Il Server non terminerà la sua esecuzione a meno che non vi siano dei guasti.  
Il software usato dagli utenti, invece, cesserà la sua esecuzione quando verrà chiuso il sistema da PC con successivo rilascio di eventuali variabili temporanee.  

_Fallimento_  
Il sistema lato Server fallirà in caso di problemi hardware, attacchi esterni o mancanza di elettricità. Stessa cosa potrà dirsi per il sistema da parte client, a meno che non si usino dispositivi non cablati.  


## 3.7 Flusso controllo globale  
Quando un utente si logga, vi è un accesso al __DataBase__, tramite una _Query_, che permette di controllare l'esistenza del soggetto. Dopo la conferma, l'utente potrà accedere a diverse operazioni messe a disposizione dal sistema, accessibili tramite un'interfaccia grafica.   
Il controllo del flusso viene attuato principalmente dal __Server MySQL__ che si occupa di gestire gli accessi concorrenti da parte di più utenti. Ad esempio, durante la prenotazione di una visita intramoenia, al momento della conferma del Medico e dell'orario, __MySQL__ entra in una sezione critica gestendo la concorrenza ed evitando che più utenti scelgano le stesse caratteristiche di Prenotazione.
