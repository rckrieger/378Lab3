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
    }
    public void act() 
    {
        Random randgen = new Random();
        int directionPicked;
        if (System.currentTimeMillis() < startTime + 60000)
        {
            if (lastTimeAddedArrow + spacing < System.currentTimeMillis())
            {
                System.out.println("last added at: " + lastTimeAddedArrow + "\n but now current time is " + System.currentTimeMillis());
                lastTimeAddedArrow = System.currentTimeMillis();
                insertArrow();
            }
        }
    } 
    public void insertArrow(){
        int directionPicked;
        directionPicked = randgen.nextInt(4);
        System.out.println(directionPicked);
        switch (directionPicked) {
            case 1:  world.addObject(new Up(), 375, 0);
                break;
            case 2:  world.addObject(new Right(), 500, 0);
                break;
            case 3:  world.addObject(new Left(), 120, 0);
                break;
            default: world.addObject(new Down(), 250, 0);
                break;
        }
    }
}
