package com.ug8.soal1;

public abstract class SummonCharacter extends Hero{
    protected Summoner owner;

    public SummonCharacter(String name,int hp, int dmg, Summoner summoner){
        super(name, hp, dmg);
        this.owner = summoner;
    }
}
