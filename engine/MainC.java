import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class MainC here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainC extends AnimatedActor
{
    /**
     * Act - do whatever the MainC wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int delta = 2;
    private int deltaX = 3 * delta;
    private int deltaY = 2 * delta;
    private Vector speed;
    private Shirt wearing = null;
    
    public MainC()
    {
        super();
        this.speed = new Vector(0,0);
        makeAnimations();
        this.animate("stand");
    }
    
    public void act() 
    {
        interact();
        changeSpeed();
        checkScroll();
        moveCharacter();
    }
    
    private void interact()
    {
        if (Greenfoot.isKeyDown("space") || Greenfoot.isKeyDown("enter"))
        {
            if (isTouching(Door.class))
            {
                Door door = (Door)getOneIntersectingObject(Door.class);
                door.enter();
            }
            if (isTouching(Shirt.class))
            {
                ArrayList<Shirt> shirts = (ArrayList<Shirt>)getIntersectingObjects(Shirt.class);
                if (shirts.size() == 1 && wearing == null)
                {
                    putOn(shirts.get(0));
                }
                else if (shirts.size() == 2 && wearing != null)
                {
                    putOn((wearing == shirts.get(0)) ? shirts.get(1) : shirts.get(0));
                }
            }
        }
    }
    
    private void changeSpeed()
    {
        int xChange = imageScale * deltaX;
        int yChange = imageScale * deltaY;
        if ((Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")) &&
            (speed.getX() > -imageScale*deltaX))
        {
            speed.changeTo(-xChange, 0);
        }
        else if ((Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) &&
                 (speed.getX() < imageScale*deltaX))
        {
            speed.changeTo(xChange, 0);
        }
        if ((Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w")) &&
            (speed.getY() > -imageScale*deltaY))
        {
            speed.changeTo(0, -yChange);
        }
        else if ((Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s")) &&
                 (speed.getY() < imageScale*deltaY))
        {
            speed.changeTo(0, yChange);
        }
        return;
    }
    
    private void moveCharacter()
    {
        int x = getX();
        int y = getY();
        int vx = speed.getX();
        int vy = speed.getY();
        int slowFactor = imageScale * delta;
        String animationType = "stand";
        if (vx == 0 && vy == 0)
        {
            //No movement to be done.
        } else {
            if (vy != 0)
            {
                y += (safeToMove(0, vy)) ? vy : 0;
                vy += (vy > 0) ? -slowFactor : slowFactor;
                animationType = "walkR";
            }
            if (vx != 0)
            {
                x += (safeToMove(vx, 0)) ? vx : 0;
                vx += (vx > 0) ? -slowFactor : slowFactor;
                animationType = (vx > 0) ? "walkR" : "walkL";
            }
            setLocation(x,y);
            if (wearing != null)
            {
                wearing.setLocation(x,y);
            }
            speed.changeTo(vx, vy);
        }
        animate(animationType);
        if (wearing != null)
        {
            wearing.animate(animationType+wearing.colorText);
        }
        return;
    }
    
    private boolean safeToMove(int dX, int dY)
    {
        int overlap = imageScale * 3;
        int h = getImage().getHeight()/2 - overlap;
        int w = getImage().getWidth()/2 - overlap;
        int charWidth = getImage().getWidth()/2;
        int left  = charWidth + overlap + dX;
        int right = getWorld().getWidth() - charWidth - overlap + dX;
        int up    = getWorld().getHeight()/2 + overlap*2 - dY;
        int down  = getWorld().getHeight() - overlap*2 - dY;
        boolean noIntersect = true;
        noIntersect &= ((getX() > left  && dX <= 0) ||
                        (getX() < right && dX >= 0));
        noIntersect &= ((getY() > up && dY <= 0) ||
                        (getY() < down && dY >= 0));
        if (dX > 0 || dY > 0)
        {
            noIntersect &= (getOneObjectAtOffset(dX+w, dY+h, Wall.class) == null);
        }
        if (dX > 0 || dY < 0)
        {
            noIntersect &= (getOneObjectAtOffset(dX+w, dY-h, Wall.class) == null);
        }
        if (dX < 0 || dY < 0)
        {
            noIntersect &= (getOneObjectAtOffset(dX-w, dY-h, Wall.class) == null);
        }
        if (dX < 0 || dY > 0)
        {
            noIntersect &= (getOneObjectAtOffset(dX-w, dY+h, Wall.class) == null);
        }
        return noIntersect;
    }
    
    private void checkScroll()
    {
        int x = getX();
        int width = getWorld().getWidth();
        int lower = width * 2 / 10;
        int upper = width * 8 / 10;
        int maxWidth = ((ScrollingWorld)this.getWorld()).getWorldWidth();
        if (x > upper)
        {
            ((Hallway)getWorld()).scroll(-imageScale*deltaX);
        }
        else if (x < lower)
        {
            ((Hallway)getWorld()).scroll(imageScale*deltaX);
        }
    }
    
    private void makeAnimations()
    {
        ArrayList<GreenfootImage> spriteCycle = new ArrayList<GreenfootImage>();
        ArrayList<GreenfootImage> spriteCycleR = new ArrayList<GreenfootImage>();
        GreenfootImage image;
        for (int i = 0; i < animatedCycle; i++)
        {
            image = new GreenfootImage("walk"+i+fileSuffix);
            image.scale(image.getWidth()*imageScale, image.getHeight()*imageScale);
            spriteCycle.add(image);
            image = new GreenfootImage(image);
            image.mirrorHorizontally();
            spriteCycleR.add(image);
        }
        animations.put("walkR", new ArrayList<GreenfootImage>(spriteCycle));
        animations.put("walkL", new ArrayList<GreenfootImage>(spriteCycleR));
        spriteCycle = new ArrayList<GreenfootImage>();
        for (int i = 0; i < animatedCycle; i++)
        {
            image = new GreenfootImage("stand"+i+fileSuffix);
            image.scale(image.getWidth()*imageScale, image.getHeight()*imageScale);
            spriteCycle.add(image);
        }
        animations.put("stand", new ArrayList<GreenfootImage>(spriteCycle));
    }
    
    private void putOn(Shirt toWear)
    {
        if (this.wearing != null)
        {
            wearing.worn = false;
        }
        this.wearing = toWear;
        toWear.setLocation(getX(), getY());
        toWear.animatedStatus = this.animatedStatus;
        toWear.animatedIndex = this.animatedIndex;
        toWear.worn = true;
    }
}
