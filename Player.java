import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import java.util.ArrayList;

public class Player extends Actor
{
    GreenfootImage scoreBoard = new GreenfootImage(150,100);
    private int speed = 3;
    private int counter = 5;
    private int health = 100;
    private boolean hurt = true;
    private int radAway;
    

    private static final GreenfootImage norm = new GreenfootImage("PLAYER.gif");
    private static final GreenfootImage high = new GreenfootImage("PLAYER3.gif");
    private static final GreenfootImage med = new GreenfootImage("PLAYER5.gif");
    private static final GreenfootImage low = new GreenfootImage("PLAYER4.gif");;

    public Player()
    {
     setImage(norm);
     radAway=0; 
    }

    public void addedToWorld(greenfoot.World wrld)
    {
     move();
    }
    public void act() 
    {
        move();
        shoot();

        if (Greenfoot.getMouseInfo() == null)
            return;
        int x = Greenfoot.getMouseInfo().getX();
        int y = Greenfoot.getMouseInfo().getY();
        turnTowards(x,y);

        Actor a = getOneIntersectingObject(Necrofago.class);
        Actor b = getOneIntersectingObject(Zombie.class);
        Actor c = getOneIntersectingObject(ZRadiactivo.class);
        Actor d = getOneIntersectingObject(Jefe.class);
        Actor e = getOneIntersectingObject(Superviviente.class);

        if (a != null)
        {
            hurt(2);
            a.move(-5);
            hurt = true;
        }

        if (b != null)
        {
            hurt(4);
            b.move(-10);
            hurt = true;
        }

        if (c != null)
        {
            hurt(1);
            c.move(-20);
            hurt = true;
        }
        
         if (d != null)
        {
            hurt(1);
            c.move(-50);
            hurt = true;
        }
         if (e != null)
        {
         health += 50;
        }

        if (health <= 95)
            setImage(high);
        if (health <= 65)
            setImage(med);
        if (health <= 20)
            setImage(low);
        if (health <= 0)
            ((Game)getWorld()).gameOver();
            
       if(foundRad()) 
          eatRad();
       
         //else 
           //  move();
      
    }  

    public void move()
    {
        if (Greenfoot.isKeyDown("w"))
            move(speed);
        if (Greenfoot.isKeyDown("s"))
            move(-speed);
    }

    public void move(int dist)
    {
        int x = getX();
        int y = getY();
        super.move(dist);
        if (getX() > getWorld().getWidth() || getX() < 0)
            setLocation(x, getY());
        if (getY() > getWorld().getHeight() || getY() < 0)
            setLocation(getX(), y);
    }

    private void shoot()
    {
        if (counter < 40)
            counter++;
        if (counter < 10)
            return;
        if (Greenfoot.isKeyDown("space"))
        {
            shootAssault();
            Greenfoot.playSound("bullet.wav");
        }
        if (counter < 40)
            return;
        if (Greenfoot.isKeyDown("shift"))
        {
            shootShotgun();
            Greenfoot.playSound("shotBullet.wav");
        }
    }

    public void shootAssault()
    {
        counter = 0;
        Bullet b = new Bullet(false,20);
        getWorld().addObject(b,getX(),getY());
        b.setRotation(getRotation());
        b.move(10);
        b.turn(90);
        b.move(2);
        b.turn(-90);
        b.turn(Greenfoot.getRandomNumber(8)-4);
    }

    public void shootShotgun()
    {
        counter = 4;
        Bullet[] bees = new Bullet[8];
        for (int i = 0; i < bees.length; i++)
            bees[i] = new Bullet(true,30);
        for (Bullet b : bees)
        {
            getWorld().addObject(b,getX(),getY());
            b.setRotation(getRotation());
            b.move(10);
            b.turn(90);
            b.move(2);
            b.turn(-90);
            b.turn(Greenfoot.getRandomNumber(12)-6);
        }
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
    
    public void eatRad()
    {
        Actor RadAway = getOneObjectAtOffset(0, 0, RadAway.class);
        if(RadAway != null) {
            // eat the leaf...
            getWorld().removeObject(RadAway);
            radAway = health + 10; 
        }
    }
    
    public void foundRadAway()
    {
        Actor RadAway = getOneObjectAtOffset(0, 0, RadAway.class);
        if(RadAway != null)
          {
           // eat the leaf...
           getWorld().removeObject(RadAway);
           radAway = health + 1; 
          }
    }
    
    public boolean foundRad()
    {
        Actor RadAway = getOneObjectAtOffset(0,0,RadAway.class);
        if(RadAway != null)
          {
           return true;
          }
          else
              {
               return false;
              }
    }
    
     public int getRadEaten()
    {
     return radAway;
    }
    
}