package com.ug9.mobilelegend;

public class Hero extends Character{
    private int healthBonus = 0;
    private int level = 1;
    private int healthMax;
    private int lifeSteal = 50;

    public Hero(String name, int damage, int health){
        super(name,damage,health);
        this.healthMax = health;

    }

    public void addDamage(int dmg){
        this.setDamage(this.getDamage()+dmg);
    }

    @Override
    public void attack(Character enemy) {
        if(!this.isDie() && !enemy.isDie()) {
            enemy.setHealth(enemy.getHealth() - this.getDamage());

            if(this.getHealth()+this.lifeSteal > this.healthMax) {
                this.setHealth(this.healthMax);
            }else{
                this.setHealth(this.getHealth() + this.lifeSteal);
            }

            this.attackInformation(enemy, this.getDamage());

            if(enemy.getHealth() <= 0){
                enemy.setHealth(0);
                enemy.setDie(true);
            }

            if(enemy.isDie()){
                this.level+=1;
                if(enemy instanceof Melee || enemy instanceof Ranged){
                    this.lifeSteal+=150;
                }else if(enemy instanceof Creep || enemy instanceof Minion){
                    if(this.getHealth()+this.healthBonus >= this.healthMax) {
                        this.setHealth(this.healthMax);
                        this.setHealthBonus(0);
                    }else{
                        this.setHealth(this.getHealth()+this.healthBonus);
                        this.setHealthBonus(0);
                    }
                }
            }
        }
    }

    public void setHealthBonus(int healthBonus) {
        this.healthBonus = healthBonus;
    }

    public int getLevel() {
        return level;
    }
}
