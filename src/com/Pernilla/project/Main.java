package com.Pernilla.project;

public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        Monster monster = new Monster();
        Player player = new Player();

        game.Welcome();
        game.Menu();

        if (player.health > 0 && monster.health > 0) {
            player.playerCombatAct();
            monster.monsterAttack();
        } else {
            if (player.health < 0);
            player.playerLost();
            
            if (monster.health < 0) {
                monster.monsterDied();
            }
        }

    }

}
