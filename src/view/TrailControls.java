/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Ian
 */
public class TrailControls extends JPanel {
    
    private JButton addHikerBtn;
    private JButton time1X, time2X, time3X;
    
    private JLabel timeLabel;
    
    public TrailControls(){
        addHikerBtn = new JButton("Add Hiker");
        
        timeLabel = new JLabel("0700");
        time1X = new JButton("1X");
        time2X = new JButton("2X");
        time3X = new JButton("3X");
        
        setLayout(new MigLayout(
                "", // Layout Constraints
                "[]push[][][][]", // Column constraints
                "")); // Row constraints));)
        
        add(addHikerBtn);
        
        add(timeLabel);
        add(time1X);
        add(time2X);
        add(time3X);
    }
    
}
