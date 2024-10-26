package com.mycompany.project3algo;

public class Dominion {
    private int rank;
    private Dominion parent;
    public int n;
    public int m;
    public int k;

    public Dominion(int nn, int mm, int kk){
        rank = 0;
        n = nn;
        m = mm;
        k = kk;
    }

    public Dominion getParent(){
        return parent;
    }

    public void setParent(Dominion p){
        parent = p;
    }

    public int getRank(){
        return rank;
    }
    
    public void setRank(int r){
        rank = r;
    }

}
