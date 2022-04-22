package com.ug8.soal1;

public class Main {
    public static void main(String[] args) {
        Creep creep1 = new Creep("Creep1",200,20);
        Creep creep2 = new Creep("Creep2",200,20);
        Creep creep3 = new Creep("Creep3",200,20);

        LoneDruid ld1 = new LoneDruid();
        Warlock wl1 = new Warlock();
        SpiritBear spiritbear1 = ld1.summon();
        Golem golem1 = wl1.summon();

        creep1.attack(spiritbear1); // 3
        creep1.attack(wl1); // 3

        ld1.attack(creep1); // 4

        spiritbear1.attack(creep2); // 5

        wl1.attack(creep3); // 6

        golem1.attack(creep1); // 7
        golem1.attack(creep2); // 7

        Golem miniGolem = golem1.summon(); // 8

        ld1.showCharacterInfo();
        System.out.println();
        spiritbear1.showCharacterInfo();
        System.out.println();
        miniGolem.showCharacterInfo();
    }
}
