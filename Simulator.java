import java.util.Random;
import java.util.List;
import java.util.Iterator;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Simulator creates an runs a simulation of an ecosystem. 
 * The ecosystem is comprised of a list of zones and a list of organisms.
 * 
 * Simulator builds and executes the simulation.
 * Tracks number of turns that have been taken.
 * 
 * @author James Marshall, S. Nikoslky
 * @version 0.0
 */
public class Simulator
{
    private HashMap<String, Zone> gameGrid;
    private ArrayList<Organism> organisms;
    private int turns;

    /**
     * Initializes gameGrid with 144 instances of Zone. *
     * each zone gets x and y coords.
     */
    public Simulator()
    { 
        Zone tempZone;
        for (int i=0; i<12; ++i)
        {
            for (int j=0; j<12; ++j)
            {
                tempZone=new Zone (i, j);
                gameGrid.put(Integer.toString(i)+","+Integer.toString(j), tempZone);
            }
        }
        
    }
    
    /**
     * Creates game display 
     */
    public void setDisplay()
    {
        
    }
    
     /**
     * updates game display
     */  
    public void updateDisplay()
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

        int startX=getStartCoord(x);
        int endX=getEndCoord(x);
        int startY=getStartCoord(y);
        int endY=getEndCoord(y);
        
        for (int i=getStartCoord(x); i<getEndCoord(x); ++i)
        {
            for (int j=getStartCoord(y); j<getEndCoord(y); ++j)
            {
                if (i!=x || j!=y)
                    neighbors.add(gameGrid.get (Integer.toString(i)+","+Integer.toString(j)));
            }
        }
        
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
