import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GoGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GoGame extends Buttons
{
    /**
     * Act - do whatever the GoGame wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
     click();
    }
    
    /**
     * 
     */
    private void click()
    {
        if(Greenfoot.mouseClicked(this)){
            getClickSound().play();
            Greenfoot.setWorld(new Game());
        }
    }
}
