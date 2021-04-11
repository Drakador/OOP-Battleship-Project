package com.company;

import java.util.ArrayList;

public class Piece extends Ships{
    int size;
    ArrayList<ShipSection> sections = new ArrayList<ShipSection>();
    public Piece(int size, String name){
        super(name, size);
        this.size = size;
    }
    // After creating the piece, generate the values in either horizontal or vertical standing that are acceptable
    // (not overlapping or out of bounds) and add the sections, passing in the row and cols.
    public void addSection(int row, int col, int num){
        sections.add(new ShipSection(row, col, false, super.getType(), num));

    }

    public boolean isSunk(){
        if (super.getHp() == 0) {
            return true;
        }
        return false;
    }

    public ArrayList<ShipSection> getSections() {
        // returns an arraylist of this ships sections for use. Call upon this to get shipsections when printing
        // out to the board.
        return sections;
    }

    public void setSections(ArrayList<ShipSection> sections) {
        this.sections = sections;
    }

    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }


}
