/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenmountaintrails.gui;

import javax.swing.JFrame;

/**
 *
 * @author Ian
 */
public class MainFrame {
    
    private JFrame frame;
    
    private TrailMap map;
    private HikersWaiting waitList;
    private TrailControls controls;
    private TrailList trailOne, trailTwo, trailThree, trailFour;
    

    
    
    
    
    
    
    public MainFrame(){
        frame = new JFrame();
        
        map = new TrailMap();
        waitList= new HikersWaiting();
        controls = new TrailControls();
        trailOne = new TrailList("Trail One");
        trailTwo = new TrailList("Trail Two");
        trailThree = new TrailList("Trail Three");
        trailFour = new TrailList("Trail Four");
        
        frame.add(map);
        frame.add(waitList);
        frame.add(controls);
        frame.add(trailOne);
        frame.add(trailTwo);
        frame.add(trailThree);
        frame.add(trailFour);
        
        build();
    }
    
    
    
    
    
    
    
    public void build() {
        //Display a title
        frame.setTitle("Buy Sell Make Money All Day!");

        //setUndecorated(true);
        //Specify an action on close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        //this.setLayout());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.pack();
        //setContentPane(mainPanel);
    }
    
}
