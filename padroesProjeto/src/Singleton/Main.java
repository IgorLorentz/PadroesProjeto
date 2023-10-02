package Singleton;

import javax.swing.*;
import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        String playerName;

        do
        {
            playerName = JOptionPane.showInputDialog(null, "Quem está jogando?","Let's Battle", JOptionPane.QUESTION_MESSAGE);
        }
        while(playerName != null && playerName.isEmpty());

        if(playerName != null)
            Game(playerName);
    }

    public static void Game(String playerName)
    {
        GameManager gameManager = GameManager.getInstance();
        gameManager.setPlayerName(playerName);

        var level = gameManager.getLevel();
        var enemiesAmount = gameManager.getEnemiesAmount();

        if(level < enemiesAmount)
        {
            var playerLife = gameManager.getPlayerLife();
            var playerDMG = gameManager.getPlayerDMG();

            var enemyName = gameManager.getEnemyName(level);
            var enemyLife = gameManager.getEnemyLife();
            var enemyDMG = gameManager.getEnemyDMG();

            System.out.println("VIDA: " + playerLife + "\nFORÇA: " + playerDMG);

            var state = Battle(playerName, playerLife, playerDMG, enemyName, enemyLife, enemyDMG);

            gameManager.state.setState(state);

            if(state == 1)
            {
                gameManager.nextLevel();
                System.out.println("LEVEL UP!");
                Game(playerName);
            }
        }
        else
        {
            System.out.println("TODOS OS MONSTROS FORAM DERROTADOS, PARABÉNS!");
        }
    }

    static int Battle(String playerName, double playerLife, double playerDMG, String enemyName, double enemyLife, double enemyDMG)
    {
        Random rand = new Random();
        int op;
        double critChance = rand.nextDouble();

        do
        {
            op = BattlePanel(playerName, enemyName, enemyLife, enemyDMG);

            if(op != 0)
                return 2;

            if(critChance <= 0.4)
            {
                enemyLife -= playerDMG * 2;

                System.out.println("CRÍTICO! Dano causado: " + (playerDMG * 2) + "\nVida atual do monstro: " + enemyLife);
            }
            else
            {
                enemyLife -= playerDMG;

                System.out.println("Dano causado: " + playerDMG + "\nVida atual do monstro: " + enemyLife);
            }

            if(enemyLife > 0)
            {
                playerLife -= enemyDMG;

                System.out.println("Dano sofrido: " + enemyDMG + "\nVida atual do player: " + playerLife);
            }

            if(playerLife <= 0)
            {
                System.out.println("PLAYER DERROTADO!");
                return 2;
            }
        }
        while(playerLife > 0 && enemyLife > 0);

        System.out.println("MONSTRO DERROTADO!");
        return 1;
    }

    static int BattlePanel(String playerName, String enemyName, double enemyLife, double enemyDMG)
    {
        String[] options = {"Atacar!", "Sair!"};
        String message = enemyName + "\nVIDA: " + enemyLife + "\nFORÇA: " + enemyDMG;
        String title = "Let's Battle, " + playerName + "!";
        String path = "images/" + enemyName + ".png";

        return JOptionPane.showOptionDialog(null, message, title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE,
                new ImageIcon(path), options, options[0]);
    }
}