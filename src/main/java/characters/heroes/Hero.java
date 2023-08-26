package characters.heroes;

import characters.Character;
import items.Item;

import java.util.ArrayList;

public abstract class Hero extends Character {
    private long gold;
    private ArrayList<Item> inventory;

    public Hero(
            long health,
            int damage,
            int level
    ) {
        super(health, damage, 0, level);
        this.gold = 100;
        this.inventory = new ArrayList<>();
    }

    public long getGold() {
        return gold;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void addGold(long amount) {
        gold += amount;
    }

    public void addToInventory(Item item) {
        inventory.add(item);
    }

    public void removeFromInventory(Item item) {
        inventory.remove(item);
    }

    public void levelUp() {
        long newHealth = getHealth() + (getHealth() / 5);
        setHealth(newHealth);

        int newDamage = getDamage() + (getDamage() / 5);
        setDamage(newDamage);

        setXp(0);

        setLevel(getLevel() + 1);
    }
}
