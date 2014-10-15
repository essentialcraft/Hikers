/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Ian
 */
public class HikersWaiting extends JPanel {
    
    private JLabel waitLabel;
    private JTextArea waitList;
    
    public HikersWaiting(){
        waitLabel = new JLabel("Hikers Waiting");
        waitList = new JTextArea();
        
        this.setLayout(new MigLayout(
                "", // Layout Constraints
                "[200]", // Column constraints
                "[][grow]")); // Row constraints));
        
        
        this.add(waitLabel, "wrap");
        this.add(waitList, "grow");
        
        
    }
    
}
