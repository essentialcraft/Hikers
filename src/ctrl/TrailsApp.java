/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctrl;
import java.util.Iterator;
import javax.swing.SwingUtilities;
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
            final Controller controller = new Controller(window, model);
        
            int it = 0;
            final boolean bool = true;
        Thread thread = new Thread(){
            int it = 0;
            boolean bool = true;
            @Override
            public void run(){
                while(bool){
                    
                    //run the loop only one hundred times
                    it++;
                    if(it == 100){ 
                        bool = false;
                    }
                    
                    //create a new hiker
                    model.generateHiker();
                    
                    //update the GUI
                    SwingUtilities.invokeLater(new Runnable(){
                      public void run(){
                          controller.updateGUI();
                      }
                    });
                try {
                    sleep(100);
                } catch (InterruptedException ex) {
                    ex.getMessage();
                }}
            }
        };
        thread.start();
        
    }
    
}
