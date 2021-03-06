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
    private DDRWorld world;
    public void addedToWorld (World world)
    {
        this.world = (DDRWorld) world;
    }
    
    public void act() 
    {
        // Add your action code here.
        if (world.DDRmode)
        {
            String scoreValue = Integer.toString(world.getScore());
            GreenfootImage temp = new GreenfootImage(scoreValue, 64, new Color(10, 120, 160), null, Color.BLACK);
            setImage(temp);
        }
        //temp.drawString(scoreValue, int x, int y)
    }    
}
