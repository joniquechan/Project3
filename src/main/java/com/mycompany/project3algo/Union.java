package com.mycompany.project3algo;

public class Union {
    
    private int[] parent;
    private int[] size;
    private int[] rank;
    private int sets;

    // constructor for initializing array?
    public Union(int dominions) {

    }

    public static void Union(int x, int y) {
        // pick new representative from one
        // connect two sets by rank
        // sets--
    }

    public static void makeSet(int dominion) {
        // create set for dominion
        // check if alr in a set -> check neighbors (helper function??)
        // sets++
        // return set
    }

    public static void findSet(int dominion) {
        // path compression
        // return representative
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