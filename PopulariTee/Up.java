import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Up here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Up extends MovingArrow
{
    private DDRWorld world;
    public void addedToWorld (World world)
    {
        this.world = (DDRWorld) world;
    }
    /**
     * Act - do whatever the Up wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        super.act();
        if (getY() > 768)
        {
            world.removeObject(this);
        }
    }
}
