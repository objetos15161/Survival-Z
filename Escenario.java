import greenfoot.*;
import greenfoot.World;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import java.awt.Color;
import greenfoot.core.WorldHandler;
import javax.swing.JPanel;
import java.awt.Point;
import java.awt.Toolkit;

/**
 * Escribe una descrición de la clase Escenario aquí.
 * 
 * @autor (tu nombre) 
 * @versión (Un número de versión o una fecha)
 */
public class Escenario extends World
{
 //Posicion del marcador   
 private static final int RADS_POS_X = 50;
 private static final int RADS_POS_Y = 15;
 //private static final int RADIACION_POS_X = 500;
 //private static final int RADIACION_POS_Y = 15;
 
 private Rads rads = new Rads();
 int point = 0;
 //private Rads radiacion = new Radiacion();
 /**
 * Constructor para objetos de clase Ciudad.
 * 
 */
 public Escenario()
 {    
   // Crea un nuevo mundo de 600x400 celdas con un tamaño de celda de 1x1 pixeles.
   super(884, 400, 1); 
   // Esta linea se encarga de poner el actor (objeto de la clase Nave) en su posicion inicial
   addObject(rads, RADS_POS_X, RADS_POS_Y);
   //addObject(radiacion, RADIACION_POS_X, RADIACION_POS_Y);
   addObject(new Player(), 300, 200);
    //addObject(new ScoreBoard(800, 600), getWidth() / 2, getHeight() / 2);
   ///if(point<100)
      ///setImage("Ciudad.gif");
      //if(point<200)
         //setImage("Hospital.png");
         //if(point>200)
            //setImage("CentalNuclear.png");
 }
 public void gameOver()
    {
        removeObjects(getObjects(greenfoot.Actor.class));
        getBackground().drawImage(new GreenfootImage("Game Over",40,Color.white,null),getWidth()/2-75,getHeight()/2-60);
        getBackground().drawImage(new GreenfootImage("Score:",40,Color.white,null),getWidth()/2-40,getHeight()/2-20);
        
        Greenfoot.stop();
    }
}
