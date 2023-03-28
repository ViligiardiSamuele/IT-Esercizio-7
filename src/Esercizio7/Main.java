package Esercizio7;

import exception.genereException;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        BranoMusicale brano1 = new BranoMusicale("Io e Te", "Giovanotti","Estate" , 3000, 69);
        BranoMusicale brano2 = new BranoMusicale("intMain", "Microsoft","Thecno" , 1000, 79);
        BranoMusicale brano3 = new BranoMusicale("voidMain", "Trump","Metal" , 2069, 10);

        CDAudio CD1 = new CDAudio("roberto chad");
        CD1.aggiungiBrano(brano1);
        CD1.aggiungiBrano(brano2);
        CD1.aggiungiBrano(brano3);

        CDAudio CD2 = new CDAudio( "giovandomenico di sabato");
        CD2.aggiungiBrano(brano1);
        CD2.aggiungiBrano(brano2);
        CD2.aggiungiBrano(brano3);
        CD2.cancellaBrano(brano3.getTitolo());
        System.out.println("search: " + CD1.search(brano2.getTitolo()).getTitolo());
        CD1.modificaBrano(new BranoMusicale("titolobello","nomebello","xiaomi",69,1000));
        System.out.println(CD1.toString());
        try{
            System.out.println(CD1.braniGenere("Thecn").toString());
        } catch (genereException e){
            System.out.println("\u001B[31mE' stata generata un'eccezione!!");
        }
    }
}