import greenfoot.Actor;
import greenfoot.World;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import java.util.List;

import java.awt.Color;

public class Necrofago extends Actor
{
    public int speed;
    private int counter = 5;
    private int zhealth = 10;    
    private boolean zhurt = true;    
    private boolean fromShotgun = false;

    public Necrofago()
    {
     setImage("Necrofago.gif");
    }
    
    public Necrofago(int spd)
    {
        speed = spd;
    }
    
    public void act() 
    {
        Actor a = getOneIntersectingObject(Bullet.class);
        Actor b = getOneIntersectingObject(ImpBullet.class);
        if (a != null)
        {
            zhurt(Greenfoot.getRandomNumber(2)+1);
            zhurt = true;
            World w = getWorld();
            int size = Greenfoot.getRandomNumber(10)+5;
            for (int i = 0; i < size; i++)
            {
                Color col = Color.red;
                int rot = getRotation()+180;
                double spd = (double)Greenfoot.getRandomNumber(4)-.1*Greenfoot.getRandomNumber(5);
                w.addObject(new Particle(rot,spd,col),getX(),getY());
            }
            return;
        }
        if (b != null)
        {
            zhurt(Greenfoot.getRandomNumber(2)+3);
            zhurt = true;
            World w = getWorld();
            int size = Greenfoot.getRandomNumber(10)+5;
            for (int i = 0; i < size; i++)
            {
                Color col = Color.red;
                int rot = getRotation()+180;
                double spd = (double)Greenfoot.getRandomNumber(4)-.1*Greenfoot.getRandomNumber(5);
                w.addObject(new Particle(rot,spd,col),getX(),getY());
            }
            return;
        }
        if (zhealth <= 10)
            doStuff();
        if (zhealth <= 10)
            removeTouching(Bullet.class);
        if (zhealth <= 0)
            getWorld().removeObject(this);
        if (Greenfoot.getRandomNumber(1000) > 998)
        {
            Greenfoot.playSound("zombiesound.mp3");
        }
    }  
    
    public boolean atWorldEdge()
    {
        if(getX() < 20 || getX() > getWorld().getWidth() - 20)
            return true;
        if(getY() < 20 || getY() > getWorld().getHeight() - 20)
            return true;
        else
            return false;
    }
    
    public void zhurt(int amount)
    {
        zhealth -= amount;
        int size = Greenfoot.getRandomNumber(5)+1;
    }
    
    public void doStuff()
    {
        if (atWorldEdge())
        {
            turnTowards(450,300);
        }
        move(2);
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
    
    public int getzhealth()
    {
        return zhealth;
    }
}