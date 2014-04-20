import java.util.ArrayList;
import java.util.Iterator;
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
 * @version 0.1
 */
public class Zone 
{
    private ArrayList<Organism> organisms;
    private boolean fireStatus;
    private int x;
    private int y;
    private int grassTotal;
    private int plantTotal;
    private int treeTotal;
    private int deerTotal;
    /**
     * Initialize zone with a zone number and set the fire status to false. 
     * 
     * @param an int representing the zone's number within the grid
     */
    public Zone(int x, int y)
    {
       organisms = new ArrayList<Organism>();
       grassTotal = 0;
       treeTotal = 0;
       plantTotal = 0;
       deerTotal = 0;
       fireStatus = false;
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
        this.fireStatus = fireStatus;
    }

    /**
     * Returns the fire status.
     * 
     * @return - a boolean indicating if the zone is on fire. 
     */
    public boolean getFireStatus()
    {
        return fireStatus;
    }
    
    /**
     * Returns zone's x coord
     * 
     *@return - integer value representing the Zone's x coord.
     */
    public int getCoordX()
    {
        return x;
    }
    
    /**
     * Returns zone's y coord
     * 
     *@return - integer value representing the Zone's y coord.
     */
    public int getCoordY()
    {
        return y;
    }
    
    /**
     * Add an Organism to the list. 
     * 
     * If there are already 10 Tree or Grass objects in the zone -
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
        this.updateTotals();
        boolean addSuccessful = false;
        if (organism instanceof Grass) {
            if (plantTotal < 10) {
                organisms.add(organism);
                addSuccessful = true;
            }
        }
        if (organism instanceof Tree) {
            if (plantTotal < 10) {
                organisms.add(organism);
                addSuccessful = true;
            }
            else if (grassTotal > 0) {
                this.killGrass();
                organisms.add(organism);
                addSuccessful = true;
            }
        }
        if (organism instanceof Deer) {
            organisms.add(organism);
        }
        this.updateTotals();
        return addSuccessful;
    }
    
    /**
     * Remove and kill a grass organism.
     */
    private void killGrass()
    {
        int x=0;
        Iterator<Organism> itr = organisms.iterator();
        while(itr.hasNext()) {
            Organism org = itr.next();
            if (x == 0) {
                if (org instanceof Grass) {
                    itr.remove();
                    org.kill();
                    x++;
                }
            }
        }
    }
    
    
    /**
     * Remove a given organism from the Zone.
     * 
     * @param an Organism object to be removed from the zone.
     */
    public void removeOrganism(Organism organism)
    {
        organisms.remove(organism);
        this.updateTotals();
    }
    
    /**
     * Update the current organism totals. 
     */
    private void updateTotals()
    {
        grassTotal=0;
        treeTotal=0;
        deerTotal=0;
        for (Organism org : organisms) {
            if (org instanceof Grass) {
                grassTotal++;
            }
            if (org instanceof Tree) {
                treeTotal++;
            }
            if (org instanceof Deer) {
                deerTotal++;
            }
        }
        plantTotal=grassTotal+treeTotal;
    }
        
    
    public int getX()
    { return x; }
    
    public int getY()
    {  return y;}   
    
    
    }
