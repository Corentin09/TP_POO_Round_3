/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Map;

/**
 * Sous-classe de Monstre gérant les lapins
 * @author coco
 */
public class Lapin extends Monstre{

    /**
     * Constructeur de Lapin
     * @param ptVie Point de vie du lapin
     * @param degAtt Dégâts d'attaque du lapin
     * @param ptPar Points de parade du lapin
     * @param pageAtt Pourcentage de chance de toucher avec une attaque
     * @param pagePar Pourcentage de chance de parer une attaque
     * @param pos Position du lapin
     * @param effets
     */
    public Lapin(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos, Map<String, Nourriture> effets) {
        super(ptVie, degAtt, ptPar, pageAtt, pagePar, pos, effets);
    }

    /**
     *Constructeur par défaut de Lapin
     */
    public Lapin() {
        super();
    }

    /**
     *Constructeur de recopie de Lapin
     * @param m Lapin à recopier
     */
    public Lapin(Lapin m) {
        super(m);
    }
   
    
}
