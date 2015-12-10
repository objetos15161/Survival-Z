import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import java.awt.Color;

import java.util.List;
import java.util.ArrayList;

/**
 * Escribe una descrición de la clase Barricada aquí.
 * 
 * @autor (tu nombre) 
 * @versión (Un número de versión o una fecha)
 */
public class Barricada extends Actor
{
    private int health = 100;
    private boolean hurt = true;
    
    /**
     * Act - hace lo que Barricada quiere hacer. Este método se llama "cuando quiera" o whenever
     * los botones 'Actuar or 'Ejecutar' son presionados en el entorno.
     */
    public void act() 
    {
     // Agrega tus códigos de acción aquí
        Actor a = getOneIntersectingObject(Necrofago.class);
        Actor b = getOneIntersectingObject(Zombie.class);
        Actor c = getOneIntersectingObject(ZRadiactivo.class);
        Actor d = getOneIntersectingObject(Jefe.class);

        if (a != null)
        {
         hurt(2);
         hurt = true;
        }

        if (b != null)
        {
         hurt(4);
         hurt = true;
        }

        if (c != null)
        {
         hurt(1);
         hurt = true;
        }
        
         if (d != null)
        {
         hurt(1);
         hurt = true;
        }
        if(health <= 0)
          //getWorld().removeObject(Barricada;
          removeTouching(Barricada.class);
    } 
    
    public Barricada()
    {
     setImage("Barricada.png");
     
    }
    public void hurt(int amount)
    {
        health -= amount;
        int size = Greenfoot.getRandomNumber(5)+1;
        for (int i = 0; i < size; i++)
        {
            int rot = Greenfoot.getRandomNumber(360);
            int spd = 2;
        }
    }
    public int getHealth()
    {
     return health;
    }
}
