package Esercizio7;

public class BranoMusicale {
    protected String titolo, autore, genere;
    protected int anno, durata;

    public BranoMusicale (){}

    public BranoMusicale(String titolo, String autore, String genere, int anno, int secondi) {
        this.titolo = titolo;
        this.autore = autore;
        this.genere = genere;
        this.anno = anno;
        this.durata = secondi;
    }

    public BranoMusicale (BranoMusicale branoMusicale){
        this.titolo = branoMusicale.titolo;
        this.autore = branoMusicale.autore;
        this.genere = branoMusicale.genere;
        this.anno = branoMusicale.anno;
        this.durata = branoMusicale.durata;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

}
