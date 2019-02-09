/**
 * Write a description of class Vector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vector  
{
    // instance variables - replace the example below with your own
    private int x;
    private int y;

    /**
     * Constructor for objects of class Vector
     */
    public Vector(int ix, int iy)
    {
        this.x = ix;
        this.y = iy;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void changeTo(Vector newV)
    {
        this.x = newV.x;
        this.y = newV.y;
        return;
    }
    
    public void changeTo(int newX, int newY)
    {
        this.x = newX;
        this.y = newY;
        return;
    }
    
    public void changeBy(Vector del)
    {
        this.x += del.x;
        this.y += del.y;
        return;
    }
    
    public void changeBy(int dX, int dY)
    {
        this.x += dX;
        this.y += dY;
        return;
    }
    
    public int getX()
    {
        return this.x;
    }
    
    public int getY()
    {
        return this.y;
    }
}
