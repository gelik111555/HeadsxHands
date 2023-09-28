package Models;
import Validators.ValidHealth;

import javax.validation.*;
import javax.validation.constraints.*;
import java.util.Set;

public class Creature {
    public Creature(int attack, int defense, int health, String name, int damage) {
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.maxHealth = health;
        this.name = name;
        this.damage = damage;
        // Проводим валидацию объекта
        validate();
    }
    @Min(value = 1, message = "Значение должно быть не менее 1")
    @Max(value = 30, message = "Значение должно быть не более 30")
    protected int attack;

    @Min(value = 1, message = "Значение должно быть не менее 1")
    @Max(value = 30, message = "Значение должно быть не более 30")
    protected int defense;

    @ValidHealth
    protected int health;
    protected int maxHealth;

    @Min(value = 1, message = "Значение должно быть не менее 1")
    @Max(value = 30, message = "Значение должно быть не более 30")
    private int damage;

    @NotBlank(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 50, message = "Имя должно содержать от 2 до 50 символов")
    protected String name;
    private boolean isAlive = true  ;
    public boolean isAlive() {
        return isAlive;
    }
    public int getDefense() {
        return defense;
    }
    public int getHealth() {
        return health;
    }
    public String getName() {
        return name;
    }
    public void setHealth(int health) {

        this.health = health;
        if (health <= 0) {
            this.health = 0;
            isAlive = false; // Устанавливаем флаг "не жив"
        }
    }
    public int getAttack() {
        return attack;
    }

    // Геттер для параметра "урон"
    public int getDamage() {
        return damage;
    }

    private void validate() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Creature>> violations = validator.validate(this);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }

        factory.close();
    }
}
