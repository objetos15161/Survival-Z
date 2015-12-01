import greenfoot.*;

/**
 * Escribe una descrición de la clase Ciudad aquí.
 * 
 * @autor BRSKCORE
 * @versión 0.01
 */
public class Ciudad extends World
{
 //Posicion del marcador   
 private static final int RADS_POS_X = 50;
 private static final int RADS_POS_Y = 15;
 private static final int RADIACION_POS_X = 500;
 private static final int RADIACION_POS_Y = 15;
 
 private Rads rads = new Rads();
 private Rads radiacion = new Radiacion();
 /**
 * Constructor para objetos de clase Ciudad.
 * 
 */
 public Ciudad()
 {    
   // Crea un nuevo mundo de 600x400 celdas con un tamaño de celda de 1x1 pixeles.
   super(884, 400, 1); 
   // Esta linea se encarga de poner el actor (objeto de la clase Nave) en su posicion inicial
   addObject(rads, RADS_POS_X, RADS_POS_Y);
   addObject(radiacion, RADIACION_POS_X, RADIACION_POS_Y);
   addObject(new P1(), 300, 200);
 }
}
