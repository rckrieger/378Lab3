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

    public void addedToWorld (World world)
    {
        this.world = (DDRWorld) world;
    }
    public void act() 
    {
    }      
}
