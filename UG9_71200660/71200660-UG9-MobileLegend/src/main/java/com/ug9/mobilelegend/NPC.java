package com.ug9.mobilelegend;

public class NPC extends Character{
    public NPC(String name, int damage, int health){
        super(name,damage,health);
    }

    @Override
    public void attack(Character enemy) {
        if(enemy instanceof Melee || enemy instanceof Ranged){
            this.setDamage(this.getDamage()+100);
        }

        if(enemy.getHealth()<= 0){
            enemy.setDie(true);
            enemy.setHealth(0);

        }else{
            if(!this.isDie()){
                enemy.setHealth(enemy.getHealth()-this.getDamage());
                this.attackInformation(enemy,this.getDamage());
            }
        }

    }
}
