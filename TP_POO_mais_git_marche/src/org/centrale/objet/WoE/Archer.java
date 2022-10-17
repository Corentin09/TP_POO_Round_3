/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;


/**
 * Sous-classe de personnage gérant les archers
 * @author coco
 */
public class Archer extends Personnage implements Combattant {
    private int nbFleche;

    /**
     * Constructeur d'Archer
     * @param nbFleche Nombre de flèche possédées par l'archer
     * @param nom Nom de l'archer
     * @param ptVie Points de vie de l'archer
     * @param degAtt Dégâts infligés par une attaque
     * @param ptPar Dégâts parés par une attaque
     * @param pageAtt Pourcentage de chance de toucher avec une attaque
     * @param pagePar Pourcentage de chance de parer une attaque
     * @param distAttMax Distance d'attaque maximale
     * @param pos Position de l'archer
     */
    public Archer(int nbFleche, String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, int distAttMax, Point2D pos, Map<String, Nourriture> effets) {
        super(nom, ptVie, degAtt, ptPar, pageAtt, pagePar, distAttMax, pos, effets);
        this.nbFleche = nbFleche;
    }

    /**
     * Constructeur par défaut de l'archer
     */
    public Archer() {
        super();
        nbFleche = 10;
    }

    /**
     * Constructeur de recopie d'Archer
     * @param perso Archer à recopier
     */
    public Archer(Archer perso) {
        super(perso);
        nbFleche = perso.nbFleche;
    }

    /**
     *
     * @return Le nombre de flèche de l'archer
     */
    public int getNbFleche() {
        return nbFleche;
    }

    /**
     *
     * @param nbFleche Nombre de flèche de l'archer
     */
    public void setNbFleche(int nbFleche) {
        this.nbFleche = nbFleche;
    }
    
    /**
     *
     * @param c Créature à combattre
     */
    public void combattre(Creature c) {
        Random alea = new Random();
        int ouch = 0;
        int ptAttBonus = 0;
        int ptParBonus = 0;
        int pageAttBonus = 0;
        int pageParBonus = 0;
        for (String s: this.getEffets().keySet()) {
            ptAttBonus += this.getEffets().get(s).getModifDegAtt();
            pageAttBonus +=  this.getEffets().get(s).getModifPageAtt();     
        }
        for (String s: c.getEffets().keySet()) {
            ptParBonus += c.getEffets().get(s).getModifPtPar();
            pageParBonus +=  c.getEffets().get(s).getModifPagePar();     
        }
        double d = this.getPos().distance(c.getPos());
        if (d > this.getDistAttMax()) {
            System.out.println("La créature est trop loin pour être attaquée"); 
        } else {
            if (d == 1) {
            int patt = alea.nextInt(101);
            System.out.println(this.getNom() + " utilise Coup de dague");
            if (patt > (this.getPageAtt()+pageAttBonus)) {
                System.out.println("L'attaque échoue");
            } else {
                System.out.println("L'attaque réussi");
                int ppar = alea.nextInt(101);
                if (ppar > (c.getPagePar()+pageParBonus)) {
                    System.out.println("La parade échoue");
                    ouch = this.getDegAtt()+ptAttBonus;
                    
                } else {
                    System.out.println("La parade réussi");
                    ouch =  Math.max(0,this.getDegAtt()+ptAttBonus-c.getPtPar()-ptParBonus);
                }
            }
            } else {
               int patt = alea.nextInt(101);
               System.out.println(this.getNom() + " utilise Tir à l'arc");
               this.setNbFleche(this.getNbFleche()-1);  
            if (patt > (this.getPageAtt()+pageAttBonus)) {
                System.out.println("L'attaque échoue");
            } else {
                System.out.println("L'attaque réussi");
                ouch = this.getDegAtt()+ptAttBonus;
            }
            }
        }
                System.out.println("L'attaque inflige " + ouch + "points de dégâts");
            if (ouch >= 0.5*c.getPtVie()) {
                System.out.println("C'est super efficace");
            }
            if (ouch <= 0.1*c.getPtVie()) {
                System.out.println("Ce n'est pas très efficace");
            }
            c.setPtVie(c.getPtVie()-ouch);
            System.out.println("Il reste " + c.getPtVie() + "points de vie");
             
            }  
    
    /**
     *Fonction d'affichage de la classe Archer
     */
    @Override
    public void affiche() {
        super.affiche();
        System.out.println("Le nombre de flèche est " + nbFleche);
    }

        
}    


