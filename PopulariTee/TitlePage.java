import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitlePage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitlePage extends World
{

    /**
     * Constructor for objects of class TitlePage.
     * 
     */
    public TitlePage()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 768, 1); 
    }
    public void act()
    {
        if (Greenfoot.getKey()!=null)
        {
            Hallway w = new Hallway();
            Greenfoot.setWorld(w);
        }
    }
}
