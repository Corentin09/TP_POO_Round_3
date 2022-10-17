/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
 *CLasse permettant de gérer la création du monde ainsi, que l'emplacement des différentes entités
 * @author leo20
 */
public class World {
	/*Archer robin;
	Paysan peon;
	Lapin bugs1;
	Lapin bugs2;
	Guerrier grosBill;
	Loup wolfie;*/

    /**
     *
     */

    private ArrayList<Creature> crea;

    /**
     *
     */
    public ArrayList<PotionSoin> potion;
 
    /**
     *
     */
    public ArrayList<Epee> sword; 
    
    private Joueur player;

    /**
     *
     */
    public static final int TailleMonde = 50;
    
    /**
     *Constructeur par défaut de World
     */
    public World() {
    	/*this.robin = new Archer();
    	this.peon = new Paysan();
    	this.bugs1 = new Lapin();
    	this.bugs2 = new Lapin();
    	this.grosBill = new Guerrier();
    	this.wolfie = new Loup();*/
        crea = new ArrayList<>();
        sword = new ArrayList<>();
        potion = new ArrayList<>();
        Archer robin = new Archer();
    	Paysan peon = new Paysan();
    	Lapin bugs1 = new Lapin();
    	Guerrier grosBill = new Guerrier();
    	Loup wolfie = new Loup();
        crea.add(robin);
    	crea.add(peon);
    	crea.add(bugs1);
    	crea.add(grosBill);
    	crea.add(wolfie);
        PotionSoin ps = new PotionSoin();
        Epee epee = new Epee();
        potion.add(ps);
        sword.add(epee);
        player = new Joueur();
	}

    /**
     *
     * @param crea
     * @param potion
     * @param sword
     */
    public World(ArrayList<Creature> crea, ArrayList<PotionSoin> potion, ArrayList<Epee> sword) {
        this.crea = crea;
        this.potion = potion;
        this.sword = sword;
        player = new Joueur();
    }
    
    /**
     *
     * @param nbrPerso
     * @param nbrMonstre
     * @param nbrObjet
     */
    public World(int nbrPerso, int nbrMonstre, int nbrObjet) {
        crea = new ArrayList<>();
        sword = new ArrayList<>();
        potion = new ArrayList<>();
        Random alea = new Random();
        int nbrPaysan =  alea.nextInt(nbrPerso+1);
        nbrPerso = nbrPerso - nbrPaysan;
        int nbrArcher = alea.nextInt(nbrPerso + 1);
        nbrPerso = nbrPerso - nbrArcher;
        int nbrGuerrier = alea.nextInt(nbrPerso + 1);
        nbrPerso = nbrPerso - nbrGuerrier;
        int nbrMage = nbrPerso;
        int nbrLapin = alea.nextInt(nbrMonstre+1);
        nbrMonstre = nbrMonstre - nbrLapin;
        int nbrLoup = nbrMonstre;
        int nbrSoin = alea.nextInt(nbrObjet+1);
        nbrObjet = nbrObjet - nbrSoin;
        int nbrEpee = nbrObjet;
        for (int i=0; i<=nbrGuerrier;i++) {
            this.crea.add(new Guerrier());
        }
        for (int i=0; i<=nbrArcher;i++) {
            this.crea.add(new Archer());
        }
        for (int i=0; i<=nbrPaysan;i++) {
            this.crea.add(new Paysan());
        }
        for (int i=0; i<=nbrMage;i++) {
            this.crea.add(new Mage());
        }
        for (int i=0; i<=nbrLapin;i++) {
            this.crea.add(new Lapin());
        }
        for (int i=0; i<=nbrLoup;i++) {
            this.crea.add(new Loup());
        }
        for (int i=0; i<=nbrSoin;i++) {
            this.potion.add(new PotionSoin());
        }
        for (int i=0; i<=nbrEpee;i++) {
            this.sword.add(new Epee());
        }
        player = new Joueur();
    }

    /**
     *
     * @return
     */
    public ArrayList<Creature> getCrea() {
        return crea;
    }

    /**
     *
     * @return
     */
    public ArrayList<PotionSoin> getPotion() {
        return potion;
    }

    /**
     *
     * @return
     */
    public ArrayList<Epee> getSword() {
        return sword;
    }

    /**
     *
     * @return
     */
    public Joueur getPlayer() {
        return player;
    }
    
    
       
    
    /**
     *Méthode permettant d'initialiser les positions des objets dans le monde
     */
    public void creerMondeAlea() {
    	Random alea = new Random();
    	int nombre_crea = crea.size();
    	ArrayList<Point2D> vu = new ArrayList<>();
    	for (int i = 0 ; i < nombre_crea ; i++){
        	crea.get(i).getPos().setPosition(alea.nextInt(2*TailleMonde+1)-TailleMonde,alea.nextInt(2*TailleMonde+1)-TailleMonde);
        	while (vu.contains(crea.get(i).getPos())) {
                    crea.get(i).getPos().setPosition(alea.nextInt(2*TailleMonde+1)-TailleMonde,alea.nextInt(2*TailleMonde+1)-TailleMonde);
        	}
        	vu.add(crea.get(i).getPos());
    	}
        int nombre_potion = potion.size();
    	ArrayList<Point2D> vu_potion = new ArrayList<>();
    	for (int i = 0 ; i < nombre_potion ; i++){
        	potion.get(i).getPos().setPosition(alea.nextInt(2*TailleMonde+1)-TailleMonde,alea.nextInt(2*TailleMonde+1)-TailleMonde);
        	while (vu_potion.contains(potion.get(i).getPos())) {
                    potion.get(i).getPos().setPosition(alea.nextInt(2*TailleMonde+1)-TailleMonde,alea.nextInt(2*TailleMonde+1)-TailleMonde);
        	}
        	vu_potion.add(potion.get(i).getPos());
    	}
        int nombre_sword = sword.size();
    	ArrayList<Point2D> vu_sword = new ArrayList<>();
    	for (int i = 0 ; i < nombre_sword ; i++){
        	sword.get(i).getPos().setPosition(alea.nextInt(2*TailleMonde+1)-TailleMonde,alea.nextInt(2*TailleMonde+1)-TailleMonde);
        	while (vu_potion.contains(sword.get(i).getPos())) {
                    sword.get(i).getPos().setPosition(alea.nextInt(2*TailleMonde+1)-TailleMonde,alea.nextInt(2*TailleMonde+1)-TailleMonde);
        	}
        	vu_sword.add(sword.get(i).getPos());
    	}
	}
    
    /**
     *Affiche les entités présentes dans le monde
     */
    public void affiche() {
        int nombre_crea = crea.size();
        for (int i = 0 ; i < nombre_crea ; i++){
            crea.get(i).affiche();
        }
        int nombre_potion = potion.size();
        for (int i = 0 ; i < nombre_potion ; i++){
            potion.get(i).affiche();
        }
        int nombre_sword = sword.size();
        for (int i = 0 ; i < nombre_sword ; i++){
            sword.get(i).affiche();
        }
        
    }
    
    /**
     *Applique l'effet des potions de soin
     */
    public void soigne(){
    	ArrayList<Integer> a_supprimer = new ArrayList<>();
    	for (int i = 0 ; i < potion.size() ; i++){
        	for (int j = 0; j < crea.size(); j++){
                    if (crea.get(j).getPos().equals(potion.get(i).getPos())){
                	crea.get(j).setPtVie(crea.get(j).getPtVie() + potion.get(i).getValeur_soin());
                	a_supprimer.add(i);
                    }
        	}
    	}
        
            for (int k = 0; k < potion.size(); k++) {
                if (a_supprimer.contains(k)){
                    potion.set(k, null);
                }
            }
    }
    
    /**
     * Vérifie que deux créatures ne soient pas sur la même case et les déplace dans le cas échéant
     */
    /*public void check_position() {
        ArrayList<Point2D> listPositionVu = new ArrayList<>();
        for (Creature c : crea) {
            while (listPositionVu.contains(c.getPos()) || Math.abs(c.getPos().getX()) > 50 || Math.abs(c.getPos().getY()) > 50) {
                c.deplace();
            }
            listPositionVu.add(c.getPos());
        }
        
    }*/
    
    /**
     *
     * @param tourJeu
     */
    public void tour_de_jeu(int tourJeu) {
        
        for (int i=0; i <= tourJeu; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Tour " + i);
            for (String s: player.getPersonnage().getEffets().keySet()) {
                int t=player.getPersonnage().getEffets().get(s).getNbToursEffet();
                if ((t-1) > 0 ) {
                    player.getPersonnage().getEffets().get(s).setNbToursEffet(t-1);
                } else {
                    player.getPersonnage().getEffets().remove(s);
                }
            }
            System.out.println("Le joueur est en position : X = " + player.getPersonnage().getPos().getX() + " et Y = " + player.getPersonnage().getPos().getY());
            affiche_world_visible(player.getPersonnage().getPos(),Math.max(player.getPersonnage().getDistAttMax(),10));
            System.out.println("Choisissez une action");
            String action = sc.nextLine();
            switch (action) {
                case "deplace":
                    boolean testPos = false;
                    while (!testPos) {
                        testPos = deplaceJoueur();
                    }
                    break;
                case "utiliser":
                    player.affiche_inventaire();
                    System.out.println("Choisissez un objet à utiliser :");
                    System.out.println("Choisissez 0 pour ne rien faire");
                    int objetConsomme = sc.nextInt();
                    if (objetConsomme > 0 || objetConsomme <= player.getInventaire().size()) {
                    player.getInventaire().get(objetConsomme - 1).est_utilise(player.getPersonnage());
                    player.getInventaire().remove(objetConsomme - 1);
                    }
                    break;
                    
                case "combattre":
                    int k = 0;
                    int j = -1;
                    ArrayList<Integer> indiceCrea = new ArrayList<>();
                    System.out.println("Les créatures à portée d'attaque sont :");
                    for (Creature c: crea) {
                        j += 1;
                        if (c.getPos().distance(player.getPersonnage().getPos()) <= player.getPersonnage().getDistAttMax()) {
                            k += 1;
                            System.out.println("Créature " + k);
                            c.affichePertinent();
                            indiceCrea.add(j);
                        }
                        
                    }
                    if (k != 0) {
                        System.out.println("Choisissez une créature à combattre");
                        int creaCombattu = sc.nextInt();
                        Personnage perso = player.getPersonnage();
                        ((Combattant)perso).combattre(crea.get(indiceCrea.get(k-1)));
                        break;
                    } else {
                        System.out.println("Pas de créature à portée");
                        break;
                    }
                    
                default :
                    player.getPersonnage().affiche();
                    break;
        }
            for (Creature c : crea) {
                c.deplace(this);
            }
        
    }
    }
    
    /**
     *
     */
    public void affiche_world() {
        
    }
    
    /**
     *
     * @return
     */
    public boolean deplaceJoueur() {
        Scanner sc = new Scanner(System.in);
        int x = 0;
        int y = 0;
        Point2D testPosition = new Point2D(player.getPersonnage().getPos());
        Point2D pos = player.getPersonnage().getPos();
        System.out.println("Rentrez une direction");
        String direction = sc.nextLine();
        switch (direction) {
            case "N":
                y = 1;
                break;
            case "NE":
                x = 1;
                y = 1;
                break;
            case "E":
                x = 1;
                break;
            case "SE":
                x = 1;
                y = -1;
                break;
            case "S":
                y = -1;
                break;
            case "SO":
                x = -1;
                y = -1;
                break;
            case "O":
                x = -1;
                break;
            case "NO":
                x = -1;
                y = 1;
                break;
            default:
                return false;
             
        }
        testPosition.Translate(x, y);
        for (Creature c: crea) {
            if (c.getPos().equals(testPosition) || Math.abs(testPosition.getX()) > TailleMonde || Math.abs(testPosition.getY()) > TailleMonde) {
                return false;
            } else {
                player.getPersonnage().getPos().Translate(x, y);
                return true;
                }
            
        } 
        return false;
    }
    
    /**
     *
     * @param pos
     * @param distAffichage
     */
    public void affiche_world_visible(Point2D pos, int distAffichage) {
        for (Creature c : crea) {
            if (c.getPos().distance(pos) <= distAffichage) {
                c.affichePertinent();
            }
        }
        for (Epee c : sword) {
            if (c.getPos().distance(pos) <= distAffichage) {
                c.affiche();
            }
        }
        for (PotionSoin c : potion) {
            if (c.getPos().distance(pos) <= distAffichage) {
                c.affiche();
            }
        }
        
    }
    
    /**
     * Affiche les différents types de protagonistes présents dans le monde
     */
    public void affiche_protagoniste() {
        int p = 0;
        int g = 0;
        int l = 0;
        int a = 0;
        int lo = 0;
        for (Creature c : crea) {
            if ("org.centrale.objet.WoE.Paysan".equals(c.getClass().getName())) {
                p += 1;
            }
            if ("org.centrale.objet.WoE.Loup".equals(c.getClass().getName())) {
                lo += 1;
            }
            if ("org.centrale.objet.WoE.Guerrier".equals(c.getClass().getName())) {
                g += 1;
            }
            if ("org.centrale.objet.WoE.Archer".equals(c.getClass().getName())) {
                a += 1;
            }
            if ("org.centrale.objet.WoE.Lapin".equals(c.getClass().getName())) {
                l += 1;
            }
        }
            System.out.println("Le monde contient " + g + " Guerriers");
            System.out.println("Le monde contient " + a + " Archers");
            System.out.println("Le monde contient " + p + " Paysans");
            System.out.println("Le monde contient " + l + " Lapins");
            System.out.println("Le monde contient " + lo + " Loups");
        
    }
}

