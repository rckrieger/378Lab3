import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class ChallengeGym here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChallengeGym extends World
{
    private static final GreenfootSound sound = new GreenfootSound("bounce.wav");

    private int worldX, worldY, worldWidth, worldHeight;

    public void setWorldDimensions(int x, int y, int width, int height)
    {
        worldX = x;
        worldY = y;
        worldWidth = width;
        worldHeight = height;
    }
    public int getWorldWidth()
    {
        return worldWidth;
    }

    public int getWorldHeight()
    {
        return worldHeight;
    }

    /**
     * Constructor for objects of class ChallengeGym.
     * 
     */
    public ChallengeGym()
    {
        super(1024, 768, 1); 
        allCollisionActors = new ArrayList<CollisionActor>();
        worldWidth = getWidth();
        worldHeight = getHeight();

    }
    
    public ArrayList<CollisionActor> getCollisionActors()
    {
        return allCollisionActors;
    }
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

}
