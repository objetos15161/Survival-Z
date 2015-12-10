import greenfoot.*;  
import java.awt.Color;
import java.awt.Font;

/**
 * Write a description of class Play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Play extends Buttons
{
    private GreenfootImage imgPlay;
    private Color amarelo;
    private Color laranja;
    private Color laranjaEscuro;
    
    /**
     * Construtor da classe Play
     */
    public Play()
    {
        drawBox();
        printText();
        imgPlay.setTransparency(0); 
    }
   
    public void act() 
    {
        super.act(); 
        imgPlay.setTransparency(255);
        click();
    }
   
    private void drawBox()
    {
        amarelo = new Color(255,188,0);
        laranja = new Color(255,133,0);
        imgPlay = getImage();
        imgPlay.setColor(laranja);
        imgPlay.fill();
        imgPlay.scale(200,50);
        imgPlay.setColor(amarelo);
        int margem = 5;
        int largura = imgPlay.getWidth()-2*margem;
        int altura = imgPlay.getHeight()-2*margem;
        imgPlay.fillRect(margem,margem,largura,altura);
    }
   
    private void printText()
    {
        laranjaEscuro = new Color(214,95,0);
        imgPlay.setColor(laranjaEscuro);
        Font play = new Font("sanserif",Font.BOLD,30);
        imgPlay.setFont(play);
        int x = imgPlay.getWidth()-130;
        int y = imgPlay.getHeight()-16;
        imgPlay.drawString("Play",x,y);
    }
    
    /**
     * 
     */
    private void click()
    {
        if(Greenfoot.mouseClicked(this))
        {
         getClickSound().play();
         Greenfoot.setWorld(new Game());
        }
    }
}