
/**
 * A Grass Organism.
 * 
 * @author J. Marshall
 * @version 0.0
 */
public class Grass extends Organism
{
    //The rate of reproduction.
    private int reproRate;
    private int reproCount;
    private int burnChance; 

    /**
     * Constructor for objects of class Grass
     */
    public Grass(Zone myZone)
    {
       super (myZone);
       reproRate = 2;
       reproCount = 0;
       burnChance = 75;
    }

    /**
     * Set the reproduction count.
     */
    public void setReproCount(int reproCount)
    {
        this.reproCount = reproCount;
    }
    
}
