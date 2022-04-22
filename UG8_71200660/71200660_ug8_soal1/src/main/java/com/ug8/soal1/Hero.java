package com.ug8.soal1;

public abstract class Hero extends Character implements AttackingCreep{
    public Hero(String name, int hp, int dmg){
        super(name,hp,dmg);
    }
}
