import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Door here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Door extends CoolActor
{
    private ScrollingWorld link;
    public Door()
    {
        //nah
    }
    
    public Door(ScrollingWorld linkTo)
    {
        super();
        this.link = linkTo;
    }
    
    public void act() 
    {
        // Add your action code here.
    }
    
    public void enter(Marcus marcus)
    {
        link.bring_to_(marcus, (ScrollingWorld)getWorld());
    }
}
