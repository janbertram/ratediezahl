import java.util.Scanner;

class SpielHelper {
    int gibUserZahl(String prompt) {
        boolean verstanden = false;
        int zahl = -1;
        while (!verstanden) {
            System.out.println(prompt);
            String eingabe = new Scanner(System.in).nextLine();
            try {
                zahl = Integer.parseInt(eingabe);
                verstanden = true;
            } catch (NumberFormatException e) {
                System.out.println("Die Eingabe muss eine ganze Zahl sein!");
            }
        }
        return zahl;
    }

    boolean gibUserZustimmung(String prompt) {
        boolean verstanden = false;
        boolean zustimmung = false;
        while (!verstanden) {
            System.out.println(prompt);
            String eingabe = new Scanner(System.in).nextLine();
            if (eingabe.equalsIgnoreCase("j")) {
                zustimmung = true;
                verstanden = true;
            } else if (eingabe.equalsIgnoreCase("n")) {
                zustimmung = false;
                verstanden = true;
            } else {
                System.out.println("Die Eingabe wurde nicht verstanden.");
            }
        }
        return zustimmung;
    }

    boolean istPrimzahl(int zahl) {
        if (zahl <= 1) {
            return false;
        }
        boolean prim = true;
        for (int i=2; i<zahl; i++) {
            if (zahl % i == 0) {
                prim = false;
            }
        }
        return prim;
    }
}