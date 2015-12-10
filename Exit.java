import greenfoot.*; 


public class Exit extends Buttons
{
    private Actor actor; 
    
    
    public Exit(Actor a) 
    {
        actor = a;
    }
    
    
    public void act() 
    {
        click();
    }
    
    
    private void click()
    {
        if(Greenfoot.mouseClicked(this)){
            getClickSound().play();
            getWorld().removeObject(actor);
            getWorld().removeObject(this);
        }
    }
}