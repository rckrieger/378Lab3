import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CollisionActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CollisionActor extends AnimatedActor
{
    public CollisionActor()
    {
        super();
    }
    
    public CollisionActor(String basename, String suffix, int noOfImages, int delay)
    {
        super(basename, suffix, noOfImages, delay);
    }
    
    @Override
    protected void addedToWorld(World world)
    {
        ((CollisionWorld)world).getCollisionActors().add(this);
    } 

}
