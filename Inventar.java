import greenfoot.*;
/**
 * Write a description of class Inventar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inventar  
{
   

    public static int ram = 1;
    public static int speicherplatz;
    
    public static void Anzeigen()
    {
        System.out.println("RAM: "+ ram +" GB");
        System.out.println("Speicherplatz: "+ speicherplatz +" GB");
        
    }
    public static void InvReset()
    {
        ram = 1;
        speicherplatz = 0;
    }
    
}
