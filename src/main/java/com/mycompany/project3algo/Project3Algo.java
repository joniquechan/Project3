/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.project3algo;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author User
 */

 // !! todo:
 // - parse input
 // - unionfind 
 // - objects

public class Project3Algo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // problem instances
        int problems = sc.nextInt();

        for (int i = 0; i < problems; i++) {
            // 3d array dimensions
            int n = sc.nextInt(); 
            int m = sc.nextInt(); 
            int k = sc.nextInt();

            // num of independent monarchies
            int l = sc.nextInt();

            // initialize array
            Dominion[][][] galaxy = new Dominion[n][m][k]; 

            // store monarchies as objects and process in reverse order to make them grow
            // should we use a stack or a list
            Stack<Monarchy> monarchies = new Stack<>();

            for (int j = 0; j < l; j++) {
                int numDominions = sc.nextInt();
                int[] dominions = new int[numDominions];

                for (int x = 0; x < numDominions; x++) {
                    dominions[x] = sc.nextInt();
                    //Set.makeSet(dominions[x]);
                }

                monarchies.push(new Monarchy(dominions));
            }
            
            int disconnectedMonths = 0;
            int numSets = 0;
            while(!monarchies.empty()){
                Monarchy mon = monarchies.pop();
                int[] dominions = mon.getDominions();

                Dominion[] doms = new Dominion[dominions.length];
                for(int j = 0; j < dominions.length; j++){
                    int dom = dominions[j];
                    int nn = dom / (n*m);
                    int mm = (dom % n*m) / n;
                    int kk = (dom % n*m) % n;

                    Dominion d = new Dominion(nn, mm, kk);
                    galaxy[nn][mm][kk] = d;
                    doms[j] = d;
                    Set.makeSet(galaxy[nn][mm][kk]);
                }

                for(int j = 1; j < doms.length; j++){
                    Set.union(doms[0], doms[j]);
                }
                numSets++;
                
                //check neighbors and connect if necessary
                for(int j = 1; j < doms.length; j++){
                    Dominion dom = doms[j];
                    //check left
                    if(dom.n != 0){
                        Dominion left = galaxy[dom.n - 1][dom.m][dom.k];
                        if(left != null){
                            if(Set.findSet(left) != Set.findSet(dom)){
                                Set.union(dom, left);
                                numSets --;
                            }
                        }
                    }
                    //check right
                    //check front
                    //check back
                    //check up
                    //check down
                }

            }
            // check numSets == 1 and update months
        }

        sc.close();
    }
}
