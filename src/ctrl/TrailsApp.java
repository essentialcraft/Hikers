/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctrl;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JOptionPane;
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
        
        Thread thread = new Thread(){
            //time_speed is how often the thread should sleep for
            //can be changed by buttons on gui
            int TIME_SPEED = 500;
            //variables that will keep track of our own 'time'
            NumberFormat formatter = new DecimalFormat("00");
            int hours = 07;
            int minutes = 00;
            //String time will appear like a clock
            String time;
            
            
            @Override
            public void run(){
                
                
                
                while(true){
                    /*
                     * Each time the thread wakes up it adds '1' to the minutes
                     * variable and checks for 59 minutes. upon reaching 60
                     * minutes the hours variables increments to simulate a clock
                     */
                    
                    time = formatter.format(hours) + ":" + formatter.format(minutes);
                    System.out.println(time);
                    minutes++;
                    if(minutes > 59){
                        minutes = 00;
                        hours++;
                    }
                    if(hours >= 10){
                        if(formatter.format(hours).equalsIgnoreCase("10") && formatter.format(minutes).equalsIgnoreCase("00")){
                                Thread realeaseHikersThread = new Thread(){
                                    @Override
                                    public void run(){
                                        while(true){
                                            /*
                                             * method that checks if a trail
                                             * has a full queue. If true, deletes
                                             * top 20 hikers from that trails que
                                             */
                                            for(int i = 0; i < 4; i++){
                                                controller.removeNamesFromTrail(i);
                                            }
                                            SwingUtilities.invokeLater(new Runnable(){
                                                public void run(){
                                                    controller.updateGUI();
                                                }
                                            });
                                            try{
                                                sleep(5000);
                                            }catch(InterruptedException ex){
                                            ex.getMessage();
                                            }
                                        }
                                    }
                                };
                                
                            realeaseHikersThread.start();
                        }
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
                    sleep(TIME_SPEED);
                } catch (InterruptedException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }}
            }
        };
        thread.start();
        
    }
    
}
