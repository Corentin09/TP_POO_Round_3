/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author coco
 */
public class Potion extends Objet {

    /**
     *
     */
    public Potion() {
        super();
    }

    /**
     *
     * @param nom
     * @param description
     * @param pos
     */
    public Potion(String nom, int prix_achat, int prix_vente, String description, Point2D pos) {
        super(nom, description, pos);
    }

    /**
     *
     * @param p
     */
    public Potion(Potion p) {
        super((Objet)p);
    }
    
    

    
    
    
}
