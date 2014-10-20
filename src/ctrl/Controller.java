/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctrl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ListIterator;
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
        
        if(!trail.getHikersOnMountain().isEmpty()){
            ListIterator<Hiker> i = trail.getHikersOnMountain().listIterator();
            while (i.hasNext()) {
                window.getTrailPanel(trailChoice).addHiker(i.next());
	        }
        }
}
    
    //will remove names from trail ...only called in the 10am thread
    public void removeNamesFromTrail(int trailChoice){
       Trail trail = model.getTrailController().getTrail(trailChoice);
       
       //first check if a trail has minimum 20 hikers
       //if so then remove 20 hikers
       
       //remove names from jlabels also remove names from logic lists
       if(trail.getHikersOnMountain().size() >= 20){
           int x = 19;
           ListIterator<Hiker> i = trail.getHikersOnMountain().listIterator();
           while(i.hasNext() && x >= 0){
               window.getTrailPanel(trailChoice).timeToRemoveHiker(x);
               model.getTrailController().getTrail(trailChoice).getHikersOnMountain().removeFirst();
               x--;
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
