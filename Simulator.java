import java.util.Random;
import java.util.List;
import java.util.Iterator;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Simulator creates an runs a simulation of an ecosystem. 
 * The ecosystem is comprised of game grid and a list of organisms.
 * 
 * Simulator builds and executes the simulation.
 * Tracks number of turns that have been taken.
 * 
 * @author James Marshall, S. Nikoslky
 * @version 0.0
 */
public class Simulator
{
    private GameGrid gameGrid;
    private ArrayList<Organism> organisms;
    private int turns;

    /**
     * Initializes gameGrid with 144 instances of Zone. *
     * each zone gets x and y coords.
     */
    public Simulator()
    { 
        gameGrid = new GameGrid();
        organisms = new ArrayList<Organism>();
        turns = 0;
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
    

}
