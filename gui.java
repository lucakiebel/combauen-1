import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gui here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gui extends Actor
{
    /**
     * Act - do whatever the gui wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static int bwe = 0; //bewegungs erlaubnis
    public void act() 
    {
        Actor a = this.getOneIntersectingObject(Robson.class);
        if(a != null)
        {
            bwe = 1;
        }
        else
        {
            bwe = 0;
        }
    }    
}
