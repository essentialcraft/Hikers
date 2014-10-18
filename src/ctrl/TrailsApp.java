/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctrl;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.SwingUtilities;
import javax.swing.text.NumberFormatter;
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
            int TIME_SPEED = 100;
            //number formatter to include leading and trailing zeros
            NumberFormat formatter = new DecimalFormat("00");
            int hours = 07;
            int minutes = 00;
            //set a string to look like a time object
            String time;
            
            @Override
            public void run(){
                while(true){
                    /*
                     * Each time the thread wakes up it adds '1' to the minutes
                     * variable of our made up time stamp. When 59 minutes have
                     * been added the hours int increments. Upon reaching 10:00
                     * the hikers will be allowed to walk up their trails
                     */
                    time = formatter.format(hours) + ":" + formatter.format(minutes);
                    System.out.println(time);
                    minutes++;
                    if(minutes == 60){
                        minutes = 00;
                        hours++;
                    }
                    model.generateHiker();
                    //set the most recent hiker to the waiting list
                    
                    SwingUtilities.invokeLater(new Runnable(){
                      public void run(){    
                      //
                      window.getWaitPanel().removeHiker(model.getTempHiker());
                      window.getWaitPanel().addHiker(model.getTempHiker());
                      controller.updateGUI();
                      //window.getWaitPanel().setList(model.getTempHiker().toString());
                      }
                    });
                try {
                    
                    sleep(TIME_SPEED);
                    
                } catch (InterruptedException ex) {
                    ex.getMessage();
                }}
            }
        };
        thread.start();
        
    }
    
}
