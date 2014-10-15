package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author Spconway
 * 
 * 
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
    //local time object to access timer setting methods
    private Date date;
    //hikerDB is the file each hikers arrTime is written to
    private final String hiker_DB;
    
    
    
    
    //when a new hiker is created a trail number is assigned to the hiker at
    //random
    public Hiker(int trailNo){
        //Create date object to store arrival date/time
        this.date = new Date();
        //store arrival time in string
        this.arrTime = date.toString();
        //store trail number
        this.trailNo = trailNo;
        //increment hiker_number
        global_hiker_Number++;
        //set instance variable to static variable
        this.hiker = global_hiker_Number;
        //setting hikerDB file path
        hiker_DB = "hikers.txt";
        //lastly, write new hiker to file
        writeToFile();
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
            String s = "Hiker: " + this.hiker + " Arrival Time: " + this.arrTime + " Trail Number: " + this.getTrailNo();
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
