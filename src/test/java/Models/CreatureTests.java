package Models;
import javax.validation.ConstraintViolationException;
import org.junit.Test;

import static org.junit.Assert.*;


public class CreatureTests {

    @Test
    public void testInvalidData() {
        try {
            // Попытка создать объект с неверными данными
            Creature creature = new Creature(35, 40, 0, "Invalid", -5);
            fail("Ожидалось исключение ConstraintViolationException, но оно не было выброшено.");
        } catch (ConstraintViolationException e) {
            // Если исключение было выброшено, можно вывести дополнительное сообщение об ошибке
            System.out.println("Исключение успешно перехвачено: " + e.getMessage());
        }
    }
}
