import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;
/**
 * Write a description of class FirstPlace here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SecondPlace extends ScoreLoad
{
    GreenfootImage segundoLugar = new GreenfootImage(400,50);
    private Color amarelo;
    
    /**
     * Act - do whatever the DesignScoreboard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    /**
     * Construtor da clase SecondPlace, simplesmente faz clear na imagem predefinida e define uma nova imagem
     */
    public SecondPlace()
    {
        display();
    }
    
    /**
     * display() - faz display da segunda melhor pontuação alguma vez obtida
     */
    private void display()
    {
        amarelo = new Color(255,188,0);
        segundoLugar.setColor(amarelo);
        segundoLugar.setFont(new Font("sanserif",Font.BOLD,25));
        String score;
        if(getList().size()<2)//se o tamanho da lista for menor que 2 entao significa que ainda o utilizador ainda nao jogou quatro vezes portanto nao existe quarta melhor pontuação
            score = "0";
        else
            score = (String)getList().get(1); //caso contrario, vai buscar o 2 elemento da lista dando obviamente a segunda melhor pontuacao de sempre porque a lista esta por ordem descrente
        
        segundoLugar.drawString("Second best: " + score,150,segundoLugar.getHeight()/2);
        
        setImage(segundoLugar);
    }
}