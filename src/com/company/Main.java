/*
* Creators:
*   Joshua Belfor
*   Kim Johnson
*   Aaron Skonieczny
*   Muhammad Ashfaq
*
*/


package com.company;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        String xCoordinate;
        int yCoordinate = 0;
        Boolean isHit;

        Scanner scan = new Scanner(System.in);

        Player newPlayer = new Player();
        newPlayer.setName(newPlayer.name);

        Machine ai = new Machine();
        ai.shotTracker();

        Board aiBoard = new Board(false);
        ArrayList<Piece> aiPieces = aiBoard.getPieces();

        Board playerBoard = new Board(true);
        ArrayList<Piece> playerPieces = playerBoard.getPieces();

        System.out.println("** Welcome to Battleship **");

        while (!aiBoard.checkWin() && !playerBoard.checkWin()) {
            aiBoard.printBoard();
            System.out.println("____________________________");
            playerBoard.printBoard();
            System.out.println("Your move, " + newPlayer.name);

            try {
                System.out.println("Enter an X coordinate A-J.");
                xCoordinate = scan.next();
            } 
            
            catch (InputMismatchException exception) {
                System.out.println("This is not a valid X coordinate, try again.");
                xCoordinate = scan.next();
            }

            while (!newPlayer.validLetter(xCoordinate.toUpperCase())) {
                System.out.println("That is not a valid X coordinate, try again.");
                xCoordinate = scan.next();
            }
            
            System.out.println("Enter a Y coordinate 1-10.");

            try {
                yCoordinate = scan.nextInt();
                while (!newPlayer.validNumber(yCoordinate)) {
                    System.out.println("This is not a valid Y coordinate, try again.");
                    yCoordinate = scan.nextInt();
                }
            }
            
            catch (InputMismatchException exception) {
                while (!scan.hasNextInt()) {
                    scan.next();
                    System.out.println("This is not a valid Y coordinate, try again.");
                }
                yCoordinate = scan.nextInt();
            }
            
            aiBoard.attack(xCoordinate, yCoordinate - 1);

            for(int i = 0; i < aiPieces.size(); i++){
                if(aiPieces.get(i).isSunk()){
                    System.out.println("Enemy " + aiPieces.get(i).type + " is sunk!");
                }
            }

            System.out.println("The computer fires. ");
            isHit = ai.fireAtHumanShips(ai.shotTracker(), playerBoard);

            for(int i = 0; i < playerPieces.size(); i++){
                if(playerPieces.get(i).isSunk()){
                    System.out.println("Friendly " + playerPieces.get(i).type + " is sunk!");
                }
            }

        }

        // As a reminder, the board returns true if the HP is zero, so you are checking for the other side.

        // This checks if the Players HP is zero, if not then the player won.
        if(playerBoard.checkWin() == false){
            System.out.println(newPlayer.getName() + " has Won!");
        }
        else{
            System.out.println("The Computer has Won!");
        }

    }

}



