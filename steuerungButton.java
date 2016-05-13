import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class steuerungButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class steuerungButton extends Actor
{
    /**
     * Act - do whatever the steuerungButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        { 
            launcher.CBSTEUERUNG.setImage("steuerung.PNG");

        }
        launcherSteuerung();

    }    

    public static void launcherSteuerung()
    {

        if(Greenfoot.isKeyDown("escape"))
        {
            launcher.CBSTEUERUNG.setImage("hb.png");
        }
    }    
}
