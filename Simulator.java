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
    private int fireChance;
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
        fireChance = 25;
    }
    
    /**
     * Prepare the simulation:
     * 
     * Populate the grid and set the fireChance
     * 
     * @params ints representing number of grass, tree, and deer. Max 300 each, min 1.
     * 
     * @return false if any of the params are more than 300 or less than 1.
     */
    public boolean prepSim(int grass, int trees, int deer, int fireChance)
    {
        //set fireChance
        this.fireChance = fireChance;
        //Check params
        if (grass + trees > 1440) {
            return false;
        }
        else {
            //Add grass
            int grassCount = grass;
            while (grassCount > 0) {
                int x = 0;
                while (x == 0) {
                    Zone randZone = getRandomZone();
                    if (randZone.plantFull() != true) {
                        Grass newGrass = new Grass(randZone);
                        organisms.add(newGrass);
                        newGrass.setReproCount(random.nextInt(3));
                        x++;
                    }
                }
                grassCount--;
            }
            //Add trees
            int treeCount = trees;
            while (treeCount > 0) {
                int x = 0;
                while (x == 0) {
                    Zone randZone = getRandomZone();
                    if (randZone.plantFull() != true) {
                        Tree newTree = new Tree(randZone);
                        organisms.add(newTree);
                        newTree.setReproCount(random.nextInt(3));
                        x++;
                    }
                }
                treeCount--;
            }
            //Add Deer
            int deerCount = deer;
            while (deerCount > 0) {
                Zone randZone = getRandomZone();
                Deer newDeer = new Deer(randZone);
                organisms.add(newDeer);
                newDeer.setAge(random.nextInt(5));
                deerCount--;
            }
            return true;
        }
    }

    /**
     * Runs through a single turn of the simulation. 
     */
    public void runSim()
    {
        //Clear out any dead organisms
        clearDead();
        //All Grass take turn
        for (Organism org : organisms) {
            if (org instanceof Grass) {
                grassTurn((Grass)org);
            }
        }
        //All Tree take turn
        for (Organism org : organisms) {
            if (org instanceof Tree) {
                treeTurn((Tree)org);
            }
        }
        //All Deer take turn
        for (Organism org : organisms) {
            if (org instanceof Deer) {
                deerTurn((Deer)org);
            }
        }
        //Add all offspring created in this round.
        ArrayList<Organism> newOrgs = new ArrayList<Organism>();
        for (Organism org : organisms) {
            newOrgs.addAll(org.getOffspring());
            org.clearOffspring();
        }
        organisms.addAll(newOrgs);
        //fire turn
        fireTurn();
        //Advance turns
        turns++;
    }
    
    /**
     * TEST METHOD
     */
    public void printZoneTotals()
    {
        ArrayList<Zone> zones = gameGrid.getZones();
        for (Zone zone : zones) {
            System.out.println(zone.getX()+","+zone.getY()+" | "+zone.grassTotal());
        }
    }
    
    /**
     * TEST METHOD
     * print adj zones.
     */
    public void printAdjZones()
    {
        ArrayList<Zone> zones = gameGrid.getZones();
        for (Zone zone : zones) {
            ArrayList<String> zoneCoords = new ArrayList<String>();
            ArrayList<Zone> adjZones = gameGrid.getAdjZones(zone.getX(), zone.getY());
            for (Zone adjZone : adjZones) {
                zoneCoords.add(" [" + Integer.toString(adjZone.getX())+","+Integer.toString(adjZone.getY())+"]");
            }
            System.out.println(zone.getX() + "," + zone.getY() + " : " + adjZones.size() + " : " + zoneCoords);
        }
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
                        grass.setReproCount(0);
                        count = 0;
                    }
                    else {
                        adjZones.remove(tempZone);
                        count = adjZones.size();
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
                        tree.setReproCount(0);
                        count = 0;
                    }
                    else {
                        adjZones.remove(tempZone);
                        count = adjZones.size();
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
                if (tempZone.grassTotal() < newZone.grassTotal()) {
                    tempZone = newZone;
                }
            }
            if (tempZone.grassTotal() == 0) {
                deer.move(adjZones.get(random.nextInt(adjZones.size())));
            }
            else {
                deer.move(tempZone);
            }
            if (deer.canRepro() == true) {
                Deer newDeer = new Deer(zone);
                deer.addOffspring(newDeer);
            }
        }
        
    }
    
    /**
     * A fire turn. sets fires, selects organisms to be killed, extinguishes fires. 
     */
    private void fireTurn()
    {
        setFire();
        for (Organism org : organisms) {
            boolean burned = didBurn(org); 
            boolean fire = org.getZone().getFireStatus();
            if (fire == true && burned == true) {
                org.kill();
            }
        }
        fireOut();
    }
     
    
    /**
     * Randomly set fire to zones. 
     */
    private void setFire()
    {
        ArrayList<Zone> zones = gameGrid.getZones();
        for (Zone zone : zones) {
            boolean fire = isFire();
            if (fire == true) {
                zone.setFireStatus(true);
            }
        }
    }
    
    /**
     * Extinguish all fires.
     */
    private void fireOut()
    {
        ArrayList<Zone> zones = gameGrid.getZones();
        for (Zone zone : zones) {
            zone.setFireStatus(false);
        }
    }
    
    /**
     * Will there be a fire?
     * 
     * @return a boolean, true if there is a fire, false if not. 
     */
    private boolean isFire()
    {
        // % chance of a fire
        int fireChance = this.fireChance;
        if (random.nextInt(100) < fireChance) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Does an organism die if there is a fire? 
     * 
     * @return true if killed.
     */
    private boolean didBurn(Organism org)
    {
        int burnChance;
        boolean didBurn = false;
        if (org instanceof Grass) {
            burnChance = 75;
            if (random.nextInt(100) < burnChance) {
                didBurn = true;
            }
            else {
                didBurn = false;
            }
        }
        if (org instanceof Tree) {
            burnChance = 60;
            if (random.nextInt(100) < burnChance) {
                didBurn = true;
            }
            else {
                didBurn = false;
            }
        }
        return didBurn;
    }
    
    /**
     * Clear out the dead.
     */
    private void clearDead()
    {
        Iterator<Organism> itr = organisms.iterator();
        while(itr.hasNext()) {
            Organism org = itr.next();
            if (org.isAlive() == false) {
                itr.remove();
            }
        }
    }
    
    /**
     * Get a random Zone.
     */
    private Zone getRandomZone()
    {
        ArrayList<Zone> zones = gameGrid.getZones();
        Zone randZone = zones.get(random.nextInt(144));
        return randZone;
    }
    
    /**
     * Reset randomizer.
     */
    private void randReset() 
    {
        random.setSeed(666);
    }

}
