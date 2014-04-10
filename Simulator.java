
/**
 * Simulator creates an runs a simulation of an ecosystem. 
 * The ecosystem is comprised of a grid of zones, which can be populated 
 * by plant and animal life. 
 *
 * Holds an ArrayList of Zone.
 * 
 * Simulator builds and executes the simulation.
 * Tracks number of turns that have ran.
 * 
 * @author James Marshall
 * @version 0.0
 */
public class Simulator
{
    private ArrayList<Zone> gameGrid;
    private int turns;

    /**
     * Initializes gameGrid with 144 instances of Zone. With each addition, 
     * the param passed to Zone, starting at 0, is incrementented by 1 
     * so that each Zone has its own number between 0 and 143. 
     */
    public Simulator()
    {
        
    }

    /**
     * Runs through a single turn of the simulation.
     */
    private void runSim()
    {
        
    }
    
    /**
     * Looks up a specific zone based on its zone number. 
     */
    public Zone getZone(int zoneNumber)
    {
        
    }
    
    /**
     * Returns a list of adjacent zones based on a given zone number.
     */
    public ArrayList<zone> getAdjZones(int zoneNumber)
    {
        
    }
}
