/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenmountaintrails.gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Ian
 */
public class TrailControls extends JPanel {
    
    private JButton addHiker;
    private JButton time1X, time2X, time3X;
    
    private JLabel timeLabel;
    
    public TrailControls(){
        addHiker = new JButton("Add Hiker");
        
        time1X = new JButton("1X");
        time2X = new JButton("2X");
        time3X = new JButton("3X");
        
        this.add(addHiker);
        this.add(time1X);
        this.add(time2X);
        this.add(time3X);
    }
    
}
