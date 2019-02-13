import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WinGym here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinGym extends ScrollingWorld
{

    /**
     * Constructor for objects of class WinGym.
     * 
     */
    public WinGym()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 768, 1, false); 
        repaint();
    }
    public void act()
    {
        if (Greenfoot.getKey()!=null)
        {
            parentWorld.bring_back(marcus, this);
        }
    }
    
}
