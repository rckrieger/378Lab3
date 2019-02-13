import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gothette here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Gothette extends CoolActor
{
    /**
     * Act - do whatever the Gothette wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean stillTalking = false;
    private long doneTalking = System.currentTimeMillis();
    private int talkTime = 5;
    
    public void act() 
    {
        long now = System.currentTimeMillis();
        if (getOneIntersectingObject(Marcus.class) != null && now > doneTalking)
        {
            Shirt shirt = ((ScrollingWorld)getWorld()).marcus.wearing;
            if (shirt != null && shirt.colorText == "black")
            {
                SpeechBubble scrub = new SpeechBubble("Cool shirt.\nStay weird.", this, 28, Color.BLACK, talkTime);
                getWorld().addObject(scrub, 0, 0);
                doneTalking = System.currentTimeMillis()+1000*talkTime;
                ((ScrollingWorld)getWorld()).marcus.gothsScore = 100;
            }
            else
            {
                SpeechBubble scrub = new SpeechBubble("**eye roll**", this, 36, Color.BLACK, talkTime);
                getWorld().addObject(scrub, 0, 0);
                doneTalking = System.currentTimeMillis()+1000*talkTime;
            }
        }
    }    
}
