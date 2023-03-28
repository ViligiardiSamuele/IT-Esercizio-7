package Esercizio7;

import exception.genereException;

import java.util.ArrayList;
import java.util.Iterator;

public class CDAudio {
    protected String nome;
    protected ArrayList<BranoMusicale> brani;

    public CDAudio(){
        this.brani = new ArrayList<>();
    }

    public CDAudio(String nome) {
        //Costruttore
        this.nome = nome;
        this.brani = new ArrayList<>();
    }

    public CDAudio(CDAudio cdAudio){
        //Costruttore di copia
        this.nome = cdAudio.nome;
        this.brani = new ArrayList<>(cdAudio.brani);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<BranoMusicale> getBrani() {
        return brani;
    }

    public void setBrani(ArrayList<BranoMusicale> brani) {
        this.brani = brani;
    }

    boolean aggiungiBrano(BranoMusicale brano){
        if(brani.contains(brano)) return false;
        return brani.add(brano);

    }

    boolean cancellaBrano(String titolo){
        Iterator<BranoMusicale> iterator = brani.iterator();
        while(iterator.hasNext())
            if(iterator.next().getTitolo().equals(titolo)) {
                iterator.remove();
                return true;
            }
        return false;
    }

    BranoMusicale search (String titolo){
        for(BranoMusicale branoMusicale : brani)
            if(branoMusicale.getTitolo().equals(titolo))
                return branoMusicale;
        return new BranoMusicale();
    }

    void modificaBrano (BranoMusicale nuovoBrano){
        for(BranoMusicale branoMusicale : brani){
            if(branoMusicale.getTitolo().equals(nuovoBrano.getTitolo()))
                branoMusicale = new BranoMusicale(nuovoBrano);
        }
    }

    int contaBraniAnno (int anno){
        int num = 0;
        for(BranoMusicale branoMusicale : brani){
            if(branoMusicale.getAnno() == anno)
                num++;
        }
        return num;
    }

    int contaBraniAutore (String autore){
        int num = 0;
        for(BranoMusicale branoMusicale : brani){
            if(branoMusicale.getAutore().equals(autore))
                num++;
        }
        return num;
    }

    BranoMusicale maxDurata(){
        BranoMusicale piulungo = brani.get(0);
        for(BranoMusicale branoMusicale : brani)
            if(branoMusicale.getDurata() > piulungo.getDurata())
                piulungo = branoMusicale;
        return piulungo;
    }

    CDAudio braniGenere (String genere) throws genereException {
        CDAudio cdGenere = new CDAudio();
        for(int i = 0; i < this.getBrani().size(); i++)
            if(this.getBrani().get(i).getGenere().equals(genere))
                cdGenere.getBrani().add(this.getBrani().get(i));
        if(cdGenere.getBrani().size() == 0)
            throw new genereException();
        return cdGenere;
    }

    CDAudio unisciCD(CDAudio cd){
        CDAudio CDUnito = new CDAudio();
        CDUnito.brani.addAll(this.getBrani());
        CDUnito.brani.addAll(cd.getBrani());
        return CDUnito;
    }

    CDAudio braniComuniCD(CDAudio cd){
        CDAudio CDComune = new CDAudio("Nuovo CD");
        for(int i = 0; i < this.getBrani().size() && i < cd.getBrani().size(); i++){
            if(this.getBrani().get(i).getTitolo().equals(cd.getBrani().get(i).getTitolo()))
                CDComune.aggiungiBrano(cd.getBrani().get(i));
        }
        return CDComune;
    }
    @Override
    public String toString() {
        String out = "Nome CD: " + this.getNome();
        for (BranoMusicale b : this.getBrani()) {
            out += "\nTitolo: " + b.getTitolo()
                    + " - Autore: " + b.getAutore()
                    + " - Genere: " + b.getGenere()
                    + " - Anno: " + b.getAnno()
                    + " - Durata: " + b.getDurata();
        }
        return out;
    }
}
