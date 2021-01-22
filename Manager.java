package w08;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Manager {
    private final int MAX_WOHNUNG = 10;
    public List<Wohnung> wohnungen = new ArrayList<>();
    private final double MAX_MONATSBEITRAG = 500.00;

    public Manager() {

        wohnungenGenerieren();

        // für alle Wohnungen Monatsbeiträge generieren
        for (int i = 1; i <= MAX_WOHNUNG; i++) {
            monatsBeitraegeGenerieren(i);
        }

        // für alle Wohnungen Monatsbeiträge ausgeben
        for (int i = 1; i <= MAX_WOHNUNG; i++) {
            monatsBeitraegeAusgeben(i);
        }
    }

    private void wohnungenGenerieren() {
        for (int i = 1; i <= MAX_WOHNUNG; i++) {
            wohnungen.add(new Wohnung(i));
        }
    }

    private void monatsBeitraegeGenerieren(int wohnungId) {
        ArrayList<Monatsbeitrag> monatsBeitraege = new ArrayList<>();
        Random random = new Random();

        // zufällige Ermittlung der Monatsbeiträge und Speicherung in Arraylist
        for (int i = 1; i <= 12; i++) {
            double aidat = MAX_MONATSBEITRAG * random.nextDouble();
            aidat = round(aidat);
            monatsBeitraege.add(new Monatsbeitrag(i, aidat));
            if (aidat > 0) {
                monatsBeitraege.get(monatsBeitraege.size()-1).setZahlungStatus(true);
            } else {
                monatsBeitraege.get(monatsBeitraege.size()-1).setZahlungStatus(false);
            }

        }
        // für eine Wohnung erstellte monatsbeitraege werden der Wohnung zugewiesen
        wohnungen.get(wohnungId - 1).setAidatlar(monatsBeitraege);
    }

    private void monatsBeitraegeAusgeben(int wohnungId) {
        wohnungen.get(wohnungId - 1).toString();
    }

    // Runden der Beträge auf 0.05
    public static double round(double value) {
        return (Math.round(value * 20) / 20.0);
    }
}
