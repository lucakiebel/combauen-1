import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Treppe2 here.
 *  
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TreppeZimmer extends Actor
{
    int Welt = 0;
    /**
     * Act - do whatever the Treppe2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Actor a = this.getOneIntersectingObject(Robson.class);
        if(a != null)
        {
            if(Greenfoot.isKeyDown("x"))
            {
                this.getWorld().removeObject(a);
                if(Welt==0)
                {
                    Welt = 1;
                    Greenfoot.delay(2);
                    Greenfoot.setWorld(new Erdgeschoss());                    
                }
                else if(Welt==1)
                {
                    Welt = 0;
                    Greenfoot.delay(2);
                    Greenfoot.setWorld(new Zimmer()); 
                }
            }              
        }
    }    
}
