package com.ug8.soal1;

public abstract class Character {
    protected int damage;
    protected String name;
    protected int health;

    public Character() {
    }

    public Character(String nama, int hp, int dmg) {
        this.name = nama;
        this.health = hp;
        this.damage = dmg;
    }

    public void attacked(int dmg){
        this.health -= dmg;
    }

    public void showCharacterInfo(){
        System.out.println("Character : "+this.name);
        System.out.println("Health : "+this.health);
        System.out.println("Damage : "+this.damage);
    }

    public boolean isDie(){
        if(this.health<=0){
            return true;
        }else{
            return false;
        }
    }
}
