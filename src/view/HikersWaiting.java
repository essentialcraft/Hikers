/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    
    LinkedList<Hiker> hikerList;
    
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
        if(!checkForHiker(hiker)){
            hikerLabels.add(new JLabel(hiker.getHikerName())); 
            //hikerLabels.add(new JLabel(String.valueOf(labelsCount) + ' ' + hiker.getHikerName())); 
            hikerNamePanel.add(hikerLabels.getLast(), "wrap");
            labelsCount++;
            this.revalidate();
            this.repaint();
        }
    }
    
    
    
    public void updateWaitListWindow(LinkedList<Hiker> hikersWaiting){
        //ListIterator<Hiker> hikerIt = hikersWaiting.listIterator();
        Iterator<JLabel> labelIter = hikerLabels.iterator();
        
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