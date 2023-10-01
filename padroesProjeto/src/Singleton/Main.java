package Singleton;

import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        String playerName;

        // Precisa verificar se o nome não é vazio ou nulo
        playerName = JOptionPane.showInputDialog(null, "Quem está jogando?","Let's Battle", JOptionPane.QUESTION_MESSAGE);

        Game(playerName);
    }

    public static void Game(String playerName)
    {
        GameManager gameManager = GameManager.getInstance();
        String[] enemies = {"slime.png", "morcego.png", "esqueleto.png",
                "mage.png", "boss01.png"};
        String[] options = {"Atacar!", "Sair!"};

        int op;

        int playerVida = gameManager.getVida();
        int playerDano = gameManager.getDano();

        String[] splitEnemy = enemies[0].split("\\.");
        String enemyNome = splitEnemy[0].toUpperCase();
        double enemyVida = 1;
        double enemyDano = 1;

        do
        {
            op = JOptionPane.showOptionDialog(null, enemyNome + "\nVIDA: " + enemyVida, "Let's Battle!",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, new ImageIcon("images/" + enemies[0]), options, options[0]);

            if(op != 1)
            {

            }
        }
        while(playerVida != 0 && op != 1);
    }

    void Battle(int playerDano, double enemyDano)
    {

    }
}