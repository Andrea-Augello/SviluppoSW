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
### 1.1 Obbiettivi di progettazione
- Facilità di utilizzo;
- Affidabilità;
- Robustezza;
- Documentazione di qualità;

## 2. Architettura software corrispondente
[...] assenza sistema corrente, si è preso in esame come riferimento il sistema descritto in [Implementing standards for the interoperability among healthcare providers in the public regionalized Healthcare Information System of the Lombardy Region, Barbarito et. al.](https://doi.org/10.1016/j.jbi.2012.01.006).  
![Fig. 4. System architecture for interoperability within hospital departments and its relationship with the regional information system.](https://ars.els-cdn.com/content/image/1-s2.0-S153204641200007X-gr4.jpg)  
Il sistema proposto prevede però un campo di applicazione molto più ridotto dovendo operare esclusivamente all'interno di un singolo ospedale per il supporto della gestione delle prenotazioni, sono state quindi presi in considerazione principalmente gli aspetti legati ai servizi di assistenza sanitaria digitale, in particolare il sistema di prenotazione degli esami e il PHR (Personal Health Record, corrispondente al Fascicolo Sanitario Elettronico preso in esame durante l'analisi dei requisiti), ma l'intero funzionamento del sistema è stato considerato come punto di partenza per la progettazione del sistema da sviluppare.
Inoltre dopo un'analisi costi-benefici è risultato che l'adozione di standard per l'interoperabilità quali HL7 fosse troppo onerosa per gli scopi proposti, risultando inoltre dal sistema di riferimento che è possibile implementare questa interoperabilità in un secondo momento senza stravolgere i sistemi informativi preesistenti.



## 3. Architettura software proposta
### 3.1 Overview
### 3.2 Scomposizione in sottosistemi
![?](https://andrea-augello.github.io/SviluppoSW/media/Diagrammi/System%20design/Architettura%20di%20sistema.png)  
### 3.3 Mappatura hardware/software
### 3.4 Gestione dati persistenti
#### Progetto concettuale
![ERD](https://andrea-augello.github.io/SviluppoSW/media/Database/erd.png)  
#### Progetto logico
### 3.5 Sicurezza e controllo degli accessi
### 3.6 Controllo globale del software
### 3.7 Condizioni di boundary
## 4. Servizi dei sottosistemi
