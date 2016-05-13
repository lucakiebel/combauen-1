import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/** 
 * Die Klasse Robson ist eine Unterklasse von Roboter.
 * Sie erbt damit alle Attribute und Methoden der Klasse Roboter.
 */

public class Robson extends Roboter
{
    //private Anz RamStat;
    private int millisElapsed = 0;
    private long lastTime = 0;
    private int as = 0; // anti spam
    /**
     * In der Methode "act" koennen Befehle / andere Methoden angewendet werden:
     * Die Methoden werden dort nacheinander "aufgerufen", wenn man
     * nach dem Kompilieren / uebersetzen den Act-Knopf drueckt..
     */

    /*public void updateAn()
    {

    RamStat.update("Arbeitsspeicher: "+Inventar.ram+"GB"); 
    getRam();   

        
    }
     */
    int hs = 0;
    public void act()
    { 
        long time = System.currentTimeMillis();
        if(lastTime != 0) {
            long diff = time - lastTime;
            millisElapsed += diff;
        }
        lastTime = time;     
        //updateAn();
        if(Greenfoot.isKeyDown("up"))
        {
            if(hs == 0 || hs == 1)
            {
                hs = 1;
                as = 0;
                millisElapsed = 0;
                bewegenO();
                setImage("Robson_vonhinten.png");
            }
        }
        if(Greenfoot.isKeyDown("down")) 
        {
            if(hs == 0 || hs == 2)
            {
                hs = 2; 
                as = 0;
                millisElapsed = 0;
                if(gui.bwe == 0)
                {
                    bewegenU(); 
                }
                setImage("Robson.png");
            }
        }
        if(Greenfoot.isKeyDown("left")) 
        {
            if(hs == 0 || hs == 3)
            {
                millisElapsed = 0;
                hs = 3;
                as = 0;
                bewegenL();
                setImage("Robson_vonlinks.png");
            }
        }
        if(Greenfoot.isKeyDown("right")) 
        {
            if(hs == 0 || hs == 4)
            {
                millisElapsed = 0;
                hs = 4;
                as = 0;
                bewegenR();
                setImage("Robson_vonrechts.png");
            }
        } 
        if(Greenfoot.isKeyDown("w"))
        {   
            if(hs == 0 || hs == 1)
            {
                hs = 1;
                as = 0;
                millisElapsed = 0;
                bewegenO();
                setImage("Robson_vonhinten.png");
                ZimmerAnf.WASDAUS.setImage("wasd-wdown.png"); 
                Zimmer.WASDAUS.setImage("wasd-wdown.png"); 
            }

        }
        if(Greenfoot.isKeyDown("s")) 
        {
            if(hs == 0 || hs == 2)
            {
                hs = 2;
                as = 0;
                millisElapsed = 0; 
                if(gui.bwe == 0)
                {
                    bewegenU(); 
                }
                setImage("Robson.png");
                ZimmerAnf.WASDAUS.setImage("wasd-sdown.png"); 
                Zimmer.WASDAUS.setImage("wasd-sdown.png");
            }
        }

        if(Greenfoot.isKeyDown("a")) 
        {
            if(hs == 0 || hs == 3)
            {
                hs = 3;
                as = 0;
                millisElapsed = 0;
                bewegenL();
                setImage("Robson_vonlinks.png");
                ZimmerAnf.WASDAUS.setImage("wasd-adown.png"); 
                Zimmer.WASDAUS.setImage("wasd-adown.png");
            }
        }

        if(Greenfoot.isKeyDown("d")) 
        {
            if(hs == 0 || hs == 4)
            {
                hs = 4;
                as = 0;
                millisElapsed = 0;
                bewegenR();
                setImage("Robson_vonrechts.png");
                ZimmerAnf.WASDAUS.setImage("wasd-ddown.png"); 
                Zimmer.WASDAUS.setImage("wasd-ddown.png"); 
            }
        } 
        if(as==0)
        { 
            if(Greenfoot.isKeyDown("i")) 
            {
                as = 1 ;
                System.out.print('\f');
                Inventar.ram++;
                Inventar.Anzeigen();

            }            

        }
        if(hs>=0)
        {
            if(millisElapsed >= 20)
            {
                hs = 0; 
                ZimmerAnf.WASDAUS.setImage("wasd-1aus.png");
                Zimmer.WASDAUS.setImage("wasd-1aus.png");
                millisElapsed = 0;
            }
        }
    }

    /*  
    public int getRam() {

    return Inventar.ram;
    }  
     */
}
