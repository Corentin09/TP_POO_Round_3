/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Arrays;

/**
 *Classe gérant les objets
 * @author leo20
 */
public class Objet {
	String nom;
	String description;
        Point2D pos;

    /**
     *Constructeur d'objet
     * @return
     */


    /**
     *
     * @return
     */
    public String getNom() {
    	return nom;
	}

    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
    	this.nom = nom;
	}


    public String getDescription() {
    	return description;
	}

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
    	this.description = description;
	}

    /**
     *
     * @return
     */
    public Point2D getPos() {
        return pos;
    }

    /**
     *
     * @param pos
     */
    public void setPos(Point2D pos) {
        this.pos = new Point2D(pos);
    }
    
    

    /**
     *Constructeur par défaut d'objet
     */
    public Objet() {
   	 this.nom = "Objet Random";
         this.description = "Ceci est un objet random, et par conséquent, possède une utilité nulle";
         this.pos = new Point2D(0,0);
	}

    /**
     *Constructeur
     * @param nom Nom de l'objet
     * @param prix_achat Prix à l'achat de l'objet
     * @param prix_vente Prix à la vente de l'objet
     * @param description Description de l'objet
     * @param pos
     */
    public Objet(String nom, String description, Point2D pos) {
    	this.nom = nom;
    	this.description = description;
        this.pos = new Point2D(pos);
	}
    
    /**
     *Constructeur de recopie
     * @param o Objet à recopier
     */
    public Objet(Objet o) {
    	this.nom = o.nom;
    	this.description = o.description;
        this.pos = new Point2D(o.pos);
	}
    
    
    /**
     * Permet d'afficher les attributs correspondant à la créature
     */
    public void affiche() {
        Class nclasse = this.getClass();
        System.out.println("La classe est : "+ nclasse.getName());
        System.out.println("Nom "+ nom);
        System.out.println("Description "+ description);
        System.out.println("Position " + Arrays.toString(pos.GetPosition()));
    }
}
