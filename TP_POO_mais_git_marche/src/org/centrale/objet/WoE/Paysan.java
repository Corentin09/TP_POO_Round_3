/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.Map;

/**
 *Sous-classe de Personnage gérant les paysans
 * @author coco
 */
public class Paysan extends Personnage {

    /**
     *Constructeur de Paysan
     * @param nom Nom du paysan
     * @param ptVie Points de vie du paysan
     * @param degAtt Dégâts infligés par une attaque
     * @param ptPar Dégâts parés par une attaque
     * @param pageAtt Pourcentage de chance de toucher avec une attaque
     * @param pagePar Pourcentage de chance de parer une attaque
     * @param distAttMax Distance d'attaque maximale
     * @param pos Position du paysan
     */
    public Paysan(String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, int distAttMax, Point2D pos, Map<String, Nourriture> effets) {
        super(nom, ptVie, degAtt, ptPar, pageAtt, pagePar, distAttMax, pos, effets);
    }

    /**
     *Constructeur de recopie de Paysan
     * @param perso Paysan à recopier
     */
    public Paysan(Paysan perso) {
        
        super((Personnage)perso);
    }

    /**
     *Constructeur par défaut de paysan
     */
    public Paysan() {
        super();
    }
    
}
