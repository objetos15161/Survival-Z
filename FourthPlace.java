import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;
/**
 * Write a description of class FirstPlace here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FourthPlace extends ScoreLoad
{
    GreenfootImage quartoLugar = new GreenfootImage(400,50);
    private Color laranjaEscuro;
    
    /**
     * Act - do whatever the DesignScoreboard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    /**
     * Construtor da clase FourthPlace, simplesmente faz clear na imagem predefinida e define uma nova imagem
     */
    public FourthPlace()
    {
        display();
    }
    
     /**
     * display() - faz display da quarta melhor pontuação alguma vez obtida
     */
    private void display()
    {
        laranjaEscuro = new Color(214,95,0);
        quartoLugar.setColor(laranjaEscuro);
        quartoLugar.setFont(new Font("sanserif",Font.BOLD,25));
        String score;
        if(getList().size()<4) //se o tamanho da lista for menor que 4 entao significa que ainda o utilizador ainda nao jogou quatro vezes portanto nao existe quarta melhor pontuação
            score = "0";
        else
            score = (String)getList().get(3);//caso contrario, vai buscar o 4 elemento da lista dando obviamente a quarta melhor pontuacao de sempre porque a lista esta por ordem descrente
        quartoLugar.drawString("Fourth best: "+ score,150,quartoLugar.getHeight()/2);
        
        setImage(quartoLugar);
    }
}
