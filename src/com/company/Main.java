/*
* Creators:
*   Joshua Belfor
*   Kim Johnson
*   Aaron Skonieczny
*   Muhammad Ashfaq
*
*/


package com.company;

public class Main {

    public static void main(String[] args) {
	// Board test
        Board ai = new Board(false);
        ai.printBoard();
        System.out.println("--------------------------------");
        Board b = new Board(true);
        b.printBoard();

        b.attack("A",1);
        b.printBoard();
        System.out.println("--------------------------------");
        ai.attack("a",1);
        ai.printBoard();
    }
}
