package com.company;

/*
 * Jointly worked on between Joshua Belfor and Muhammad Ashfaq
 */
import java.util.ArrayList;
import java.util.Random;

public class Board {
    private ShipSection[][] board = new ShipSection[10][10];
    private boolean player;
    private ArrayList<Piece> pieces;

    public Board(boolean player) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = new ShipSection(i, j, true, "none", 0);
            }
        }
        pieces = getChosenBoard();
        // Place the sections onto the board
        for (Piece p : pieces) {
            ArrayList<ShipSection> sects = p.getSections();
            for (int j = 0; j < p.getSize(); j++) {
                int r = sects.get(j).getRow();
                int c = sects.get(j).getCol();
                board[r][c] = sects.get(j);
                if (!player) {
                    board[r][c].setTile("~");
                }

            }
        }
        this.player = player;
        // This tells us if the board belongs to the player or the AI, and we use it to
        // determine once the ships are set up if they are hidden or not. True if player, False if AI.
    }

    public boolean attack(String row, int col) {
        int iRow = letterToNum(row);
        if (board[iRow][col].isEmpty() == false) {
            board[iRow][col].setTile("x");

            // Grab the correct piece and update its HP.
            for (Piece p : pieces) {
                if (p.getType().equals(board[iRow][col].getMemberOf())) {
                    p.setHp(p.getHp() - 1);
                    // Update the shipSection
                    ArrayList<ShipSection> temp = p.getSections();
                    for(ShipSection s : temp){
                        if (s.getNum() == board[iRow][col].getNum()){
                            s = board[iRow][col];
                            p.setSections(temp);
                        }
                    }
                }
            }
            System.out.println("Hit!");
            return true;
        } else {
            board[iRow][col].setTile("o");
            System.out.println("Miss!");
            return false;
        }
    }


    public void printBoard() {
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        String[] lets = {"A","B", "C","D","E","F","G","H","I","J"};
        for (int i = 0; i < 10; i++){
            System.out.print(lets[i] + " ");
            for (int j = 0; j < 10; j++){
                System.out.print(board[i][j].getTile() + " ");
            }
            System.out.println();
        }
    }

    private int letterToNum(String row) {
        int newRow = 0;
        row = row.toUpperCase();
        switch (row) {
            case "A" -> newRow = 0;
            case "B" -> newRow = 1;
            case "C" -> newRow = 2;
            case "D" -> newRow = 3;
            case "E" -> newRow = 4;
            case "F" -> newRow = 5;
            case "G" -> newRow = 6;
            case "H" -> newRow = 7;
            case "I" -> newRow = 8;
            case "J" -> newRow = 9;
        }
        return newRow;
    }


    public ShipSection[][] getBoard() {
        return board;
    }

    public void setBoard(ShipSection[][] board) {
        this.board = board;
    }

    public boolean isPlayer() {
        return player;
    }

    public void setPlayer(boolean player) {
        this.player = player;
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    private ArrayList<Piece> getChosenBoard() {

        Random ran = new Random();
        /* Muhammed, take this section and add it into the chosenBoard and return it */


        // Remember, goes by row then column. Prevent any overlaps. First one I made is an example.
        // Board 1 --------------------------------------------------
        ArrayList<Piece> chosenBoard = new ArrayList<Piece>();
        int chosen = ran.nextInt(5);
        //System.out.println(chosen);
        switch(chosen){
            case 0:
                // Carrier
                chosenBoard.add( new Piece(5, "Carrier"));
                chosenBoard.get(0).addSection(0,0,1);
                chosenBoard.get(0).addSection(0,1,2);
                chosenBoard.get(0).addSection(0,2,3);
                chosenBoard.get(0).addSection(0,3,4);
                chosenBoard.get(0).addSection(0,4,5);


                // battleship
                chosenBoard.add( new Piece(4, "Battleship"));
                chosenBoard.get(1).addSection(8,0,1);
                chosenBoard.get(1).addSection(8,1,2);
                chosenBoard.get(1).addSection(8,2,3);
                chosenBoard.get(1).addSection(8,3,3);

                // cruiser
                chosenBoard.add( new Piece(3, "Cruiser "));
                chosenBoard.get(2).addSection(5,0,1);
                chosenBoard.get(2).addSection(5,1,2);
                chosenBoard.get(2).addSection(5,2,3);
                // submarine
                chosenBoard.add(new Piece(3, "Submarine"));
                chosenBoard.get(3).addSection(2,7,1);
                chosenBoard.get(3).addSection(3,7,2);
                chosenBoard.get(3).addSection(4,7,3);
                // destroyer
                chosenBoard.add(new Piece(2, "Destroyer"));
                chosenBoard.get(4).addSection(2,3,1);
                chosenBoard.get(4).addSection(3,3,2);
                break;
            case 1:
                // Carrier
                chosenBoard.add( new Piece(5, "Carrier"));
                chosenBoard.get(0).addSection(3,0,1);
                chosenBoard.get(0).addSection(3,1,2);
                chosenBoard.get(0).addSection(3,2,3);
                chosenBoard.get(0).addSection(3,3,4);
                chosenBoard.get(0).addSection(3,4,5);

                // battleship
                chosenBoard.add( new Piece(4, "Battleship"));
                chosenBoard.get(1).addSection(0,0,1);
                chosenBoard.get(1).addSection(0,1,2);
                chosenBoard.get(1).addSection(0,2,3);
                chosenBoard.get(1).addSection(0,3,4);

                // cruiser
                chosenBoard.add( new Piece(3, "Cruiser "));
                chosenBoard.get(2).addSection(5,1,1);
                chosenBoard.get(2).addSection(5,2,2);
                chosenBoard.get(2).addSection(5,3,3);
                // submarine
                chosenBoard.add(new Piece(3, "Submarine"));
                chosenBoard.get(3).addSection(3,7,1);
                chosenBoard.get(3).addSection(4,7,2);
                chosenBoard.get(3).addSection(5,7,3);
                // destroyer
                chosenBoard.add(new Piece(2, "Destroyer"));
                chosenBoard.get(4).addSection(4,5,1);
                chosenBoard.get(4).addSection(5,5,2);
                break;
            case 2:
                // Carrier
                chosenBoard.add( new Piece(5, "Carrier"));
                chosenBoard.get(0).addSection(7,0,1);
                chosenBoard.get(0).addSection(7,1,2);
                chosenBoard.get(0).addSection(7,2,3);
                chosenBoard.get(0).addSection(7,3,4);
                chosenBoard.get(0).addSection(7,4,5);

                // battleship
                chosenBoard.add( new Piece(4, "Battleship"));
                chosenBoard.get(1).addSection(2,0,1);
                chosenBoard.get(1).addSection(2,1,2);
                chosenBoard.get(1).addSection(2,2,3);
                chosenBoard.get(1).addSection(2,3,4);

                // cruiser
                chosenBoard.add( new Piece(3, "Cruiser "));
                chosenBoard.get(2).addSection(0,0,1);
                chosenBoard.get(2).addSection(0,1,2);
                chosenBoard.get(2).addSection(0,2,3);
                // submarine
                chosenBoard.add(new Piece(3, "Submarine"));
                chosenBoard.get(3).addSection(3,5,1);
                chosenBoard.get(3).addSection(4,5,2);
                chosenBoard.get(3).addSection(5,5,3);
                // destroyer
                chosenBoard.add(new Piece(2, "Destroyer"));
                chosenBoard.get(4).addSection(4,3,1);
                chosenBoard.get(4).addSection(5,3,2);
                break;

            case 3:
                // Carrier
                chosenBoard.add( new Piece(5, "Carrier"));
                chosenBoard.get(0).addSection(7,0,1);
                chosenBoard.get(0).addSection(7,1,2);
                chosenBoard.get(0).addSection(7,2,3);
                chosenBoard.get(0).addSection(7,3,4);
                chosenBoard.get(0).addSection(7,4,5);

                // battleship
                chosenBoard.add( new Piece(4, "Battleship"));
                chosenBoard.get(1).addSection(5,1,1);
                chosenBoard.get(1).addSection(5,2,2);
                chosenBoard.get(1).addSection(5,3,3);
                chosenBoard.get(1).addSection(5,4,4);

                // cruiser
                chosenBoard.add( new Piece(3, "Cruiser "));
                chosenBoard.get(2).addSection(2,1,1);
                chosenBoard.get(2).addSection(2,2,2);
                chosenBoard.get(2).addSection(2,3,3);
                // submarine
                chosenBoard.add(new Piece(3, "Submarine"));
                chosenBoard.get(3).addSection(0,2,1);
                chosenBoard.get(3).addSection(0,3,2);
                chosenBoard.get(3).addSection(0,4,3);
                // destroyer
                chosenBoard.add(new Piece(2, "Destroyer"));
                chosenBoard.get(4).addSection(3,6,1);
                chosenBoard.get(4).addSection(4,6,2);
                break;
            case 4:
                // Carrier
                chosenBoard.add( new Piece(5, "Carrier"));
                chosenBoard.get(0).addSection(5,0,1);
                chosenBoard.get(0).addSection(5,1,2);
                chosenBoard.get(0).addSection(5,2,3);
                chosenBoard.get(0).addSection(5,3,4);
                chosenBoard.get(0).addSection(5,4,5);

                // battleship
                chosenBoard.add( new Piece(4, "Battleship"));
                chosenBoard.get(1).addSection(2,1,1);
                chosenBoard.get(1).addSection(2,2,2);
                chosenBoard.get(1).addSection(2,3,3);
                chosenBoard.get(1).addSection(2,4,4);

                // cruiser
                chosenBoard.add( new Piece(3, "Cruiser "));
                chosenBoard.get(2).addSection(3,3,1);
                chosenBoard.get(2).addSection(3,4,2);
                chosenBoard.get(2).addSection(3,5,3);
                // submarine
                chosenBoard.add(new Piece(3, "Submarine"));
                chosenBoard.get(3).addSection(3,6,1);
                chosenBoard.get(3).addSection(4,6,2);
                chosenBoard.get(3).addSection(5,6,3);
                // destroyer
                chosenBoard.add(new Piece(2, "Destroyer"));
                chosenBoard.get(4).addSection(0,3,1);
                chosenBoard.get(4).addSection(0,4,2);
                break;
        }

        return chosenBoard;
    }

}