package com.Pernilla.project;

public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        Monster monster = new Monster();
        Player player = new Player();

        game.Welcome();
        game.Menu();

        // TODO - do-while så länge spelet pågår

        if (Player.getHealth() > 0 && Monster.getHealth() > 0) {
            player.playerCombatAct();
            monster.monsterAttack();
        } else {
            if (Player.getHealth() < 0);
            player.playerLost();

            if (Monster.getHealth() < 0) {
                monster.monsterDied();
            }
        }

    }

}
