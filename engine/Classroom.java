import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Classroom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Classroom extends ScrollingWorld
{

    /**
     * Constructor for objects of class Classroom.
     * 
     */
    public Classroom()
    {
        super(1024, 768, 1, false);
        this.marcusX = 200;
        this.marcusY = 600;
        
        Background bg = (Background)(new ClassroomBackground());
        GreenfootImage image = bg.getImage();
        image.scale(image.getWidth()*imageScale/2, image.getHeight()*imageScale/2);
        bg.setImage(image);
        this.boundingBG = bg;
        this.bgMusic = new GreenfootSound("PopulariTee Theme.mp3");
        addObject(bg, 0, image.getHeight()/2);
        
        Marcus main = new Marcus();
        addObject(main, marcusX, marcusY);
    }
}
