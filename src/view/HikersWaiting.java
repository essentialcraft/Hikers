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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Ian
 */
public class HikersWaiting extends JPanel {
    
    private JLabel waitLabel;
    private JTextArea waitList;
    private JScrollPane scroll;
    
    public HikersWaiting(){
        waitLabel = new JLabel("Hikers Waiting");
        waitList = new JTextArea();
        DefaultCaret caret = (DefaultCaret)waitList.getCaret();
        caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
        waitList.setLineWrap(true);
        waitList.setWrapStyleWord(true);
        scroll = new JScrollPane(waitList);
        this.setLayout(new MigLayout(
                "", // Layout Constraints
                "[200]", // Column constraints
                "[][500]")); // Row constraints));
        
        
        this.add(waitLabel, "wrap");
        this.add(scroll, "grow");
        
        
    }
    
    public void setList(String in) {
        waitList.insert(in + "\n", 0);
    }
    
    public JTextArea getWaitList(){
        return waitList;
    }
    
}
