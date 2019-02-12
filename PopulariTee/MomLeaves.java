import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MomLeaves here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MomLeaves extends World
{

    /**
     * Constructor for objects of class MomLeaves.
     * 
     */
    public MomLeaves()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 768, 1); 
        repaint();
    }
    public void act()
    {
        if (Greenfoot.getKey()!=null)
        {
            TitlePage w = new TitlePage();
            Greenfoot.setWorld(w);
        }
    }
}
