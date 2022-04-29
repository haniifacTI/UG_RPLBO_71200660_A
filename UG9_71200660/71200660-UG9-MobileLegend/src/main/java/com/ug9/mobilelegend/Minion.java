package com.ug9.mobilelegend;

public class Minion extends NPC{
    public Minion(String name, int damage, int health){
        super(name,damage,health);
    }

    @Override
    public void attack(Character enemy) {
        if(enemy instanceof Creep){
            System.out.println("ERROR, Minion tidak bisa menyerang Creep");
        }else {
            super.attack(enemy);
        }
    }
}
