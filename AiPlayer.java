package com.company;

import java.util.ArrayList;

public class AiPlayer extends Player{
    public String name = "";
    // Sets player up as a Computer player as opposed to a human player
    @Override
    public void setName(String name) {
        this.name = "Machine Player";
    }

    // Overrides and sets  isHuman boolean to False
    @Override
    public boolean isHuman() {
        return false;
    }


}
