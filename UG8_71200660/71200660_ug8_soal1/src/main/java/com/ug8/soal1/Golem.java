package com.ug8.soal1;

public class Golem extends SummonCharacter implements Summoner{
    private int kill;

    public Golem(Summoner summoner){
        super("Golem",1000,120,summoner);
    }

    @Override
    public void attack(Creep creep) {
        creep.health -= this.damage;
        if(creep.isDie()){
            this.kill += 1;
            creep.health = 0;
        }
    }

    @Override
    public Golem summon() {
        if(this.kill>0){
            this.kill -= 1;
            return new Golem(this);
        }else{
            return null;
        }
    }
}
