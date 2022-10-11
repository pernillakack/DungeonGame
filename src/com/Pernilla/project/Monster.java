package com.Pernilla.project;

import java.util.Random;
import java.util.Scanner;

public class Monster implements ICombat{


    public static String monster;
    public static int strength;
    public static int health;
    public int baseDamage;
    static int i;
    boolean monsterStatus = true;
    int damage;

    public void getMonster() {

        Game game = new Game();
        Player player = new Player();

        String[] Monster = {"Ogre", "Troll", "Orc", "Minotaur","Zombie"};
        Random random = new Random();
        i = random.nextInt(0, 4);
        switch (i) {
            case 0:
                this.monster = "Ogre";
                this.health = 100;
                this.strength = 15;
                break;
            case 1:
                this.monster = "Troll";
                this.health = 100;
                this.strength = 12;
                break;
            case 2:
                this.monster = "Orc";
                this.health = 90;
                this.strength = 10;
                break;
            case 3:
                this.monster = "Minotaur";
                this.health = 90;
                this.strength = 9;
                break;
            case 4:
                this.monster = "Zombie";
                this.health = 80;
                this.strength = 8;
                break;
        }
        System.out.println("You have awakened the " + (Monster[i])
                + " and it is charging against you, " + game.name + "!\nWhat will you do?");
        player.playerCombatAct();
    }

    public void monsterStatus() {
        Player player = new Player();

        System.out.println("The " + this.monster + " has " + this.strength + " in strength and " + this.health + " in health");

        player.playerCombatAct();
    }
    public void monsterAttack () {
        Scanner scan = new Scanner(System.in);
        Player player = new Player();
        System.out.println("The " + this.monster + " turns around and attacks you again! What will you do?" +
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
        if (this.health < 1) {
            System.out.println("Congrats! You have slayed the " + this.monster + " and won a grand price!" +
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
        damage = this.strength / 4 + 1;

        calculateDamage();
        return damage;

    }

    @Override
    public void calculateDamage() {
    Player player = new Player();
    player.health = player.health - damage;


        System.out.println("The " + this.monster + " caused damage by " + damage + " points to your health.");
        player.fight();

    }
}
