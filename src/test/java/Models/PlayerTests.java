package Models;
import javax.validation.ConstraintViolationException;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTests {
    @Test
    public void testSuperHeal() {
        // Создаем объект player для тестирования
        Creature player = new Player(10, 5, 50, "Testplayer", 5);

        // Попробуем применить суперспособность исцеления несколько раз
        for (int i =0; i<4;i++ ) {
            HealResult result = ((Player) player).superHeal();
            System.out.println("Результат исцеления: " + result.getMessage());
        }

        // Попытка применить суперспособность исцеления в пятый раз
        ((Player) player).superHeal();

        // Проверяем, что здоровье было исцелено правильно
        assertEquals(50 , player.getHealth());

        // Проверяем, что счетчик исцелений увеличился
        assertEquals(4, ((Player) player).getHealingCount());

        // Попытка применить суперспособность исцеления еще раз
        ((Player) player).superHeal();

        // Проверяем, что счетчик исцелений не увеличился больше 4
        assertEquals(4, ((Player) player).getHealingCount());
    }

    @Test
    public void testHealing30PercentWhenHealthBelow50Percent() {
        int stratrHealth = 50;
        // Создаем объект player для тестирования
        Creature player = new Player(10, 5, stratrHealth, "Testplayer", 5);
        player.setHealth(stratrHealth/2);
        System.out.println("Текущий уровень здоровья: " + player.health);
        // Попытка применить суперспособность исцеления в пятый раз
        ((Player) player).superHeal();
        System.out.println("Yровень здоровья после исцеления: " + player.health);

    }
}
