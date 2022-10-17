/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Sous-classe de personnage gérant les guerriers
 * @author coco
 */
public class Guerrier extends Personnage implements Combattant {

    /**
     * Constructeur de Guerrier
     * @param nom Nom du guerrier
     * @param ptVie Points de vie du guerrier
     * @param degAtt Dégâts infligés par une attaque
     * @param ptPar Dégâts parés par une attaque
     * @param pageAtt Pourcentage de chance de toucher avec une attaque
     * @param pagePar Pourcentage de chance de parer une attaque
     * @param distAttMax Distance d'attaque maximale
     * @param pos Position du guerrier
     */
    public Guerrier(String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, int distAttMax, Point2D pos, Map<String,Nourriture> effets) {
        super(nom, ptVie, degAtt, ptPar, pageAtt, pagePar, distAttMax, pos, effets);
    }

    /**
     * Constructeur de recopie 
     * @param perso Guerrier à recopier
     */
    public Guerrier(Guerrier perso) {
        
        super((Personnage)perso);
    }

    /**
     * Constructeur par défaut de guerrier
     */
    public Guerrier() {
        super();
    }
    
    /**
     * Méthode de combat
     * @param c Créature à combattre
     */
    public void combattre(Creature c) {
        Random alea = new Random();
        int ouch;
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

        System.out.println(this.getNom() + " utilise Coup d'Épée");
        double d = this.getPos().distance(c.getPos());
        if (d !=1) {
            System.out.println("La créature est trop loin pour être attaquée"); 
        } else {
            int patt = alea.nextInt(101);
            if (patt > (this.getPageAtt() + pageAttBonus)) {
                System.out.println("L'attaque échoue");
            } else {
                System.out.println("L'attaque réussi");
                int ppar = alea.nextInt(101);
                if (ppar > (c.getPagePar() + pageParBonus)) {
                    System.out.println("La parade échoue");
                    ouch = this.getDegAtt()+ptAttBonus;
                    
                } else {
                    System.out.println("La parade réussi");
                    ouch =  Math.max(0,ptAttBonus+this.getDegAtt()-c.getPtPar() - ptParBonus);
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
            
            
            }   
}
}
