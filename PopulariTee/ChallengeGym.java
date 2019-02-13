
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class ChallengeGym here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChallengeGym extends CollisionWorld
{

    /**
     * Constructor for objects of class ChallengeGym.
     * 
     */
    public ChallengeGym()
    {
        super(1024, 768, 1, false); 
        addActors();
        this.marcusX = -2000;
        this.marcusY = -2000;
    }
    
    public void addActors()
    {
        addObject(new Banana(), 400, 700);
        addObject(new Banana(), 800, 700);
        addObject(new Banana(), 1100, 700);
        addObject(new Banana(), 1400, 700);
        addObject(new Banana(), 1500, 700);
        addObject(new BasketBall(), 70, 100);

    }

}
