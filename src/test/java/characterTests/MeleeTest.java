package characterTests;

import characters.heroes.Melee;
import items.Item;
import items.Weapon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MeleeTest {
    private Melee melee;
    private Item item1;

    @Before
    public void before() {
        melee = new Melee(100, 20, 1);
    }

    @Test
    public void hasHealth() {
        assertEquals(100, melee.getHealth());
    }

    @Test
    public void hasDamage() {
        assertEquals(20, melee.getDamage());
    }

    @Test
    public void startsWithNoXp() {
        assertEquals(0, melee.getXp());
    }

    @Test
    public void hasLevel() {
        assertEquals(1, melee.getLevel());
    }

    @Test
    public void startsWith100Gold() {
        assertEquals(100, melee.getGold());
    }

    @Test
    public void inventoryStartsEmpty() {
        assertEquals(0, melee.getInventory().size());
    }

    @Test
    public void startsWithFistAsWeapon() {
        assertEquals("Fist", melee.getWeapon().getName());
    }

    @Test
    public void canAddGold() {
        melee.addGold(50);
        assertEquals(150, melee.getGold());
    }

    @Test
    public void canAddXp() {
        melee.addXp(10);
        assertEquals(10, melee.getXp());
    }

    @Test
    public void canAddToInventory() {
        item1 = new Item("Healing potion");
        melee.addToInventory(item1);
        assertEquals(1, melee.getInventory().size());
    }

    @Test
    public void canRemoveFromInventory() {
        item1 = new Item("Healing potion");
        Item item2 = new Item("Sword");
        Item item3 = new Item("Diamond");
        melee.addToInventory(item1);
        melee.addToInventory(item2);
        melee.addToInventory(item3);
        melee.removeFromInventory(item2);
        assertEquals(2, melee.getInventory().size());
    }

    @Test
    public void canLevelUp() {
        melee.levelUp();
        assertEquals(120, melee.getHealth());
        assertEquals(24, melee.getDamage());
        assertEquals(0, melee.getXp());
        assertEquals(2, melee.getLevel());
    }

    @Test
    public void canReduceHealth() {
        melee.reduceHealth(20);
        assertEquals(80, melee.getHealth());
    }

    @Test
    public void canChangeWeapon() {
        Weapon weapon = new Weapon("Sword", 10);
        melee.addToInventory(weapon);
        melee.changeWeapon(weapon);
        assertEquals("Sword", melee.getWeapon().getName());
        assertEquals(10, melee.getWeapon().getDamage());
    }

    @Test
    public void cannotEquipWeaponNotInInventory() {
        Weapon weapon = new Weapon("Sword", 10);
        melee.changeWeapon(weapon);
        assertEquals("Fist", melee.getWeapon().getName());
        assertEquals(2, melee.getWeapon().getDamage());
    }

    @Test
    public void canUnequipWeapon() {
        Weapon weapon = new Weapon("Sword", 10);
        melee.addToInventory(weapon);
        melee.changeWeapon(weapon);
        melee.unequipWeapon();
        assertEquals("Fist", melee.getWeapon().getName());
        assertEquals(2, melee.getWeapon().getDamage());
    }

    @Test
    public void cannotUnequipFist() {
        Weapon weapon = new Weapon("Fist", 5);
        melee.addToInventory(weapon);
        melee.changeWeapon(weapon);
        melee.unequipWeapon();
        assertEquals("Fist", melee.getWeapon().getName());
        assertEquals(5, melee.getWeapon().getDamage());
    }
}