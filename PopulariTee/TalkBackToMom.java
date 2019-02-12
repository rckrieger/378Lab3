import greenfoot.*; 
/**
 * Write a description of class TalkBackToMom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TalkBackToMom extends World
{
    // instance variables - replace the example below with your own
    public TalkBackToMom()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 768, 1); 
        repaint();
    }
    public void act()
    {
        if (Greenfoot.getKey()!=null)
        {
            MomLeaves w = new MomLeaves();
            Greenfoot.setWorld(w);
        }
    }
}
