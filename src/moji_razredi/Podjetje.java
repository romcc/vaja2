package moji_razredi;

public class Podjetje implements Searchable{
    private String ime;
    private int davcnaStevilka;
    private long maticnaStevilka;
    private boolean davcniZavezanec;
    private int stZaposlenih;
    private String email;

    public Podjetje(String ime, int davcnaStevilka, long maticnaStevilka, boolean davcniZavezanec, int stZaposlenih, String email) {
        this.ime = ime;
        this.davcnaStevilka = davcnaStevilka;
        this.maticnaStevilka = maticnaStevilka;
        this.davcniZavezanec = davcniZavezanec;
        this.stZaposlenih = stZaposlenih;
        this.email = email;
    }

    @Override
    public boolean Search(String string) {
        if (ime.toLowerCase().contains(string.toLowerCase())){
            return true;
        }
        else if (email.toLowerCase().contains(string.toLowerCase())){
            return true;
        }
        else if (String.valueOf(davcnaStevilka).contains(string)) {
            return true;
        }
        else if (String.valueOf(maticnaStevilka).contains(string)) {
            return true;
        }
        else if (String.valueOf(stZaposlenih).contains(string)) {
            return true;
        }
        return false;
    }

    public String getIme() {
        return ime;
    }

    public int getDavcnaStevilka() {
        return davcnaStevilka;
    }

    public boolean isDavcniZavezanec() {
        return davcniZavezanec;
    }

}
