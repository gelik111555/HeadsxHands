# Console Battle Simulator

This repository contains a console application that lets you witness thrilling battles between a hero and a monster.

## Key Features

- **Creature Base Class**: The program incorporates a core base class called "Creature" which serves as the foundation for hero and monster entities.

- **Hero and Monster**: Utilizing inheritance, we've created "Hero" and "Monster" classes, each equipped with unique abilities and attributes. Notably, the hero can heal up to 4 times during battles.

- **Rigorous Testing**: Every method within the program has undergone meticulous testing to ensure reliability and correctness.

- **Customizable Battle Functionality**: The battle functionality is designed as an interface named "BattleInterface." This means you have the flexibility to override and customize the battle logic by creating your own class that implements this interface.

## Usage Example

In this example, we demonstrate a battle between a hero and a monster using the `Player` and `Monster` classes, as well as the battle service `BattleService`.

```java
public static void main(String[] args) {
    BattleInterface battleService = new BattleService();

    Creature hero = new Player(10, 5, 50, "Hero", 5); // Creating the hero
    Creature monster = new Monster(7, 2, 60, "Monster", 7); // Creating the monster

    boolean heroTurn = true; // Flag to determine whose turn it is
    AttackResult result;
    while (hero.isAlive() && monster.isAlive()) {
        if (heroTurn) {
            // Hero's turn: hero attacks the monster
            result =  battleService.attack(hero, monster);
            System.out.println(result.getMessage());
            heroTurn = false; // Pass the turn to the monster
        } else {
            // Monster's turn: monster attacks the hero
            result =  battleService.attack(monster, hero);
            System.out.println(result.getMessage());
            heroTurn = true; // Pass the turn to the hero
        }
    }
    if(hero.isAlive())
        System.out.println("Hero wins");
    else
        System.out.println("Monster wins");
}
```
## Contact

For questions or further information, please don't hesitate to contact me via [Telegram](https://t.me/gleb777777).

