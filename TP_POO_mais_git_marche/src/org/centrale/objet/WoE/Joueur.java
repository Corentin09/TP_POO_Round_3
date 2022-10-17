/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author coco
 */
public class Joueur {
    private String nom;
    private String login;
    private String password;
    private Personnage personnage;
    private ArrayList<Nourriture> inventaire;

    /**
     *
     * @param nom
     * @param login
     * @param password
     * @param personnage
     */
    public Joueur(String nom, String login, String password, Personnage personnage, ArrayList<Nourriture> inventaire) {
        this.nom = nom;
        this.login = login;
        this.password = password;
        this.personnage = personnage;
        this.inventaire = inventaire;
    }

    /**
     *
     * @param nom
     * @param personnage
     */
    public Joueur(String nom, Personnage personnage) {
        this.nom = nom;
        this.personnage = personnage;
        this.login = "ProXGamerdu31";
        this.password = "12345";
        this.inventaire = new ArrayList<>();
    }

    /**
     *
     * @param nom
     */
    public Joueur(String nom) {
        this.nom = nom;
        this.personnage = new Guerrier();
        this.login = "ProXGamerdu31";
        this.password = "12345";
        this.inventaire = new ArrayList<>();
    }

    /**
     *
     */
    public Joueur() {
        this.nom = "Bob";
        this.personnage = new Guerrier();
        this.login = "ProXGamerdu31";
        this.password = "12345";
        this.inventaire = new ArrayList<>();
    }
    
    /**
     *
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @return
     */
    public String getLogin() {
        return login;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @return
     */
    public Personnage getPersonnage() {
        return personnage;
    }

    public ArrayList<Nourriture> getInventaire() {
        return inventaire;
    }
    
    

    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @param login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @param personnage
     */
    public void setPersonnage(Personnage personnage) {
        this.personnage = personnage;
    }

    public void setInventaire(ArrayList<Nourriture> inventaire) {
        this.inventaire = inventaire;
    }
    
    
    
    /**
     *
     */
    public void choixPerso() {
        Scanner sc;
        sc = new Scanner(System.in);
        Random alea = new Random();
        System.out.println("Choisissez votre classe de personnage");
        String cPerso = sc.nextLine();
        System.out.println("Choisissez votre nom de personnage");
        String cNom = sc.nextLine();
        Map<String,Nourriture> effets = new HashMap<>();
        switch(cPerso) {
            case "Guerrier":
                int pv = alea.nextInt(100,151);
                int degAtt = alea.nextInt(20,31);
                int ptPar = alea.nextInt(15,26);
                int pageAtt = alea.nextInt(50,81);
                int pagePar = alea.nextInt(30,51);
                int distAttMax = 1;
                Point2D pos = new Point2D(0,0);
                this.personnage = new Guerrier(cNom,pv,degAtt,ptPar,pageAtt,pagePar,distAttMax,pos, effets);
                break;
            case "Archer":
                int pvArcher = alea.nextInt(5,101);
                int degAttArcher = alea.nextInt(5,16);
                int ptParArcher = alea.nextInt(10,20);
                int pageAttArcher = alea.nextInt(60,91);
                int pageParArcher = alea.nextInt(40,61);
                int distAttMaxArcher = alea.nextInt(3,8);
                Point2D posArcher = new Point2D(0,0);
                int fleche = alea.nextInt(10,21);
                this.personnage = new Archer(fleche, cNom,pvArcher,degAttArcher,ptParArcher,pageAttArcher,pageParArcher,distAttMaxArcher,posArcher, effets);
                break;
            case "Mage":
                int pvMage = alea.nextInt(40,76);
                int degAttMage = alea.nextInt(20,51);
                int ptParMage = alea.nextInt(5,11);
                int pageAttMage = alea.nextInt(50,76);
                int pageParMage = alea.nextInt(10,21);
                int distAttMaxMage = alea.nextInt(1,6);
                Point2D posMage = new Point2D(0,0);
                int mana = alea.nextInt(75,126);
                this.personnage = new Mage(mana, cNom,pvMage,degAttMage,ptParMage,pageAttMage,pageParMage,distAttMaxMage,posMage, effets);
                break;
            default :
                int pvg = alea.nextInt(100,151);
                int degAttg = alea.nextInt(20,31);
                int ptParg = alea.nextInt(15,26);
                int pageAttg = alea.nextInt(50,81);
                int pageParg = alea.nextInt(30,51);
                int distAttMaxg = 1;
                Point2D posg = new Point2D(0,0);
                this.personnage = new Guerrier(cNom,pvg,degAttg,ptParg,pageAttg,pageParg,distAttMaxg,posg, effets);
                break;
  
        }
        
    }
    
    public void affiche_inventaire() {
        System.out.println("L'inventaire du joueur contient :");
        int k = 0;
        for (Nourriture o: this.inventaire) {
            k+=1;
            System.out.println("Objet" + k + ": " +o.nom);
        }
    }
    
    
    
    
    
}
