public class Start {

    public static void main(String[] args) {
        SpielHelper spielHelper = new SpielHelper();
        Zahlenraten spiel;
        if (spielHelper.gibUserZustimmung("Möchtest Du die Info-Variante des Zahlenratespiels spielen? (j/n)")) {
            spiel = new InfoZahlenraten();
        } else {
            spiel = new Zahlenraten();
        }
        spiel.printBeschreibung();
        while (spiel.istLaufend()) {
            spiel.rate();
            spiel.checkeNeuesSpiel();
        }
    }

}
