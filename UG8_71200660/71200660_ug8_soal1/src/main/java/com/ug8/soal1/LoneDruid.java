package com.ug8.soal1;

public class LoneDruid extends Hero implements Upgradeable, Summoner{
    private int killCreep;
    private int level;

    public LoneDruid(){
        super("Lone Druid",1800,140);
    }

    @Override
    public SpiritBear summon() {
        return new SpiritBear(this);
    }

    @Override
    public void upgrade() {
        if(this.killCreep>=3){
            this.level += 1;
            this.killCreep -= 3;
            this.name = "Lone Druid +"+this.level;
            this.damage += 20;
        }
    }

    @Override
    public void showCharacterInfo() {
        super.showCharacterInfo();
        System.out.println("Kill Creep : "+this.killCreep);
    }

    @Override
    public void attack(Creep creep) {
        creep.health -= this.damage;
        if(creep.isDie()){
            this.killCreep += 1;
            creep.health = 0;
        }
    }
}
