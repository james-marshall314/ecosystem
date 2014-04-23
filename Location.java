import java.util.ArrayList;
/**
 * Represent a location in a rectangular grid.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class Location
{
    // grid coords. 
    private int x;
    private int y;
    // a plant in this location. 
    private Organism plant;
    // Deer in this location.
    private ArrayList<Deer> deer; 

    /**
     * Init coords, set location to empty
     */
    public Location(int x, int y)
    {
        this.x = x;
        this.y = y;
        plant = null;
        deer = new ArrayList<Deer>();
    }
    
    /**
     * Add an organism to this location.
     */
    public void add(Organism org)
    {
        if (org instanceof Deer) {
            deer.add((Deer)org);
        }
        else {
            if (plant == null) {
                plant = org;
            }
        }
    }
    
    /**
     * Clear the location of given organism.
     */
    public void clear(Organism org) 
    {
        if (org instanceof Deer) {
            deer.remove((Deer)org);
        }
        else {
            if (org instanceof Tree || org instanceof Grass) {
                plant = null;
            }
        }
    }
    
    /**
     * @Check if the location is full
     * (location is full if there is already a plant object)
     */
    public boolean isFull()
    {
        if (plant == null) {
            return false;
        }
        else {
            return true;
        }
    }
    
    /**
     *@return the X coord of this location. 
     */
    public int getCoordX()
    {
        return x;
    }
    
    
    /**
     *@return the Y coord of this location. 
     */
    public int getCoordY()
    {
        return y;
    }
}
