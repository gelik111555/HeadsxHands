package Interfaces;
import Models.AttackResult;
import Models.Creature;

public interface BattleInterface {

    // Метод для атаки другого существа
    AttackResult attack(Creature attacker, Creature target);
}