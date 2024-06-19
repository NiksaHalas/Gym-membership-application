# Aplikacija za članstvo u teretani

Aplikacija za članstvo u teretani je web aplikacija koja omogućava upravljanje informacijama o članovima teretane, uplatama i planovima treninga. Projekat je razvijen korišćenjem Jave, JavaScript-a, HTML-a, CSS-a i MySQL baze podataka.

## Sadržaj

- [Opis Projekta](#opis-projekta)
- [Tehnologije](#tehnologije)
- [Funkcionalnosti](#funkcionalnosti)
- [Instalacija](#instalacija)
- [Upotreba](#upotreba)


## Opis Projekta

Aplikacija za članstvo u teretani omogućava administratorima teretane da upravljaju članovima, njihovim uplatama i planovima treninga. Aplikacija pruža korisnički interfejs za pregled, dodavanje, izmenu i brisanje članova, kao i za upravljanje uplatama i dodeljivanje planova treninga.

## Tehnologije

- **Backend:** Java (Spring Boot)
- **Frontend:** HTML, CSS, JavaScript
- **Baza podataka:** MySQL
- **Biblioteke i alati:** Bootstrap, FontAwesome

## Funkcionalnosti

1. **Upravljanje članovima**
   - Lista članova
   - Dodavanje članova
   - Izmena članova
   - Brisanje članova
   - Pretraga članova
   - Praćenje isteka članarine

2. **Upravljanje uplatama**
   - Pregled uplata
   - Dodavanje uplata
   - Izmena uplata
   - Brisanje uplata

3. **Upravljanje planovima**
   - Pregled planova
   - Dodavanje planova
   - Izmena planova
   - Brisanje planova

4. **Dodeljivanje planova članovima**

## Instalacija

1. **Kloniranje repozitorijuma**

    ```bash
    git clone https://github.com/your-username/programski-jezici-ispit-2024.git
    cd programski-jezici-ispit-2024
    ```

2. **Podešavanje backend-a**

    - Uverite se da imate instaliran JDK i Maven.
    - Importujte projekat u vaš IDE (preporučuje se IntelliJ IDEA).
    - Konfigurišite MySQL bazu podataka prema `application.properties` fajlu.
    - Pokrenite Spring Boot aplikaciju.

3. **Podešavanje frontend-a**

    - Otvorite frontend folder u vašem omiljenom editoru.
    - Uverite se da imate instaliran `Node.js`.
    - Pokrenite lokalni server za frontend.

4. **Povezivanje frontend-a i backend-a**

    - Uverite se da su oba servera (backend i frontend) pokrenuta.
    - Proverite `fetch` pozive u JavaScript fajlovima da koriste odgovarajući URL za backend API.

## Upotreba

- Otvorite web pregledač i idite na `http://localhost:3000` (ili port koji koristi vaš frontend server).
- Koristite aplikaciju za upravljanje članovima, uplatama i planovima.



