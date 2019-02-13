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
        public static final GreenfootSound sound = new GreenfootSound("bounce.wav");

    private int worldX, worldY, worldWidth, worldHeight;
    private int cameraOffsetX, cameraOffsetY;
    
    public int getCameraX()
    {
        return cameraOffsetX;
    }

    public int getCameraY()
    {
        return cameraOffsetY;
    }

    public void setCameraX(int x)
    {
        cameraOffsetX = x;
    }

    public void setCameraY(int y)
    {
        cameraOffsetY = y;
    }

    public void setWorldDimensions(int x, int y, int width, int height)
    {
        worldX = x;
        worldY = y;
        worldWidth = width;
        worldHeight = height;
    }

    public int getWorldX()
    {
        return worldX;
    }

    public int getWorldY()
    {
        return worldY;
    }

    public int getWorldWidth()
    {
        return worldWidth;
    }

    public int getWorldHeight()
    {
        return worldHeight;
    }

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
