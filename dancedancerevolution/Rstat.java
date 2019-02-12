import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class rstat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rstat extends Stationary
{
    private MyWorld world;

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
        this.world = (MyWorld) world;
    }
    private void arrowKeys()
    {
        if(Greenfoot.isKeyDown("right")) checkHit();
    }
    private void checkHit()
    {
        Right overlap = (Right)getOneIntersectingObject(Right.class);
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
