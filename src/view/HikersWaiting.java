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
        
        this.setLayout(new BorderLayout());
        
        
        this.add(waitLabel, BorderLayout.NORTH);
        this.add(waitList, BorderLayout.SOUTH);
        
        
    }
    
}
