package Models;

import Interfaces.HealInterface;

public class Player extends Creature implements HealInterface {
    private int healingCount = 0; // Счётчик исцелений
    private int maxHealingCount = 4; // Счётчик исцелений

    public Player(int attack, int defense, int health, String name, int damage) {
        super(attack, defense, health, name, damage);
    }

    // Метод суперспособности "исцеление на 30%"
    @Override
    public HealResult superHeal() {
        HealResult result;
        if (healingCount < maxHealingCount) { // Проверка, что исцеление можно применить не более 4 раз
            int healingAmount = (int) (maxHealth * 0.3); // Исцеление на 30% от максимального здоровья
            health += healingAmount;

            // Убедимся, что здоровье не превышает максимальное
            if (health > maxHealth) {
                health = maxHealth;
            }

            healingCount++; // Увеличим счётчик исцелений
            return new HealResult
                    (true, "Вы использовали суперспособность и исцелились на " + healingAmount + " единиц здоровья.");
        }
        return new HealResult
                (false, "Вы не можете использовать суперспособность исцеления больше 4 раз.");
    }
    @Override
    public int getHealingCount() {
        return healingCount;
    }

    @Override
    public int getMaxHealingCount() {return maxHealingCount;}
}
