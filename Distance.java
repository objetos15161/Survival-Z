import greenfoot.Actor;
import java.awt.Point;
import java.util.List;

public class Distance  
{
    /**
     * Finds the distance between two Points
     * @param a Point a.
     * @param b Point b.
     * @return The distance between the two points.
     */
    public static double distanceBetween(Point a, Point b)
    {
        double x = a.getX() - b.getX();
        double y = a.getY() - b.getY();

        return Math.abs(Math.sqrt(x*x+y*y));
    }

    /**
     * Finds the distance between two coordinates
     * @param x1 The first x
     * @param y1 The first y
     * @param x2 The second x
     * @param y2 The second y
     */
    public static double distanceBetween(int x1, int y1, int x2, int y2)
    {
        return distanceBetween(new Point(x1, y1), new Point(x2, y2));
    }

    /**
     * Finds the distance between two actors' centers.
     * @param a Actor a.
     * @param b Actor b.
     * @return The distance between the center of Actor a, and the center of Actor b
     */
    public static double distanceBetween(Actor a, Actor b)
    {
        return distanceBetween(a.getX(), a.getY(), b.getX(), b.getY());
    }
    
    /**
     * Finds the Point the least amount away from a Point of reference
     * Precondition: pnts.size() > 0
     * @param a The reference Point.
     * @param pnts The points to find the distances of
     * @return The Point the closest to the reference Point
     */
    public static Point closestTo(Point a, List<Point> pnts)
    {
        Point closest = null;
        double min = Double.MAX_VALUE;
        
        for (Point p : pnts)
        {
            double distance = distanceBetween(a, p);
            if (distance < min)
            {
                min = distance;
                closest = p;
            }
        }
        
        return closest;
    }
    
    /**
     * Finds the Point farthest away from a Point of reference.
     * Precondition: pnts.size() > 0
     * @param a The reference Point
     * @param pnts The points to find the distances of
     * @return The Point the farthest away from the reference Point
     */
    public static Point farthestFrom(Point a, List<Point> pnts)
    {
        Point farthest = null;
        double max = Double.MIN_VALUE;
        
        for (Point p : pnts)
        {
            double distance = distanceBetween(a, p);
            if (distance > max)
            {
                max = distance;
                farthest = p;
            }
        }
        
        return farthest;
    }
    
    /**
     * Finds the Actor closest to an Actor of reference.
     * Precondition: pnts.size() > 0
     * @param a The reference Actor
     * @param acts The Actors to find the distances of
     * @return The Actor the closest to the Reference Actor
     */
    public static Actor closestTo(Actor a, List<Actor> acts)
    {
        Actor closest = null;
        double min = Double.MAX_VALUE;
        
        for (Actor act : acts)
        {
            double distance = distanceBetween(a, act);
            if (distance < min)
            {
                min = distance;
                closest = act;
            }
        }
        
        return closest;
    }
    
    /**
     * Finds the Actor farthest to an Actor of reference.
     * Precondition: pnts.size() > 0
     * @param a The reference Actor
     * @param acts The Actors to find the distances of
     * @return The Actor the farthest to the Reference Actor
     */
    public static Actor farthestFrom(Actor a, List<Actor> acts)
    {
        Actor farthest = null;
        double max = Double.MIN_VALUE;
        
        for (Actor act : acts)
        {
            double distance = distanceBetween(a, act);
            if (distance > max)
            {
                max = distance;
                farthest = act;
            }
        }
        
        return farthest;
    }
}