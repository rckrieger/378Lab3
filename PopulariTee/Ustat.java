import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ustat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ustat extends Stationary
{
    private DDRWorld world;

    /**
     * Act - do whatever the lstat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        arrowKeys();
    }    
    public void addedToWorld (World world)
    {
        this.world = (DDRWorld) world;
    }
    private void arrowKeys()
    {
        if(pressingKey("up") || pressingKey("w")) checkHit();
    }
    private void checkHit()
    {
        Up overlap = (Up)getOneIntersectingObject(Up.class);
        if(overlap != null)
        {
            world.addPoint();
            world.removeObject(overlap);
        }
        else {
            world.subtractPoint();
        }
        //         ((MyWorld)getWorld()).playSound("sounds/coin.wav");

    } 
}
