package com.lpsil.jstratprojet;

import java.util.ArrayList;

/**
 * Created by Léo on 25/11/2016.
 */

public class Plateau extends Thread{
    private int longueur;
    private int largeur;
    private Carte carte;
    private Case[][] tabCase;

    private ArrayList<Personnage> equipe_1;
    private ArrayList<Personnage> equipe_2;

    private Personnage persoActif;
    private ArrayList<Personnage> equipeActive;
    private Case caseActive;

    private Boolean finPartie;
    private Boolean modDeplacement;



    public Plateau(){
        this.setCarte(new Carte());
        setLongueur(10);
        setLargeur(10);
        setTabCase(new Case[getLongueur()][getLargeur()]);
        setEquipe_1(new ArrayList<Personnage>());
        setEquipe_2(new ArrayList<Personnage>());

        initEquipe();
        initPlateau();
        setFinPartie(false);
        setCaseActive(null);
        setModDeplacement(false);

    }

    public Plateau(Carte c){
        this.setCarte(c);
        setLongueur(c.getLongueur());
        setLargeur(c.getLargeur());
        setTabCase(new Case[getLongueur()][getLargeur()]);
        setEquipe_1(new ArrayList<Personnage>());
        setEquipe_2(new ArrayList<Personnage>());

        initEquipe();
        initPlateau();
        setFinPartie(false);
        setCaseActive(null);
        setModDeplacement(false);
    }

    public void initEquipe(){
        for(int i=0;i<3;i++){
            Personnage p = new Personnage();
            p.setNom("équipe 1 joueur "+i);
            equipe_1.add(p);
        }
        for(int i=0;i<3;i++){
            Personnage p = new Personnage();
            p.setNom("équipe 2 joueur "+i);
            equipe_2.add(p);
        }

    }


    public void initPlateau(){
        int p1=0; //nb de perso placé
        int p2=0; //nb de perso placé
        for(int x = 0; x< getLongueur(); x++){
            for(int y = 0; y< getLargeur(); y++){
                getTabCase()[x][y]=new Case(x,y, getCarte().getGrilleDecor()[x][y], getCarte().getGrilleObstacle()[x][y]);

                //génération des joueurs (temporaire)
                if(getCarte().getSpawnJoueur()[x][y]==1){
                    getTabCase()[x][y].setPerso(equipe_1.get(p1));
                    p1++;
                }else if(getCarte().getSpawnJoueur()[x][y]==2){
                    getTabCase()[x][y].setPerso(equipe_2.get(p2));
                    p2++;
                }

            }
        }
    }

    public void initDeplacement(){
        for(int x = 0; x< getLongueur(); x++) {
            for (int y = 0; y < getLargeur(); y++) {
                tabCase[x][y].setDeplacement(false);
            }
        }

    }

    public void initChemin(){
        for(int x = 0; x< getLongueur(); x++) {
            for (int y = 0; y < getLargeur(); y++) {
                tabCase[x][y].setChemin(false);
            }
        }
    }

    public void deplacementNormal(int X, int Y,int pm){
        int x=X;
        int y=Y;




        if(pm>0){
            if(y+1<=carte.getLargeur()-1&&!tabCase[x][y].isObstacle()) {
                tabCase[x][y].setDeplacement(true);
                deplacementNormal(x, y + 1, pm - 1);

            }
            if(y-1>=0&&!tabCase[x][y].isObstacle()) {
                tabCase[x][y].setDeplacement(true);
                deplacementNormal(x, y - 1, pm - 1);
            }
            if(x+1<=carte.getLongueur()-1&&!tabCase[x][y].isObstacle()) {
                tabCase[x][y].setDeplacement(true);
                deplacementNormal(x + 1, y, pm - 1);
            }
            if(x-1>=0&&!tabCase[x][y].isObstacle()) {
                tabCase[x][y].setDeplacement(true);
                deplacementNormal(x - 1, y, pm - 1);
            }
        }
    }



    @Override
    public void run(){
        while(!getFinPartie()){
            setEquipeActive(equipe_1);
            /*try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
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

    public Carte getCarte() {
        return carte;
    }

    public void setCarte(Carte carte) {
        this.carte = carte;
    }

    public Case[][] getTabCase() {
        return tabCase;
    }

    public void setTabCase(Case[][] tabCase) {
        this.tabCase = tabCase;
    }

    public ArrayList<Personnage> getEquipe_1() {
        return equipe_1;
    }

    public void setEquipe_1(ArrayList<Personnage> equipe_1) {
        this.equipe_1 = equipe_1;
    }

    public ArrayList<Personnage> getEquipe_2() {
        return equipe_2;
    }

    public void setEquipe_2(ArrayList<Personnage> equipe_2) {
        this.equipe_2 = equipe_2;
    }


    public Personnage getPersoActif() {
        return persoActif;
    }

    public void setPersoActif(Personnage persoActif) {
        this.persoActif = persoActif;
    }

    public ArrayList<Personnage> getEquipeActive() {
        return equipeActive;
    }

    public void setEquipeActive(ArrayList<Personnage> equipeActive) {
        this.equipeActive = equipeActive;
    }

    public Case getCaseActive() {
        return caseActive;
    }

    public void setCaseActive(Case caseActive) {
        this.caseActive = caseActive;
    }

    public Boolean getFinPartie() {
        return finPartie;
    }

    public void setFinPartie(Boolean finPartie) {
        this.finPartie = finPartie;
    }

    public Boolean getModDeplacement() {
        return modDeplacement;
    }

    public void setModDeplacement(Boolean modDeplacement) {
        this.modDeplacement = modDeplacement;
    }
}
