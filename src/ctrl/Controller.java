/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctrl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    
    
        
    public void addNamesToTrail(int trailChoice){
        //window.getTrailsPanel(1).setNamesToList(model.getTrailController().getTrailOne().);
        //Trail trail = model.getTrailController().getTrail();
        Trail trail = (TrailOne)model.getTrailController().getTrail(1);
        //window.getTrailPanel(1).clearList();
        
        if(trail.getTrailQueue().size() > 0){
            for(int i = 0; i < trail.getTrailQueue().size(); i++){
                HikerStack temp = trail.getTrailQueue().poll();
                System.out.println(temp.printNames());
                for(int j = 0; j < temp.size();j++){
                    window.getTrailPanel(1).addHiker(temp.pop());
                    
                }
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
