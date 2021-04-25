package com.company;
import java.lang.reflect.Array;
import java.util.Arrays;

public class MachinePlay {
    /*
     Creates 10x10 array of 2's for shot tracking
     2's change to 0's when shots fired in that location
     *** This needs to be called once in Main Method for
     AI shot tracking.
    */
    public int[][] machineShotArray() {

        int[][] shotTracker = new int[10][10];
        for (int i = 0; i < 10; i++) {
            shotTracker[i] = new int[] { 2,2,2,2,2,2,2,2,2,2 };
        }
        return shotTracker;
    }

    /*
    Method for machine player attack. Gets random coordinates and
    updates machine shot array. Returns coordinates to use for attack
    method in board class.
     */
    public int[][] machinePlayerFire(int[][] machineShotArray) {
        int[][] newGuess;
        newGuess = validStrike(machineShotArray);
        fireShot(machineShotArray, newGuess);

        return newGuess;
    }

    public int[][] validStrike(int[][] machineShotArray) {
        int zero = 0;
        int[][] randomGuess = new int[1][1];
        int coordinateValue = 1;

        // This loop will continue to create a random row and column guess while
        // the random coordinates on the machine strike board are not empty.

        do {
            int[] row = {(int) (Math.random() * 10)};
            int[] col = {(int) (Math.random() * 10)};
            randomGuess[0] = row;
            randomGuess[1] = col;

            coordinateValue = Array.getInt(machineShotArray, randomGuess[0][1]);

        } while(coordinateValue != 2);

        // Returns new guess coordinates that will be used to pass through randomStrike() method.
        return randomGuess;
    }


    /*
    This method sets XY guess coordinates to XY machine array coordinates so that they
    can be changed from 2 to 1 on the  machine array. This makes the guess coordinate
    unavailable for being fired at again erroneously by the AI as the AI checks
    coordinates to be equal to 2 (the Array default) before allowing a shot to be fired.
     */
    public void fireShot(int[][] machineShotArray, int[][] guess){

        int[] arrayValue = {1};

        machineShotArray[0][1] = guess[0][1];
        machineShotArray[0] = arrayValue;
        machineShotArray[1] = arrayValue;

    }

    /*
    Converts row value of new guess to a letter (A-J). This will be used in the main
    method after calling machinePlayerFire(); String rowLetterGuess = convertGuessRow(newGuess);
    Then int colNumberGuess = newGuess[1]; Then use attack class from Board class:
    attack(rowLetterGuess, colNumberGuess);
     */
    public String convertGuessRow(int[][] newGuess) {
        String letterRow = String.valueOf(newGuess[0]);

        switch (letterRow) {
            case "0" -> letterRow = "A";
            case "1" -> letterRow = "B";
            case "2" -> letterRow = "C";
            case "3" -> letterRow = "D";
            case "4" -> letterRow = "E";
            case "5" -> letterRow = "F";
            case "6" -> letterRow = "G";
            case "7" -> letterRow = "H";
            case "8" -> letterRow = "I";
            case "9" -> letterRow = "J";
        }
        return letterRow.toUpperCase();
    }
}

