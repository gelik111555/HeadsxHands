package Services;

import Interfaces.BattleInterface;
import Models.AttackResult;
import Models.Creature;
import Models.Monster;
import Models.Player;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BattleServiceTests {

    @Test
    public void testSuccessfulAttack() {
        Creature monsterKraken = new Monster(3, 2, 10, "Kraken", 7);
        Creature playerPaladin = new Player(2, 3, 15, "Paladin", 3);

        BattleInterface battleService = new BattleService();
        AttackResult result =  battleService.attack(monsterKraken, playerPaladin);

        // Вывести результат в консоль
        System.out.println("Результат атаки: " + result.getMessage());
        System.out.println("Здоровье игрока : " + playerPaladin.getHealth());
        // Проверьте ожидаемые результаты после успешной атаки
        // Проверяем, была ли успешной атака
        if (result.isSuccessful()) {
            // Если атака успешна, здоровье должно быть меньше
            assertTrue(playerPaladin.getHealth() < 15); // Предполагаем, что здоровье было 15 до атаки
        } else {
            // Если атака не успешна, здоровье остается на предыдущем уровне
            assertEquals(15, playerPaladin.getHealth()); // Предполагаем, что здоровье не изменилось
        }
    }
    @Test
    public void testKeepAttackingUntilHeroDies() throws InterruptedException {
        Creature monsterKraken = new Monster(3, 2, 10, "Kraken", 7);
        Creature playerPaladin = new Player(2, 3, 15, "Paladin", 3);

        BattleInterface battleService = new BattleService();

        while (true){
            AttackResult result =  battleService.attack(monsterKraken, playerPaladin);
            // Вывести результат в консоль
            System.out.println("Результат атаки: " + result.getMessage());
            System.out.println("Здоровье игрока : " + playerPaladin.getHealth());
            Thread.sleep(100); // Приостановка выполнения потока
            // если герой умер тогда выходим из цикла
            if(!playerPaladin.isAlive())
                break;
        }

        // Проверьте ожидаемые результаты после успешной атаки
        assertTrue(!playerPaladin.isAlive());
    }

}
