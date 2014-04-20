import java.awt.*;
import javax.swing.*;
import java.util.HashMap;
import java.awt.event.*;

//import javax.swing.JButton;
//import javax.swing.JFrame;

public class EcosystemGUI extends JFrame 
{
    // Extends JFrame so it can create frames 
    private JButton startButton;
    private JButton exitButton;
    private JButton resetButton;
    private JButton fireButton;
    
    private SimDisplay display;
    private Container myPane;
    private JPanel buttonPad;
    private JPanel buttonPadPanel;
    private JPanel sim;
    
    public EcosystemGUI() 
    {

        this.setSize(750, 600);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Forest Game");

        startButton = new JButton("Start");
        resetButton = new JButton("Reset");
        exitButton = new JButton("Exit");
        fireButton = new JButton("Fire");
    
        display=new SimDisplay();
        myPane=getContentPane();
        myPane.setLayout(new BorderLayout());
    
        buttonPad=new JPanel();
        buttonPad.setLayout(new GridLayout(0, 1));
    
        //add buttons and button listeners
        buttonPad.add(startButton);   
        startButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) {startSim();}
        });
        buttonPad.add(resetButton);
        resetButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) {reset();}
        });
        buttonPad.add(fireButton);
        fireButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) {burn();}
        });
        buttonPad.add(exitButton);
        exitButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) {end();}
        });
        
        //put buttonPad into buttonPane so it doesnt stretch in length
        buttonPadPanel=new JPanel(new FlowLayout());
        buttonPadPanel.add(buttonPad);
        //put buttonPadPane into main pane
        myPane.add(buttonPadPanel, BorderLayout.EAST);
        myPane.add(display, BorderLayout.CENTER);
    
        this.setVisible(true);
    }

    private void startSim()
    {
        
    }
    
    private void burn()
    {
        
    }
    
    private void reset()
    {
        
    }
    
    private void end()
    {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
}
