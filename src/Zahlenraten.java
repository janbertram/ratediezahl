import java.util.Random;

class Zahlenraten {
    boolean laufend;
    int zufallszahl;
    int versuche;
    SpielHelper spielHelper;
    Random random = new Random();

    Zahlenraten() {
        laufend = true;
        zufallszahl = random.nextInt(100) + 1;
        versuche = 0;
        spielHelper = new SpielHelper();
    }
    boolean istLaufend() {
        return laufend;
    }

    void printBeschreibung() {
        System.out.println("Zahlenraten");
        System.out.println("-----------\n");
        System.out.println("Errate eine vom Computer erstellte Zufallszahl im Bereich von 1 bis 100!");
    }

    void checkeNeuesSpiel() {
        if (spielHelper.gibUserZustimmung("Möchtest Du noch einmal spielen? (j/n)")) {
            zufallszahl = random.nextInt(99) + 1;
            versuche = 0;
        } else {
            laufend = false;
        }
    }

    void rate() {
        int gerateneZahl;
        boolean erraten = false;
        while (!erraten) {
            gerateneZahl = spielHelper.gibUserZahl("Rate eine Zahl:");
            versuche++;
            if  (liegtNichtImBereich(gerateneZahl)) {
                // nichts passiert
            } else {
                erraten = istErraten(gerateneZahl);
            }
        }
    }

    boolean liegtNichtImBereich(int eingegebeneZahl) {
        if (eingegebeneZahl < 1 || eingegebeneZahl > 100) {
            System.out.println("Die Zahl soll im Bereich von 1 bis 100 liegen!");
            System.out.println("Dieser Versuch wird als Fehlversuch gezählt.");
            return true;
        } else {
            return false;
        }
    }

    boolean istErraten(int gerateneZahl) {
        boolean erraten = false;
        if (gerateneZahl < zufallszahl) {
            System.out.println("Diese Zahl war zu klein!");
        } else if (gerateneZahl > zufallszahl) {
            System.out.println("Diese Zahl war zu groß!");
        } else {
            System.out.println("Diese Zahl war richtig!");
            System.out.println("Du hast " + versuche + " Versuche benötigt.");
            erraten = true;
        }
        return erraten;
    }

}