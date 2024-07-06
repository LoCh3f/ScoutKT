# <p align="center">ScoutTKT</p>

<p align="center">
  <img src="https://github.com/LoCh3f/ScoutKT/blob/master/app/src/main/res/drawable/main_logo.jpg" alt="Logo del Progetto" width="300"/>
</p>

# ScoutKT - La Tua Guida nei Mercati di Cryptovalute

Benvenuti alla repository di **ScoutKT**! Siamo entusiasti di presentarvi la nostra app, sviluppata in Kotlin, per monitorare i mercati delle crypto valute.

## Indice

- [Introduzione](#introduzione)
- [Problema](#problema)
- [Soluzione](#soluzione)
- [Funzionalità Principali](#funzionalità-principali)
- [Tecnologia](#tecnologia)
- [Vantaggi Competitivi](#vantaggi-competitivi)
- [Chiamata all'Azione](#chiamata-allazione)
- [Domande e Risposte](#domande-e-risposte)
- [Istruzioni per l'Installazione](#istruzioni-per-linstallazione)
- [Contributi](#contributi)
- [Licenza](#licenza)

## Introduzione

ScoutKT è un'app che fornisce aggiornamenti in tempo reale su tutte le principali cryptovalute. È stata sviluppata per aiutare sia i principianti che gli esperti a monitorare i mercati delle cryptovalute in modo efficace e intuitivo.

## Problema

- Il mercato delle cryptovalute è altamente volatile e in continua evoluzione.
- Monitorare i prezzi e le tendenze può essere complicato e richiede tempo.
- Gli investitori necessitano di strumenti affidabili e in tempo reale per prendere decisioni informate.

## Soluzione

ScoutKT offre:
- Aggiornamenti in tempo reale su tutte le principali cryptovalute.
- Notifiche personalizzabili per avvisare l'utente delle variazioni di prezzo.
- Un'interfaccia user-friendly e intuitiva.

## Funzionalità Principali

- **Monitoraggio in tempo reale:** Prezzi aggiornati al secondo per oltre 1000 cryptovalute.
- **Alert personalizzabili:** Imposta notifiche per variazioni di prezzo, volumi di scambio e altre metriche chiave.(Work in progress)
- **Analisi di mercato:** Grafici e strumenti di analisi per comprendere le tendenze. (Beta)
- **Portafoglio virtuale:** Tieni traccia dei tuoi investimenti e delle performance del tuo portafoglio. (In arrivo prossimamente)

## Tecnologia

ScoutKT è sviluppata interamente in Kotlin, un linguaggio moderno e potente che garantisce prestazioni elevate e sicurezza. L'app è integrata con API di mercato per dati precisi e aggiornati e si basa su un'architettura robusta per garantire affidabilità e scalabilità.

## Vantaggi Competitivi

- Rapidità e precisione degli aggiornamenti.
- Facilità d'uso grazie a un'interfaccia intuitiva.

## Chiamata all'Azione
Scarica ScoutKT oggi stesso e inizia a monitorare i mercati di cryptovalute come un professionista!  
Disponibile prossimamente su Google Play.  

## Domande e Risposte

Grazie per il vostro interesse in ScoutKT! Se avete domande, sentitevi liberi di contattarci.

## Istruzioni per l'Installazione

1. Clonare la repository:
    ```bash
    git clone https://github.com/tuo-utente/scoutkt.git
    ```
2. Navigare nella cartella del progetto:
    ```bash
    cd scoutkt
    ```
3. Aprire il progetto con Android Studio.
4. Aggiungere le proprie api key gratuite per effettuare richieste a CoinMarketCup  \ScoutKT\app\src\main\java\com\example\scoutkt\data\remote\Key.kt
5. Registrati per ottenere la tua chiave gratuita https://coinmarketcap.com/api/pricing/ 
6. Costruire e eseguire l'app su un emulatore o un dispositivo fisico.

## Contributi

I contributi sono benvenuti! Per favore, seguite questi passaggi per contribuire:
1. Fork la repository.
2. Creare un branch per le vostre modifiche:
    ```bash
    git checkout -b feature/nome-feature
    ```
3. Fare commit delle vostre modifiche:
    ```bash
    git commit -m 'Aggiunta nuova feature'
    ```
4. Push del branch:
    ```bash
    git push origin feature/nome-feature
    ```
5. Aprire una Pull Request.
6. 
## API Utilizzate
### Third-Party Libraries
- **Yahoo Finance:** `libs.yahoo.finance`
- **Firebase BOM:** `platform(libs.firebase.bom)`
- **Firebase Analytics:** `libs.firebase.analytics`
- **Firebase Auth:** `libs.firebase.auth`
- **Gson:** `libs.gson`
- **Coil Compose:** `libs.coil.compose`
- **Coroutines:** `libs.coroutines`
- **Ktor Core:** `libs.io.ktor.core`
- **Ktor Logging:** `libs.io.ktor.logging`
- **Ktor Android:** `libs.io.ktor.android`
- **Kotlinx Serialization:** `libs.kotlinx.serialization`
- **Ktor Content:** `libs.io.ktor.content`
- **Ktor OkHttp:** `libs.io.ktor.okhttp`
- **Ktor Serialization:** `libs.io.ktor.serialization`
- **Ktor JSON:** `libs.io.ktor.json`
- **Ktor CIO:** `libs.io.ktor.cio`
- **Trading View API:** `libs.ycharts`

## Licenza

Questo progetto è sotto licenza MIT. Per maggiori dettagli, consultare il file [LICENSE](LICENSE).
