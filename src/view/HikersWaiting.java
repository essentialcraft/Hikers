/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.LinkedList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;
import model.ArrayQueue;
import model.Hiker;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Ian
 */
public class HikersWaiting extends JPanel {
    
    private JLabel waitLabel;
    private JTextArea waitList;
    
    private JScrollPane scroll;
    
    private JPanel hikerNamePanel;
    private LinkedList<JLabel> hikerLabels; 
    private int labelsCount = 0;
    
    public HikersWaiting(){
        hikerLabels = new LinkedList();
        waitLabel = new JLabel("Hikers Waiting");
        waitList = new JTextArea();
        
        hikerNamePanel = new JPanel(new MigLayout(
                "", // Layout Constraints
                "[]", // Column constraints
                "[][]")); // Row constraints)););
        
        DefaultCaret caret = (DefaultCaret)waitList.getCaret();
        caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
        waitList.setLineWrap(true);
        waitList.setWrapStyleWord(true);
        scroll = new JScrollPane(hikerNamePanel);
        this.setLayout(new MigLayout(
                "fill", // Layout Constraints
                "[200]", // Column constraints
                "[][grow]")); // Row constraints));
        
        
        this.add(waitLabel, "wrap");
        this.add(scroll, "grow");
        //this.add(scroll, "grow");
        
        
    }
    
    public void setList(String in) {
        waitList.insert(in + "\n", 0);
    }
    
    public JTextArea getWaitList(){
        return waitList;
    }
    
    public void addHiker(Hiker hiker){
        hikerLabels.add(new JLabel(hiker.getHikerName())); 
        hikerNamePanel.add(hikerLabels.getLast(), "wrap");
        labelsCount++;
        this.revalidate();
        this.repaint();

        //frame.pack();
    }
    
}
