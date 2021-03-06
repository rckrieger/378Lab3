import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.lang.Math;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hallway extends ScrollingWorld
{
    //public int leftWalkBound = 
    //public int rightWalkBound = 
    //public int upWalkBound = 
    //public int downWalkBound = 
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Hallway()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 768, 1, false);
        this.marcusX = 400;
        this.marcusY = 600;
        setPaintOrder(Shirt.class, Marcus.class, SpeechBubble.class, Door.class, Background.class);

        Background bg = (Background)(new HallwayBackground());
        GreenfootImage image = bg.getImage();
        image.scale(image.getWidth()*imageScale, image.getHeight()*imageScale);
        bg.setImage(image);
        this.worldWidth = image.getWidth();
        this.boundingBG = bg;
        addObject(bg, 0, image.getHeight()/2);
        
        GreenfootSound music = new GreenfootSound("PopulariTee Theme.mp3");
        this.bgMusic = music;
        
        Door door3 = (Door)(new HallwayDoor((ScrollingWorld)(new Classroom((ScrollingWorld)this))));
        image = door3.getImage();
        image.scale(image.getWidth()*imageScale, image.getHeight()*imageScale);
        door3.setImage(image);
        addObject(door3, 65*imageScale + 2, bg.getImage().getHeight()/2 - 31*imageScale);
        Door door2 = (Door)(new HallwayDoorM((ScrollingWorld)(new Gym((ScrollingWorld)this))));
        image = door2.getImage();
        image.scale(image.getWidth()*imageScale, image.getHeight()*imageScale);
        door2.setImage(image);
        addObject(door2, -66*imageScale + 2, bg.getImage().getHeight()/2 - 26*imageScale);
        Door door4 = (Door)(new HallwayDoorM((ScrollingWorld)(new DDRWorld((ScrollingWorld)this))));
        image = door4.getImage();
        image.scale(image.getWidth()*imageScale, image.getHeight()*imageScale);
        door4.setImage(image);
        addObject(door4, 567*imageScale - 3, bg.getImage().getHeight()/2 - 26*imageScale);
        Door door1 = (Door)(new HallwayDoor((ScrollingWorld)(new Classroom((ScrollingWorld)this))));
        image = door1.getImage();
        image.scale(image.getWidth()*imageScale, image.getHeight()*imageScale);
        door1.setImage(image);
        addObject(door1, -566*imageScale - 3, bg.getImage().getHeight()/2 - 31*imageScale);

        Marcus main = new Marcus();
        marcus = main;
        addObject(main, marcusX, marcusY);

        Shirt shirtBlue = new Shirt("blue", Color.BLUE);
        addObject(shirtBlue, 750, 600);

        Shirt shirtPurple = new Shirt("purple", new Color(180, 60, 200));
        addObject(shirtPurple, -750, 600);
        
        SpeechBubble derp = new SpeechBubble("I am what\nI wear!", main, 36, Color.WHITE, 4);
        addObject(derp, 0, 0);
    }
}
