import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScrollingWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScrollingWorld extends World
{

    /**
     * Constructor for objects of class ScrollingWorld.
     * 
     */
    protected int imageScale;
    protected int worldWidth;
    protected Shirt worn;
    protected Marcus marcus;
    protected int marcusX;
    protected int marcusY;
    public Background boundingBG;
    public GreenfootSound bgMusic;
    public int speed;
    protected ScrollingWorld parentWorld;
    
    public ScrollingWorld(int width, int height, int gridSize, boolean bounded)
    {
        super(width, height, gridSize, bounded);
        this.imageScale = 5;
        this.speed = 60;
        Greenfoot.setSpeed(speed);
    }
    
    public int getImageScale()
    {
        return imageScale;
    }
    
    public int getWorldWidth()
    {
        return worldWidth;
    }
    
    public void scroll(int distance)
    {
        int width = boundingBG.getImage().getWidth();
        int left  = width/2 - distance;
        int right = -width/2 - distance + getWidth();
        int x = boundingBG.getX();
        if ((x < left && distance > 0) || (x > right && distance < 0))
        {
            ScrollingActor[] actors = getObjects(ScrollingActor.class).toArray(new ScrollingActor[0]);
            for (ScrollingActor actor : actors)
            {
                actor.scroll(distance);
            }
        }
    }
    
    protected void pauseWorld()
    {
        bgMusic.pause();
        marcusX = marcus.getX();
        marcusY = marcus.getY();
        if (marcus.wearing != null)
        {
            worn = marcus.wearing;
            removeObject(worn);
        }
        removeObject(marcus);
    }
    
    protected void resumeWorld()
    {
        addObject(marcus, marcusX, marcusY);
        if (marcus.wearing != null)
        {
            addObject(marcus.wearing, marcusX, marcusY);
        }
        Greenfoot.setSpeed(speed);
        bgMusic.play();
    }
    
    public void bring_to_(Marcus mercurial, ScrollingWorld from)
    {
        marcus = mercurial;
        parentWorld = from;
        from.pauseWorld();
        Greenfoot.setWorld(this);
        resumeWorld();
    }
}
