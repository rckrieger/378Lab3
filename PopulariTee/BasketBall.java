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
    public static final double GRAVITY = 0.5;
    private ChallengeGym world;
    
    /**
     * Create a new ball
     */
    public BasketBall()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth()/4, image.getHeight()/4);
        setImage(image);
        reset();
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
        }
        catch(IllegalStateException ex) {}
        catch(NullPointerException ex) {}
    }
    
    private void checkWall()
    {
        if(getX()<=0) {
            xspeed *= -1;
            setLocation(getX()+3, getY());
            ((ChallengeGym)getWorld()).sound.play();
        }
        else if(getX()>world.getWidth()-60) {
            WinGym w = new WinGym();
            Greenfoot.setWorld(w);
        }
        else if(getY()>=750) {
            yspeed *= -1;
            setLocation(getX(), getY()+3);
            ((ChallengeGym)getWorld()).sound.play();
        }
    }
    
    /**
     * Check if we've won (hit the goal)
     */
    private void checkWin()
    {
    //    if(getOneIntersectingObject(Goal.class)!=null) world.won();
    }
   
    /**
     * Move the ball
     */
    private void move()
    {
        setLocation((int)(getX()+xspeed), (int)(getY()+yspeed));
        yspeed += GRAVITY;
    }
  
     /**
     * Control the ball using the arrow keys
     */
    private void arrowKeys()
    {
        if(Greenfoot.isKeyDown("left")) xspeed -= 0.5;
        if(Greenfoot.isKeyDown("right")) xspeed += 0.5;
    }   
}
