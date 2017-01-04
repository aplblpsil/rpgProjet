package com.lpsil.jstratprojet;

/**
 * Created by Léo on 07/12/2016.
 */

public class Carte {
    private int longueur;
    private int largeur;
    private boolean[][] grilleObstacle; //savoir si la case accesible
    private int[][] spawnJoueur;        //1=J 2=J2
    private int[][] grilleDecor;        //id le l'image du décor à afficher
                                            //0 vide
                                            //1 herbe

    public Carte(){
        setLongueur(30);
        setLargeur(20);
        setGrilleObstacle(new boolean[getLongueur()][getLargeur()]);
        setGrilleDecor(new int[getLongueur()][getLargeur()]);
        setSpawnJoueur(new int[getLongueur()][getLargeur()]);
        initCarte();
        creerCarte();
    }

    public void initCarte(){
        for(int x = 0; x< getLongueur(); x++){
            for(int y = 0; y< getLargeur(); y++){
                getGrilleObstacle()[x][y]=false;
                getGrilleDecor()[x][y]=0;
                getSpawnJoueur()[x][y]=0;
            }
        }

    }

    public void creerCarte(){
        //herbe partout
        for(int x = 0; x< getLongueur(); x++){
            for(int y = 0; y< getLargeur(); y++){
                getGrilleDecor()[x][y]=1;

            }
        }
        //point de spawn de l'équipe 1 pour 2 perso
        getSpawnJoueur()[getLongueur() /2-1][1]=1;
        getSpawnJoueur()[getLongueur() /2+1][1]=1;
        //point de spawn de l'équipe 2 pour 2 perso
        getSpawnJoueur()[getLongueur() /2-1][getLargeur() -1]=2;
        getSpawnJoueur()[getLongueur() /2+1][getLargeur() -1]=2;
    }

    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public boolean[][] getGrilleObstacle() {
        return grilleObstacle;
    }

    public void setGrilleObstacle(boolean[][] grilleObstacle) {
        this.grilleObstacle = grilleObstacle;
    }

    public int[][] getSpawnJoueur() {
        return spawnJoueur;
    }

    public void setSpawnJoueur(int[][] spawnJoueur) {
        this.spawnJoueur = spawnJoueur;
    }

    public int[][] getGrilleDecor() {
        return grilleDecor;
    }

    public void setGrilleDecor(int[][] grilleDecor) {
        this.grilleDecor = grilleDecor;
    }
}
