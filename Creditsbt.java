import greenfoot.*;  
import java.awt.Color;
import java.awt.Font;

/**
 * Write a description of class Credits here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Creditsbt extends Buttons
{
    private GreenfootImage imgCredits;
    private Color amarelo;
    private Color laranja;
    private Color laranjaEscuro;
    private Credits credits;
    
    /**
     * Construtor da classe Credits
     */
    public Creditsbt()
    {
        drawBox();
        printText();
        imgCredits.setTransparency(0);
        credits = new Credits();
    }
    
    /**
     * Act - do whatever the Credits wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        imgCredits.setTransparency(255);
        click();
    }
    
    /**
     * 
     */
    private void printText()
    {
        laranjaEscuro = new Color(214,95,0);
        imgCredits.setColor(laranjaEscuro);
        Font play = new Font("sanserif",Font.BOLD,30);
        imgCredits.setFont(play);
        int x = imgCredits.getWidth()-150;
        int y = imgCredits.getHeight()-16;
        imgCredits.drawString("Credits",x,y);
    }
    
     /**
     * 
     */
    private void drawBox()
    {
        amarelo = new Color(255,188,0);
        laranja = new Color(255,133,0);
        imgCredits = getImage();
        imgCredits.setColor(laranja);
        imgCredits.fill();
        imgCredits.scale(200,50);
        imgCredits.setColor(amarelo);
        int margem = 5;
        int largura = imgCredits.getWidth()-2*margem;
        int altura = imgCredits.getHeight()-2*margem;
        imgCredits.fillRect(margem,margem,largura,altura);
    }
    
    /**
     * 
     */
    public void click()
    {
        //processo analogo ao explicado na classe Helpbt
        if(Greenfoot.mouseClicked(this)){
            getClickSound().play();
            getWorld().addObject(credits,getWorld().getWidth()/2,getWorld().getHeight()/2);
            getWorld().addObject(new Exit(credits),credits.getX() - credits.getImage().getWidth()/2,credits.getY() - credits.getImage().getHeight()/2);
        }
    }
}