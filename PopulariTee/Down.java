import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class down here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Down extends MovingArrow
{
    /**
     * Act - do whatever the down wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private DDRWorld world;
    public void addedToWorld (World world)
    {
        this.world = (DDRWorld) world;
    }
    
    public void act() 
    {
        super.act();
        if (getY() > 768)
        {
            world.removeObject(this);
            world.subtractPoint();
        }
        // Add your action code here.
    } 
}
