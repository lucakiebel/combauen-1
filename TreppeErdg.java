import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Treppe2 here.
 *  
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TreppeErdg extends Actor
{

    /**
     * Act - do whatever the Treppe2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Actor a = this.getOneIntersectingObject(RobsonL.class);
        if(a != null)
        {
            if(Greenfoot.isKeyDown("x"))
            {
                this.getWorld().removeObject(a); 
                Greenfoot.delay(20);
                Greenfoot.setWorld(new Zimmer());

            }              
        }
    }    
}
