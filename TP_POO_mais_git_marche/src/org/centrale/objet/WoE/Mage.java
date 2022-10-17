/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author coco
 */
public class Mage extends Personnage implements Combattant {
    private int PtMana;

    /**
     *
     * @param PtMana
     * @param nom
     * @param ptVie
     * @param degAtt
     * @param ptPar
     * @param pageAtt
     * @param pagePar
     * @param distAttMax
     * @param pos
     */
    public Mage(int PtMana, String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, int distAttMax, Point2D pos, Map<String,Nourriture> effets) {
        super(nom, ptVie, degAtt, ptPar, pageAtt, pagePar, distAttMax, pos, effets);
        this.PtMana = PtMana;
    }

    /**
     *
     */
    public Mage() {
        super();
        this.PtMana = 100;
    }

    /**
     *
     * @param perso
     */
    public Mage(Mage perso) {
        super((Personnage)perso);
        this.PtMana = perso.PtMana;
    }

    /**
     *
     * @return
     */
    public int getPtMana() {
        return PtMana;
    }

    /**
     *
     * @param PtMana
     */
    public void setPtMana(int PtMana) {
        this.PtMana = PtMana;
    }
    
    

   
    
    /**
     *
     * @param c Créature à combattre
     */
    @Override
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
            System.out.println(this.getNom() + " utilise Coup de baton");
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
                    ouch =  Math.max(0,this.getDegAtt()+ptAttBonus-c.getPtPar() - ptParBonus);
                }
            }
            } else {
               int patt = alea.nextInt(101);
               System.out.println(this.getNom() + " utilise Boule de Feu");
               this.setPtMana(this.getPtMana()-10);  
            if (patt > this.getPageAtt()) {
                System.out.println("L'attaque échoue");
            } else {
                System.out.println("L'attaque réussi");
                ouch = 2*(this.getDegAtt()+ptAttBonus);
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
        System.out.println("Le nombre de points de mana est " + PtMana);
    }

        
}   

