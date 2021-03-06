
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cheque here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MovingArrow extends PhysicsActor
{
    private double xspeed;
    private double yspeed;
    /** The force on the ball due to gravity */
    public double GRAVITY = 0.4;
    private double maxSpeed = 10;
    private DDRWorld world;
    
    public MovingArrow()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth()/2, image.getHeight()/2);
        setImage(image);
    }
    /**
     * Called when the Ball is added to the world
     */
    public void addedToWorld (World world)
    {
        this.world = (DDRWorld) world;
        this.GRAVITY = new Double(this.world.DDRspeed)/100*GRAVITY;
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
            move();
        }
        catch(IllegalStateException ex) {}
        catch(NullPointerException ex) {}
    }
    
    private void checkWall()
    {
        if(getX()<=0) {
            xspeed *= -1;
            setLocation(getX()+3, getY());
          //  ((MyWorld)getWorld()).playSound("sounds/bounce.wav");
        }
        else if(getX()>world.getWidth()-2) {
            xspeed *= -1;
            setLocation(getX()-3, getY());
           // ((MyWorld)getWorld()).playSound("sounds/bounce.wav");
        }
       /* else if(getY()>=319) {
            yspeed *= -1;
            setLocation(getX(), getY()+3);
           // ((MyWorld)getWorld()).playSound("sounds/bounce.wav");
        }*/
    }
    /**
     * Check if we are intersecting with any coins
     */

    
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
        setLocation((int)(getX()), (int)(getY()+yspeed));
        if (yspeed < maxSpeed)
        {
            yspeed += GRAVITY;
        }
    }
 
     /**
     * Control the ball using the arrow keys
     */
}
