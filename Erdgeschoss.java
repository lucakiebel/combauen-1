import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Write a description of class Erdgeschoss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Erdgeschoss extends World
{
    private static int zellenGroesse = 1;
    public static wasdaus WASDAUS = new wasdaus();
    public static GreenfootImage textImage = new GreenfootImage("    Arbeitsspeicher: "+ Inventar.ram+ "GB\n Speicherplatz:  "+ Inventar.speicherplatz +"GB", 
            20, Color.black, new Color(0, 0, 0, 0));  
    /**
     * Constructor for objects of class Erdgeschoss.
     * 
     */ 
    public Erdgeschoss()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500,600, zellenGroesse);
        setBackground("images/hintergrund.png");
        setPaintOrder(Schraube.class, Akku.class, erdgeschossBG.class,  Roboter.class, Wand.class );
        Greenfoot.setSpeed(54);
        prepare();
    }

    private void prepare()
    {
        gui gui = new gui();
        addObject(gui,255,550);
        TreppeErdg treppeErdg = new TreppeErdg();
        addObject(treppeErdg, 467, 36);
        RobsonL robsonl = new RobsonL();
        addObject(robsonl, 465, 24);
        erdgeschossBG ERDBG = new erdgeschossBG();
        addObject(ERDBG,250,300);
        addObject(WASDAUS,69,547);
        
        //

    }
}
