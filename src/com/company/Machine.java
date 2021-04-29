/*
Kim Johnson
*/

package com.company;
import java.util.Arrays;
import java.util.List;

public class Machine extends Player{
    private int[][] shotTracker;

    public Machine(String name) {
        this.shotTracker = shotTracker();
        this.name = name;
        System.out.println("Computer Player has been created");
    }

    // No Args Constructor
    public Machine() {

    }

    // Overrides and sets  isHuman boolean to False
    @Override
    public boolean isHuman() {
        return false;
    }

    /*
     Creates 10x10 array of 2's for shot tracking
     2's change to 0's when shots fired in that location
     *** This needs to be called once in Main Method for
     AI shot tracking.
    */

    public int[][] shotTracker() {
        // initialize array
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

    public Boolean fireAtHumanShips(int[][] shotTracker, Board human) {
        int row, col;
        int squareValue;
        Boolean hit = false;
        int shotFired = 1;


        // This loop will continue to create a random row and column guess while
        // the random coordinates on the machine strike board are not empty.

        do {
            row = (int) (Math.random() * 10);
            col = (int) (Math.random() * 10);
            squareValue = getElement(shotTracker, row,col);
            System.out.println(getElement(shotTracker, row,col));


        } while(squareValue != 2);

        String letter = convertRow(row);
        hit = human.attack(letter,col);
        setElement(shotTracker, row,col);
        System.out.println(getElement(shotTracker, row,col));

        // Returns new guess coordinates that will be used to pass through randomStrike() method.
        return hit ;
    }

    /*
    This method is used by the fireAtHumanShips() method. It passes through the validated random
    row(x) and column(y) and returns the value of square of those coordinates to a variable. All square
    that equal 2 have not been fired at yet. If not a 2, then fireAtHumanShips() will loop until it
    gets coordinates that equal 2.
    */
    private int getElement(int[][] coordinates, int row, int col) {
        return coordinates[row][col];
    }

    /*
    setElement() is used by fireAtHumanShips().
    This method sets XY guess coordinates (individual square) of XY ai shot array to a value of 1.
    This makes the guess coordinate unavailable for being fired at again erroneously by the AI as the AI checks
    coordinates to be equal to 2 (the Array default) before allowing a shot to be fired.
     */
    private void setElement(int[][] coordinates, int row, int col) {
            int squareValue = 1;
        coordinates[row][col] = squareValue;
    }

    /*
    Converts row value of new guess to a letter (A-J). This will be used in the main
    method after calling machinePlayerFire(); String rowLetterGuess = convertGuessRow(newGuess);
    Then int colNumberGuess = newGuess[1]; Then use attack class from Board class:
    attack(rowLetterGuess, colNumberGuess);
     */
    public String convertRow(int row) {
        String rowToLetter = String.valueOf(row);

        switch (rowToLetter) {
            case "0" -> rowToLetter = "A";
            case "1" -> rowToLetter = "B";
            case "2" -> rowToLetter = "C";
            case "3" -> rowToLetter = "D";
            case "4" -> rowToLetter = "E";
            case "5" -> rowToLetter = "F";
            case "6" -> rowToLetter = "G";
            case "7" -> rowToLetter = "H";
            case "8" -> rowToLetter = "I";
            case "9" -> rowToLetter = "J";
        }
        return rowToLetter.toUpperCase();
    }
}

