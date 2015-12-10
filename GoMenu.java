import greenfoot.*; 

/**
 * Write a description of class GoMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GoMenu extends Buttons
{
    /**
     * Act - do whatever the GoMenu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        click();
    }
    
    /**
     * click() - Quando clicamos neste botão produz um som e leva-nos para o Menu.
     */
    private void click()
    {
        if(Greenfoot.mouseClicked(this)){
            getClickSound().play();
            Greenfoot.setWorld(new Menu());
        }
    }
}