import greenfoot.*;  

/**
 * 
 */
public class Scoreboard extends World
{
    /**
     * Constructor for objects of class Scoreboard.
     * 
     */
    public Scoreboard()
    {    
        super(650, 750, 1);
        
        adicionaObjetos();
    }
    
    /**
     * adicionaObjetos- adiciona o titulo da tabela de pontuações e as respetivas pontuações a este cenário
     */
    private void adicionaObjetos()
    {
        addObject(new DesignScoreboard(),320,250);
        addObject(new FirstPlace(),100,350);
        addObject(new SecondPlace(),100,450);
        addObject(new ThirdPlace(),100,550);
        addObject(new FourthPlace(),100,650);
        addObject(new GoMenu(),620,720);
    }
}
