package moji_razredi;

import org.omg.CORBA.INTERNAL;

public class Artikel implements Searchable{

    private String ime;
    private int cena;
    private static long EAN;
    private String drzava;

    public Artikel(String ime, int cena){
        this.ime = ime;
        this.cena = cena;
        //this.EAN = (long) Math.floor(Math.random() * 900000000000L) + 100000000000L;
        this.EAN = 383958466632L;
        int ean2 = Integer.parseInt(String.valueOf(EAN).substring(0,2));
        int ean3 = Integer.parseInt(String.valueOf(EAN).substring(0,3));
        Drzava(ean2, ean3);
    }

    private void Drzava(int ean2, int ean3){
        if(ean2 == 00 || ean2 == 01 || ean2 == 02 || ean2 == 03 || ean2 == 04 || ean2 == 05 || ean2 == 06 || ean2 == 07 || ean2 == 10 || ean2 == 11 || ean2 == 12 || ean2 == 13){
            this.drzava = "USA and Canada";
        }
        else if(ean2 == 20 || ean2 == 21 || ean2 == 22 || ean2 == 23 || ean2 == 24 || ean2 == 25 || ean2 == 26 || ean2 == 27 || ean2 == 28 || ean2 == 29){
            this.drzava = "Internal use";
        }
        else if (ean3 == 383) {
            this.drzava = "Slovenia";
        }
        else if(ean3 == 385){
            this.drzava = "Croatia";
        }
    }

    @Override
    public boolean Search(String string) {
        if (ime.toLowerCase().contains(string.toLowerCase())){
            return true;
        }
        else if (String.valueOf(cena).contains(string)) {
            return true;
        }
        return false;
    }

    public static boolean checkDigit(int kontrolnaStevilka){
        int[]digits = Long.toString(EAN).chars().map(c -> c-'0').toArray();
        for(int i = 1; i < digits.length; i += 2){
            digits[i] = digits[i] * 3;
        }
        int rez = 0;
        for(int i = 0; i < digits.length; i++){
            rez += digits[i];
        }
        int s = (int)(Math.round( rez / 10.0) * 10);
        if (s < rez)
            s += 10;
        rez = s - rez;

        if (kontrolnaStevilka == rez)
            return true;

        return false;
    }

    public String getIme() {
        return ime;
    }

    public int getCena() {
        return cena;
    }

}