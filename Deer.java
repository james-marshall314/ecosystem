/**
 * Write a description of class Deer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Deer extends Organism
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class Deer
     */
    public Deer(Zone myZone, Location myLoc)
    {
        super (myZone, myLoc);
        
        
    }

    /**
     * Deer moves
     * 
     * @return     new Zone
     */
    public void setZone(Zone newZone)
    {
        myZone=newZone;
    }
}
