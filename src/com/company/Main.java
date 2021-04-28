/*
* Creators:
*   Joshua Belfor
*   Kim Johnson
*   Aaron Skonieczny
*   Muhammad Ashfaq
*
*/


package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        String xCoordinate = "";
        int aiHits = 0;
        int yCoordinate = 0;
        Boolean isHit;

        Scanner scan = new Scanner(System.in);

        Player newPlayer = new Player();
        newPlayer.getName();
        newPlayer.setName(newPlayer.name);

        Machine ai = new Machine();
        ai.shotTracker();


        Board aiBoard = new Board(false);
        Board playerBoard = new Board(true);

        System.out.println("** Welcome to Battleship **");

        while(aiBoard.checkWin() == false && playerBoard.checkWin() == false){
            aiBoard.printBoard();
            System.out.println("____________________________");
            playerBoard.printBoard();
            System.out.println("Your move, " + newPlayer.name);
            try{
                System.out.println("Enter an X coordinate.");
                 xCoordinate = scan.next();
            }

            catch(InputMismatchException exception){
                System.out.println("This is not a valid X coordinate, try again.");
                xCoordinate = scan.next();
            }

            while (newPlayer.validLetter(xCoordinate.toUpperCase()) == false) {
                System.out.println("That is not a valid X coordinate, try again.");
                xCoordinate = scan.next();
            }

            try{
                System.out.println("Enter a Y coordinate.");
                yCoordinate = scan.nextInt();

            }

            catch(InputMismatchException exception){
                System.out.println("This is not a valid Y coordinate, try again.");
                yCoordinate = scan.nextInt();
            }

            while (newPlayer.validNumber(yCoordinate) == false) {
                System.out.println("This is not a valid Y coordinate, try again.");
                yCoordinate = scan.nextInt();
            }

            aiBoard.attack(xCoordinate, yCoordinate - 1);
            
            System.out.println("The computer fires. ");
            isHit = ai.fireAtHumanShips(ai.shotTracker(), playerBoard);
		
        }




    }

}

