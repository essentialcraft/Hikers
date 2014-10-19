/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;
import model.Hiker;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Ian
 */
public class TrailList extends JPanel {
    
    private JLabel trailLabel;
    private JTextArea trailList;
    
    private JPanel hikerNamePanel;
    private LinkedList<JLabel> hikerLabels; 
    private int labelsCount = 0;
    
    private JScrollPane scroll;
    
    public TrailList(String trailName){
        trailLabel = new JLabel(trailName);
        trailList = new JTextArea();
        DefaultCaret caret = (DefaultCaret)trailList.getCaret();
        caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
        trailList.setLineWrap(true);
        trailList.setWrapStyleWord(true);
        
        
        hikerNamePanel = new JPanel(new MigLayout(
                "", // Layout Constraints
                "[]", // Column constraints
                "[][]")); // Row constraints)););
        hikerLabels = new LinkedList();
        scroll = new JScrollPane(hikerNamePanel);
        
        this.setLayout(new MigLayout(
                "debug, fill, ins 0", // Layout Constraints
                "[150]", // Column constraints
                "[][200]")); // Row constraints));

        
        this.add(trailLabel, "span");
        this.add(scroll, "grow");
    }
    
    public void addHiker(Hiker hiker){
        if(!checkForHiker(hiker)){
            hikerLabels.add(new JLabel(hiker.getHikerName())); 
            hikerNamePanel.add(hikerLabels.getLast(), "wrap");
            labelsCount++;
            this.revalidate();
            this.repaint();
        }
    }
    
//    public void removeHiker(Hiker hiker){
//        if(checkForHiker(hiker)){
//            Iterator<JLabel> labelIter = hikerLabels.iterator();
//        while(labelIter.hasNext()){
//            if(labelIter.next().getText() == hiker.getHikerName()){
//                labelIter.remove();
//            }
//            this.revalidate();
//            this.repaint();
//        }}
//    }
    
    public boolean checkForHiker(Hiker hiker){
        
        boolean found = false;
        Iterator<JLabel> labelIter = hikerLabels.iterator();
        while(labelIter.hasNext()){
            if(labelIter.next().getText().equals(hiker.getHikerName())){
                found = true;
            }
        }
        return found;
    }
}