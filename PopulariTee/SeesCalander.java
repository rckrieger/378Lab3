import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SeesCalander here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SeesCalander extends World
{

    /**
     * Constructor for objects of class SeesCalander.
     * 
     */
    public SeesCalander()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 768, 1); 
        repaint();
    }
    public void act()
    {
        if (Greenfoot.getKey()!=null)
        {
            Backstory w = new Backstory();
            Greenfoot.setWorld(w);
        }
    }
}
