import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;

/**
 * Write a description of class Help here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Helpbt extends Buttons
{
    private GreenfootImage imgHelp;
    private Color amarelo;
    private Color laranja;
    private Color laranjaEscuro;
    private Help help;
    
    /**
     * Construtor, desenha uma caixa, faz print do texto e inicializa o objeto help
     */
    public Helpbt()
    {
        drawBox();
        printText();
        help = new Help();
        imgHelp.setTransparency(0); 
    }
    
    /**
     * Act - do whatever the Help wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act(); 
        imgHelp.setTransparency(255);
        click();
    }
    
    /**
     * 
     */
    private void drawBox()
    {
        amarelo = new Color(255,188,0);
        laranja = new Color(255,133,0);
        imgHelp = getImage();
        imgHelp.setColor(laranja);
        imgHelp.fill();
        imgHelp.scale(200,50);
        imgHelp.setColor(amarelo);
        int margem = 5;
        int largura = imgHelp.getWidth()-2*margem;
        int altura = imgHelp.getHeight()-2*margem;
        imgHelp.fillRect(margem,margem,largura,altura);
    }
    
    /**
     * 
     */
    private void printText()
    {
        laranjaEscuro = new Color(214,95,0);
        imgHelp.setColor(laranjaEscuro);
        Font play = new Font("sanserif",Font.BOLD,30);
        imgHelp.setFont(play);
        int x = imgHelp.getWidth()-130;
        int y = imgHelp.getHeight()-16;
        imgHelp.drawString("Help",x,y);
    }
    
    /**
     * 
     */
    
    public void click()
    {
        if(Greenfoot.mouseClicked(this)){
            getClickSound().play(); //quando é carregado neste botão é produzido um som de click
            getWorld().addObject(help,getWorld().getWidth()/2,getWorld().getHeight()/2); //adicionamos num objeto da Classe help, este objeto tem a função de ser um popup que poderá ser fechado pelo utilizador 
            getWorld().addObject(new Exit(help), help.getX() - help.getImage().getWidth()/2, help.getY() - help.getImage().getHeight()/2); //botão que fecha o popup, adiciona um objeto da classe Exit que recebe como o objeto o Actor que quer remover, neste caso o objeto adicionado acima deste
        }
    }
}
