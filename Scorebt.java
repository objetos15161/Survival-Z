import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scorebt extends Buttons
{
    private GreenfootImage imgScore;
    private Color amarelo;
    private Color laranja;
    private Color laranjaEscuro;
    
    /**
     * Construtor da classe Scorebt
     */
    public Scorebt()
    {
        drawBox();
        printText();
        imgScore.setTransparency(0);
    }
    
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        imgScore.setTransparency(255);
        click();
    }
    
    /**
     * printText - Escreve texto na caixa.
     */
    private void printText()
    {
        laranjaEscuro = new Color(214,95,0);
        imgScore.setColor(laranjaEscuro);
        Font play = new Font("sanserif",Font.BOLD,30);
        imgScore.setFont(play);
        int x = imgScore.getWidth()-140;
        int y = imgScore.getHeight()-16;
        imgScore.drawString("Score",x,y);
    }
    
    /**
     * click - Método que adiciona um evento quando carregamos no botão, neste caso dá um som e muda para o cenário que apresenta os melhores scores.
     */
    private void click()
    {
        if(Greenfoot.mouseClicked(this)){
            getClickSound().play();
            Greenfoot.setWorld(new Scoreboard());
        }
    }
    
     /**
     * drawBox - Desenha a caixa e suas margens para o botão.
     */
    private void drawBox()
    {
        amarelo = new Color(255,188,0);
        laranja = new Color(255,133,0);
        imgScore = getImage();
        imgScore.setColor(laranja);
        imgScore.fill();
        imgScore.scale(200,50);
        imgScore.setColor(amarelo);
        int margem = 5;
        int largura = imgScore.getWidth()-2*margem;
        int altura = imgScore.getHeight()-2*margem;
        imgScore.fillRect(margem,margem,largura,altura);
    }
}