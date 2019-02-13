import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScrollingActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScrollingActor extends Actor
{
    /**
     * Act - do whatever the ScrollingActor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    
    protected void checkScroll(int deltaX)
    {
        int x = getX();
        int width = getWorld().getWidth();
        int lower = width * 4 / 10;
        int upper = width * 6 / 10;
        if (x > upper)
        {
            ((ScrollingWorld)getWorld()).scroll(-deltaX);
        }
        else if (x < lower)
        {
            ((ScrollingWorld)getWorld()).scroll(deltaX);
        }
    }
    
    public void scroll(int scrollChange)
    {
        this.setLocation(this.getX()+scrollChange, this.getY());
    }
}
