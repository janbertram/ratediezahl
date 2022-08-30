public class InfoZahlenraten extends Zahlenraten {

    @Override
    void printBeschreibung() {
        super.printBeschreibung();
        System.out.println("Wenn Du eine Primzahl eingibst, wirst du darauf aufmerksam gemacht.");
    }

    @Override
    void rate() {
        int gerateneZahl;
        boolean erraten = false;
        while (!erraten) {
            gerateneZahl = spielHelper.gibUserZahl("Rate eine Zahl:");
            versuche++;
            if  (liegtNichtImBereich(gerateneZahl)) {
                // nichts passiert
            } else {
                if (spielHelper.istPrimzahl(gerateneZahl)) {
                    System.out.println("Das ist ja eine Primzahl!");
                }
                erraten = istErraten(gerateneZahl);
            }
        }
    }

}
