/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Component;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import model.Hiker;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Ian
 */
public class HikersWaiting extends JPanel {
    
    private JLabel waitLabel;
    
    
    private JScrollPane scroll;
    
    private JPanel hikerNamePanel;
    private LinkedList<JLabel> hikerLabels; 
    private int labelsCount = 0;
    
    LinkedList<Hiker> hikerList;
    
    public HikersWaiting(){
        hikerLabels = new LinkedList();
        waitLabel = new JLabel("Hikers Waiting");
        
        
        hikerNamePanel = new JPanel(new MigLayout(
                "", // Layout Constraints
                "[]", // Column constraints
                "[][]")); // Row constraints)););
        
        scroll = new JScrollPane(hikerNamePanel);
        this.setLayout(new MigLayout(
                "fill", // Layout Constraints
                "[200]", // Column constraints
                "[][grow]")); // Row constraints));

        this.add(waitLabel, "wrap");
        this.add(scroll, "grow");
    }
    
    //add a hiker to the waiting list panel
    public void addHiker(Hiker hiker){
        //check if the given hiker is on the panel
        if(!checkForHiker(hiker)){
            hikerLabels.add(new JLabel(hiker.getHikerName()));
            //get newly created JPanel and add it
            hikerNamePanel.add(hikerLabels.getLast(), "wrap");
            labelsCount++;
            this.revalidate();
            this.repaint();
        }
    }
    
    
    //this will check the waitlist from the model against the hikers
    //listed as waiting on the GUI, and remove hikers no longer waiting
    public void updateWaitListWindow(LinkedList<Hiker> hikersWaiting){
        //to iterate through current labels
        Iterator<JLabel> labelIter = hikerLabels.iterator();
        
        //if a label doesn't belong remove it
        while(labelIter.hasNext()){
            JLabel temp = labelIter.next();
            if(!checkList(hikersWaiting, temp.getText())){
                for(Component c : hikerNamePanel.getComponents()){
                    if(temp.getText().equals(((JLabel)c).getText())){
                        hikerNamePanel.remove(c);
                        this.revalidate();
                        this.repaint();
                    }
                }
            }
        }
    }
    
    //check a given list against a String, used by update()
    public boolean checkList(LinkedList<Hiker> hikersWaiting, String hikerMatch){
        boolean found = false;
        ListIterator<Hiker> waitIter = hikersWaiting.listIterator();
        
        while(waitIter.hasNext()){
            if(waitIter.next().getHikerName().equals(hikerMatch)){
                found = true;
            }
        }
        return found;
    }
    
    
    
    
    
    
//    public void updateWaitListWindow(LinkedList<Hiker> hikersWaiting){
//        ListIterator<Hiker> hikerIt = hikersWaiting.listIterator();
//        
//        while(hikerIt.hasNext()){
//            Hiker temp = hikerIt.next();
//            if(checkForHiker(temp)){
//                for(Component c : hikerNamePanel.getComponents()){
//                    if(temp.getHikerName().equals(((JLabel)c).getText())){
//                        System.out.println("Match");
//                        System.out.println(temp.getHikerName());
//                        System.out.println(((JLabel)c).getText());
//                        hikerNamePanel.remove(c);
//                        this.revalidate();
//                        this.repaint();
//                    }
//                }
//            }
//        }
//    }
    
    public void removeHiker(Hiker hiker){
        
        
        
        
    }
    
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
    
        





//        while(waitListIter.hasNext()){
//            Hiker temp = waitListIter.next();
//            for (Component c : hikerNamePanel.getComponents()) {
//                if(((JLabel)c).getText() == temp.getHikerName()){
//                    
//                    //JOptionPane.showMessageDialog(null, ((JLabel)c).getText() + temp.getHikerName());
//                    
//                    ((JLabel)c).remove(c);
//                    hikerNamePanel.revalidate();
//                    hikerNamePanel.repaint();
//                }
//            }






//            if(checkForHiker(temp)){
//                while(labelIter.hasNext()){
//                    JLabel tempLabel = labelIter.next();
//                    if(tempLabel.getText() == temp.getHikerName()){
//                        labelIter.remove();
//                        for (Component c : hikerNamePanel.getComponents()) {
//                            if(((JLabel)c).getText() == tempLabel.getText()){
//                                ((JLabel)c).remove(c);
//                                hikerNamePanel.revalidate();
//                                hikerNamePanel.repaint();
//                            }
//                        }
//                        
//                        
//                    }
//                }
//            }
            
            
      //  }

//        if(checkForHiker(hiker)){
//            Iterator<JLabel> labelIter = hikerLabels.iterator();
//        
//            while(labelIter.hasNext()){
//                if(labelIter.next().getText() == hiker.getHikerName()){
//                    labelIter.remove();
//                }
//            this.revalidate();
//            this.repaint();
//            }
//        }
    //}
    
    
}