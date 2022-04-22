package com.ug8.soal1;

public class Creep extends Character implements AttackingHero{
    public Creep(String name, int hp, int dmg){
        super(name,hp,dmg);
    }

    @Override
    public void attack(Hero hero) {
        hero.health -= this.damage;
        if(hero.isDie()) {
            hero.health = 0;
        }
    }
}
