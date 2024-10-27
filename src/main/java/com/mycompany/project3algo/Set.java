package com.mycompany.project3algo;

/**
 * This class is the main file.
 *
 * @author Roni Ebenezer, Jonique Chan
 * @version 1.0
 * File: Set.java
 * Created: Oct 2024
 * ©Copyright Cedarville University, its Computer Science faculty, 
 * and the authors. All rights reserved.
 *
 * Description: This class contains the methods for a Disjoint Set data structure. It has a union method that takes two sets and combines them together.
 * It also has a makeSet method that creates a set given a Dominion object and a findSet method that returns the parent of a given Dominion object. 
 */

public class Set {

    // method to combine two sets together
    public static void union(Dominion x, Dominion y) {
        Dominion xparent = findSet(x);
        Dominion yparent = findSet(y);
        int xrank = xparent.getRank();
        int yrank = yparent.getRank();

        // same parent
        if (xparent == yparent) {
            return;
        }
        // different parent, check rank, choose higher rank to be parent
        if (xrank > yrank) {
            yparent.setParent(xparent);
        }
        else if (xrank < yrank) {
            xparent.setParent(yparent);
        } 
        else {
            yparent.setParent(xparent);
            xparent.setRank(xrank + 1);
        }
    }

    // method to make a set given a dominion
    public static void makeSet(Dominion dominion) {
        dominion.setParent(dominion);
        dominion.setRank(0);
    }

    // method that returns representative of a given dominion 
    public static Dominion findSet(Dominion d) {
        if(d.getParent() != d){
            d.setParent(findSet(d.getParent()));
        }
        return d.getParent();
    }
}