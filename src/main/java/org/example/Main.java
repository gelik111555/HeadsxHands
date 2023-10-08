package org.example;

import Interfaces.BattleInterface;
import Interfaces.HealInterface;
import Models.AttackResult;
import Models.Creature;
import Models.Monster;
import Models.Player;
import Services.BattleService;

import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        BattleInterface battleService = new BattleService();

        Creature hero = new Player(10, 5, 50, "Hero", 5); // Создание героя
        Creature monster = new Monster(11, 2, 60, "Monster", 7); // Создание монстра

        boolean heroTurn = true; // Флаг для определения, чей ход сейчас
        AttackResult result;
        while (hero.isAlive() && monster.isAlive()) {
            if (heroTurn) {
                // Ход героя: герой атакует монстра

                // Добавим случайное исцеление
                Random random = new Random();
                if (random.nextDouble() < 0.20) { // Например, исцеление с вероятностью 20%
                    System.out.println(((HealInterface) hero).superHeal().getMessage());
                }

                result =  battleService.attack(hero, monster);
                System.out.println(result.getMessage());
                heroTurn = false; // Передача хода монстру
            } else {
                // Ход монстра: монстр атакует героя
                battleService.attack(monster, hero);
                result =  battleService.attack(monster, hero);
                System.out.println(result.getMessage());
                heroTurn = true; // Передача хода герою
            }
        }
        if(hero.isAlive())
            System.out.println("Победил герой");
        else
            System.out.println("Победил монстр");
    }

}