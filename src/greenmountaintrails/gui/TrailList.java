/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenmountaintrails.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Ian
 */
public class TrailList extends JPanel {
    
    private JLabel trailLabel;
    private JTextArea trailList;
    
    public TrailList(String trailName){
        trailLabel = new JLabel(trailName);
        trailList = new JTextArea();
    }
    
}
