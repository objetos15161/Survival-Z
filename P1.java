import greenfoot.*;

/**
 * Escribe una descrición de la clase P1 aquí.
 * 
 * @autor BRSKCORE
 * @versión 0.01
 */
public class P1 extends Actor
{
  int posX;
  int posY;
 
  public P1()
  {
   setRotation(0);
  }
      
  public void act()
  {
   actualizarPosicion();
  }
        
  public void actualizarPosicion()
  {
   posX = getX();
   posY = getY();
        
  if(Greenfoot.isKeyDown("left"))
     posX -= 3;
     else
         if(Greenfoot.isKeyDown("right"))
            posX += 3;            
            else
                if(Greenfoot.isKeyDown("down"))
                   posY += 3;            
                   else
                       if(Greenfoot.isKeyDown("up"))
                          posY -= 3;
      setLocation( posX, posY );
  } 
}
    

