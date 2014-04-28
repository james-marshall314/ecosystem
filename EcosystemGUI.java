import java.awt.*;
import javax.swing.*;
import java.util.HashMap;
import java.awt.event.*;

//import javax.swing.JButton;
//import javax.swing.JFrame;

/**
 * EcosystemGUI is the control module for the simulation.  It creates and manages Simulator and 
 * SimDisplay.  Is controlled by buttonpad.
 */
public class EcosystemGUI extends JFrame 
{

// Extends JFrame so it can create frames

    private JButton startButton;
    private JButton exitButton;
    private JButton resetButton;
    private JButton fireButton;
    
    private SimDisplay display;
    private Simulator sim;
    private Container myPane;
    private JPanel buttonPad;
    
    public EcosystemGUI() 
    {

    this.setSize(550, 490);
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Forest Game");

    buttonPad=makeButtonPad();
    display=new SimDisplay();
    
    sim=new Simulator();
    myPane=getContentPane();
    myPane.setLayout(new BorderLayout());

    //put buttonPad, simDisplay into main pane
    myPane.add(buttonPad, BorderLayout.EAST);
    myPane.add(display, BorderLayout.CENTER);
    
    this.setVisible(true);
}
   
 
 /**
  * MakeButtonPad creates a buttonpad, a panel to contain it, and sets action listeners
  * @return - a buttonPad Jpanel
  */
    private JPanel makeButtonPad()
    {
        //class-level variables
        startButton = new JButton("Start");
        resetButton = new JButton("Reset");
        exitButton = new JButton("Exit");
        fireButton = new JButton("Fire");
        
        JPanel buttons=new JPanel();
        buttons.setLayout(new GridLayout(0, 1));
        //put buttonPad into buttonPane so it doesnt stretch in length
        JPanel buttonPadPanel=new JPanel(new FlowLayout());
        buttonPadPanel.add(buttons);
        
        //add buttons and button listeners
        buttons.add(startButton);   
            startButton.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) {startSim();}
            });
        buttons.add(resetButton);
            resetButton.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) {reset();}
            });
        buttons.add(fireButton);
            fireButton.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) {burn();}
            });
        buttons.add(exitButton);
            exitButton.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) {end();}
            });
            
        return buttonPadPanel;
    }
    private void startSim()
    {
        
        
    }
    
    private void burn()
    {
        
    }
    
    private void reset()
    {
        display.clearSim();
        
    }
    
    private void end()
    {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
}
