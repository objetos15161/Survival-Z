import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

import java.awt.Color;

public class Particle extends Actor
{
    private double speed = 0;

    protected int life = 100;

    protected boolean red = true;
    
    protected int size = Greenfoot.getRandomNumber(2)+5;

    private int lastX = 0;
    private int lastY = 0;

    public Particle(int rot, double startingSpeed, Color col)
    {
        setRotation(rot);
        speed = startingSpeed;
        makeImage(col);
    }
    
    private void makeImage(Color col)
    {
        size = Greenfoot.getRandomNumber(2)+5;
        GreenfootImage img = new GreenfootImage(size,size);
        img.setColor(col);
        red = col.equals(Color.red);
        img.fill();
        setImage(img);
    }

    public void act() 
    {
        if (lastX == 0 && lastY == 0 && red)
        {
            lastX = getX();
            lastY = getY();
        }
        Actor a = getOneIntersectingObject(Player.class);
        if (a == null)
            a = getOneIntersectingObject(Zombie.class);
        if (a == null)
            a = getOneIntersectingObject(Jefe.class);
        if (a == null)
            a = getOneIntersectingObject(ZRadiactivo.class);
        if (a != null)
        {
            if ((int)speed == 0)
                speed = 2;
            else
                speed *= 2;
            setRotation(a.getRotation());
        }
        move((int)speed);
        speed -= speed/10.0;
        if (a == null && (lastX != getX() || lastY != getY()) && red)
        {
            lastX = getX();
            lastY = getY();
        }
        else
            red = true;
        if (life <= 0)
            fade();
        else
            dist();
        life--;
        try
        {
            if (getWorld() != null && getX() > getWorld().getWidth() || getY() > getWorld().getWidth() || getY() < 0 || getX() < 0)
                getWorld().removeObject(this);
                life -= 10;
        }
        catch (IllegalStateException e){}
    }

    private void dist()
    {
        Actor p = (Actor)getWorld().getObjects(Player.class).get(0);
        if (p == null)
        {
            getImage().setTransparency(0);
        }
        int dist = (int)Distance.distanceBetween(this,p);
        if (dist > 255)
            dist = 255;
        getImage().setTransparency(255-dist);
        if (dist >= 200)
            life--;
    }

    private void fade()
    {
        if (life <= 0 & getImage().getTransparency()-4 >= 0)
            getImage().setTransparency(getImage().getTransparency()-4);
        else if (life <= 0)
            getWorld().removeObject(this);
    }
}