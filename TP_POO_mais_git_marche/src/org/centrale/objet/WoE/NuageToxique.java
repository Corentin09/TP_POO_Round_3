/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;
import static org.centrale.objet.WoE.World.TailleMonde;

/**
 *
 * @author leo20
 */
public class NuageToxique extends Objet implements Deplacables, Combattant {
        private int toxicite;

    public NuageToxique() {
    }

    public NuageToxique(String nom, String description, Point2D pos, int toxicite) {
        super(nom, description, pos);
        this.toxicite = toxicite;
    }

    public NuageToxique(NuageToxique nt) {
        super(nt);
        this.toxicite = nt.toxicite;
    }
        

    @Override
    public void combattre(Creature c) {
        double d = this.getPos().distance(c.getPos());
        if (d>0){
            System.out.println("La créature n''est pas dans le nuage toxique et ne subit par conséquent aucun dégât");
        }
        else {
            c.setPtVie(c.getPtVie()-toxicite);
            System.out.println(c.getClass()+" respire le gaz et subit "+toxicite+" dégâts. Il lui reste "+c.getPtVie()+" points de vie");
        }
    }

    @Override
    public boolean deplace(World monde) {
        Random Alea = new Random();
        Point2D testPosition = new Point2D(pos);
        int r1 = Alea.nextInt(3)-1;
        int r2 = Alea.nextInt(3)-1;
        while ((r1 == 0) && (r2==0)) {
        r1 = Alea.nextInt(3)-1;
        r2 = Alea.nextInt(3)-1;
            }
        testPosition.Translate(r1, r2);
        for (Creature c: monde.getCrea()) {
            if (c.getPos().equals(testPosition) || Math.abs(testPosition.getX()) > TailleMonde || Math.abs(testPosition.getY()) > TailleMonde) {
                return false;
            } else {
                pos.Translate(r1, r2);
                return true;
                }
         
        }
        return false;
    }
    
}
