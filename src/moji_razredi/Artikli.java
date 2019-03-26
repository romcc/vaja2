package moji_razredi;
import java.util.ArrayList;

public class Artikli{

    private ArrayList<Artikel> artikli = new ArrayList<Artikel>();
    private ArrayList<Integer> kol = new ArrayList<Integer>();

    public void dodaj(Artikel artikel, int kolicina){
        this.artikli.add(artikel);
        this.kol.add(kolicina);
    }

    public void brisi(Artikel artikel){
        for (int i = 0; i < artikli.size(); i++) {
            if(artikli.get(i) == artikel){
                artikli.remove(i);
                kol.remove(i);
            }
        }
    }

    public void popravi(Artikel artikel, int kolicina) {
        for (int i = 0; i < artikli.size(); i++) {
            if (artikli.get(i) == artikel) {
                artikli.set(i, artikel);
                kol.set(i, kolicina);
            }
        }
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < artikli.size(); i++){
            str += "" + artikli.get(i).getIme() + ", Kolicina: " + kol.get(i).toString() + ", Cena: " + artikli.get(i).getCena() / 100 + "." + artikli.get(i).getCena() % 100 + "€\n";
        }
        return str;
    }

    public ArrayList<Artikel> getArtikli() {
        return artikli;
    }

    public ArrayList<Integer> getKol() {
        return kol;
    }

}