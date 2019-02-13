import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BasketBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BasketBall extends BallPhysics
{
    private double xspeed;
    private double yspeed;
    /** The force on the ball due to gravity */
    public static final double GRAVITY = 0.3;
    private ChallengeGym world;
    private static final int SCROLL_WIDTH = 160;
    int absoluteScroll;
    /**
     * Create a new ball
     */
    public BasketBall()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth()/4, image.getHeight()/4);
        setImage(image);
        reset();
        absoluteScroll = 0;
    }
    
    /**
     * Called when the Ball is added to the world
     */
    public void addedToWorld (World world)
    {
        this.world = (ChallengeGym) world;
    }
    
    /**
     * Sets the speed of the ball to 0
     */
    public void reset()
    {
        xspeed = 0;
        yspeed = 0;
    }
    
        /**
     * Steps the ball goes through continuously
     * Act - do whatever the Cheque wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        try {
            arrowKeys();
            move();
            checkWall();
            checkWin();
            checkScroll((int)xspeed);
        }
        catch(IllegalStateException ex) {}
        catch(NullPointerException ex) {}
    }
    
    private void checkWall()
    {
        if(getX()<=0) {
            xspeed *= -1;
            setLocation(getX()+5, getY());
            ((ChallengeGym)getWorld()).sound.play();
        }
        else if(getY()>=750) {
            yspeed *= -1;
            setLocation(getX(), 749);
            ((ChallengeGym)getWorld()).sound.play();
        }
        else if(getY()<=200) {
            yspeed *= -1;
            setLocation(getX(), 201);
            ((ChallengeGym)getWorld()).sound.play();
        }
    }
    
    /**
     * Check if we've won (hit the goal)
     */
    private void checkWin()
    {
        if(getX()>900) {
            ScrollingWorld world = (ScrollingWorld)getWorld();
            WinGym w = new WinGym(world.parentWorld, world.bgMusic);
            w.bring_to_(world.marcus, world.parentWorld);
        }
    }
   
    /**
     * Move the ball
     */
    private void move()
    {
        setLocation((int)(getX()+xspeed), (int)(getY()+yspeed));
        yspeed += GRAVITY;
        xspeed += (xspeed>0) ? -.01: .01;
     }
  
     /**
     * Control the ball using the arrow keys
     */
    private void arrowKeys()
    {
        if(Greenfoot.isKeyDown("left") && xspeed > -7) xspeed -= 0.5;
        if(Greenfoot.isKeyDown("right") && xspeed < 7) xspeed += 0.5;
    }   
}
