package com.company;

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

}





