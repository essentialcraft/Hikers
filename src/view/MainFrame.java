/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Ian
 */
public class MainFrame {
    
    private JFrame frame;
    private JPanel mainPanel, trailsPanel;
    
    private TrailMap map;
    private HikersWaiting waitList;
    private TrailControls controls;
    private TrailList trails[];
    private String names[] = {"Easy Trail",
        "Antonio Banderas Trail",
        "Death Trail",
        "Soft kittens trail"
    };
    
    
    
    public MainFrame(){
        frame = new JFrame();       
        
        mainPanel = new JPanel(new MigLayout(
                "fill", // Layout Constraints
                "", // Column constraints
                "")); // Row constraints
        frame.add(mainPanel);
        map = new TrailMap();
        waitList= new HikersWaiting();
        controls = new TrailControls();
        
        trailsPanel = new JPanel(new MigLayout(
                "debug, fill, ins 0", // Layout Constraints
                "", // Column constraints
                "")); // Row constraints);
        
        
        
        trails = new TrailList[4];
        //trailsPanel.add(trails[0] = new TrailList(names[0]));
        for(int i = 0; i < trails.length; i++){
            trailsPanel.add(trails[i] = new TrailList(names[i]));
        }
        
        
        mainPanel.add(waitList, "dock west");
        mainPanel.add(map, "wrap");
        mainPanel.add(controls, "grow, wrap");
        mainPanel.add(trailsPanel, "grow");
        
        
        
        
        
        this.build();
    }
    
    public void build() {
        //Display a title
        frame.setTitle("Green Mountain Trails Software");

        //frame.setSize(1000, 800);
        //setUndecorated(true);
        //Specify an action on close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        //this.setLayout());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.pack();
        frame.setContentPane(mainPanel);
        frame.setLocationRelativeTo(null);
    }
    
//    public TrailList getList(int i){
//        return trails[i];
//    }
    
    public void addListener(ActionListener listen) {
        
        
    }
    
    public HikersWaiting getWaitPanel(){
        return waitList;
    }
    
    public TrailList getTrailPanel(int trailChoice){
        return trails[trailChoice];
    }
}
