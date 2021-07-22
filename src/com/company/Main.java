
package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int bossHealth = 700;
    public static int bossDamage = 66;
    public static String bossDefence = "";
    public static String[] heroesAttackType = {"Physical", "Magical", "Kinetic", "Medic", "Berserk", "Thor"};
    public static int[] heroesHealth = {270, 260, 250, 238, 400, 300};
    public static int[] heroesDamage = {34, 29, 24, 0, 10, 19};
    public static int helpHeroes;


    public static void main(String[] args) {
        printStatistics();
        while (!isGameFinished()) {
            round();
        }
    }

    public static void changeBossDefence() {
        Random random = new Random();
        int randomIndex = random.nextInt(heroesAttackType.length); // 0, 1, 2
        bossDefence = heroesAttackType[randomIndex];
        System.out.println("Boss choose defence: " + bossDefence);
    }

    public static void round() {
        if (bossHealth > 0) {
            Random random = new Random();
            random.nextBoolean();
            boolean frjf = false;
            changeBossDefence();
            bossHits();
        }
        hilenimeGeroeti();
        heroesHit();
        printStatistics();
    }

    public static void heroesHit() {
        for (int i = 0; i < heroesDamage.length; i++) {
            if (heroesHealth[i] > 0 && bossHealth > 0) {
                if (bossDefence == heroesAttackType[i]) {
                    Random random = new Random();
                    int coeff = random.nextInt(9) + 2; //2,3,4,5,6,7,8,9,10
                    System.out.println("Critical damage: " + heroesDamage[i] * coeff);
                    if (bossHealth - heroesDamage[i] * coeff < 0) {
                        bossHealth = 0;
                    } else {
                        bossHealth = bossHealth - heroesDamage[i] * coeff;
                    }
                } else {
                    if (bossHealth - heroesDamage[i] < 0) {
                        bossHealth = 0;
                    } else {
                        bossHealth = bossHealth - heroesDamage[i];
                    }
                }
            }
        }
    }


    public static void bossHits() {
        boolean allBossHits = false;
        Random rount = new Random(3);

        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0) {
                if (heroesHealth[i] - bossDamage < 0) {
                    heroesHealth[i] = 0;
                } else {
                    heroesHealth[i] = heroesHealth[i] - bossDamage;
                }
            }
        }
    }

    public static boolean isGameFinished() {
        if (bossHealth <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    public static void printStatistics() {
        System.out.println("__________________");
        System.out.println("Boss health: " + bossHealth + " [" + bossDamage + "]");
        for (int i = 0; i < heroesHealth.length; i++) {
            System.out.println(heroesAttackType[i]
                    + " health: " + heroesHealth[i] + " [" + heroesDamage[i] + "]");
        }
        System.out.println("__________________");
    }

    public static void hilenimeGeroeti() {
        int index = 0;
        for (String nameHerous : heroesAttackType) {
            if (nameHerous == "Medic")
            {
                    if (heroesHealth[index] > 0) {
                    for (int i = 0; i < heroesHealth.length; i++) {
                        if (heroesHealth[i] < 100 && heroesHealth[i] > 0) {
                            int helpHerous = 30;
                            heroesHealth[i] += helpHerous;
                            System.out.println("ND:  " + heroesAttackType[i]   +  "  " + heroesHealth[i]);
                            break;
                        }

                    }
                }
            }

        }
    }
}
