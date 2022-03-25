package com.ug7.game;

public class Ninja extends Karakter{
    private boolean isAbilityReady;

    public Ninja(Player player){
        super(player);
    }

    @Override
    public void buyWeapon(int weapon) {
        super.buyWeapon(weapon);
        if(weapon == 1){
            this.reduceMoney(500);
            this.setWeapon(1);
            System.out.println("Berhasil membeli senjata! Uang sekarang : "+this.getMoney());
        }
        else if(weapon == 4){
            this.reduceMoney(4000);
            this.setWeapon(4);
            System.out.println("Berhasil membeli senjata! Uang sekarang : "+this.getMoney());
        }
        else{
            System.out.println("Sebagai ninja kamu hanya boleh membeli pisau/katana!");
        }
    }

    @Override
    public void abilityAttack(Karakter karakter) {
        if(this.isAbilityReady){
            if(this.isWalk()){
                karakter.setHP((int) (karakter.getHP() - karakter.getHP() * 0.5));
            }
            else{
                karakter.setHP(0);
            }
        }
        else{
            System.out.println("Ability belum aktif!");
        }

        System.out.println("Rasakan ini, "+karakter.getPlayer().getUsername());
        System.out.println(karakter.getPlayer().getUsername() + " terkena serangan! Sisa HP "+ karakter.getPlayer().getUsername() + karakter.getHP());

        if(karakter.isAlive()){

        }else{
            this.getPlayer().setLevel(this.getPlayer().getLevel()+1);
            System.out.println(karakter.getPlayer().getUsername() + "Mati");
        }
    }

    public void abilityCheck(Karakter karakter){
        if (karakter.getHP() < 50){
            this.isAbilityReady = true;
        }
    }

    @Override
    public void normalAttack(Karakter karakter) {
        double multiplier = 1;
        if(this.isWalk()){
            multiplier = 1;
        }else{
            multiplier = 1.5;
        }

        int dmg = super.weaponDamage();
        karakter.setHP((int) (karakter.getHP() - dmg * multiplier));
        System.out.println(karakter.getPlayer().getUsername() + " terkena serangan! Sisa HP " + karakter.getPlayer().getUsername() + karakter.getHP());

        if(karakter.isAlive()){

        }else{
            System.out.println(karakter.getPlayer().getUsername() + "Mati");
        }
    }

    @Override
    public void walk(boolean type) {
        System.out.println(this.getPlayer().getUsername() + " menghilang! (Lari)");
    }

    public String checkWalk(){
        if(this.isWalk()){
            return "Berjalan";
        }
        else{
            return "Berlari";
        }
    }
    @Override
    public void getInfo(){
        if(this.getHP() < 0){
            setHP(0);
        }
        System.out.println("[Karakter Ninja]");
        System.out.println("Username : "+this.getPlayer().getUsername());
        System.out.println("Level : "+this.getPlayer().getLevel());
        System.out.println("Money : "+this.getPlayer());
        System.out.println("HP : "+this.getHP());
        System.out.println("Weapon : "+this.checkWeapon());
        System.out.println("Movement : "+this.checkWalk());
    }


}
