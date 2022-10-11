package com.Pernilla.project;

import java.util.Scanner;

public class Game {

    public static String name;
    int menuChoice;



    Player player = new Player();


    public String Welcome () {

        System.out.println("Welcome to DungeonRun! Hope you come prepared!");
        System.out.println("We are starting to prepare your tombstone. What is your name?");
        Scanner scan = new Scanner(System.in);
        this.name = scan.next();

        return this.name;

    }
    public int Menu() {

        Monster monster = new Monster();

        System.out.println("Ok " + this.name + ", what would you like to do now?");
        System.out.println("Press 1 to enter the Dungeon.\nPress 2 to see your status.\nPress 3 to exit the game.");
        Scanner scan = new Scanner(System.in);


        switch (scan.nextInt()) {
            case 1 -> monster.getMonster();
            case 2 -> player.playerStatus();
            case 9 -> {
                System.out.println("Bye bye!");
                System.exit(0);
            }
            default -> System.out.println("Something went wrong. Please choose your path - " +
                    "\nPress 1 to fight.\nPress 2 to see your status.\nPress 3 to exit the game.");
        }
            return menuChoice;
    }




}
