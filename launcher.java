import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class launcher extends World
{

    /**
     * Constructor for objects of class MyWorld.
     *  
     */ 
    public static cbabout CBABOUT = new cbabout();
    public static cbsteuerung CBSTEUERUNG = new cbsteuerung();
    private static int zellenGroesse = 1;
    
    public launcher()
    {    
        super(500, 600, zellenGroesse);
        setBackground("hintergrund.png");
        prepare();
        setPaintOrder(cbsteuerung.class, cbabout.class, Schraube.class);
    }

    private void prepare()
    {
        losbauenButton button1 = new losbauenButton();
        addObject(button1, 391, 446);

        openAlpha alpha = new openAlpha();
        addObject(alpha, 230, 138);

        launchergui gui = new launchergui();
        addObject(gui, 255, 75);
        
        addObject(CBSTEUERUNG,242,199);
        addObject(CBABOUT,240,178);
        //menu one
        optionenButton optionenB = new optionenButton();
        steuerungButton steuerungB = new steuerungButton();
        aboutButton aboutB = new aboutButton();

        addObject(optionenB, 105, 230);
        addObject(steuerungB, 260, 228);
        addObject(aboutB, 415, 230);

    }

    
}
