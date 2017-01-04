package com.lpsil.jstratprojet;

/**
 * Created by Rasta on 25/11/2016.
 */

public class Personnage {
    private String nom;
    private int pv;
    private int pm;
    private int pvRestant;
    private int pmRestant;
    private String image;

    public Personnage(){
        setNom("");
        setPv(10);
        setPm(3);
        setImage("joueur1");
        setPmRestant(pm);
        setPvRestant(pv);
    }



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getPm() {
        return pm;
    }

    public void setPm(int pm) {
        this.pm = pm;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPvRestant() {
        return pvRestant;
    }

    public void setPvRestant(int pvRestant) {
        this.pvRestant = pvRestant;
    }

    public int getPmRestant() {
        return pmRestant;
    }

    public void setPmRestant(int pmRestant) {
        this.pmRestant = pmRestant;
    }
}
