package com.company;

/* The point of the ShipSection is to be stored in a Piece as an array.
 * This will allow us to handle printing each section of a ship.
 */
public class ShipSection {
    int row;
    int col;
    String tile = "S";  // Starts off as S, if the ShipSection is hit then we change it to show it is hit with an X
    boolean empty;
    /* memberOf string ties this ship section to a specific piece. When an action occurs on this ship section
            iterate through the list of game pieces and get that piece, update the information for it accordingly. That may
            include removing HP, and checking if the HP is 0, making the ship sunk. use num to get which shipSection was
            needing to be used.
         */
    String memberOf;
    int num;
    /*
        Each section holds a number, so when you need to update a section this can be an easier unique identifier for
        you to search for, rather than the Row and Col.
     */

    public ShipSection(int row, int col, boolean empty, String memberOf, int num){
        this.row = row;
        this.col = col;
        if(empty == true){
            this.tile = "~";
        }
        this.empty = empty;
        this.memberOf = memberOf;
        // Check on a hit if the board is empty. If it is, adjust the tile to an o, if not adjust to an x and
        // modify the data accordingly.

    }


    // Getters and setters

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    /*
        When making the AI ships remember to replace the tile with the ~ because the player is not supposed to see it.
     */

    public String getTile() {
        return tile;
    }

    public void setTile(String tile) {
        this.tile = tile;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public String getMemberOf() {
        return memberOf;
    }

    public void setMemberOf(String memberOf) {
        this.memberOf = memberOf;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }


}
