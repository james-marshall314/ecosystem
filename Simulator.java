import java.util.Random;
import java.util.List;
import java.util.Iterator;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
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
    private static final Random random = new Random(666);

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
        //All Grass take turn
        for (Organism org : organisms) {
            if (org instanceof Grass) {
                this.grassTurn((Grass)org);
            }
        }
        //All Tree take turn
        for (Organism org : organisms) {
            if (org instanceof Tree) {
                this.treeTurn((Tree)org);
            }
        }
        //All Deer take turn
        for (Organism org : organisms) {
            if (org instanceof Deer) {
                this.deerTurn((Deer)org);
            }
        }
        //Add all offspring created in this round.
        for (Organism org : organisms) {
            organisms.addAll(org.getOffspring());
            org.clearOffspring();
        }
        //Advance turns
        turns++;
    }
    
    /**
     * A turn for a Grass object. 
     */
    private void grassTurn(Grass grass)
    {
        if (grass.canRepro() == true) {
            ArrayList<Zone> adjZones = gameGrid.getAdjZones(grass.getZone().getCoordX(), grass.getZone().getCoordY());
            adjZones.add(grass.getZone());
            int count = adjZones.size();
            while(count > 0) {
                Zone tempZone = adjZones.get(random.nextInt(count));
                if (tempZone.plantFull() == false) {
                    Grass newGrass = new Grass(tempZone);
                    grass.addOffspring(newGrass);
                    tempZone.addOrg(newGrass);
                    grass.setReproCount(0);
                    count = 0;
                }
                else {
                    adjZones.remove(tempZone);
                }
            }
        }
        else {
            grass.advCount();
        }
    }
    
    /**
     * A turn for a Tree object
     */
    private void treeTurn(Tree tree)
    {
        if (tree.canRepro() == true) {
            ArrayList<Zone> adjZones = gameGrid.getAdjZones(tree.getZone().getCoordX(), tree.getZone().getCoordY());
            adjZones.add(tree.getZone());
            int count = adjZones.size();
            while(count > 0) {
                Zone tempZone = adjZones.get(random.nextInt(count));
                if (tempZone.treeFull() == false) {
                    Tree newTree = new Tree(tempZone);
                    tree.addOffspring(newTree);
                    tempZone.addOrg(newTree);
                    tree.setReproCount(0);
                    count = 0;
                }
                else {
                    adjZones.remove(tempZone);
                }
            }
        }
        else {
            tree.advCount();
        }
    }
    
    /**
     * A turn for a Deer object
     */
    private void deerTurn(Deer deer)
    {
        deer.healthMinus();
        deer.agePlus();
        if (deer.getHealth() == 0) {
            deer.kill();
        }
        else {
            Zone zone = deer.getZone();
            //Eat
            if (zone.grassTotal() > 0) {
                zone.killGrass();
                deer.healthPlus();
            }
            //Move
            ArrayList<Zone> adjZones = gameGrid.getAdjZones(zone.getCoordX(), zone.getCoordY());
            adjZones.add(zone);
            Zone tempZone = adjZones.get(0);
            for (Zone newZone : adjZones) {
                if (tempZone.grassTotal() > newZone.grassTotal()) {
                    tempZone = newZone;
                }
            }
            if (tempZone.grassTotal() == 0) {
                adjZones.remove(zone);
                deer.move(adjZones.get(random.nextInt(adjZones.size())));
            }
            else {
                deer.move(tempZone);
            }
            if (deer.canRepro() == true) {
                Deer newDeer = new Deer(zone);
                deer.addOffspring(newDeer);
                zone.addOrg(newDeer);
            }
        }
        
    }
    
    /**
     * Reset randomizer.
     */
    private void randReset() 
    {
        random.setSeed(666);
    }

}
