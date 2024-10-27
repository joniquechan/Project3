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


public class Project3Algo {
        public static void main(String[] args) {
        System.out.println("enter input: ");
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
            Stack<Monarchy> monarchies = new Stack<>();

            for (int j = 0; j < l; j++) {
                int numDominions = sc.nextInt();
                int[] dominions = new int[numDominions];

                for (int x = 0; x < numDominions; x++) {
                    dominions[x] = sc.nextInt();
                }

                monarchies.push(new Monarchy(dominions));
            }
            
            int disconnectedMonths = 0;
            int numSets = 0;

            while (!monarchies.isEmpty()) {
                Monarchy mon = monarchies.pop();
                int[] dominions = mon.getDominions();

                Dominion[] doms = new Dominion[dominions.length];
                for (int j = 0; j < dominions.length; j++) {
                    int dom = dominions[j];
                    int kk = dom / (n*m);
                    int mm = (dom % (n*m)) / n;
                    int nn = (dom % (n*m)) % n;

                    Dominion d = new Dominion(nn, mm, kk);
                    galaxy[nn][mm][kk] = d;
                    doms[j] = d;
                    Set.makeSet(galaxy[nn][mm][kk]);
                    numSets++;
                }

                for(int j = 1; j < doms.length; j++){
                    Set.union(doms[0], doms[j]);
                    numSets--;
                }
                
                //numSets++;
                
                //check neighbors and connect if necessary
                for(int j = 1; j < doms.length; j++){
                    Dominion dom = doms[j];
                    
                    //check left
                    if(dom.n > 0){
                        Dominion left = galaxy[dom.n - 1][dom.m][dom.k];
                        if(left != null && Set.findSet(left) != Set.findSet(dom)){
                            Set.union(dom, left);
                            numSets--;
                        }
                    }

                    //check right
                    if (dom.n < n - 1) {
                        Dominion right = galaxy[dom.n + 1][dom.m][dom.k];
                        if (right != null && Set.findSet(right) != Set.findSet(dom)) {
                            Set.union(dom, right);
                            numSets--;
                        }
                    }

                    //check front
                    if (dom.m > 0) {
                        Dominion front = galaxy[dom.n][dom.m - 1][dom.k];
                        if (front != null && Set.findSet(front) != Set.findSet(dom)) {
                            Set.union(dom, front);
                            numSets--;
                        }
                    }
                    //check back
                    if (dom.m < m - 1) {
                        Dominion back = galaxy[dom.n][dom.m + 1][dom.k];
                        if (back != null && Set.findSet(back) != Set.findSet(dom)) {
                            Set.union(dom, back);
                            numSets--;
                        }
                    }
                    //check up
                    if (dom.k > 0) {
                        Dominion up = galaxy[dom.n][dom.m][dom.k - 1];
                        if (up != null && Set.findSet(up) != Set.findSet(dom)) {
                            Set.union(dom, up);
                            numSets--;
                        }
                    }
                    //check down
                    if (dom.k < k - 1) {
                        Dominion down = galaxy[dom.n][dom.m][dom.k + 1];
                        if (down != null && Set.findSet(down) != Set.findSet(dom)) {
                            Set.union(dom, down);
                            numSets--;
                        }
                    }
                }

            }
            // check numSets == 1 and update months
            if (numSets > 1) {
                disconnectedMonths++;
            }

            System.out.println("disconnected months: " + disconnectedMonths);
        }

        sc.close();
    }
}
