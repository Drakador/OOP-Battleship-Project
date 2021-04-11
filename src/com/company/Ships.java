package com.company;

public class Ships {
    int hp;
    String type;
    public Ships(String type, int hp)
    {
        this.type = type;
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isSunk(){
        if(hp <= 0){
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return "Ships{" +
                "hp=" + hp +
                ", type='" + type +
                '}';
    }
}
