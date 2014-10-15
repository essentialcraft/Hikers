/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctrl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        
        //window.getWaitList();
    }
        
    //main flow of methods
    public class SubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            
            
            
         
            
            
        }
    
    
    }
    
}
