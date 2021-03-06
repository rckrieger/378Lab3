import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Write a description of class ArrowGenerator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArrowGenerator extends Actor
{
    private DDRWorld world;
    long startTime = System.currentTimeMillis();
    Random randgen = new Random();
    long spacing = 500;
    long lastTimeAddedArrow = -spacing;


    public void addedToWorld (World world)
    {
        this.world = (DDRWorld) world;
        randgen = new Random();
    }
    public void act() 
    {
        if (world.DDRmode)
        {
            if (System.currentTimeMillis() < startTime + 35000)
            {
                if (lastTimeAddedArrow + spacing < System.currentTimeMillis())
                {
                    //System.out.println("last added at: " + lastTimeAddedArrow + "\n but now current time is " + System.currentTimeMillis());
                    lastTimeAddedArrow = System.currentTimeMillis();
                    insertArrow();
                }
            }
            else
            {
                world.hideScore();
                world.getMarcus().theatreScore = world.getScore();
                world.DDRmode = false;
                world.getMarcus().DDRmode = false;
                world.removeActors();
                Greenfoot.setSpeed(world.speed);
                world.bgMusic.play();
                if (world.marcus.theatreScore > 100)
                {
                    SpeechBubble congrats = new SpeechBubble("Nice moves!\nI found this in the back.\nWant it?", getWorld().getObjects(Drama.class).get(0), 22, Color.BLACK, 7);
                    getWorld().addObject(congrats, 0, 0);
                    Shirt shirtBlack = new Shirt("black", Color.BLACK);
                    world.addObject(shirtBlack, 250, 600);
                }
            }
        }
    } 
    public void insertArrow(){
        int directionPicked;
        directionPicked = randgen.nextInt(8);
        //System.out.println(directionPicked);
        switch (directionPicked) {
            case 1:  world.addObject(new Up(), 375, 0);
                break;
            case 2:  world.addObject(new Right(), 500, 0);
                break;
            case 3:  world.addObject(new Left(), 120, 0);
                break;
            case 4: world.addObject(new Down(), 250, 0);
                break;
            default:
                break;
        }
    }
}
