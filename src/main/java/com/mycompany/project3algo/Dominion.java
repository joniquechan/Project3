package com.mycompany.project3algo;

/**
 * This class is the main file.
 *
 * @author Roni Ebenezer, Jonique Chan
 * @version 1.0
 * File: Dominion.java
 * Created: Oct 2024
 * ©Copyright Cedarville University, its Computer Science faculty, 
 * and the authors. All rights reserved.
 *
 * Description: This class is for the Dominion object where it contains a constructor that initializes the coordinates of a dominion as well as its rank. 
 * It also contains getters and setters for its parent and rank.
 *  
 */

public class Dominion {
    
    private int rank;
    private Dominion parent;
    // coordinates
    public int n;
    public int m;
    public int k;

    // constructor 
    public Dominion(int nn, int mm, int kk){
        rank = 0;
        n = nn;
        m = mm;
        k = kk;
    }

    // method to return parent of a dominion 
    public Dominion getParent(){
        return parent;
    }

    // method to set parent of a dominion
    public void setParent(Dominion p){
        parent = p;
    }

    // method to get rank of a dominion
    public int getRank(){
        return rank;
    }
    
    // method to set rank of a dominion
    public void setRank(int r){
        rank = r;
    }

}
