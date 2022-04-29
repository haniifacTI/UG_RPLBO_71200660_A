package com.ug9.mobilelegend;

public class Creep extends NPC{
    public Creep(String name, int damage, int health){
        super(name,damage,health);
    }

    @Override
    public void attack(Character enemy) {
        if(enemy instanceof Creep || enemy instanceof Minion){
            System.out.println("ERROR, Creep tidak bisa menyerang Creep dan/atau Minion");
        }else{
            super.attack(enemy);
        }
    }
}
