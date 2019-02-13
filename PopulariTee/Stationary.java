import java.util.Random;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stationary here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stationary extends Arrow
{
    /**
     * Act - do whatever the Stationary wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private DDRWorld world;
    private boolean alreadyPressing = false;

    public void addedToWorld (World world)
    {
        this.world = (DDRWorld) world;
    }
    public void act() 
    {
    }
    
    protected boolean pressingKey(String dir1, String dir2)
    {
        boolean currentlyPressing = Greenfoot.isKeyDown(dir1) || Greenfoot.isKeyDown(dir2);
        if(!alreadyPressing && currentlyPressing)
        {
            alreadyPressing = true;
            return true;
        }
        alreadyPressing = currentlyPressing;
        return false;
    }
}
