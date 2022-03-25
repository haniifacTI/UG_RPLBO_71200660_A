package com.ug7.game;

public class Penyihir extends Karakter{
    private boolean isAbilityReady;

    public Penyihir(Player player) {
        super(player);
    }

    @Override
    public void buyWeapon(int weapon) {
        super.buyWeapon(weapon);
        if(weapon == 2){
            this.reduceMoney(2000);
            this.setWeapon(2);
            System.out.println("Berhasil membeli senjata! Uang sekarang : "+this.getMoney());
        }
        else if(weapon == 3){
            this.reduceMoney(3000);
            this.setWeapon(3);
            System.out.println("Berhasil membeli senjata! Uang sekarang : "+this.getMoney());
        }
        else{
            System.out.println("Sebagai penyihir kamu hanya boleh membeli tongkat/tongkat sihir!");
        }
    }

    @Override
    public void abilityAttack(Karakter karakter) {
        if(this.isAbilityReady){
            if(this.isWalk()){
                this.setHP(100);
            }
            else{
                this.setHP((int) (this.getHP() + this.getHP() * 0.5));
            }
        }
        else{
            System.out.println("Ability belum aktif!");
        }

        System.out.println("Tidak semudah itu, "+karakter.getPlayer().getUsername());
        System.out.println("HP Sekarang : "+this.getHP());
    }

    @Override
    public void normalAttack(Karakter karakter) {
        double multiplier = 1;
        if(this.isWalk()){
            multiplier = 1.5;
        }else{
            multiplier = 1;
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
        System.out.println(this.getPlayer().getUsername() + " terbang! (Lari)");
    }

    public String checkWalk(){
        if(this.isWalk()){
            return "Berjalan";
        }
        else{
            return "Terbang";
        }
    }
    @Override
    public void getInfo(){
        if(this.getHP() < 0){
            setHP(0);
        }
        System.out.println("[Karakter Ninja]");
        System.out.println("Username : "+this.getPlayer().getUsername());
        System.out.println("Level : "+getPlayer().getLevel());
        System.out.println("Money : "+getPlayer());
        System.out.println("HP : "+getHP());
        System.out.println("Weapon : "+checkWeapon());
        System.out.println("Movement : "+checkWalk());
    }
}
