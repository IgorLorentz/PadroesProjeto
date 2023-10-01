package Singleton;

public class GameManager
{
    private static GameManager instance;
    private String[] status = {"NextLevel", "Finish"};
    private int level;
    private int score;


    private String playerName;
    private double playerLife;
    private double playerDMG;

    private String[] enemyNames = {"Slime", "Morcego", "Esqueleto",
            "Mage", "Boss01"};
    private double enemyLife;
    private double enemyDMG;

    private GameManager()
    {
        this.level = 0;
        this.score = 0;

        this.playerLife = 5;
        this.playerDMG = 1;

        this.enemyLife = 1;
        this.enemyDMG = 1;
    }

    public static GameManager getInstance()
    {
        if(instance == null)
        {
            instance = new GameManager();
        }

        return instance;
    }

    public void nextLevel()
    {
        this.level++;

        this.playerLife *= 1.5;
        this.playerDMG *= 1.5;

        this.enemyLife *= 3;
        this.enemyDMG *= 2;
    }

    public int getLevel()
    {
        return level;
    }

    public int getScore()
    {
        return score;
    }

    public String getPlayerName()
    {
        return playerName;
    }

    public void setPlayerName(String playerName)
    {
        this.playerName = playerName;
    }

    public double getPlayerLife()
    {
        return playerLife;
    }

    public double getPlayerDMG()
    {
        return playerDMG;
    }

    public String getEnemyName(int i)
    {
        return enemyNames[i];
    }

    public double getEnemyLife()
    {
        return enemyLife;
    }

    public double getEnemyDMG()
    {
        return enemyDMG;
    }
}