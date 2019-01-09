# Object Design Document

<!-- TOC depthFrom:1 depthTo:6 withLinks:1 updateOnSave:1 orderedList:0 -->

- [Object Design Document](#object-design-document)
	- [1. Introduzione](#1-introduzione)
		- [1.1 Trade-off della progettazione degli oggetti](#11-trade-off-della-progettazione-degli-oggetti)
		- [1.2 Linee guida della documentazione delle interfacce](#12-linee-guida-della-documentazione-delle-interfacce)
	- [2. Packages](#2-packages)
		- [2.1 CreaPrenotazione](#21-crea-prenotazione)
	- [3. Interfacce delle classi](#3-interfacce-delle-classi)

<!-- /TOC -->

## 1. Introduzione

### 1.1 Trade-off della progettazione degli oggetti
- __Prestazioni vs Costi :__  
Il sistema realizzato con un budget ristretto ha permesso la realizzazione di un prodotto creato a partire da materiali open source, minimizzando i costi ma comunque al contempo permettendo di realizzare un sistema molto soddisfacente.  
  
- __Interfaccia vs Facilità d'utilizzo :__  
Le interfacce utilizzate per il software, grazie all'utilizzo di form e di un layout semplice e minimale, permettono la migliore interazione possibile anche con un utente meno esperto nel campo informatico. Il tutto è facilitato da una semplice gestione del database.  
  
- __Interfaccia vs Tempo di risposta :__  
I tempi di risposta tra server e interfaccia sono molto rapidi e soddisfano a pieno le esigenze del sistema. Naturalmente all'aumentare della dimensione del Database aumentano anche i corrispettivi tempi di risposta e di ricerca nello stesso.  
  
- __Costi vs Manutenzione :__  
Avendo utilizzato materiali opensource e come linguaggio di programmazione Java, il sistema può essere modificato, implementato con nuove funzioni o eventualmente corretto in maniera del tutto facile e intuitiva.  
  
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


## 3. Interfacce delle classi
