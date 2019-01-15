package com.dice;

import java.util.Random;

public  class Dice {

    private int noOfSide;
    private int value;
    
    public Dice(int numberOfSides) {
        noOfSide=numberOfSides;
    }
            
    public int getValue() {
        return value;
 }

 public void roll() {
     //I am not sure how to structure this section
     Random rand = new Random();
     value = rand.nextInt(noOfSide) + 1;
 }
}
