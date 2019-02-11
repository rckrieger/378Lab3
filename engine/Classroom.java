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
    public Classroom(ScrollingWorld returnTo)
    {
        super(1024, 768, 1, false);
        this.marcusX = 600;
        this.marcusY = 300;
        setPaintOrder(DeskRow.class, Shirt.class, Marcus.class, ClassroomBackground.class);
        
        Background bg = (Background)(new ClassroomBackground());
        GreenfootImage image = bg.getImage();
        image.scale(image.getWidth()*imageScale, image.getHeight()*imageScale);
        bg.setImage(image);
        this.boundingBG = bg;
        this.bgMusic = new GreenfootSound("PopulariTee Theme.mp3");
        addObject(bg, image.getWidth()/2, image.getHeight()/2);
        
        Marcus main = new Marcus();
        addObject(main, marcusX, marcusY);
        
        DeskRow desks = new DeskRow();
        image = desks.getImage();
        image.scale(image.getWidth()*imageScale, image.getHeight()*imageScale);
        desks.setImage(image);
        addObject(desks, image.getWidth()/2, bg.getImage().getHeight()-image.getHeight()/2);
        
        Door cDoor = (Door)(new ClassroomDoor(returnTo));
        image = cDoor.getImage();
        image.scale(image.getWidth()*imageScale, image.getHeight()*imageScale);
        cDoor.setImage(image);
        addObject(cDoor, bg.getImage().getWidth()-image.getWidth()/2, bg.getImage().getHeight()/2);
    }
}
