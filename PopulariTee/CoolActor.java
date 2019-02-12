import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Write a description of class Walker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CoolActor extends ScrollingActor
{
    /**
     * Act - do whatever the Walker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    protected String animatedStatus;
    protected int frameCount;
    protected int frameCycle = 25;
    protected int animatedIndex;
    protected int animatedCycle = 4;
    protected int imageScale;
    protected String fileSuffix = ".png";
    protected Map<String, ArrayList<GreenfootImage>> animations;
    
    public CoolActor()
    {
        animations = new HashMap<String, ArrayList<GreenfootImage>>();
        this.animatedStatus = "stand";
        this.animatedIndex = 0;
        this.frameCount = 0;
        this. imageScale = 10;
    }
    
    public void act()
    {
        //Nope.
    }
    
    protected void animate(String type)
    {
        if (!animatedStatus.equals(type))
        {
            animatedStatus = type;
            animatedIndex = 0;
            frameCount = 0;
        }
        frameCount = ++frameCount%frameCycle;
        if (frameCount == 0)
        {
            animatedIndex = ++animatedIndex%animatedCycle;
        }
        setImage(animations.get(type).get(animatedIndex));
    }
    
    protected void colorCycle(GreenfootImage image, Color toChange, Color newColor)
    {
        for (int i = 0; i < image.getHeight(); i++)
        {
            for (int j = 0; j < image.getWidth(); j++)
            {
                if (image.getColorAt(j, i).equals(toChange))
                {
                    image.setColorAt(j, i, newColor);
                }
            }
        }
    }
    
    protected void colorIsolate(GreenfootImage image, Color toKeep)
    {
        for (int i = 0; i < image.getHeight(); i++)
        {
            for (int j = 0; j < image.getWidth(); j++)
            {
                if (!image.getColorAt(j, i).equals(toKeep))
                {
                    image.setColorAt(j, i, new Color(0,0,0,0));
                }
            }
        }
    }
}
