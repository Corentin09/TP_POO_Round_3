/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Map;
import java.util.Random;

/**
 *Sous-classe de Monstre gérant les loups
 * @author coco
 */
public class Loup extends Monstre implements Combattant {

    /**
     *Constructeur de Loup
     * @param ptVie Point de vie du loup
     * @param degAtt Dégâts d'attaque du loup
     * @param ptPar Points de parade du loup
     * @param pageAtt Pourcentage de chance de toucher avec une attaque
     * @param pagePar Pourcentage de chance de parer une attaque
     * @param pos Position du loup
     * @param effets
     */
    public Loup(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos, Map<String, Nourriture> effets) {
        super(ptVie, degAtt, ptPar, pageAtt, pagePar, pos, effets);
    }

    /**
     *Constructeur par défaut de Loup
     */
    public Loup() {
        super();
    }

    /**
     *Constructeur de recopie de Loup
     * @param m Loup à recopier
     */
    public Loup(Loup m) {
        super((Monstre)m);
    }
    
    /**
     *Méthode de combat de loup
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
        System.out.println("Le loup utilise Coup de Croc");
        double d = this.getPos().distance(c.getPos());
        if (d !=1) {
            System.out.println("La créature est trop loin pour être attaquée"); 
        } else {
            int patt = alea.nextInt(101);
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

