import greenfoot.Actor;
import greenfoot.World;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import java.util.List;

import java.awt.Color;

/**
 * Escribe una descrición de la clase Superviviente aquí.
 * 
 * @autor (tu nombre) 
 * @versión (Un número de versión o una fecha)
 */
public class Superviviente extends Actor
{
    /**
     * Act - hace lo que Superviviente quiere hacer. Este método se llama "cuando quiera" o whenever
     * los botones 'Actuar or 'Ejecutar' son presionados en el entorno.
     */
    public int speed;
    private int counter = 5;
    private boolean zhurt = false;

    public Superviviente()
    {
     setImage("Superviviente.gif");
    }
    public Superviviente(int spd)
    {
     speed = spd;
    }
    public void act() 
    {
        // Agrega tus códigos de acción aquí.
        move();
    }   
        private void move()
    {
        List p=getObjectsInRange(450,Player.class);
        int Distx, Disty;
        double angle;
        if(p.size()>0)
        {
            Player P=(Player)p.get(0);
            Distx=getX()-P.getX();
            Disty=getY()-P.getY();
            angle=Math.toDegrees(Math.atan2(Disty,Distx))+180;
            setRotation((int)angle);
            angle = Math.toRadians( getRotation() );
            int x = (int) Math.round(getX() + Math.cos(angle) * speed);
            int y = (int) Math.round(getY() + Math.sin(angle) * speed);
            setLocation(x, y);
        }
    }
}
