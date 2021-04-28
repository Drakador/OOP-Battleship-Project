/*
Kim Johnson
April 2021

 */

package com.company;

import java.util.*;

public class Player {

    public String name = "";

    public Player() {
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = "Player One";
    }

    public boolean isHuman() {
        return true;
    }


    // Method checks user input for Letter (row) for attack
    public boolean validLetter(String letter) {
        // List of acceptable letters: A-J
        ArrayList<String> letterList = new ArrayList<String>(10);

        // list contains 10 elements, Letters A-J
        letterList.add("A");
        letterList.add("B");
        letterList.add("C");
        letterList.add("D");
        letterList.add("E");
        letterList.add("F");
        letterList.add("G");
        letterList.add("H");
        letterList.add("I");
        letterList.add("J");

        // returns true is number from input is found in number list
        boolean validLetter = letterList.contains(letter);

        return validLetter;
    }

    // Method checks user input for Number (column) for attack. Must be a number
    // between 1-10
    public boolean validNumber(Integer number) {
        boolean numberInRange = false;
        int minValue = 1;
        int maxValue  = 10;

        if (number >= minValue && number <= maxValue){
            numberInRange = true;
        }

        return numberInRange;
    }
}







