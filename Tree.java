
/**
 * Write a description of class Tree here.
 * 
 * @author J. Marshall
 * @version 0.0
 */
public class Tree extends Organism
{
    // The rate of reproduction.
    private int reproRate;
    // Turns since last repro.
    private int reproCount;
    // % chance of death if there is a fire.
    private int burnChance; 

    /**
     * Constructor for objects of class tree
     */
    public Tree(Zone myZone)
    {
       super (myZone);
       reproRate = 5;
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
