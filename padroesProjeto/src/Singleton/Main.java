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

        var playerLife = gameManager.getPlayerLife();
        var playerDMG = gameManager.getPlayerDMG();

        var enemyName = gameManager.getEnemyName(level);
        var enemyLife = gameManager.getEnemyLife();
        var enemyDMG = gameManager.getEnemyDMG();

        var status = Battle(playerName, playerLife, playerDMG, enemyName, enemyLife, enemyDMG);

        if(status == 0)
        {
            gameManager.nextLevel();
            Game(playerName);
        }
    }

    static int Battle(String playerName, double playerLife, double playerDMG, String enemyName, double enemyLife, double enemyDMG)
    {
        Random rand = new Random();
        int op = 0;
        double critChance = rand.nextDouble();

        do
        {
            op = BattlePanel(playerName, enemyName, enemyLife, enemyDMG);

            if(op != 0)
                return 1;

            if(critChance <= 0.4)
            {
                enemyLife -= playerDMG * 2;

                System.out.println("CRÍTICO!");
            }
            else
            {
                enemyLife -= playerDMG;
            }

            System.out.println("Inimigo: " + enemyLife);

            if(enemyLife > 0)
            {
                playerLife -= enemyDMG;
            }

            System.out.println("Player: " + playerLife);

            if(playerLife <= 0)
                return 1;
        }
        while(playerLife > 0 && enemyLife > 0);

        return 0;
    }

    static int BattlePanel(String playerName, String enemyName, double enemyLife, double enemyDMG)
    {
        String[] options = {"Atacar!", "Sair!"};
        String message = enemyName + "\nVIDA: " + enemyLife + "\nDANO: " + enemyDMG;
        String title = "Let's Battle, " + playerName + "!";
        String path = "images/" + enemyName + ".png";

        return JOptionPane.showOptionDialog(null, message, title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE,
                new ImageIcon(path), options, options[0]);
    }
}