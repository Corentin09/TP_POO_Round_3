/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Arrays;

/**
 *
 * @author coco
 */
public class TestPoint2D {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Point2D p = new Point2D(5,5);
        Point2D p2 = new Point2D();
        
        Point2D p3 = new Point2D(p);
        System.out.println(p.getX());
        System.out.println(p.getY());
        
        System.out.println(p2.getX());
        System.out.println(p2.getY());
        
        System.out.println(p3.getX());
        System.out.println(p3.getY());
        
        p.setX(30);
        
        System.out.println(Arrays.toString(p.GetPosition()));
        System.out.println(Arrays.toString(p3.GetPosition()));
        
        p2.setPosition(5, 0);
        System.out.println(Arrays.toString(p2.GetPosition()));
        
        p2.Translate(10, -20);
        System.out.println(Arrays.toString(p2.GetPosition()));
        
        p2.setPosition(0, 0);
        
        p.setPosition(5,0);
        double d = p.distance(p2);
        System.out.println(d);
    }
}
