/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctrl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.ListIterator;
import javax.swing.JOptionPane;
import model.*;
import view.*;

/**
 *
 * @author Ian
 */
public class Controller {

    
    
    //The two classes the controller will....control    
    MainFrame window;
    TrailModel model;
    
    public Controller(MainFrame window, TrailModel model){
        this.window = window;
        this.model = model;
        
        this.window.addListener(new SubmitListener());
        
        //window.getWaitPanel();
    }
    
    //update all the necessary panels
    public void updateGUI( ){
        this.window.getWaitPanel().addHiker(model.getHikersWaiting().getLast());
        this.window.getWaitPanel().updateWaitListWindow(model.getHikersWaiting());
        for(int i = 0; i < 4; i++){
            this.addNamesToTrail(i);
        }
//        if(isItTime){
//            for(int i = 0; i<4; i++){
//                this.removeNamesFromTrail(i);
//            }
//        }
    }
    
    //will add a list of assigned names to their appropriate display on the GUI
    public void addNamesToTrail(int trailChoice){
        Trail trail = model.getTrailController().getTrail(trailChoice);
        Hiker temp = null;
        if(!trail.getHikersOnMountain().isEmpty()){
            Iterator<Hiker> i = trail.getHikersOnMountain().iterator();
            while (i.hasNext()) {
                temp = i.next();
                if(temp != null){
                    
                    window.getTrailPanel(trailChoice).addHiker(temp);
                }
            }
        }
}
    
    //will remove names from trail ...only called in the 10am thread
    public void removeNamesFromTrail(int trailChoice){
       Trail trail = model.getTrailController().getTrail(trailChoice);
       
       //first check if a trail has minimum 20 hikers
       //if so then remove 20 hikers
       
       //remove names from jlabels also remove names from logic lists
       int x = 0;
       if(trail.getHikersOnMountain().size() >= 10){
           Iterator<Hiker> i = trail.getHikersOnMountain().iterator();
           while(i.hasNext() && x < 10){
               window.getTrailPanel(trailChoice).timeToRemoveHiker(x);
               //model.getHikersWaiting().remove(x);
               
               Hiker temp = i.next();
               i.remove();
               x++;
           }
       }
}
    
    
    //main flow of methods
    public class SubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
        
        }
    
    
    }
    
}
