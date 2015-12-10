import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;
/**
 * Write a description of class DesignScoreboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DesignScoreboard extends Actor
{
    GreenfootImage titulo = new GreenfootImage(300,100);
    private Color verde;
    
    /**
     * Act - do whatever the DesignScoreboard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    /**
     * Construtor da classe DesignScoreboard() - simplesmente faz display do titulo do scoreboard
     */
    public DesignScoreboard()
    {   
        printTitle();
    }
    
    /**
     * printTitle() - titulo do Scoreboard
     */
    private void printTitle()
    {
        Color verde = new Color(196,223,155);
        titulo.setColor(verde);
        titulo.setFont(new Font("sanserif",Font.BOLD,50));
        titulo.drawString("Scoreboard",10,50);
        setImage(titulo);
    }
}
