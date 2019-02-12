import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MomAnswers here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MomAnswers extends World
{

    /**
     * Constructor for objects of class MomAnswers.
     * 
     */
    public MomAnswers()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 768, 1); 
        repaint();
    }
    public void act()
    {
        if (Greenfoot.getKey()!=null)
        {
            TalkBackToMom w = new TalkBackToMom();
            Greenfoot.setWorld(w);
        }
    }
}
