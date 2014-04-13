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
    //the the simulator object that uses this organism. 
    private Simulator simulator;
    //the zone the object is in.
    private Zone currentZone;
    //a list to temoporarly hold offspring that may be created during a turn of the sim.
    private ArrayList<Organism> offspring;

    /**
     * Constructor for objects of class Organism
     */
    public Organism(Simulator simulator)
    {
    }

    /**
     *Check if this organism is alive.
     *@return A boolean, true if alive. 
     */
    public boolean isAlive()
    {
    }
    
    /**
     * Kill this organism.
     * organism removes its self from its current zone.
     * isAlive set false.
     */
    public void kill()
    {
    }
    
    /**
     * Get a list of offspring.
     */
    public ArrayList<Organism> getOffspring()
    {
    }
    
    /**
     * Clear the list of offspring.
     */
    public void clearOffspring()
    {
    }
}
