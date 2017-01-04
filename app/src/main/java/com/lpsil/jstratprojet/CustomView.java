package com.lpsil.jstratprojet;

/**
 * Created by Léo on 13/10/2016.
 */


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;


public class CustomView extends View implements View.OnTouchListener, View.OnClickListener {



    private Paint paint;

    private Bitmap bitmap;
    private int bmpSize;
    private Plateau plateau;
    private float Xaffiche;
    private float Yaffiche;
    private float Xmove;
    private float Ymove;
    private Canvas terrain;
    private Tour tour;
    private ArrayList<Bitmap> tabBitmap;


    float Xclic;
    float Yclic;
    int indXc=0;
    int indYc=0;
    int indXm=0;
    int indYm=0;
    int coutDep=0;





    public CustomView(Context context) {
        super(context);
        tabBitmap=new ArrayList<Bitmap>();
        initBitmap();
        bmpSize= BitmapFactory.decodeResource(this.getContext().getResources(), R.drawable.joueur1).getWidth();
        Xaffiche=0;
        Yaffiche=0;
        Xmove=0;
        Ymove=0;
        Xclic=0;
        Yclic=0;

        int x = 50;
        int y = 50;
        int sideLength = 200;
        Carte c =new Carte();
        plateau = new Plateau(c);
        //this.onSizeChanged(200,100,50,50);
        int height=plateau.getLongueur()*64;
        int width=plateau.getLargeur()*64;
        android.view.ViewGroup.LayoutParams lp = new android.view.ViewGroup.LayoutParams(height,width);//100 is width and 200 is height
        this.setLayoutParams(lp);
        init();

        //tour=new Tour(plateau);
        //tour.start();
        plateau.start();
        System.out.println("Custum view créé");
    }

    public void init(){
        this.isFocusable();
        this.isFocusableInTouchMode();


        this.setOnTouchListener(this);
        this.setOnClickListener(this);

        this.invalidate();




    }

    private void initBitmap(){
        //Bitmap bit = new Bitmap();
        /*Bitmap bit = BitmapFactory.decodeResource(this.getContext().getResources(), R.drawable.joueur1);
        tabBitmap.add(bit);
        bit = BitmapFactory.decodeResource(this.getContext().getResources(), R.drawable.selection_bleu);
        tabBitmap.add(bit);
        bit =BitmapFactory.decodeResource(this.getContext().getResources(), R.drawable.selection_vert);
        tabBitmap.add(bit);
        bit =BitmapFactory.decodeResource(this.getContext().getResources(), R.drawable.selection);
        tabBitmap.add(bit);*/

        tabBitmap.add(BitmapFactory.decodeResource(this.getContext().getResources(), R.drawable.joueur1));
        tabBitmap.add(BitmapFactory.decodeResource(this.getContext().getResources(), R.drawable.herbe));
        tabBitmap.add(BitmapFactory.decodeResource(this.getContext().getResources(), R.drawable.selection_bleu));
        tabBitmap.add(BitmapFactory.decodeResource(this.getContext().getResources(), R.drawable.selection_vert));
        tabBitmap.add(BitmapFactory.decodeResource(this.getContext().getResources(), R.drawable.selection));
    }


    @Override
    protected void onDraw(Canvas canvas) {


        paint=new Paint();
        //bitmap = BitmapFactory.decodeResource(this.getContext().getResources(), R.drawable.joueur1);
        terrain=canvas;
        //canvas.translate(Xaffiche,Yaffiche);

        //Xaffiche=canvas.getClipBounds().left;
        //Yaffiche=canvas.getClipBounds().top;

        //System.out.println("position du canvas : "+Xaffiche+" "+Yaffiche);

        //try {
            for (int x = 0; x < plateau.getLongueur(); x++) {


                for (int y = 0; y < plateau.getLargeur(); y++) {

                    if (plateau.getTabCase()[x][y].getIDImage() == 1) {

                        //bitmap = BitmapFactory.decodeResource(this.getContext().getResources(), R.drawable.herbe);

                        canvas.drawBitmap(tabBitmap.get(1), x * tabBitmap.get(1).getWidth(), y * tabBitmap.get(1).getHeight(), paint);

                    }

                    if (!plateau.getTabCase()[x][y].isObstacle()) {

                        paint.setStyle(Paint.Style.STROKE);
                        paint.setColor(Color.BLACK);
                        canvas.drawRect(x * bmpSize, y * bmpSize, (x + 1) * bmpSize, (y + 1) * bmpSize, paint);
                        paint = new Paint();
                    }

                    if (plateau.getTabCase()[x][y].isDeplacement()) {
                        //bitmap = BitmapFactory.decodeResource(this.getContext().getResources(), R.drawable.selection_bleu);
                        canvas.drawBitmap(tabBitmap.get(2), x * tabBitmap.get(2).getWidth(), y * tabBitmap.get(2).getHeight(), paint);
                    }
                    if (plateau.getTabCase()[x][y].isChemin()) {
                        //bitmap = BitmapFactory.decodeResource(this.getContext().getResources(), R.drawable.selection_vert);
                        canvas.drawBitmap(tabBitmap.get(3), x * tabBitmap.get(3).getWidth(), y * tabBitmap.get(3).getHeight(), paint);
                    }

                    if (plateau.getTabCase()[x][y].getPerso() != null) {
                        if (plateau.getTabCase()[x][y].getPerso() == plateau.getPersoActif()) {
                            //bitmap = BitmapFactory.decodeResource(this.getContext().getResources(), R.drawable.selection);
                            canvas.drawBitmap(tabBitmap.get(4), x * tabBitmap.get(4).getWidth(), y * tabBitmap.get(4).getHeight(), paint);
                        }
                        //bitmap = BitmapFactory.decodeResource(this.getContext().getResources(), R.drawable.joueur1);
                        canvas.drawBitmap(tabBitmap.get(0), x * tabBitmap.get(0).getWidth(), y * tabBitmap.get(0).getHeight(), paint);
                    }

                }

            }
            //}catch(Exception e){

           // }






    }

    private void moveMap(){
        //terrain.setMatrix(null);
        //terrain.translate(Xaffiche,Yaffiche);
        //System.out.println("move :"+Xmove+" "+Ymove);
        //terrain.translate(Xaffiche,Yaffiche);
        this.setTranslationX(Xaffiche);
        this.setTranslationY(Yaffiche);

    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {


        if(event.getAction()== MotionEvent.ACTION_DOWN){


            Xclic=event.getX();
            Yclic=event.getY();



            //int indX=(int)(Xclic-Xaffiche)/bmpSize;
            //int indY=(int)(Yclic-Yaffiche)/bmpSize;
            indXc=(int)(Xclic)/bmpSize;
            indYc=(int)(Yclic)/bmpSize;

            //try {
                if (plateau.getTabCase()[indXc][indYc].getPerso() != null) {
                    plateau.setPersoActif(plateau.getTabCase()[indXc][indYc].getPerso());
                    plateau.setCaseActive(plateau.getTabCase()[indXc][indYc]);
                    plateau.initDeplacement();
                    plateau.setModDeplacement(true);
                    plateau.deplacementNormal(indXc, indYc, plateau.getPersoActif().getPmRestant());
                    plateau.getCaseActive().setDeplacement(false);
                    System.out.println(plateau.getTabCase()[indXc][indYc].getPerso().getNom() + " actif en " + indXc + " " + indYc);
                }
            //}catch(Exception e){

            //}

        }
        if(event.getAction()== MotionEvent.ACTION_UP){
            //System.out.println("up");

            int indXm=(int)(event.getX())/bmpSize;
            int indYm=(int)(event.getY())/bmpSize;

            if (plateau.getTabCase()[indXm][indYm].isChemin()){
                //inversion position du joueur
                plateau.getTabCase()[indXm][indYm].setPerso(plateau.getPersoActif());
                plateau.getCaseActive().setPerso(null);

                plateau.setCaseActive(plateau.getTabCase()[indXm][indYm]);
                plateau.initDeplacement();

                plateau.getPersoActif().setPmRestant(plateau.getPersoActif().getPmRestant()-coutDep);
                plateau.deplacementNormal(indXm, indYm, plateau.getPersoActif().getPmRestant());
                plateau.initChemin();
            }
            plateau.setModDeplacement(false);

        }

        if(event.getAction()== MotionEvent.ACTION_MOVE){
            //System.out.println("move");





            //Xmove=event.getRawX()-Xaffiche;
            //Ymove=event.getRawY()-Yaffiche;

            Xmove=event.getX();
            Ymove=event.getY();
            Xaffiche-=(Xclic-Xmove);
            Yaffiche-=(Yclic-Ymove);

            indXm = (int) (Xmove) / bmpSize;
            indYm = (int) (Ymove) / bmpSize;



            //System.out.println("move de : "+(Xmove-Xclic)+" "+(Ymove-Yclic));

            //moveMap();
            //if((event.getX()/bmpSize)!=indXm||(event.getY()/bmpSize)!=indYm) {
            if(Math.abs(indXc-indXm)>0||Math.abs(indYc-indYm)>0){
            //if(indXm<event.getX()){
                plateau.initChemin();


                if (plateau.getModDeplacement()) {
                    System.out.println("move en : " + indXm + " " + indYm);
                    coutDep=Chemin.trouver(plateau.getCaseActive(), plateau.getTabCase()[indXm][indYm], plateau.getTabCase());

                    //CheminThread thread = new CheminThread(plateau.getCaseActive(), plateau.getTabCase()[indXm][indYm], plateau.getTabCase());
                    //thread.start();
                }else{
                    moveMap();
                }
                indXc = (int) (Xmove) / bmpSize;
                indYc = (int) (Ymove) / bmpSize;
            }

        }
        this.invalidate();
        return false;
    }


    @Override
    public void onClick(View v) {

    }

}
