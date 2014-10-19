package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Spconway
 * 
 * Need method that is called in constructor that reads a random first name from
 * the first name list and a random last name from the last name list. I need 
 * to put first and last names in seperate files.
 */
public class Hiker {
    //hiker_Number is static to keep track of global number of hikers
    private static int global_hiker_Number = 0;
    /************HIKER INT IS THE "NAME" OF THE HIKER*************/
    private int hiker;
    //arrTime is the date and time of arrival for each new hiker
    //kept in eastern standard time
    private String arrTime;
    //trailNo keeps track of the trail the hiker is assigned to
    private int trailNo;
    //hiker name is string name of hiker
    private String hikerName;
    //local time object to access timer setting methods
    private Date date;
    //hikerDB is the file each hikers arrTime is written to
    private final String hiker_DB;
    
    
    
    
    //when a new hiker is created a trail number is assigned to the hiker at
    //random
    public Hiker(){
        //Create date object to store arrival date/time
        this.date = new Date();
        //store arrival time in string
        this.arrTime = date.toString();
        //store trail number
        this.trailNo = trailNo;
        //increment hiker_number
        global_hiker_Number++;
        //set hikerName as random name from file
        giveHikerName();
        this.hiker = global_hiker_Number;
        //setting hikerDB file path
        hiker_DB = "hikers.txt";
        //lastly, write new hiker to file
        writeToFile();
    }
    
    //reads a random first name and a random last name from a text file and
    //gives a newly generated hiker a name
    private void giveHikerName(){
        String s = "";
        String fn = "firstNames.text";
        String ln = "lastNames.text";
        Random rand = new Random();
        BufferedReader brf = null;
        BufferedReader brl = null;
        try {
            brf = new BufferedReader(new FileReader(new File(fn)));
            brl = new BufferedReader(new FileReader(new File(ln)));
            int firstNameInt = rand.nextInt(100);
            int lastNameInt = rand.nextInt(100);
            for(int i = 0; i <= firstNameInt; i++){
                s = brf.readLine() + " ";
            }
            String temp = "";
            for(int i = 0; i <= lastNameInt; i++){
                temp = brl.readLine();
            }
            s += temp;
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            ex.getMessage();
        }catch (IOException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            ex.getMessage();
        }finally{
            try {
                brf.close();
                brl.close();
            } catch (IOException ex) {
                ex.getMessage();
            }
        }
        this.hikerName = s;
    }
    
    
    
    //returns hikerName string
    public String getHikerName(){
        return hikerName;
    }
    
    
    
    //getArrivalTime returns the string representation of the arrival dat/time
    //of this hiker
    public String getArrivalTime(){
        return arrTime;
    }
    
    
    
    
    //getHikerNumber returns the int representation of hiker which is the 
    //hikers unique id number
    public int getHikerNumber(){
        return hiker;
    }
    
    
    
    
    //returns the trail number the hiker was assigned to
    public int getTrailNo(){
        return trailNo;
    }
    
    
    
    
    
    //write to file method will record hikers information to a txt file....
    //...in case something bad happens to this hiker
    private void writeToFile(){
        //Create file object and reference FileWriter object
        File file = new File(this.hiker_DB);
        FileWriter fw = null;
        //begin try catch
        try{
            //calling file.createNewFile() should check automatically for
            //the file and if it does not exist, create it
            file.createNewFile();
            //passing true as second parameter enables append mode
            fw = new FileWriter(file, true);
            /********CREATE STRING CONTAINING HIKER # AND ARRTIME******/
            String s = "Hiker: " + this.hiker + " Name: " + this.hikerName + " Arrival Time: " + this.arrTime + " Trail Number: " + this.getTrailNo();
            fw.write(s);
            //calling system.getproperty and passing line.separator causes
            //puts the curser at a new line in the txt file
            fw.write(System.getProperty("line.separator"));
            
        }catch(FileNotFoundException e){
            e.getMessage();
        }catch(IOException e){
            e.getMessage();
        }finally{
            try{
                fw.close();
            }catch(NullPointerException e){
                e.getMessage();
            }catch(IOException e){
                e.getMessage();
            }
        }
    }
    
    
    
    //returns the string representation of getHikerNumber
    @Override
    public String toString(){
        String s = "Hiker id: " + getHikerNumber();
        
        return s;
    }
}
