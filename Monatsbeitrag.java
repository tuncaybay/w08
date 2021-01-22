package w08;

public class Monatsbeitrag {
    private int monat;
    private double bezahlteBetrag;
    private boolean zahlungStatus;

    // Bu construktor a ihtiyac yok ama ödevde isteniyor
    public Monatsbeitrag(int monat) {
        this.monat = monat;
    }

    public Monatsbeitrag(int monat, double bezahlteBetrag) {
        this.monat = monat;
        this.bezahlteBetrag = bezahlteBetrag;
    }

    public int getMonat() {
        return monat;
    }

    public double getBezahlteBetrag() {
        return bezahlteBetrag;
    }

    public boolean isZahlungStatus() {
        return zahlungStatus;
    }

    public void setZahlungStatus(boolean zahlungStatus) {
        this.zahlungStatus = zahlungStatus;
    }
}
