package com.mycompany.project3algo;

/**
 * This class is the main file.
 *
 * @author Roni Ebenezer, Jonique Chan
 * @version 1.0
 * File: Monarchy.java
 * Created: Oct 2024
 * ©Copyright Cedarville University, its Computer Science faculty, 
 * and the authors. All rights reserved.
 *
 * Description: This class is for the Monarchy object. It contains a constructor that holds an array of dominion values and a getter that returns the dominions of the 
 * Monarchy. 
 */

public class Monarchy {
    private int[] dominions;

    // constructor
    public Monarchy(int[] d) {
        dominions = d;
    }

    // method to get dominions in the monarchy
    public int[] getDominions() {
        return dominions;
    }
}
