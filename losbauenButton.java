import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class losbauenButton extends Actor
{
    /**
     * Act - do whatever the button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)) {//true if you clicked at this object;
            //setImage("losbauen-button2.png"); //changes the image of the button so that you see if it's clicked;
            Greenfoot.delay(40);
            //also add the methods you want to execute;
            Greenfoot.setWorld(new ZimmerAnf());
        }    
    }
}
