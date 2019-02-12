import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Backstory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Backstory extends World
{

    /**
     * Constructor for objects of class Backstory.
     * 
     */
    public Backstory()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 768, 1); 
        repaint();
    }
    public void act()
    {
        if (Greenfoot.getKey()!=null)
        {
            MomAnswers w = new MomAnswers();
            Greenfoot.setWorld(w);
        }
    }
}
