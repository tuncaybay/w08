package w08;


import java.text.DecimalFormat;
import java.util.ArrayList;

public class Wohnung {
    private int wohnungId;
    private final double MONATSBEITRAG = 250.00;
    private ArrayList<Monatsbeitrag> monatsBeitraege = new ArrayList<>();

    public Wohnung(int wohnungId) {
        this.wohnungId = wohnungId;
    }

    public void setAidatlar(ArrayList<Monatsbeitrag> aidatlar) {
        this.monatsBeitraege = aidatlar;
    }

    public String toString() {
        // Formatierung der Monatsbeiträge
        DecimalFormat formatter1 = new DecimalFormat("#0.00");
        formatter1.setPositiveSuffix(" Fr.");
        formatter1.setNegativeSuffix(" Fr.");

        // Formatierung der Saldo
        DecimalFormat formatter2 = new DecimalFormat("#0.00");
        formatter2.setPositiveSuffix(" Fr.");
        formatter2.setNegativeSuffix(" Fr.");
        formatter2.setPositivePrefix("+");

        double saldo = 0.00;

        System.out.println("Wohnung [" + wohnungId + "]");
        for (int i = 0; i < monatsBeitraege.size(); i++) {
            saldo += monatsBeitraege.get(i).getBezahlteBetrag();
            System.out.println("[" + monatsBeitraege.get(i).getMonat() + "]:" + formatter1.format(monatsBeitraege.get(i).getBezahlteBetrag()));
        }
        saldo = Manager.round(saldo - MONATSBEITRAG * 12);
        System.out.println("Saldo Wohnung [" + wohnungId + "]: " + formatter2.format(saldo));
        System.out.println("----------------------------");

        return null;
    }
}
