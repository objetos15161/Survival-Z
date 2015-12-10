import greenfoot.*;

/**
 * 
 */
public class Menu extends World
{
    private GreenfootSound sonFondo; 
    private Play buttonPlay; 
    private Scorebt buttonScore;
    
    
    
    public Menu()
    {    
        super(650, 750, 1);
        
        //inicializacion del escenario
        sonFondo = new GreenfootSound("Music.mp3");
        buttonPlay = new Play();
        buttonScore = new Scorebt();
        preparation();
    }
    
    
    public void act()
    {   
        loopSom();
        isClicked();
        
    }
    
    
    private void preparation()
    {
        addObject(buttonPlay, -300, 250);
        addObject(new Helpbt(), -300, 350);
        addObject(buttonScore, -300, 450);
        addObject(new Creditsbt(), -300, 550);
        addObject(new ScoreLoad(),0, 0);
    }
    
    
    private void loopSom()
    {
        if(!sonFondo.isPlaying())
            sonFondo.play(); 
    }
    
    
    private void isClicked()
    {
        
        if(Greenfoot.mouseClicked(buttonPlay) && sonFondo.isPlaying())
            sonFondo.stop();
        if(Greenfoot.mouseClicked(buttonScore) && sonFondo.isPlaying())
            sonFondo.stop();
    }
    
    
}
