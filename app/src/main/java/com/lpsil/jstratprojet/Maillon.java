package com.lpsil.jstratprojet;

/**
 * Created by Léo on 28/12/2016.
 */

public class Maillon {
    private int x,y,cout;
    private Maillon prec;

    public Maillon(){
        x=0;
        y=0;
        cout=0;
        prec=null;
    }

    public Maillon(int X, int Y, int C, Maillon M){
        x=X;
        y=Y;
        cout=C;
        prec = M;
    }

    public int CompareTo(Maillon m){
        int resultat=0;
        if (this.getCout() > m.getCout())
            resultat = 1;
        if (this.getCout() < m.getCout())
            resultat = -1;
      /*if (this.getCout() == autrejoueur.point)
         resultat = 0;*/
        return resultat;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the cout
     */
    public int getCout() {
        return cout;
    }

    /**
     * @param cout the cout to set
     */
    public void setCout(int cout) {
        this.cout = cout;
    }

    /**
     * @return the prec
     */
    public Maillon getPrec() {
        return prec;
    }

    /**
     * @param prec the prec to set
     */
    public void setPrec(Maillon prec) {
        this.prec = prec;
    }
}
