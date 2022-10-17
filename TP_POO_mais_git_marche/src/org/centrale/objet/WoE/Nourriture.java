/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author leo20
 */
public class Nourriture extends Objet implements Utilisable{
    private int modifDegAtt;
    private int modifPageAtt;
    private int modifPagePar;
    private int modifPtPar;
    private int nbToursEffet;



    public int getModifDegAtt() {
        return modifDegAtt;
    }

    public void setModifDegAtt(int modifDegAtt) {
        this.modifDegAtt = modifDegAtt;
    }

    public int getModifPageAtt() {
        return modifPageAtt;
    }

    public void setModifPageAtt(int modifPageAtt) {
        this.modifPageAtt = modifPageAtt;
    }

    public int getModifPagePar() {
        return modifPagePar;
    }

    public void setModifPagePar(int modifPagePar) {
        this.modifPagePar = modifPagePar;
    }

    public int getModifPtPar() {
        return modifPtPar;
    }

    public void setModifPtPar(int modifPtPar) {
        this.modifPtPar = modifPtPar;
    }

    public int getNbToursEffet() {
        return nbToursEffet;
    }

    public void setNbToursEffet(int nbToursEffet) {
        this.nbToursEffet = nbToursEffet;
    }
    
    
    
    public static final String POULET = "Poulet";
    public static final int POULET_MODIF_DEGATT = 2;
    public static final int POULET_MODIF_PAGEATT = 0;
    public static final int POULET_MODIF_PAGEPAR = 0;
    public static final int POULET_MODIF_PTPAR = 0;
    public static final int POULET_NBTOURS = 3;
    
    public static final String CHAMPIGNON_VENENEUX = "Champignon vénéneux";
    public static final int CHAMPIGNON_VENENEUX_DEGATT = 0;
    public static final int CHAMPIGNON_VENENEUX_PAGEATT = 0;
    public static final int CHAMPIGNON_VENENEUX_PAGEPAR = 0;
    public static final int CHAMPIGNON_VENENEUX_PTPAR = -2;
    public static final int CHAMPIGNON_VENENEUX_NBTOURS = 5;

    public Nourriture(int modifDegAtt, int modifPageAtt, int modifPagePar, int modifPtPar, int nbToursEffet, String nom, String description, Point2D pos) {
        super(nom, description, pos);
        this.modifDegAtt = modifDegAtt;
        this.modifPageAtt = modifPageAtt;
        this.modifPagePar = modifPagePar;
        this.modifPtPar = modifPtPar;
        this.nbToursEffet = nbToursEffet;
    }

    public Nourriture poulet(Point2D pos) {
        return new Nourriture(POULET_MODIF_DEGATT, POULET_MODIF_PAGEATT, POULET_MODIF_PAGEPAR, POULET_MODIF_PTPAR, POULET_NBTOURS, "Poulet", "Miam", pos);
    };
    
    public Nourriture champignonVeneneux(Point2D pos) {
        return new Nourriture(CHAMPIGNON_VENENEUX_DEGATT, CHAMPIGNON_VENENEUX_PAGEATT, CHAMPIGNON_VENENEUX_PAGEPAR, CHAMPIGNON_VENENEUX_PTPAR, CHAMPIGNON_VENENEUX_NBTOURS,"Champignon vénéneux","Manger ceci était une mauvaise idée",pos);
    };
    
    
    @Override
    public void est_utilise(Personnage p){
        p.getEffets().put(this.getNom(),this);
    }
}


