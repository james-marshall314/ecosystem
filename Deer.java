/**
 * A Deer Organism.
 * 
 * @author J. Marshall, S. Nikolsky
 * @version 0.0
 */
public class Deer extends Organism
{
    private int health;
    private int age;
    private int reproAge;

    /**
     * Constructor for objects of class Deer
     */
    public Deer(Zone myZone)
    {
        super (myZone);
        health = 8;
        age = 0;
        reproAge = 4;
    }
    
    /**
     * Set the age of the deer.
     */
    public void setAge(int age)
    {
        this.age = age;
    }
    
    /**
     * Check if deer can reproduce.
     * 
     * @return  boolean true if deer can reproduce.
     */
    public boolean canRepro()
    {
        if (age >= reproAge && health == 8) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Deer moves
     * 
     * @return  new Zone
     */
    public void setZone(Zone newZone)

    {
        myZone=newZone;
    }
}
