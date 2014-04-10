
/**
 * a Zone object, which represents a piece of land in the simulation grid. 
 * It can contain plants and animals. 
 * Zone contains a collection of Organisms. 
 * Zone contains methods for interaction with this collection
 * The contructor for Zone initializes the collections by creating and 
 * adding a randomized number of Plant and Animal Objects. 
 * 
 * Zone also keeps track of its disaster state and has methods to access and mutate this information
 * 
 * Zone also knows which Zone it is in the simulation (0 - 143)
 * 
 * @author James Marshall
 * @version 0.0
 */
public class Zone
{
    private ArrayList<Plant> plants;
    private ArrayList<Animal> animals;
    private boolean fireStatus;
    private int zoneNumber;
    private int plantTotal;
    private int grassTotal;
    private int treeTotal;
    private int deerTotal;
    /**
     * Initialize ArrayLists with starting number of plants and animals.
     * fireStatus set to false.
     * 
     * @param zoneNumber
     */
    public Zone(int zoneNumber)
    {
       
    }
    
    /**
     * Set the fire status.
     */
    public void setFireStatus(boolean fireStatus)
    {
        
    }

    /**
     * Returns the zoneNumber 
     */
    public int getZoneNumber()
    {
        
    }
    
    /**
     * Add a Plant to the list. 
     * if the list already contains 10 objects, 
     * the Plant can take the place of a null reference.
     * If no null, if the Plant is type Tree, it can replace type Grass.
     */
    public void addPlant(Plant plant)
    {
        
    }
    
    /**
     * Add an Animal to the list.
     */
    public void addAimal(Animal animal)
    {
        
    }
    
    /**
     * Replace Plant reference in plants with null.
     */
    public void removePlant(Plant plant)
    {
        
    }
    
    /**
     * Remove Animal from the animals. 
     */
    public void removeAnimal(Animal animal)
    {
        
    }
    
    /**
     * Check to see if there is any grass in this zone, returns how much grass.
     */
    public int hasGrass()
    {
        
    }
}
