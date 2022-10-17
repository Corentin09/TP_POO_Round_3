/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
/**
 * Sous-classe de la classe Créature gérant les personnages du jeu World of ECN
 * @author coco
 */
public abstract class Personnage extends Creature {
    private String nom;
    private int distAttMax;


    /**
     *
     * @param nom Nom du personnage
     * @param ptVie Points de Vie du personnage
     * @param degAtt Points de dégâts infligés par une attaque
     * @param ptPar Points de dégâts évités lors d'une parade
     * @param pageAtt Pourcentage de chance de toucher avec une attaque
     * @param pagePar Pourcentage de chance de parer une attque
     * @param distAttMax Distance d'attaque maximale
     * @param pos Position du personnage
     */
    public Personnage(String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, int distAttMax, Point2D pos, Map<String, Nourriture> effets) {
        super(ptVie, degAtt, ptPar, pageAtt, pagePar, pos,effets);
        this.nom = nom;
        this.distAttMax = distAttMax;
    }
    
    /**
     *
     * @param perso Personnage à recopier
     */
    public Personnage(Personnage perso) {
        super((Creature)perso);
        this.nom = perso.nom;
        this.distAttMax = perso.distAttMax;
    }

    /**
     *
     */
    public Personnage() {
        super();
        this.nom = "Steve";
        this.distAttMax = 1;
    }

    /**
     *
     * @return le nom du personnage
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @return La distance d'attaque maximale
     */
    public int getDistAttMax() {
        return distAttMax;
    }


    

    /**
     *
     * @param nom le nom du personnage
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @param distAttMax La distance d'attaque maximale
     */
    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }


    
    /**
     *
     */
    @Override
    public void affiche() {
        super.affiche();
        System.out.println("Nom "+ nom);
        System.out.println("distAttMax "+ distAttMax);
    }
    
    
}
