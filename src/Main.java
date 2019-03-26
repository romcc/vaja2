import moji_razredi.Artikel;
import moji_razredi.Artikli;
import moji_razredi.Racun;
import moji_razredi.Podjetje;

public class Main {

    public static void main(String[] args) {
        Podjetje podjetje1 = new Podjetje("HENKEL MARIBOR d.o.o.", 58665765, 6261752000L, true, 15, "henkel.slovenija@henkel.com");
        Podjetje podjetje2 = new Podjetje("KLS d.o.o.", 40543552, 1574345000, true, 2, "kls@siol.net");
        Podjetje podjetje3 = new Podjetje("LIDL Slovenija d.o.o. k.d.", 59314923, 1719947000, true, 1000, "uprava@lidl.si");

        Artikel ravnilo = new Artikel("Ravnilo", 199);
        Artikel kemik = new Artikel("Kemični Svinčnik", 95);
        Artikel geotrikotnik = new Artikel("Geotrikotnik", 245);
        Artikel svincnik = new Artikel("Svinčnik", 355);
        Artikel svece = new Artikel("Sveče", 287);

        Artikli artikli = new Artikli();
        artikli.dodaj(ravnilo, 4);
        artikli.dodaj(kemik, 1);
        artikli.dodaj(geotrikotnik, 2);

        Racun racun = new Racun("blagajnik", podjetje1, artikli, 22);
        Racun racun2 = new Racun("blagajnik", podjetje2, 22);
        Racun racun3 = new Racun("blagajnik", podjetje3, 22);

        racun2.dodaj(svece, 5);
        racun3.dodaj(svece, 2);
        racun3.dodaj(svincnik, 2);

        System.out.println(racun.toString());

        System.out.println(racun.toString());

        if (podjetje1.Search("HENKEL")){
            System.out.println("Podjetje 1 vsebuje besedo 'HENKEL'");
        }
        else{
            System.out.println("\nPodjetje 1 ne vsebuje besede 'HENKEL'");
        }
        if (podjetje1.Search("6657")){
            System.out.println("\nPodjetje 1 vsebuje besedo '6657'");
        }
        else{
            System.out.println("\nPodjetje 1 ne vsebuje besede '6657'");
        }
        if (podjetje2.Search("@2si")){
            System.out.println("\nPodjetje 2 vsebuje besedo '@2si'");
        }
        else{
            System.out.println("\nPodjetje 2 ne vsebuje besede '@2si'");
        }


        if(ravnilo.checkDigit(9))
            System.out.println("\nArtikel ima veljavno EAN kodo");
        else
            System.out.println("\nArtikel nima veljavje EAN kode");

        if(ravnilo.checkDigit(7))
            System.out.println("\nArtikel ima veljavno EAN kodo");
        else
            System.out.println("\nArtikel nima veljavje EAN kode");

    }
}
