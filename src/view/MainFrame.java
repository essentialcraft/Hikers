/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Ian
 */
public class MainFrame {
    
    private JFrame frame;
    private JPanel mainPanel;
    
    private TrailMap map;
    private HikersWaiting waitList;
    private TrailControls controls;
    private TrailList trailOne, trailTwo, trailThree, trailFour;
    
    public MainFrame(){
        frame = new JFrame();
        mainPanel = new JPanel(new BorderLayout());
        
        map = new TrailMap();
        waitList= new HikersWaiting();
        controls = new TrailControls();
        trailOne = new TrailList("Trail One");
        trailTwo = new TrailList("Trail Two");
        trailThree = new TrailList("Trail Three");
        trailFour = new TrailList("Trail Four");
        
        waitList.setPreferredSize(new Dimension(100, 600));
        map.setPreferredSize(new Dimension(500,500));
        //mainPanel.add(controls, BorderLayout.CENTER);
        
        mainPanel.add(waitList, BorderLayout.WEST);
        mainPanel.add(map, BorderLayout.EAST);
        //mainPanel.add(map, BorderLayout.CENTER);
        
        frame.add(mainPanel);
        
        
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
    }
    
}
