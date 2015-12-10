import greenfoot.*;
import greenfoot.World;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import java.awt.Color;
import greenfoot.core.WorldHandler;
import javax.swing.JPanel;
import java.awt.Point;
import java.awt.Toolkit;
/**
 * Escribe una descrición de la clase Escenario aquí.
 * 
 * @autor (tu nombre) 
 * @versión (Un número de versión o una fecha)
 */
public class Game extends World
{
    GreenfootSound backgroundMusic = new GreenfootSound("Music.mp3");
    private int ztimer = 0;
    private int ttimer = 0;
    private int ctimer = 0;
    private int speed = 1;
    private int maxTime = 90;
    private int score = 0;

    //Posicion del marcador   
    private static final int RADS_POS_X = 50;
    private static final int RADS_POS_Y = 15;

    private Rads rads = new Rads();
    int point = 0;
    //private Rads radiacion = new Radiacion();
    /**
     * Constructor para objetos de clase Ciudad.
     * 
     */
    public Game()
    {    
        // Crea un nuevo mundo de 600x400 celdas con un tamaño de celda de 1x1 pixeles.
        super(650, 750, 1); 

        // Esta linea se encarga de poner el actor (objeto de la clase Nave) en su posicion inicial
        addObject(rads, RADS_POS_X, RADS_POS_Y);

        GreenfootImage img = new GreenfootImage(900, 600);
        img.fill();
        //Posicion del jugador 
        addObject(new Player(),getWidth()/2,getHeight()/2);
        addObject(new Score(),79,61);
        addObject(new Barricada(),getWidth()/2,getHeight()/2);
        setPaintOrder(Player.class,Zombie.class,Necrofago.class,ZRadiactivo.class,Jefe.class,Bullet.class);
        setActOrder(Player.class, Zombie.class,Necrofago.class,ZRadiactivo.class,Jefe.class,Bullet.class);
        for(int i=0; i<3; i++)
        {
            RadAway radAway = new RadAway();
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(radAway, x, y);
        }
        
    }
    //Empieza el acto
    public void act()
    {
     getPlayer();
        
     
        if (Greenfoot.getMouseInfo() == null)
            return;
        //updateVars();
        if (ztimer <= 0)
            releaseASquare();
        else
            ztimer--;

        if (Greenfoot.getMouseInfo() == null)
            return;
        //updateVars();
        if (ttimer <= 0)
            releaseASquare();
        else
            ttimer--;

        if (Greenfoot.getMouseInfo() == null)
            return;
        //updateVars();
        if (ctimer <= 0)
            releaseASquare();
        else
            ctimer--;
    }
    //Comienza musica
    public void started()
    {
        backgroundMusic.playLoop();
    }
    //Nuevo jugador
    public Player getPlayer()
    {
        return new Player();
    }
    //Liberad los zombies XD
    public void releaseASquare()
    {    
        Zombie z = new Zombie();
        Necrofago t = new Necrofago();
        ZRadiactivo c = new ZRadiactivo();
        Jefe b = new Jefe();
        Superviviente s = new Superviviente();

        addObject(z, 1, 1);
        while (z.getX() < getWidth() && z.getX() > 0 && z.getY() < getHeight() && z.getY() > 0)
        {    
            int x = Greenfoot.getRandomNumber(700)+300;
            if (Greenfoot.getRandomNumber(2)+1 == 1)
                x = -x;
            int y = Greenfoot.getRandomNumber(700)+300;
            if (Greenfoot.getRandomNumber(2)+1 == 1)
                y = -y;
            z.setLocation(x,y);
        }
        ztimer = Greenfoot.getRandomNumber(400);

        addObject(t, 1, 1);
        while (t.getX() < getWidth() && t.getX() > 0 && t.getY() < getHeight() && t.getY() > 0)
        {    
            int x = Greenfoot.getRandomNumber(700)+300;
            if (Greenfoot.getRandomNumber(2)+1 == 1)
                x = -x;
            int y = Greenfoot.getRandomNumber(700)+300;
            if (Greenfoot.getRandomNumber(2)+1 == 1)
                y = -y;
            t.setLocation(x,y);
        }
        ttimer = Greenfoot.getRandomNumber(8000);

        addObject(c, 1, 1);
        while (c.getX() < getWidth() && c.getX() > 0 && c.getY() < getHeight() && c.getY() > 0)
        {    
            int x = Greenfoot.getRandomNumber(700)+300;
            if (Greenfoot.getRandomNumber(2)+1 == 1)
                x = -x;
            int y = Greenfoot.getRandomNumber(700)+300;
            if (Greenfoot.getRandomNumber(2)+1 == 1)
                y = -y;
            c.setLocation(x,y);
        }
        ctimer = Greenfoot.getRandomNumber(4000);
        
        addObject(b, 1, 1);
        while (b.getX() < getWidth() && b.getX() > 0 && b.getY() < getHeight() && b.getY() > 0)
        {    
            int x = Greenfoot.getRandomNumber(700)+300;
            if (Greenfoot.getRandomNumber(2)+1 == 1)
                x = -x;
            int y = Greenfoot.getRandomNumber(700)+300;
            if (Greenfoot.getRandomNumber(2)+1 == 1)
                y = -y;
            b.setLocation(x,y);
        }
        ctimer = Greenfoot.getRandomNumber(1000);
        
        addObject(s, 1, 1);
        while (s.getX() < getWidth() && s.getX() > 0 && s.getY() < getHeight() && s.getY() > 0)
        {    
            int x = Greenfoot.getRandomNumber(700)+300;
            if (Greenfoot.getRandomNumber(2)+1 == 1)
                x = -x;
            int y = Greenfoot.getRandomNumber(700)+300;
            if (Greenfoot.getRandomNumber(2)+1 == 1)
                y = -y;
            s.setLocation(x,y);
        }
        ctimer = Greenfoot.getRandomNumber(10000);
    }
    //Puntos
    public void point(int amount)
    {
        score += amount;
        int size = 10;
    }
    //Obtener la puntuacion
    public int getScore()
    {
        return score;
    }
    //sobre pantalla GAME OVER
    public void gameOver()
    {
        removeObjects(getObjects(greenfoot.Actor.class));
        getBackground().drawImage(new GreenfootImage("Game Over",40,Color.white,null),getWidth()/2-75,getHeight()/2-60);
        //getBackground().drawImage(new GreenfootImage("Score:",40,Color.white,null),getWidth()/2-40,getHeight()/2-20);      
        Greenfoot.stop();
    }
}
