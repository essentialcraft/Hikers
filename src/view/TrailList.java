/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import model.Hiker;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Ian
 */
public class TrailList extends JPanel {
    
    private JLabel trailLabel;
    
    //panel to be used for JScroll
    private JPanel hikerNamePanel;
    
    //this list is added to the GUI to represent hikers on the trial
    //used LL so it can grow and shrink
    private LinkedList<JLabel> hikerLabels; 
    private int labelsCount = 0;
    
    private JScrollPane scroll;
    
    public TrailList(String trailName){
        trailLabel = new JLabel(trailName);
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
    
    //add a hiker to the panel and repaint
    public void addHiker(Hiker hiker){
        if(!checkForHiker(hiker)){
            hikerLabels.add(new JLabel(hiker.getHikerName())); 
            hikerNamePanel.add(hikerLabels.getLast(), "wrap");
            labelsCount++;
            this.revalidate();
            this.repaint();
        }
    }
    public void timeToRemoveHiker(int i){
        hikerNamePanel.remove(hikerLabels.removeFirst());
        //hikerLabels.remove(i);
        this.revalidate();
        this.repaint();
    }
    
    //PROBABLY DOESN'T WORK, USE TO REMOVE HIKERS FROM TRAIL DISPLAY
    //FOR WORKING VERSION OF ALGORITHM CHECK updateWaitListWindow() in HikersWaiting
    public void removeHiker(Hiker hiker){
        if(checkForHiker(hiker)){
            Iterator<JLabel> labelIter = hikerLabels.iterator();
        while(labelIter.hasNext()){
            if(labelIter.next().getText() == hiker.getHikerName()){
                labelIter.remove();
            }
            this.revalidate();
            this.repaint();
        }}
    }
    
    //checks for an incoming hiker over hikers aleady on the trial
    //used for removal of hikers (unimplemented)
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