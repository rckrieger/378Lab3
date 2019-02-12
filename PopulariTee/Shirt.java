import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Shirt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shirt extends CoolActor
{
    protected Color color;
    public String colorText;
    public Boolean worn = false;
    public Shirt()
    {
        //nah
    }
    
    public Shirt(String colorText, Color color)
    {
        this.color = color;
        this.colorText = colorText;
        makeAnimations();
        animate("unworn");
    }
    
    public void act() 
    {
        if (!worn)
        {
            animate("unworn");
        }
    }
    
    private void makeAnimations()
    {
        ArrayList<GreenfootImage> standCycle = new ArrayList<GreenfootImage>();
        ArrayList<GreenfootImage> nervesCycle = new ArrayList<GreenfootImage>();
        ArrayList<GreenfootImage> unwornCycle = new ArrayList<GreenfootImage>();
        ArrayList<GreenfootImage> walkRCycle = new ArrayList<GreenfootImage>();
        ArrayList<GreenfootImage> walkLCycle = new ArrayList<GreenfootImage>();
        GreenfootImage stand;
        GreenfootImage nerves;
        GreenfootImage unworn;
        GreenfootImage oval;
        GreenfootImage walkR;
        GreenfootImage walkL;
        Color shirt = new Color(248, 152, 56);
        stand = new GreenfootImage("stand"+fileSuffix);
        unworn = new GreenfootImage("stand"+fileSuffix);
        colorIsolate(stand, shirt);
        colorIsolate(unworn, shirt);
        colorCycle(stand, shirt, color);
        colorCycle(unworn, shirt, color);
        oval = new GreenfootImage(unworn);
        unworn.setColor(new Color(10, 10, 10, 100));
        unworn.fillOval(0,0,unworn.getWidth(), unworn.getHeight());
        unworn.drawImage(oval, 0, 0);
        stand.scale(stand.getWidth()*imageScale, stand.getHeight()*imageScale);
        unworn.scale(unworn.getWidth()*imageScale, unworn.getHeight()*imageScale);
        for (int i = 0; i < animatedCycle; i++)
        {
            nerves = new GreenfootImage("nerves"+i+fileSuffix);
            walkR = new GreenfootImage("walk"+i+fileSuffix);
            walkL = new GreenfootImage("walk"+i+fileSuffix);
            walkL.mirrorHorizontally();
            colorIsolate(nerves, shirt);
            colorIsolate(walkR, shirt);
            colorIsolate(walkL, shirt);
            colorCycle(nerves, shirt, color);
            colorCycle(walkR, shirt, color);
            colorCycle(walkL, shirt, color);
            nerves.scale(nerves.getWidth()*imageScale, nerves.getHeight()*imageScale);
            walkR.scale(walkR.getWidth()*imageScale, walkR.getHeight()*imageScale);
            walkL.scale(walkL.getWidth()*imageScale, walkL.getHeight()*imageScale);
            standCycle.add(stand);
            unwornCycle.add(unworn);
            nervesCycle.add(nerves);
            walkRCycle.add(walkR);
            walkLCycle.add(walkL);
        }
        animations.put("stand", new ArrayList<GreenfootImage>(standCycle));
        animations.put("blink", new ArrayList<GreenfootImage>(standCycle));
        animations.put("annoyed", new ArrayList<GreenfootImage>(standCycle));
        animations.put("unworn", new ArrayList<GreenfootImage>(unwornCycle));
        animations.put("nerves", new ArrayList<GreenfootImage>(nervesCycle));
        animations.put("walkR", new ArrayList<GreenfootImage>(walkRCycle));
        animations.put("walkL", new ArrayList<GreenfootImage>(walkLCycle));
    }
}
