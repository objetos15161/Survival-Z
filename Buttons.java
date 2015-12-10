import greenfoot.*;  


public class Buttons extends Actor
{
    private int speedX;
    private GreenfootSound clickSound;
    
    /**
     * 
     */
    public Buttons()
    {
        speedX = 0;
        clickSound = new GreenfootSound("buttonSound.wav");
    }
    
    /**
     * 
     */
    public void act() 
    {
        efeitosEntrada();
    }   
    
    /**
     *
     */
    private void efeitosEntrada()
    {
        if(getX() < getWorld().getWidth()/2)
            move(speedX);
        else
            setLocation(getWorld().getWidth()/2, getY());
        if(speedX < 10)
            speedX++;
    }
    
    /**
     *
     */
    protected GreenfootSound getClickSound()
    {
        return clickSound;
    }
}
