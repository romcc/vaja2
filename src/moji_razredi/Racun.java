package moji_razredi;
import java.util.Date;

public class Racun implements Searchable{
    protected int id;
    static int stevec = 0;
    private Date datum;
    private Artikli artikli;
    private int skupnaCena;
    private int skupnaCenaDDV;
    private int davcnaStopnja;
    private Podjetje pod;
    private int davcnaPodjetja;

    public Racun(Podjetje podjetje, int davcnaStopnja){
        stevec++;
        this.id = stevec;
        this.datum = new Date();
        this.pod = podjetje;
        this.davcnaPodjetja = podjetje.getDavcnaStevilka();
        this.artikli = new Artikli();
        this.skupnaCena = 0;
        this.skupnaCenaDDV = 0;
        this.davcnaStopnja = davcnaStopnja;
    }

    public Racun(Podjetje podjetje, Artikli artikli, int davcnaStopnja){
        stevec++;
        this.id = stevec;
        this.datum = new Date();
        this.pod = podjetje;
        this.davcnaPodjetja = podjetje.getDavcnaStevilka();
        this.davcnaStopnja = davcnaStopnja;
        this.artikli = artikli;
        for (int i = 0; i < artikli.getArtikli().size(); i++){
            this.skupnaCena += artikli.getArtikli().get(i).getCena() * artikli.getKol().get(i);
        }
        int y = this.skupnaCena * davcnaStopnja / 100;
        this.skupnaCenaDDV = this.skupnaCena + y;
    }

    public void dodaj(Artikel artikel, int kolicina){
        this.artikli.dodaj(artikel, kolicina);
        this.skupnaCena += artikel.getCena() * kolicina;
        int y = this.skupnaCena * davcnaStopnja / 100;
        this.skupnaCenaDDV = this.skupnaCena + y;
    }

    public void brisi(Artikel artikel){
        this.artikli.brisi(artikel);
        updateCena();
    }

    public void popravi(Artikel artikel, int kolicina) {
        this.artikli.popravi(artikel, kolicina);
        updateCena();
    }

    private void updateCena(){
        this.skupnaCena = 0;
        for (int i = 0; i < artikli.getArtikli().size(); i++){
            this.skupnaCena += artikli.getArtikli().get(i).getCena() * artikli.getKol().get(i);
        }
        int y = this.skupnaCena * davcnaStopnja / 100;
        this.skupnaCenaDDV = this.skupnaCena + y;
    }

    public boolean jeDavcniZavezanec(){
        if (pod.isDavcniZavezanec()){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String str = "Št. Računa: " + id + "%\nRačun izdal: " + pod.getIme() + "\nDavčna številka podjetja: " + davcnaPodjetja + "\nDatum izdaje: " + datum + "\n\nArtikli:\n" + artikli.toString() + "\nSkupna cena: " + skupnaCena / 100 + "." + skupnaCena % 100 +
                "€\nSkupna cena z DDV: " + skupnaCenaDDV / 100 + "." + skupnaCenaDDV % 100 + "€\n" + "DDV %: " + davcnaStopnja + "\n";
        return str;
    }

    @Override
    public boolean Search(String string) {
        if (String.valueOf(datum).contains(string)) {
            return true;
        }
        else if (String.valueOf(skupnaCena).contains(string)) {
            return true;
        }
        else if (String.valueOf(skupnaCenaDDV).contains(string)) {
            return true;
        }
        else if (String.valueOf(davcnaStopnja).contains(string)) {
            return true;
        }
        else if (String.valueOf(davcnaPodjetja).contains(string)) {
            return true;
        }
        return false;
    }

}