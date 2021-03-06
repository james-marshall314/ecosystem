import java.util.ArrayList;
/**
 * Organism knows if it is alive or dead. Has a method to kill it.
 * Organism stores the zone it is currently in. and if it is alive or not.
 * Organism stores a reference to the Simulator object that uses it. 
 * Organism should also store a list of its offspring -
 * and methods to relay that list as well as clear it.
 * 
 * @author James Marshall
 * @version 0.0
 */
public class Organism
{
    private boolean isAlive;
    //zone
    protected Zone myZone;
    //a location within a zone.
    private Location myLoc;
    //a list to temporarly hold offspring that may be created during a turn of the sim.
    private ArrayList<Organism> offspring;

    /**
     * Constructor for objects of class Organism
     * 
     * sets Zone that is passed in and adds the org to that zone.
     */
    public Organism(Zone myZone)
    {
        isAlive = true;
        this.myZone = myZone;
        myZone.addOrg(this);
        offspring = new ArrayList<Organism>();
    }

    /**
     *Check if this organism is alive.
     *@return A boolean, true if alive. 
     */
    public boolean isAlive()
    { 
        return isAlive;
    }
    
    /**
     * Kill this organism.
     * organism removes its self from its current zone.
     * isAlive set false.
     */
    public void kill()
    {
        isAlive = false;
        myZone.removeOrg(this);
    }
    
    /**
     * Set the location of the object.
     */
    public void setLoc(Location loc)
    {
        myLoc = loc;
    }
    
    /**
     * Get a list of offspring.
     */
    public ArrayList<Organism> getOffspring()
    {
        return offspring;
    }
    
    /**
     * Add offspring
     * 
     * @param an organism reprsenting this organisms offspring
     */
    public void addOffspring(Organism org)
    {
        offspring.add(org);
    }
    
    /**
     * Clear the list of offspring.
     */
    public void clearOffspring()
    {
        offspring.clear();
    }
    
    /**
     * @return this organisms zone.
     */
    public Zone getZone()
    {
        return myZone;
    }
}
