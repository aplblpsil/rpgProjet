package com.lpsil.jstratprojet;

/**
 * Created by Léo on 28/12/2016.
 */

public class Tour extends Thread{
    Plateau plateau;
    Boolean finPartie;


    public Tour(Plateau p){
        this.plateau=p;
    }

    public void run(){
        finPartie=false;
        while(!finPartie){

        }
    }
}
