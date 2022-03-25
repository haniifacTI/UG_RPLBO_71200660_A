package com.ug7.game;

public class Karakter {
    private Player player;
    private int HP = 100;
    private int money = 5000;
    private int weapon = 0;
    private boolean isWalk = false;

    public Karakter(Player player){
        this.player = player;
    }

    public boolean isAlive(){
        if(this.getHP() > 0){
            return true;
        }else{
            return false;
        }
    }

    public void buyWeapon(int weapon){
        System.out.println("1. Pisau");
        System.out.println("2. Tongkat");
        System.out.println("3. Tongkat Sihir");
        System.out.println("4. Katana");
        System.out.println("Pilih senjata: "+weapon);
    }

    public void abilityAttack(Karakter karakter){

    }

    public void normalAttack(Karakter karakter){

    }

    public int weaponDamage(){
        int wpn_dmg = 0;
        switch (this.getWeapon()){
            case 1:
                wpn_dmg = 20;
                break;
            case 2:
                wpn_dmg = 25;
                break;
            case 3:
                wpn_dmg = 60;
                break;
            case 4:
                wpn_dmg = 50;
                break;
        }
        return wpn_dmg;
    }

    public String checkWeapon(){
        String nama_wep = "";
        switch (this.getWeapon()){
            case 0:

            case 1:
                nama_wep = "Pisau";
                break;
            case 2:
                nama_wep = "Tongkat";
                break;
            case 3:
                nama_wep = "Tongkat Sihir";
                break;
            case 4:
                nama_wep = "Katana";
                break;
        }
        return nama_wep;
    }

    public void walk(boolean type){
        this.isWalk = type;
    }


    public void getInfo(){
        System.out.println("Username : "+this.getPlayer().getUsername());
        System.out.println("Level : "+getPlayer().getLevel());
        System.out.println("Money : "+getPlayer());
        System.out.println("HP : "+getHP());
        System.out.println("Weapon : "+checkWeapon());

    }

    public Player getPlayer() {
        return player;
    }

    public int getMoney() {
        return money;
    }

    public void reduceMoney(int price) {
        if (this.money >= price){
            this.money = money - price;
        }else{
            System.out.println("Uang tidak cukup");
        }
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getWeapon() {
        return weapon;
    }

    public void setWeapon(int weapon) {
        this.weapon = weapon;
    }

    public boolean isWalk() {
        return isWalk;
    }
}
