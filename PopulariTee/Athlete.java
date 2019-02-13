import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Athlete here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Athlete extends CoolActor
{
    /**
     * Act - do whatever the Athlete wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private String[] spoken = new String[]
    {"Bro, what are you\ndoing on my court?",
    "Would you like to\nvote for me?",
    "I only vote for\npeople who have\nGAME.",
    "I have game.",
    "Prove it then!"};
    private int thisIsDumb = 0;
    private boolean speaking = true;
    private int talkTime = 5;
    
    public void act() 
    {
        // Add your action code here.
    }
    
    public void conversate()
    {
        if (thisIsDumb > 4)
        {
            ChallengeGym doIt = new ChallengeGym();
            doIt.parentWorld = (ScrollingWorld)getWorld();
            doIt.bring_to_(((ScrollingWorld)getWorld()).marcus, (ScrollingWorld)getWorld());
        }
        if (speaking)
        {
            SpeechBubble speak = new SpeechBubble(spoken[thisIsDumb++], this, 22, Color.BLACK, talkTime);
            getWorld().addObject(speak, 0, 0);
        } else {
            Marcus him = ((ScrollingWorld)getWorld()).marcus;
            SpeechBubble speak = new SpeechBubble(spoken[thisIsDumb++], him, 22, Color.BLACK, talkTime);
            getWorld().addObject(speak, 0, 0);
        }
        speaking = !speaking;
    }
}
