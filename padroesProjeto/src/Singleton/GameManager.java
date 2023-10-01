package Singleton;

public class GameManager
{
    private static GameManager instance;

    private int vida;
    private int dano;
    private int pontos;

    private GameManager()
    {
        this.vida = 5;
        this.dano = 1;
        this.pontos = 0;
    }

    public static GameManager getInstance()
    {
        if(instance == null)
        {
            instance = new GameManager();
        }

        return instance;
    }

    public int getVida()
    {
        return vida;
    }

    public int getDano()
    {
        return dano;
    }

    public int getPontos()
    {
        return pontos;
    }
}