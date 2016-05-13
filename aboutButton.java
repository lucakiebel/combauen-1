import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class aboutButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class aboutButton extends Actor
{
    /**
     * Act - do whatever the aboutButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        { 
            launcher.CBABOUT.setImage("CBabout1.PNG");
            
        }
        launcherAbout();
        
    }    
    public static void launcherAbout()
    {
        
        if(Greenfoot.isKeyDown("escape"))
        {
            launcher.CBABOUT.setImage("hb.png");
        }
    }
   
}
