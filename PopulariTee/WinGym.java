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
    public WinGym(ScrollingWorld world, GreenfootSound bgMusic)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 768, 1, false);
        this.parentWorld = world;
        this.marcusX = 200;
        this.marcusY = 600;
        this.bgMusic = bgMusic;
        repaint();
    }
    public void act()
    {
        if (Greenfoot.isKeyDown("space") || Greenfoot.isKeyDown("enter"))
        {
            parentWorld.marcusY = 600;
            parentWorld.marcusX = 400;
            marcus.jocksScore = 100;
            parentWorld.bring_back(marcus, this);
            marcus.STOPYOUASSHOLE = false;
        }
    }
    
}
