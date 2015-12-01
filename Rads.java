import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rads extends Actor
{
    int  rad= 0;
  
    protected void draw() 
    {
        setImage(new GreenfootImage("Rads: " + rad, 24, Color.BLACK, null));
    }    
    public void add() {
        rad++;
        draw();
    }
    public void reset() {
        rad = 0;
        draw();
    }
    public void set(int newScore) {
        rad = newScore;
        draw();
    }
    public int get() {
        return rad;
    }
    public void show() {
        draw();
    }
    public void hide() {
        setImage(new GreenfootImage(1,1));
    }
    
}