/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctrl;
import static java.lang.Thread.sleep;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.SwingUtilities;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import model.*;
import view.*;

/**
 *
 * @author Ian
 */
public class TrailsApp {
    private static Thread threadOne, threadTwo;
    //time_speed is how often the thread should sleep for
    //can be changed by buttons on gui
    static int TIME_SPEED = 100;
    //variables that will keep track of our own 'time'
    static NumberFormat formatter = new DecimalFormat("00");
    static int hours = 07;
    static int minutes = 00;
    //String time will appear like a clock
    static String time;
    
    final static MainFrame window = new MainFrame();
    final static TrailModel model = new TrailModel();
    final static Controller controller = new Controller(window, model);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
//            final MainFrame window = new MainFrame();
//            final TrailModel model = new TrailModel();
//            final Controller controller = new Controller(window, model);
        
        threadTwo = new Thread(){
                @Override
                public void run(){
                    while(true){
                        time = formatter.format(hours) + ":" + formatter.format(minutes);
                        System.out.println(time);
                        minutes++;
                        if(minutes > 59){
                            minutes = 00;
                            hours++;
                        }
                        //JOptionPane.showMessageDialog(null, controller.model.getTrailController().getTrail(1).getHikersOnMountain().size());

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

                        /*
                         * Checking for the leftover hikers
                         * in hikers waiting
                         */
//                        if(controller.window.getWaitPanel().areThereStraglers()){
//                            for(int i =0; i < 4; i++){
//
//                            }
//                        }
                        try{
                            //thread sleeps for 5 seconds to simulate hikers taking
                            //that long to go up the mountain
                            sleep(1000);
                        }catch(InterruptedException ex){
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                }
            };
        
         threadOne = new Thread(){
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
                    if(hours == 10){
                        Thread.currentThread().interrupt();
                        threadTwo.start();
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
                    ex.getMessage();
                }}
            }
        };
         
         threadOne.start();
//         class hopeThisWorks extends TimerTask{
//             public void run(){
//                 for(int i = 0; i < 4; i++){
//                     controller.removeNamesFromTrail(i);
//                 }
//                 controller.updateGUI();
//                 JOptionPane.showMessageDialog(null, "hi");
//             }
//             
//         }
        //timer.schedule(new hopeThisWorks(), 0, 5000);
    }
}
