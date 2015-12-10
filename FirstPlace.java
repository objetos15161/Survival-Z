import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;
/**
 * Write a description of class FirstPlace here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FirstPlace extends ScoreLoad
{
    GreenfootImage primeiroLugar = new GreenfootImage(400,50);
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
     * Construtor da clase FirstPlace, simplesmente faz clear na imagem predefinida e define uma nova imagem
     */
    public FirstPlace()
    {
        display();
    }
    
     /**
     * display() - faz display da melhor pontuação alguma vez obtida
     */
    private void display()
    {
        Color verde = new Color(196,223,155);
        primeiroLugar.setColor(verde);
        primeiroLugar.setFont(new Font("sanserif",Font.BOLD,25));
        String score;
        if(getList().isEmpty()) //quando a lista está vazia metemos o score a 0.
            score = "0";
        else
            score = (String)getList().get(0);//caso contrario, vai buscar o 1 elemento da lista dando obviamente a  melhor pontuacao de sempre porque a lista esta por ordem descrente
        primeiroLugar.drawString("Best score: " + score,150,primeiroLugar.getHeight()/2);
        
        setImage(primeiroLugar);
    }
}
