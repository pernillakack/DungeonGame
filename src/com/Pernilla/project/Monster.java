package com.Pernilla.project;

import java.util.Random;
import java.util.Scanner;

public class Monster implements ICombat{


    private static String monster;
    private static int strength;
    private static int health;
    private int baseDamage;
    int i;
    boolean monsterStatus = true;
    int damage;

    public static String getMonster() {
        return monster;
    }

    public static void setMonster(String monster) {
        Monster.monster = monster;
    }

    public static int getStrength() {
        return strength;
    }

    public static void setStrength(int strength) {
        Monster.strength = strength;
    }

    public static int getHealth() {
        return health;
    }

    public static void setHealth(int health) {
        Monster.health = health;
    }

    public void generateMonster() {

        Game game = new Game();
        Player player = new Player();

        String[] Monster = {"Ogre", "Troll", "Orc", "Minotaur","Zombie"};
        Random random = new Random();
        i = random.nextInt(0, 4);
        switch (i) {
            case 0:
                monster = "Ogre";
                health = 100;
                strength = 15;
                break;
            case 1:
                monster = "Troll";
                health = 100;
                strength = 12;
                break;
            case 2:
                monster = "Orc";
                health = 90;
                strength = 10;
                break;
            case 3:
                monster = "Minotaur";
                health = 90;
                strength = 9;
                break;
            case 4:
                monster = "Zombie";
                health = 80;
                strength = 8;
                break;
        }
        System.out.println("You have awakened the " + (Monster[i])
                + " and it is charging against you, " + Player.getName() + "!\nWhat will you do?");
        player.playerCombatAct();
    }

    public void monsterStatus() {
        Player player = new Player();

        System.out.println("The " + monster + " has " + strength + " in strength and " + health + " in health");

        player.playerCombatAct();
    }
    public void monsterAttack () {
        Scanner scan = new Scanner(System.in);
        Player player = new Player();
        System.out.println("The " + monster + " turns around and attacks you again! What will you do?" +
                "\n Press 1 to try and dodge." +
                "\n Press 2 to try to run away.");
        switch (scan.next()) {
            case "1":
                player.playerDidDodge();
                break;
            case "2":
                System.out.println("Create playerRunsAway"); //TODO Create playerRunsAway
                break;
            default:
                System.out.println("Please try again:" +
                        "\n Press 1 to try and dodge." +
                        "\n Press 2 to try to run away.");
        }

    }
    public void monsterDied () {
        Scanner scan = new Scanner(System.in);
        Player player = new Player();
        if (health < 1) {
            System.out.println("Congrats! You have slayed the " + monster + " and won a grand price!" +
                    "\n Would you like to continue in to the dungeon or are you a quitter?" +
                    "\n Press 1 to continue" +
                    "\n Press 2 to quit");
            switch (scan.next()) {
                case "1":
                    player.playerCombatAct();
                    break;
                case "2":
                    System.out.println("Bye bye!");
                    System.exit(0);
                default:
                    System.out.println("Pleas try again;" +
                            "\n Press 1 to continue" +
                            "\n Press 2 to quit");
            }
        }
    }

    @Override
    public int fight() {
        Game game = new Game();
        damage = strength / 4 + 1;

        calculateDamage();
        return damage;

    }

    @Override
    public void calculateDamage() {
    Player player = new Player();
    Player.setHealth((Player.getHealth() - damage));


        System.out.println("The " + monster + " caused damage by " + damage + " points to your health.");
        player.fight();

    }
}
