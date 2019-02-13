import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DDRWorld extends ScrollingWorld
{
    /** The number of lives the player starts with */
    public static final int STARTLIVES = 5;
    /** The number of levels */
    public static final int MAXLEVEL = 11;
    /** The time to wait between each level */
    public static final int DELAY = 30;
    private int score = 0;
    private final ArrayList<CollisionActor> allCollisionActors;
    private int cameraOffsetX, cameraOffsetY;
    private int worldX, worldY, worldWidth, worldHeight;
    public long startTime = System.currentTimeMillis();
    public boolean DDRmode = false;
    public int DDRspeed = 50;
    //private static final GreenfootSound sound = new GreenfootSound("bounce.wav");
    /**
     * Create a new world.
     */
    public int getScore(){
        return score;
    }
    public DDRWorld(ScrollingWorld returnTo)
    {    
        super(1024, 768, 1, false); 
        setPaintOrder(MovingArrow.class, Stationary.class, Shirt.class, Marcus.class, Score.class, Background.class);
        this.parentWorld = returnTo;
        this.bgMusic = new GreenfootSound("PopulariTee Theme.mp3");
        this.marcusX = 900;
        this.marcusY = 500;
        allCollisionActors = new ArrayList<CollisionActor>();
        addActors();
        worldWidth = getWidth();
        worldHeight = getHeight();
        score = 0;
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
        Score scoreDisplay  = new Score();
        Background bg = (Background)(new DDRBackground());
        this.boundingBG = bg;
        addObject(bg, bg.getImage().getWidth()/2, bg.getImage().getHeight()/2);
        addObject(arrowgenerator, 0, 0);
        addObject(DOWN, 250, 700);
        addObject(UP, 375, 700);
        addObject(RIGHT, 500, 700);
        addObject(LEFT, 120, 700);
        addObject(scoreDisplay, 850, 100);
    }
        //SPEECH BUBBLE
        //  addObject(new SpeechBubble("play-bubble.png", forest, 1000), -500, -500);
        // addObject(new SpeechBubble("big-bubble.png", forest, -10), 450, 300);
}
