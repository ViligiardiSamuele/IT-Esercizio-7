package Esercizio7;

import java.util.ArrayList;
import java.util.Iterator;

public class CDAudio {
    protected String nome;
    protected ArrayList<BranoMusicale> brani;

    public CDAudio(){/*Vuoto*/}

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

    CDAudio braniGenere (String genere) throws Eccezione {
        CDAudio cdGenere = new CDAudio();
        for(int i = 0; i < brani.size(); i++)
            if(brani.get(i).getGenere().equals(genere))
                cdGenere.brani.add(brani.get(i));
        if(cdGenere.brani.size() == 0)
            throw new Eccezione();
        return cdGenere;
    }

    CDAudio unisciCD(CDAudio cd){
        CDAudio CDUnito = new CDAudio();
        CDUnito.brani.addAll(this.getBrani());
        CDUnito.brani.addAll(cd.getBrani());
        return CDUnito;
    }

    CDAudio braniComuniCD(CDAudio cd){
        CDAudio CDComune = new CDAudio();
        for(int i = 0; i < this.brani.size() && i < cd.brani.size(); i++){
            if(this.brani.get(i).getTitolo().equals(cd.brani.get(i).getTitolo()))
                CDComune.brani.add(cd.brani.get(i));
        }
        return CDComune;
    }
}
