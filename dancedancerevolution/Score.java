import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private MyWorld world;
    public void addedToWorld (World world)
    {
        this.world = (MyWorld) world;
    }
    
    public void act() 
    {
        // Add your action code here.
        String scoreValue = Integer.toString(world.getScore());
        GreenfootImage temp = new GreenfootImage(scoreValue, 30, Color.RED, null);
        setImage(temp);
        //temp.drawString(scoreValue, int x, int y)
    }    
}
