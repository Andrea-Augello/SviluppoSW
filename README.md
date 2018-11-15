---
title: Sviluppo del Software
--- 

**Tema di Progetto**

**Corso:**

**Basi di Dati e Progettazione del Software
(a.a 2018/19)**

Si richiede la progettazione di un sistema per il supporto a tutte le attività di gestione delle
prenotazioni sanitarie all’interno di un grande ospedale. Le specifiche di seguito espresse sono da
considerarsi come minime per la tesina in oggetto e possono essere estese dallo studente
qualora questo non violi la natura e l’intento del sistema richiesto. Lo studente, durante la stesura
del progetto, deve dimostrare capacità di interazione con il committente al fine di estendere o
integrare, se necessario, le specifiche riportate di seguito.
## Descrizione generale del sistema
Si richiede di progettare e sviluppare un software di gestione di un ospedale di grandi
dimensione per la parte che riguarda la prenotazione delle prestazioni sanitarie.

L’ospedale è diviso in reparti ed ambulatori ed ognuno di questi fornisce prestazioni sanitarie con
orari dipendenti dalla politica del reparto.

Il software deve permettere all’utente che vuole prenotare una prestazione di effettuare una
richiesta in base ai dati riportati in ricetta ed al personale medico ed amministrativo di gestire od
elaborare la richiesta qualora necessario.

L’utente deve poter prenotare la prestazione dopo aver visionato un calendario delle disponibilità
che tiene conto della priorità inserita nella ricetta (diagnosi, priorità e numero di ricetta). Il sistema
deve tenere conto che fino ad un giorno prima può essere richiesta una prestazione in urgenza ed
in questo caso deve essere possibile erogarla anche spostandone altre. All’atto della
prenotazione l’utente viene informato sulla eventuale documentazione da portare alla visita e gli
viene confermata la prestazione tramite email o sms. All’utente viene inviata una mail o sms di
remind 24 ore prima dell’esame in modo che in caso di rinuncia lo slot orario possa esser liberato,
nella mail (o messaggio) viene ricordata la lista dei documenti da portare.

Il sistema deve tenere in considerazione le prestazioni che sono dipendenti da altre (per esempio,
prima visita ortopedica colonna vertebrale potrebbe essere necessario portare delle lastre ed in
tal caso il sistema deve gestire le prenotazioni in sequenza). Anche il personale medico deve
essere in grado di prenotare una prestazione o un ricovero qualora questo fosse necessario a
valle di una visita e deve memorizzare nel sistema tutti i dati relativi alla visita per potere essere
consultati alle visite successive o anche da altri reparti durante visite di natura differente.

L’utente può controllare lo storico delle sue visite e stampare in ogni momento la cartella clinica a
fronte del pagamento di una determinata cifra (il pagamento non deve essere gestito).

_Parte opzionale: gestione dei pagamenti e delle ricevute._
## To do list:
- [x] Scoprire cosa si deve fare.
- [ ] Progetto concettuale database.
- [ ] Progetto logico database.
- [ ] Casi d'uso.
- [ ] Diagramma delle classi.
- [ ] Diagramma delle interazioni.
- [ ] *...*
- [ ] **Mandare mail e SMS con java**.
- [ ] Implementazione.
