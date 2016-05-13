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
ZIMMERANF RESETTET DAS INVENTAR
 */  

public class ZimmerAnf extends World
{
    private static int zellenGroesse = 1;
    public static wasdaus WASDAUS = new wasdaus();
    public static GreenfootImage textImage = new GreenfootImage("    Arbeitsspeicher: "+ Inventar.ram+ "GB\n Speicherplatz:  "+ Inventar.speicherplatz +"GB", 
            20, Color.black, new Color(0, 0, 0, 0));      
    /**
     * Erschaffe eine Welt mit 14 * 10 Zellen.
     */
    public ZimmerAnf() 
    {
        super(500,600, zellenGroesse);
        setBackground("images/hintergrund.png");
        setPaintOrder(Schraube.class, Akku.class,  Roboter.class, Wand.class );
        Greenfoot.setSpeed(54); 
        //InvAnz();  
        prepare();
        //System.out.print('\f'); 
        //Einleitung();
       

    }

    /**
     * Bereite die Welt für den Programmstart vor. Das heißt: Erzeuge die Anfangs-
     * Objekte und füge sie der Welt hinzu.
     */
    /*public void InvAnz()  
    {  

    GreenfootImage image = new GreenfootImage(textImage); 
    getBackground().drawImage(textImage, 300, 500);  

    }
     */
    private void prepare()
    {
        gui gui = new gui();
        addObject(gui,255,550);
        Robson robson = new Robson();
        addObject(robson, 90, 420); 
        ZimmerBild zimmerbild = new ZimmerBild();
        addObject(zimmerbild, 250, 250);
        TreppeZimmer treppeZimmer = new TreppeZimmer();
        addObject(treppeZimmer, 467, 36);
        //einleitung cbeinleitung = new einleitung();
        //addObject(cbeinleitung, 250, 250);
        
        addObject(WASDAUS,69,547);

        //Anz RamStat = new Anz("Arbeitsspeicher: "+Inventar.ram+"GB");
        //addObject(RamStat, 255, 520);

    }

    /*public void Einleitung()
    {
    int einl = 0;
    while( einl == 0 )
    {
    System.out.println("Open Alpha 0.1");
    System.out.println("Steuerung:");
    System.out.println("    Moveset: W A S D / Pfeiltasten");
    System.out.println("Aktionen: X"); 
    System.out.println("Aktionen sind mit folgenden Objekten möglich:");
    System.out.println("    Zimmern, Türen, Items aller Art und NPCs");
    System.out.println("©LuckyLutscher 2015-2016, All rights reserved");
    einl = 1;

    }
    }
     */
   
    public static void cAnz()
    {
        textImage.clear();

    }
}