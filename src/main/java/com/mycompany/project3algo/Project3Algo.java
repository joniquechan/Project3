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
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int l = sc.nextInt();

            // initialize array

            // store dominions
            Stack<int[]> monarchies = new Stack<>();

            for (int j = 0; j < l; j++) {
                int numDominions = sc.nextInt();
                int[] dominions = new int[numDominions];

                for (int x = 0; x < numDominions; x++) {
                    dominions[x] = sc.nextInt();
                }

                monarchies.push(dominions);
            }
            
        }
    }
}
