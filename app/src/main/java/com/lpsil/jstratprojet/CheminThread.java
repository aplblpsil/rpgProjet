package com.lpsil.jstratprojet;

/**
 * Created by Léo on 28/12/2016.
 */

public class CheminThread extends Thread{
    Case[][] tabCase;
    Case debut;
    Case fin;

    public CheminThread(Case cd,Case cf,Case[][] tab){
        super();
        tabCase =tab;
        debut=cd;
        fin=cf;
    }

    @Override
    public void run(){
        Chemin.trouver(debut, fin, tabCase);
    }
}
