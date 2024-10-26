package com.mycompany.project3algo;

public class Set {
    
    private int[] parent;
    private int[] size;
    private int[] rank;
    private int sets;

    // constructor for initializing array?
    public Set(int dominions) {

    }

    public static void union(Dominion x, Dominion y) {
        // pick new representative from one
        // connect two sets by rank
        // sets--
        Dominion xparent = findSet(x);
        Dominion yparent = findSet(y);
        int xrank = xparent.getRank();
        int yrank = yparent.getRank();

        if(xparent.getRank() >= yparent.getRank()){
            yparent.setParent(xparent);
            if(xrank == yrank){
                xparent.setRank(xrank + 1);
            }

        }
        else{
            xparent.setParent(yparent);
            if(xrank == yrank){
                yparent.setRank(yrank + 1);
            }
        }
    }

    public static void makeSet(Dominion dominion) {
        // create set for dominion
        // check if alr in a set -> check neighbors (helper function??)
        // sets++
        // return set
        dominion.setParent(dominion);
    }

    public static Dominion findSet(Dominion d) {
        // path compression
        // return representative
        if(d.getParent() != d){
            d.setParent(findSet(d.getParent()));
        }
        return d.getParent();
    }

    // remove dominion from empire
    public void remove(int dominion) {

    }

    public boolean isConnected() {
        return sets == 1;
    }
    // representative
    // makeArray
    // makeSet <- sets +1
    // findSet
    // checkneighbors 
    // bool isConnected
    // if not connected months++
}