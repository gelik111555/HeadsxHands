package Services;

import Interfaces.BattleInterface;
import Models.AttackResult;
import Models.Creature;

import java.util.Random;

public class BattleService implements BattleInterface {


    // Метод для атаки другого существа
    @Override
    public AttackResult attack(Creature attacker, Creature target) {
        // Рассчитываем количество бросков кубика
        int atac = attacker.getAttack();
        int def = target.getDefense();
        int diceRollsCount;
        // если защита будет выше аттаки то бросок кубика будет всегда 1
        if(def > atac) diceRollsCount = 1;
        // если атака будет выше брони тогда вычитаем из брони атаку и получаем количество бросков кубика
        else diceRollsCount = atac - def  + 1;

        boolean attackSuccessful = false; // Флаг успешной атаки

        //Бросаем кубики
        // Успех определяется броском N кубиков
        Random random = new Random();
        for (int i = 0; i < diceRollsCount; i++) {
            int diceRoll = random.nextInt(6) + 1; // Результат броска кубика от 1 до 6
            if(diceRoll >= 5){
                // Удар считается успешным, если выпало 5 или 6
                attackSuccessful = diceRoll >= 5;
                break;
            }
        }
        AttackResult attackResult;

        // В результате мы решаем будет ли успешна атака или нет.
        if (attackSuccessful) {
            // Если удар успешен, выбираем произвольное значение из параметра Урон атакующего
            int damage = random.nextInt(attacker.getAttack()) + 1;

            // Вычитаем урон из Здоровья защищающегося
            int newHealth = target.getHealth() - damage;
            if (newHealth < 0) {
                newHealth = 0;
            }
            target.setHealth(newHealth);
            attackResult = new AttackResult
                    (true, "Атака успешна! "
                            + attacker.getName() + " наносит " + damage + " урона  по " + target.getName() + ".");
           return attackResult;
        } else {
            return attackResult = new AttackResult
                    (false, "Атака не удалась. " + attacker.getName() +
                            " промахивается по " + target.getName() + ".");

        }
    }
}
