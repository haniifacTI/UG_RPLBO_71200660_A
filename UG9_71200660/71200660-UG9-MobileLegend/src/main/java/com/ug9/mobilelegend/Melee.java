package com.ug9.mobilelegend;

public class Melee extends Hero implements Skill{
    public Melee(String name, int damage, int health){
        super(name,damage,health);
    }

    @Override
    public void ultimate() {
        this.addDamage(100);
        System.out.println(this.getName()+" mengaktifkan ulti. Damage saat ini bertambah 150");
    }

    @Override
    public void attack(Character enemy) {
        if(enemy instanceof Creep){
            this.setHealthBonus(200);
        }
        super.attack(enemy);
    }
}
