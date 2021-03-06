import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpeechBubble here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpeechBubble extends ScrollingActor
{
    private static final int HOVER_AMOUNT = 10;

    private Actor attachedTo;
    private GreenfootImage image;
    private double timer;
    private long startTime;
    private String picture;
    
    public SpeechBubble(String text, Actor a, int size, Color textColor, double timer)
    {
        this.attachedTo = a;
        GreenfootImage bubble = new GreenfootImage("bubble.png");
        bubble.scale(200, 150);
        image = new GreenfootImage(text, size, textColor, null, Color.BLACK);
        picture = text;
        bubble.drawImage(image, 20, 30);
        this.setImage(bubble);
        this.timer = timer * 1000;
        this.startTime = System.currentTimeMillis();
    }
   
        
    /**
     * Act - do whatever the SpeechBubble wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        if (picture == "play-bubble.png" || picture == "fail-bubble.png" || picture == "end-bubble.png")
        {
            setLocation(450, 300);
            if(picture == "play-bubble.png" && Greenfoot.getKey()!=null)
                getWorld().removeObject(this);
            if((picture == "fail-bubble.png") && Greenfoot.isKeyDown("control"))
                getWorld().removeObject(this);
        }
        else
        {
            setLocation(attachedTo.getX() + HOVER_AMOUNT * 2, attachedTo.getY() - (attachedTo.getImage().getHeight() / 2 + image.getHeight() / 2) - HOVER_AMOUNT);
        }
        checkExpiration();
    }    
    
    private void checkExpiration() {
        if (System.currentTimeMillis() > startTime + timer) {
            getWorld().removeObject(this);
        }
    }
}

