package com.ug8.soal1;

public class Warlock extends Hero implements Summoner{
    private int numOfSummon = 0;

    public Warlock(){
        super("Warlock",700,80);
    }

    @Override
    public void attack(Creep creep) {
        creep.health -= this.damage;
        if(creep.isDie()) {
            creep.health = 0;
        }
    }

    @Override
    public Golem summon() {
        this.numOfSummon += 1;
        return new Golem(this);
    }
}
