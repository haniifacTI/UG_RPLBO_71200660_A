package com.ug8.soal1;

public class SpiritBear extends SummonCharacter{
    public SpiritBear(LoneDruid ld){
        super("Spirit Bear",1000,130,ld);
    }

    @Override
    public void attack(Creep creep) {
        creep.health -= this.damage;
        if(creep.isDie()){
            creep.health = 0;
        }
    }
}
