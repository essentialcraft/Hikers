/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctrl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.ListIterator;
import javax.swing.JOptionPane;
import model.*;
import view.*;

/**
 *
 * @author Ian
 */
public class Controller {

    
    // TODO code application logic here
        
    MainFrame window;
    TrailModel model;
    
    public Controller(MainFrame window, TrailModel model){
        this.window = window;
        this.model = model;
        
        this.window.addListener(new SubmitListener());
        
        //window.getWaitPanel();
    }
    
    public void updateGUI(){
        for(int i = 0; i < 4; i++){
            addNamesToTrail(i);
        }
        
        
        
    }
    
    
        
    public void addNamesToTrail(int trailChoice){
        Trail trail = model.getTrailController().getTrail(trailChoice);
      
        if(!trail.getHikersOnMountain().isEmpty()){
            ListIterator<Hiker> i = trail.getHikersOnMountain().listIterator();
            System.out.println(i.next().getHikerName());
            while (i.hasNext()) {
	            window.getTrailPanel(trailChoice).addHiker(i.next());
	        }
        }



//window.getTrailPanel(trailChoice).setNamesToList();
        
    }





//main flow of methods
    public class SubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
        
        }
    
    
    }
    
}
