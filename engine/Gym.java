import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gym here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gym extends ScrollingWorld
{
    public Gym(ScrollingWorld returnTo)
    {
        super(1024, 768, 1, false);
        this.marcusX = 600;
        this.marcusY = 500;
        this.imageScale = 1;
        
        Background bg = (Background)(new GymBackground());
        GreenfootImage image = bg.getImage();
        image.scale(image.getWidth()*imageScale, image.getHeight()*imageScale);
        bg.setImage(image);
        this.boundingBG = bg;
        this.bgMusic = new GreenfootSound("PopulariTee Theme.mp3");
        addObject(bg, image.getWidth()/2, image.getHeight()/2);
        
        Door door1 = (Door)(new GymDoor((ScrollingWorld)returnTo));
        image = door1.getImage();
        image.scale(image.getWidth()*imageScale, image.getHeight()*imageScale);
        door1.setImage(image);
        addObject(door1, 582, 283);
        
        Door door2 = (Door)(new GymDoorM((ScrollingWorld)returnTo));
        image = door2.getImage();
        image.scale(image.getWidth()*imageScale, image.getHeight()*imageScale);
        door2.setImage(image);
        addObject(door2, 2107, 283);
        
    }
}
