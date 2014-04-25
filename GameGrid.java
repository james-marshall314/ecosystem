import java.util.Random;
import java.util.List;
import java.util.Iterator;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * A grid of Zone objects that makes up the gameGrid
 * 
 * @author J. Marshall, S. Nikolsky
 * @version
 */
public class GameGrid
{
    private HashMap<String, Zone> gameGrid;
    private ArrayList<Zone> zones;

    /**
     * Constructor for objects of class GameGrid
     */
    public GameGrid()
    { 
        Zone tempZone;
        gameGrid = new HashMap<String, Zone>();
        zones = new ArrayList<Zone>();
        for (int i=0; i<12; ++i)
        {
            for (int j=0; j<12; ++j)
            {
                tempZone=new Zone (i, j);
                gameGrid.put(Integer.toString(i)+","+Integer.toString(j), tempZone);
                zones.add(tempZone);
            }
        }
        
    }
    
    /**
     * @return a list of all the Zones in the HashMap
     */
    public ArrayList<Zone> getZones()
    {
        return zones;
    }
    
    /**
     * Looks up a specific zone based on its zone number. 
     */
    public Zone getZone(int x, int y)
    {
        return this.gameGrid.get(Integer.toString(x)+","+Integer.toString(y));
    }
    
    /**
     * Returns a list of adjacent zones based on a given zone number.
     */
    public ArrayList<Zone> getAdjZones(int x, int y)
    {
        ArrayList<Zone> neighbors = new ArrayList<Zone>();
        
        for (int i=getStartCoord(x); i <= getEndCoord(x); ++i)
        {
            for (int j=getStartCoord(y); j <= getEndCoord(y); ++j)
            {
                neighbors.add(gameGrid.get (Integer.toString(i)+","+Integer.toString(j)));
            }
        }
        neighbors.remove(gameGrid.get(Integer.toString(x)+","+Integer.toString(y)));
        return neighbors;
    }
    
    private int getStartCoord(int coord)
    {
        if (coord>0)
            return coord-1;
        else
            return coord;
    }
    
    private int getEndCoord(int coord)
    {
        if (coord<11)
            return coord+1;
        else
            return coord;
    }

}
