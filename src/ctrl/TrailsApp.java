/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctrl;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.*;
import view.*;

/**
 *
 * @author Ian
 */
public class TrailsApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
            final MainFrame window = new MainFrame();
            final TrailModel model = new TrailModel();
            Controller controller = new Controller(window, model);
            
            //window.getList(1).setList("Jimmothy Tybottom");
        
        Thread thread = new Thread(){
            @Override
            public void run(){
                
                while(true){
                    model.generateHiker();
                    //set the most recent hiker to the waiting list
                    window.getWaitPanel().setList(model.getTempHiker().toString());
                try {
                    sleep(30);
                } catch (InterruptedException ex) {
                    ex.getMessage();
                }}
            }
        };
        thread.start();
        
    }
    
}
