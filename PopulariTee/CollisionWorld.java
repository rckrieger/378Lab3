import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class CollisionWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CollisionWorld extends ScrollingWorld
{

    /**
     * Constructor for objects of class CollisionWorld.
     * 
     */
    private final ArrayList<CollisionActor> allCollisionActors;
    @Override
    public void removeObject(Actor object) 
    {
        super.removeObject(object);

        if(object instanceof CollisionActor)
        {
            allCollisionActors.remove(object);
        }
    }
    public ArrayList<CollisionActor> getCollisionActors()
    {
        return allCollisionActors;
    }
    public CollisionWorld(int x, int y,int z,boolean bool)
    {
        super(x, y, z, bool);
        allCollisionActors = new ArrayList<CollisionActor>();
    }
}
