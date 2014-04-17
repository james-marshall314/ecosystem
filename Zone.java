import java.util.ArrayList;
/**
 * A Zone object, which represents a piece of land in the simulation grid. 
 * Zone stores information about its self such as how many Organism objects are in it. 
 * It contains methods for adding and removing Organism objects. 
 * 
 * Zone conatins a list of all organisms currently in the zone. 
 * 
 * Zone also keeps track of its disaster state and has methods to access and mutate this information.
 * 
 * Zone keeps a record of which Zone it is in the simulation (0 - 143).
 * 
 * @author James Marshall
 * @version 0.0
 */
public class Zone 
{
    private ArrayList<Organism> organisms;
    private boolean fireStatus;
    private int x;
    private int y;
    private int grassTotal;
    private int treeTotal;
    private int deerTotal;
    /**
     * Initialize zone with a zone number and set the fire status to false. 
     * 
     * @param an int representing the zone's number within the grid
     */
    public Zone(x, y)
    {
       this.x=x;
       this.y=y;
    }
    
    /**
     * Set the fire status.
     * 
     * @param - a boolean for fire status
     */
    public void setFireStatus(boolean fireStatus)
    {
        
    }

    /**
     * Returns the fire status.
     * 
     * @return - a boolean indicating if the zone is on fire. 
     */
    public boolean getFireStatus()
    {
    }
    
    /**
     * Returns the zoneNumber
     * 
     *@return - an integer value represting the zone's number within the grid.
     */
    public int getZoneNumber()
    {
        
    }
    
    /**
     * Add an Organism to the list. 
     * 
     * If there are already than 10 Tree or Grass objects in the zone -
     * Does not allow grass to be added. 
     * Will add a tree only if it can take the place of a grass object.
     * Grass object is set to dead.
     * 
     * if the addition is allowed, the organism totals are updated. 
     * 
     * returns False if the addition was not allowed. 
     * 
     * @param An Organism object to be added to the zone
     * @return a boolean indcating if the opperation was successful or not. 
     */
    public boolean addOrgansim(Organism organism)
    {
    }
    
    /**
     * Remove a given organism from the Zone.
     * 
     * @param an Organism object to be removed from the zone.
     */
    public void removeOrganism(Organism organism)
    {
    }
    
    /**
     * Update the current organism totals. 
     */
    private void updateTotals()
    {
    }
    
    public int getX()
    { return x; }
    
    public int getY()
    {  return y;}   
    
    
    }
