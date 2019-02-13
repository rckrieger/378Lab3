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
        worldWidth = super.getWidth();
        worldHeight = super.getHeight();

    }
    
    public void addActors()
    {
        BasketBall ball = new BasketBall();
        Banana ban1 = new Banana();
        Banana ban2 = new Banana();
        Banana ban3 = new Banana();
        addObject(ban1, 200, 700);
        addObject(ban2, 600, 700);
        addObject(ban3, 800, 700);
        addObject(ball, 70, 70);

    }

}
