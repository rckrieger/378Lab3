import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class MainC here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Marcus extends CoolActor
{
    /**
     * Act - do whatever the MainC wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int delta = 2;
    private int deltaX = 3 * delta;
    private int deltaY = 2 * delta;
    private Vector speed;
    public Shirt wearing = null;
    private boolean spacing = false;
    private int idling = 0;
    private int idleCycle = 20*imageScale;
    public boolean DDRmode = false;
    public boolean STOPYOUASSHOLE = false;
    public int theatreScore = 0;
    public int jocksScore = 0;
    public int gothsScore = 0;
    
    public Marcus()
    {
        super();
        this.speed = new Vector(0,0);
        makeAnimations();
        this.animate("stand");
    }
    
    public void act() 
    {
        if (jocksScore != 0 && theatreScore != 0)
        {
            System.out.println("YOU WIN YOU ASSHOLE, NOW MAKE AN ENDSCREEN!");
        }
        else if (!STOPYOUASSHOLE)
        {
            interact();
            changeSpeed();
            checkScroll(deltaX);
            moveCharacter();
        }
    }
    
    private void interact()
    {
        if (!spacing && (Greenfoot.isKeyDown("space") || Greenfoot.isKeyDown("enter")))
        {
            if (isTouching(Athlete.class) && jocksScore == 0)
            {
                Athlete Jim = (Athlete)getOneIntersectingObject(Athlete.class);
                Jim.conversate();
            }
            else if (getWorld().getClass() == DDRWorld.class && theatreScore == 0)
            {
                DDRmode = true;
                DDRWorld ddr = (DDRWorld)getWorld();
                ddr.DDRmode = true;
                Greenfoot.setSpeed(ddr.DDRspeed);
                ddr.addActors();
                ddr.bgMusic.pause();
                ddr.DDRsong.play();
            }
            else if (isTouching(Door.class))
            {
                Door door = (Door)getOneIntersectingObject(Door.class);
                door.enter(this);
            }
            else if (isTouching(Shirt.class))
            {
                ArrayList<Shirt> shirts = (ArrayList<Shirt>)getIntersectingObjects(Shirt.class);
                if (shirts.size() == 1)
                {
                    if (wearing == null)
                    {
                        putOn(shirts.get(0));
                    } else {
                        derobe();
                    }
                }
                else if (shirts.size() == 2 && wearing != null)
                {
                    putOn((wearing == shirts.get(0)) ? shirts.get(1) : shirts.get(0));
                }
            }
        }
        if (!spacing && Greenfoot.isKeyDown("i"))
        {
            Color color = (wearing != null) ? wearing.color : Color.WHITE;
            SpeechBubble derp = new SpeechBubble("I am what\nI wear!", this, 36, color, 5);
            getWorld().addObject(derp, 0, 0);
        }
        if (Greenfoot.isKeyDown("space") || Greenfoot.isKeyDown("enter") || Greenfoot.isKeyDown("i"))
        {
            spacing = true;
        }
        else
        {
            spacing = false;
        }
    }
    
    private void changeSpeed()
    {
        int xChange = deltaX;
        int yChange = deltaY;
        if ((Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")) &&
            (speed.getX() > -deltaX))
        {
            speed.changeTo(-xChange, 0);
        }
        else if ((Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) &&
                 (speed.getX() < deltaX))
        {
            speed.changeTo(xChange, 0);
        }
        if ((Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w")) &&
            (speed.getY() > -deltaY))
        {
            speed.changeTo(0, -yChange);
        }
        else if ((Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s")) &&
                 (speed.getY() < deltaY))
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
        int slowFactor = delta;
        String animationType = "stand";
        if (vx == 0 && vy == 0)
        {
            animationType = doIdle();
        } else {
            idling = 0;
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
            wearing.animate(animationType);
        }
        return;
    }
    
    private String doIdle()
    {
        if (++idling > idleCycle)
        {
            if (idling > idleCycle+4*imageScale)
            {
                idling = 0;
            }
            if (wearing == null)
            {
                return "stand";
            }
            switch (wearing.colorText)
            {
                case "red":
                    return "nerves";
                case "black":
                    return "annoyed";
                case "yellow":
                    return "blink";
                case "purple":
                case "blue":
                default:
                    return "stand";
                
            }
        }
        return "stand";
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
        noIntersect &= !DDRmode;
        noIntersect &= ((getX() > left  && dX <= 0) ||
                        (getX() < right && dX >= 0));
        noIntersect &= ((getY() > up && dY <= 0) ||
                        (getY() < down && dY >= 0));
        if (dX > 0 || dY > 0)
        {
            noIntersect &= (getOneObjectAtOffset(dX+w, dY+h, Gothette.class) == null);
        }
        if (dX > 0 || dY < 0)
        {
            noIntersect &= (getOneObjectAtOffset(dX+w, dY-h, Gothette.class) == null);
        }
        if (dX < 0 || dY < 0)
        {
            noIntersect &= (getOneObjectAtOffset(dX-w, dY-h, Gothette.class) == null);
        }
        if (dX < 0 || dY > 0)
        {
            noIntersect &= (getOneObjectAtOffset(dX-w, dY+h, Gothette.class) == null);
        }
        return noIntersect;
    }
    
    private void makeAnimations()
    {
        ArrayList<GreenfootImage> spriteCycle = new ArrayList<GreenfootImage>();
        ArrayList<GreenfootImage> spriteCycleR = new ArrayList<GreenfootImage>();
        ArrayList<GreenfootImage> blinkCycle = new ArrayList<GreenfootImage>();
        GreenfootImage image;
        GreenfootImage image2;
        for (int i = 0; i < 3; i++)
        {
            image = new GreenfootImage("walk"+i+fileSuffix);
            image.scale(image.getWidth()*imageScale, image.getHeight()*imageScale);
            spriteCycle.add(image);
            image = new GreenfootImage(image);
            image.mirrorHorizontally();
            spriteCycleR.add(image);
            image = new GreenfootImage("blink"+i+fileSuffix);
            image.scale(image.getWidth()*imageScale, image.getHeight()*imageScale);
            blinkCycle.add(image);
        }
        spriteCycle.add(spriteCycle.get(1));
        spriteCycleR.add(spriteCycleR.get(1));
        blinkCycle.add(blinkCycle.get(1));
        animations.put("walkR", new ArrayList<GreenfootImage>(spriteCycle));
        animations.put("walkL", new ArrayList<GreenfootImage>(spriteCycleR));
        animations.put("blink", new ArrayList<GreenfootImage>(blinkCycle));
        spriteCycle = new ArrayList<GreenfootImage>();
        image = new GreenfootImage("annoyed0"+fileSuffix);
        image2 = new GreenfootImage("annoyed1"+fileSuffix);
        image.scale(image.getWidth()*imageScale, image.getHeight()*imageScale);
        image2.scale(image2.getWidth()*imageScale, image2.getHeight()*imageScale);
        spriteCycle.add(image);
        spriteCycle.add(image2);
        spriteCycle.add(image2);
        spriteCycle.add(image2);
        animations.put("annoyed", new ArrayList<GreenfootImage>(spriteCycle));
        spriteCycle = new ArrayList<GreenfootImage>();
        image = new GreenfootImage("nerves0"+fileSuffix);
        image2 = new GreenfootImage("nerves1"+fileSuffix);
        image.scale(image.getWidth()*imageScale, image.getHeight()*imageScale);
        image2.scale(image2.getWidth()*imageScale, image2.getHeight()*imageScale);
        spriteCycle.add(image);
        spriteCycle.add(image2);
        spriteCycle.add(image);
        spriteCycle.add(image2);
        animations.put("nerves", new ArrayList<GreenfootImage>(spriteCycle));
        spriteCycle = new ArrayList<GreenfootImage>();
        image = new GreenfootImage("stand"+fileSuffix);
        image.scale(image.getWidth()*imageScale, image.getHeight()*imageScale);
        for (int i = 0; i < animatedCycle; i++)
        {
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
        wearing.setLocation(getX(), getY());
        wearing.animatedStatus = this.animatedStatus;
        wearing.animatedIndex = this.animatedIndex;
        wearing.worn = true;
    }
    
    private void derobe()
    {
        wearing.worn = false;
        wearing = null;
    }
}
