package com.Pernilla.project;

import java.util.Random;
import java.util.Scanner;

public class Player implements ICombat {

    Monster monster;
    Game game;

    public static int strength = 8;
    public static int intelligence = 10;
    public static int agility = 20;
    public static int health = 100;
    public static int experience = 0;
    public int level = 1;

    int damage;
    boolean dodged;



    public void playerStatus() {

        Game game = new Game();
        System.out.println("This is your current status, " + Game.name + ":" +
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
    public Boolean playerDidDodge() {
        Random random = new Random();
        Monster monster = new Monster();
        int i = random.nextInt(0, 50);
        if (i < this.agility) {
            System.out.println("You managed to dodge the attack!"); //TODO go back to playermenu
        } else {
            System.out.println("You were to slow!");
            monster.fight();
        }
        return dodged;
    }
    public void playerLevelUp() {
        if (this.experience > 49) {
            this.level = this.level + 1;
            this.strength++;
            this.intelligence++;
            this.agility++;
            this.health = this.health + 10;
            System.out.println(game.name + ", you have leveled up!");
        }
    }

    public void playerLost() {
        Monster monster = new Monster();
        Scanner scan = new Scanner(System.in);
        if (this.health < 1) {
            System.out.println("You have been killed by the " + monster.monster +
                    " and your tombstone came to it's use," + game.name);
            System.out.println("Would you like to start over? Y/N");

            if (scan.next() == "y") {

            } else {
                System.out.println("Bye bye");
                System.exit(0);
            }
        }
    }
    @Override
    public int fight() {
        damage = this.strength + this.level / 4 + 1;
        System.out.println("cost damage to the " + monster.monster + " by " + damage);
        calculateDamage();
        return damage;
    }

    @Override
    public void calculateDamage() {
        Monster monster = new Monster();
        monster.health = monster.health - damage;
        this.experience = this.experience + 10;

        System.out.println("The " + monster.monster + " health is now: " + monster.health);
    }
}
