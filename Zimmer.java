
import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
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
 * Die einzigen aktiven Akteure in der Zimmer sind die Roboter.
 * Die Welt besteht aus 14 * 10 Feldern.
 */  

public class Zimmer extends World
{
    private static int zellenGroesse = 1;
    public static wasdaus WASDAUS = new wasdaus();
    /**
     * Erschaffe eine Welt mit 14 * 10 Zellen.
     */
    public Zimmer() 
    { 
        super(500,600, zellenGroesse);
        setBackground("images/hintergrund.png");
        setPaintOrder(Schraube.class, Akku.class,  Roboter.class, Wand.class);   
        prepare(); 

    }

    /**
     * Bereite die Welt f�r den Programmstart vor. Das hei�t: Erzeuge die Anfangs-
     * Objekte und f�ge sie der Welt hinzu.
     */
    private void prepare()
    {
        Robson robson = new Robson();
        addObject(robson, 458, 29); 
        ZimmerBild zimmerbild = new ZimmerBild();
        addObject(zimmerbild, 250, 250);
        TreppeZimmer treppeZimmer = new TreppeZimmer();
        addObject(treppeZimmer, 467, 36);
        addObject(WASDAUS,69,547);
        gui gui = new gui();
        addObject(gui,255,550);
    }

}
