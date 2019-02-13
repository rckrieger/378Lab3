import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DDRWorld extends CollisionWorld
{
    /** The number of lives the player starts with */
    public static final int STARTLIVES = 5;
    /** The number of levels */
    public static final int MAXLEVEL = 11;
    /** The time to wait between each level */
    public static final int DELAY = 30;
    private int score = 0;
    public long startTime = System.currentTimeMillis();
    public boolean DDRmode = false;
    public int DDRspeed = 44;
    public int worldWidth, worldHeight;
    public GreenfootSound DDRsong = new GreenfootSound("DanceSong.mp3");
    //private static final GreenfootSound sound = new GreenfootSound("bounce.wav");
    /**
     * Create a new world.
     */
    public int getScore(){
        return score;
    }
    
    public DDRWorld(ScrollingWorld returnTo)
    {    
        super(1024, 768, 1, false); 
        setPaintOrder(MovingArrow.class, Stationary.class, Shirt.class, Marcus.class, Drama.class, Dramette.class, Score.class, Background.class);
        this.parentWorld = returnTo;
        this.bgMusic = new GreenfootSound("PopulariTee Theme.mp3");
        this.marcusX = 900;
        this.marcusY = 500;
        worldWidth = super.getWidth();
        worldHeight = super.getHeight();
        Background bg = (Background)(new DDRBackground());
        this.boundingBG = bg;
        addObject(bg, bg.getImage().getWidth()/2, bg.getImage().getHeight()/2);
        
        Drama drama = new Drama();
        GreenfootImage image = drama.getImage();
        image.scale(image.getWidth()*imageScale/5, image.getHeight()*imageScale/5);
        drama.setImage(image);
        addObject(drama, 100, 600);
        
        Dramette dramette = new Dramette();
        image = dramette.getImage();
        image.scale(image.getWidth()*imageScale/4, image.getHeight()*imageScale/4);
        dramette.setImage(image);
        addObject(dramette, 850, 450);
    }

    /**
     * Adds a coin to the player's score.
     */
    public void addPoint()
    {
        score += 5;
    }
    public void subtractPoint()
    {
        score -= 5;
    }

    public void addActors() {
        score = 0;
        Dstat DOWN = new Dstat();
        Ustat UP = new Ustat();
        Rstat RIGHT = new Rstat();
        Lstat LEFT = new Lstat();
        ArrowGenerator arrowgenerator = new ArrowGenerator();
        ClassroomDoor exit = new ClassroomDoor(parentWorld);
        Score scoreDisplay  = new Score();
        GreenfootImage image = new GreenfootImage(1,1);
        scoreDisplay.setImage(image);
        image = exit.getImage();
        image.scale(image.getWidth()*imageScale, image.getHeight()*imageScale);
        exit.setImage(image);
        addObject(exit, worldWidth-image.getWidth()/2, worldHeight/2);
        addObject(arrowgenerator, 0, 0);
        addObject(DOWN, 250, 700);
        addObject(UP, 375, 700);
        addObject(RIGHT, 500, 700);
        addObject(LEFT, 120, 700);
        addObject(scoreDisplay, 850, 100);
    }
    
    public void removeActors()
    {
        for (MovingArrow arrow : getObjects(MovingArrow.class))
        {
            removeObject(arrow);
        }
        for (Stationary arrow : getObjects(Stationary.class))
        {
            removeObject(arrow);
        }
        hideScore();
    }
    
    public void hideScore()
    {
        java.util.List<Score> scores = getObjects(Score.class);
        if (scores.size() > 0)
        {
            removeObject(scores.get(0));
        }
    }
        //SPEECH BUBBLE
        //  addObject(new SpeechBubble("play-bubble.png", forest, 1000), -500, -500);
        // addObject(new SpeechBubble("big-bubble.png", forest, -10), 450, 300);
}
