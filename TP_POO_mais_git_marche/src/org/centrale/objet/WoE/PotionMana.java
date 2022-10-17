/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author coco
 */
public class PotionMana extends Potion{
   int valeurMana;

    /**
     *Constructeur de PotionSoin
     * @param valeurMana
     * @param nom Nom de l'objet
     * @param prix_achat Prix à l'achat de l'objet
     * @param prix_vente Prix à la vente de l'objet
     * @param description Description de l'objet
     * @param pos
     */
    public PotionMana(int valeurMana, String nom, int prix_achat, int prix_vente, String description, Point2D pos) {
        super(nom, prix_achat, prix_vente, description, pos);
        this.valeurMana = valeurMana;
    }

    /**
     *Constructeur par défaut
     */
    public PotionMana() {
        super();
        this.valeurMana = 1000000000;
    }

    /**
     *Constructeur de recopie
     * @param o Potion à recopier
     */
    public PotionMana(PotionMana o) {
        super((Potion)o);
        this.valeurMana = o.valeurMana;
    }
    
    /**
     *
     * @return
     */
    public int getValeurMana() {
        return valeurMana;
    }

    /**
     *
     * @param valeurMana
     */
    public void setValeurMana(int valeurMana) {
        this.valeurMana = valeurMana;
    }
    
    /**
     *Fonction d'affichage pour PotionSoin
     */
    @Override
    public void affiche() {
        super.affiche();
        System.out.println("La potion rend " + valeurMana + " points de mana");
    }


} 

