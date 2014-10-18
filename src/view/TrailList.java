/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

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
public class TrailList extends JPanel {
    
    private JLabel trailLabel;
    private JTextArea trailList;
    private JScrollPane scroll;
    
    public TrailList(String trailName){
        trailLabel = new JLabel(trailName);
        trailList = new JTextArea();
        DefaultCaret caret = (DefaultCaret)trailList.getCaret();
        caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
        trailList.setLineWrap(true);
        trailList.setWrapStyleWord(true);
        scroll = new JScrollPane(trailList);
        
        this.setLayout(new MigLayout(
                "debug, fill, ins 0", // Layout Constraints
                "[150]", // Column constraints
                "[][200]")); // Row constraints));

        
        this.add(trailLabel, "span");
        this.add(scroll, "grow");
    }
    
    public void setNamesToList(String in) {
        trailList.insert(in + "\n", 0);
    }
    
    public void clearList(){
        trailList.setText("");
    }
}
