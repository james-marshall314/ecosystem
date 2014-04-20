import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;

/**
 * An ImagePanel is a Swing component that can display an OFImage.
 * It is constructed as a subclass of JComponent with the added functionality
 * of setting an OFImage that will be displayed on the surface of this
 * component.
 * 
 * @author Michael Kölling and David J. Barnes.
 * @version 1.0
 */
public class SimDisplay extends Canvas
{
    // The current width and height of this panel
    private int width, height;
    private Canvas myCanvas;
    
    private JFrame frame;
    private Graphics2D curGraphic;
    private Color backgroundColor;
    private Image canvasImage;
    
    // An internal image buffer that is used for painting. For
    // actual display, this image buffer is then copied to screen.
    

    /**
     * Create a new, empty SimDisplay
     */
    public void SimDisplay(JFrame myFrame)
    {
        width = 600;    // size for sim display
        height = 600;
        frame=myFrame;
        myCanvas = new Canvas();
        myCanvas.setVisible(true);
        canvasImage=null;
    }

    /**
     * Display current state of grid.
     * @param:  gameGrid (which is a HashMap<String, Zone>)
     */
    public void showSim(HashMap<String, Zone> gameGrid)
    {
        for (int i=0; i<12; ++i)
        {
            for (int j=0; j<12; ++j)
            {
                Zone curZone=gameGrid.get(Integer.toString(i)+","+Integer.toString(j));
                showZone(curZone);
            }
        }
    }
    
    /**
     * Clear the image on this panel.
     */
    public void clearSim()
    {
          //super.//clears the canvas
    }
    
    // The following methods are redefinitions of methods
    // inherited from superclasses.
    
    /**
     * Tell the layout manager how big we would like to be.
     * (This method gets called by layout managers for placing
     * the components.)
     * 
     * @return The preferred dimension for this component.
     */
    public Dimension getPreferredSize()
    {
        return new Dimension(width, height);
    }
    
    /**
     * This component needs to be redisplayed. Copy the internal image 
     * to screen. (This method gets called by the Swing screen painter 
     * every time it want this component displayed.)
     * 
     * @param g The graphics context that can be used to draw on this component.
     */
    public void showZone(Zone myZone)
    {
        
    }
}
