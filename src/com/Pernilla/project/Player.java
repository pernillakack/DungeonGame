package com.Pernilla.project;

import java.util.Random;
import java.util.Scanner;

public class Player implements ICombat {

    Monster monster;
    Game game;
    private static String name;

    private static int strength = 8;
    private static int intelligence = 10;
    private static int agility = 20;

    private static int health = 100;
    private static int experience = 0;
    private static int speed = 10;
    private int level = 1;

    int damage;
    boolean dodged;

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        Player.name = name;
    }

    public static int getStrength() {
        return strength;
    }

    public static void setStrength(int strength) {
        Player.strength = strength;
    }

    public static int getIntelligence() {
        return intelligence;
    }

    public static void setIntelligence(int intelligence) {
        Player.intelligence = intelligence;
    }

    public static int getAgility() {
        return agility;
    }

    public static void setAgility(int agility) {
        Player.agility = agility;
    }

    public static int getHealth() {
        return health;
    }

    public static void setHealth(int health) {
        Player.health = health;
    }

    public static int getExperience() {
        return experience;
    }

    public static void setExperience(int experience) {
        Player.experience = experience;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean isDodged() {
        return dodged;
    }

    public void setDodged(boolean dodged) {
        this.dodged = dodged;
    }


    public void playerStatus() {

        Game game = new Game();
        System.out.println("This is your current status, " + name + ":" +
                "\n Strength: " + strength +
                "\n Intelligence: " + intelligence +
                "\n Agility: " + agility +
                "\n Health: " + health +
                "\n Experience: " + experience +
                "\n Level: " + level);

        System.out.println("Press 1 to go back to the starting menu or press 2 to go back to fighting menu.");
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        if(x == 1) {
            game.Menu();
        } else {
            playerCombatAct();
        }
    }

    public void playerCombatAct() {

        Monster monster = new Monster();

            System.out.println("Choose one of the following:" +
                    "\n Press 1 to swing your sword at it." +
                    "\n Press 2 to to try and dodge." +
                    "\n Press 3 to run away." +
                    "\n Press 4 to se your status." +
                    "\n Press 5 to se the monsters status." +
                    "\n Press 9 to exit the game");

            Scanner scan = new Scanner(System.in);


            switch (scan.next()) {
                case "1":
                    System.out.println("You swung your sword and");
                    fight();
                    break;
                case "2":
                    playerDidDodge();
                    break;
                case "3":
                    System.out.println("Tries to run away"); //TODO playerRunsAway
                    break;
                case "4":
                    playerStatus();
                    break;
                case "5":
                    monster.monsterStatus();
                    break;
                case "9":
                    System.out.println("Bye bye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please try again" +
                            "\n Press 1 to swing your sword at it." +
                            "\n Press 2 to to try and dodge." +
                            "\n Press 3 to run away." +
                            "\n Press 4 to se your status." +
                            "\n Press 5 to se the monsters status." +
                            "\n Press 9 to exit the game");
            }
        }
    public void playerDidDodge() {
        Random random = new Random();
        Monster monster = new Monster();
        int i = random.nextInt(0, 50);
        if (i < agility) {
            System.out.println("You managed to dodge the attack!");
            playerCombatAct();
        } else {
            System.out.println("You were to slow!");
            monster.fight();
        }
    }
    public void playerLevelUp() {
        if (experience > 49) {
            level = (level + 1);
            strength++;
            intelligence++;
            agility++;
            health = (health + 10);
            System.out.println(Player.getName() + ", you have leveled up!");
        }
    }

    public void playerLost() {
        Scanner scan = new Scanner(System.in);
        if (health < 1) {
            System.out.println("You have been killed by the " + Monster.getMonster() +
                    " and your tombstone came to it's use," + Player.getName());
            System.out.println("Would you like to start over? y/n");

            if (scan.next() == "y") {
                game.Welcome();
            } else {
                System.out.println("Bye bye");
                System.exit(0);
            }
        }
    }

    public void playerRunsAway() {
        Random random = new Random();
        int i = random.nextInt();

    }
    @Override
    public int fight() {
        damage = strength + this.level / 4 + 1;
        System.out.println("cost damage to the " + Monster.getMonster() + " by " + damage);
        calculateDamage();
        return damage;
    }

    @Override
    public void calculateDamage() {
        Monster monster = new Monster();
        Monster.setHealth(Monster.getHealth() - damage);
        experience = experience + 10;

        System.out.println("The " + Monster.getMonster() + " health is now: " + Monster.getHealth());
    }
}
