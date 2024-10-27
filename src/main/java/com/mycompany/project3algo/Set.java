package com.mycompany.project3algo;

public class Set {

    public static void union(Dominion x, Dominion y) {
        Dominion xparent = findSet(x);
        Dominion yparent = findSet(y);
        int xrank = xparent.getRank();
        int yrank = yparent.getRank();

        // same parent
        if (xparent == yparent) {
            return;
        }
        // different parent, check rank
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

    public static void makeSet(Dominion dominion) {
        dominion.setParent(dominion);
        dominion.setRank(0);
    }

    public static Dominion findSet(Dominion d) {
        // path compression
        // return representative
        if(d.getParent() != d){
            d.setParent(findSet(d.getParent()));
        }
        return d.getParent();
    }
}