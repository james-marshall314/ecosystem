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
     * Get the health level of this deer
     * 
     * @return an int representing the health of this deer
     */
    public int getHealth()
    {
        return health;
    }
    
    /**
     * Health + 1
     */
    public void healthPlus()
    {
        health++;
    }
    
    /**
     * Health 1 1
     */
    public void healthMinus()
    {
        health--;
    }
    
    /**
     * Set the age of the deer.
     */
    public void setAge(int age)
    {
        this.age = age;
    }
    
    /**
     * Age +1
     */
    public void agePlus()
    {
        age++;
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
     * @param a new zone to move to.
     */
    public void move(Zone newZone)

    {
        myZone.removeOrg(this);
        newZone.addOrg(this);
        myZone=newZone;
        
    }
}
