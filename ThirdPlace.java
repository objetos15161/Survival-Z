import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;
/**
 * Write a description of class FirstPlace here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ThirdPlace extends ScoreLoad
{
    GreenfootImage terceiroLugar = new GreenfootImage(400,50);
    private Color laranja;
    
    /**
     * Act - do whatever the DesignScoreboard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    /**
     * Construtor da clase ThirdPlace, simplesmente faz clear na imagem predefinida e define uma nova imagem
     */
    public ThirdPlace()
    {
        display();
    }
    
     /**
     * display() - faz display da terceira melhor pontuação alguma vez obtida
     */
    private void display()
    {
        laranja = new Color(255,133,0);
        terceiroLugar.setColor(laranja);
        terceiroLugar.setFont(new Font("sanserif",Font.BOLD,25));
        String score;
        if(getList().size()<3)//se o tamanho da lista for menor que 3 entao significa que ainda o utilizador ainda nao jogou quatro vezes portanto nao existe quarta melhor pontuação
            score = "0";
        else
            score = (String)getList().get(2); //caso contrario, vai buscar o 3 elemento da lista dando obviamente a terceira melhor pontuacao de sempre porque a lista esta por ordem descrente

        terceiroLugar.drawString("Third best: " + score,150,terceiroLugar.getHeight()/2);
        
        setImage(terceiroLugar);
    }
}