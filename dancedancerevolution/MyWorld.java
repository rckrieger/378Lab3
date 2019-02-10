import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    /** The number of lives the player starts with */
    public static final int STARTLIVES = 5;
    /** The number of levels */
    public static final int MAXLEVEL = 11;
    /** The time to wait between each level */
    public static final int DELAY = 30;
    private int score;
    private final ArrayList<CollisionActor> allCollisionActors;
    private int cameraOffsetX, cameraOffsetY;
    private int worldX, worldY, worldWidth, worldHeight;
    public long startTime = System.currentTimeMillis();
    //private static final GreenfootSound sound = new GreenfootSound("bounce.wav");

    /**
     * Create a new world.
     */
    public MyWorld()
    {    
        super(1024, 768, 1);        
        allCollisionActors = new ArrayList<CollisionActor>();
        addActors();
        worldWidth = getWidth();
        worldHeight = getHeight();
        score = 0;
        prepare();
    }

    /**
     * Plays a sound if the mute switch is off.
     */
   /* public void playSound(String s)
    {
        Greenfoot.playSound(s);
    }*/

    /**
     * Adds a coin to the player's score.
     */
    public void addPoint()
    {
        score += 5;
    }
    public void subtractPoint()
    {
        score -= 5;
    }
    
    public ArrayList<CollisionActor> getCollisionActors()
    {
        return allCollisionActors;
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

    private void addActors() {
        Dstat DOWN = new Dstat();
        Ustat UP = new Ustat();
        Rstat RIGHT = new Rstat();
        Lstat LEFT = new Lstat();
        ArrowGenerator arrowgenerator = new ArrowGenerator();
        addObject(arrowgenerator, 0, 0);
        addObject(DOWN, 250, 600);
        addObject(UP, 375, 600);
        addObject(RIGHT, 500, 600);
        addObject(LEFT, 120, 600);
    }
        //SPEECH BUBBLE
        //  addObject(new SpeechBubble("play-bubble.png", forest, 1000), -500, -500);
        // addObject(new SpeechBubble("big-bubble.png", forest, -10), 450, 300);

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}
