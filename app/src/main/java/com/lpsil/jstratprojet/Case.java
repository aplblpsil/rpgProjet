package com.lpsil.jstratprojet;

/**
 * Created by Léo on 07/12/2016.
 */

public class Case {
    private int X;
    private int Y;
    private boolean obstacle; //si cette case peur acceuillir un Perso
    private Personnage Perso;   //contien un personnage ou null
    private int IDImage;        //ID du décor sur la case
    private boolean deplacement;//si le perso focus peut atteinde cette case
    private boolean chemin;     //case du chemin de deplacement
    private boolean attaque;    //si le perso focus peut attaquer cette case
    private int cout;           //cout en pm du déplacement sur cette case
    private Case suivant;       //case suivante si chainé

    public Case(){
        setX(0);
        setY(0);
        setObstacle(false);
        setIDImage(0);
        setDeplacement(false);
        setChemin(false);
        setCout(0);
    }

    public Case(int x, int y, int id , boolean obs){
        setX(x);
        setY(y);
        setObstacle(obs);
        setIDImage(id);
        setDeplacement(false);
        setChemin(false);
        setCout(0);
    }

    public Case(Case c){
        setX(c.getX());
        setY(c.getY());
        setObstacle(c.isObstacle());
        setIDImage(c.getIDImage());
        setDeplacement(c.isDeplacement());
        setChemin(c.isChemin());
        setCout(c.getCout());
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }


    public Personnage getPerso() {
        return Perso;
    }

    public void setPerso(Personnage perso) {
        Perso = perso;
    }

    public int getIDImage() {
        return IDImage;
    }

    public void setIDImage(int IDImage) {
        this.IDImage = IDImage;
    }

    public boolean isDeplacement() {
        return deplacement;
    }

    public void setDeplacement(boolean deplacement) {
        this.deplacement = deplacement;
    }

    public boolean isAttaque() {
        return attaque;
    }

    public void setAttaque(boolean attaque) {
        this.attaque = attaque;
    }

    public boolean isObstacle() {
        return obstacle;
    }

    public void setObstacle(boolean obstacle) {
        this.obstacle = obstacle;
    }

    public int getCout() {
        return cout;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    public Case getSuivant() {
        return suivant;
    }

    public void setSuivant(Case suivant) {
        this.suivant = suivant;
    }

    public boolean isChemin() {
        return chemin;
    }

    public void setChemin(boolean chemin) {
        this.chemin = chemin;
    }
}
