import greenfoot.Actor;
import greenfoot.World;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

import java.awt.Color;

public class Bullet extends Actor
{
    private int speed = 100;
    private boolean fromShotgun = false;

    public Bullet(boolean shot, int speed)
    {
        GreenfootImage img = new GreenfootImage(4,2);
        img.setColor(Color.yellow);
        img.fill();
        setImage(img);
        fromShotgun = shot; 
        this.speed = speed;
    }

    public void act()
    {
        Actor a = moved(speed);
        if (getX() > getWorld().getWidth() || getX() < 0 || getY() < 0 || getY() > getWorld().getHeight())
            getWorld().removeObject(this);
    }
    
    public Actor moved(int amount)
    {
        int x1 = getX();
        int y1 = getY();
        move(amount);
        int x2 = getX();
        int y2 = getY();
        setLocation(x1,y1);
        Actor a = null;
        for (int i = 0; i < amount; i +=5)
        {
            move(5);
            a = getOneIntersectingObject(Zombie.class);
            if (a != null)
                break;
        }
        setLocation(x2,y2);
        return a;
    }
}