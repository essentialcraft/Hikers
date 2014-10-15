package model;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Spconway
 * 
 * TrailModel is the controller class that handles the relationship between
 * HikerStack and Trails
 * 
 * 1. makes four hikerstack classes(one for each trail) and use random number
 * generator to generate number between 1 and 4 and whichever number that is 
 * is the trail that gets a hiker..repeat every 3 seconds or so? 
 * 
 * 2. do (1) until any of the hikerstacks are full then dump that into the appropriate
 * trail class and call the clear method to start that hikerstack over
 * 
 * 2.5 calling the checkHikerStackFull method checks if there are 10 hikers
 * in a stack and if so dumps it to the appropriate trail class
 * 
 * 3. after a hikerstack gets dumped to the appropriate trail it is erased and
 * the process starts over for that hikerstack.
 * 
 * DON'T FORGET A METHOD THAT DUMPS HIKERSTACK REGARDLESS OF SIZE FOR WHEN
 * THE CHECKTRAILS BUTTON IS CLICKED
 * 
 * MAYBE A METHOD IN TRAILS THAT ACCEPTS A HIKERSTACK AND A NUMBER AND DEPENDING
 * ON THE NUMBER ASSIGNES THE HIKERSTACK TO THAT NUMBER
 */
public class TrailModel {
    //trails class will have a method for each trail that accepts hikerstacks
    private TrailController trailController;
    //
    private HikerStack hikerStackOne, hikerStackTwo, hikerStackThree, hikerStackFour;
    //psuedo random number generator
    private Random rand;
    
    public TrailModel(){
        trailController = new TrailController();
        hikerStackOne = new HikerStack();
        hikerStackTwo = new HikerStack();
        hikerStackThree = new HikerStack();
        hikerStackFour = new HikerStack();
        rand = new Random();
    }
    
    //uses a psuedo random number to assign hikers at "random" to trails
    public void generateHiker(){
        int r = (rand.nextInt(4) + 1);
        Hiker newHiker = new Hiker(r);
        //JOptionPane.showMessageDialog(null, newHiker.toString());
        
        if(r == 1){
            hikerStackOne.push(newHiker);
            checkHikerStackFull(hikerStackOne, r);
        }else if(r == 2){
            hikerStackTwo.push(newHiker);
            checkHikerStackFull(hikerStackTwo, r);
        }else if(r == 3){
            hikerStackThree.push(newHiker);
            checkHikerStackFull(hikerStackThree, r);
        }else if(r == 4){
            hikerStackFour.push(newHiker);
            checkHikerStackFull(hikerStackFour, r);
        }
    }
    
    //checks if a hikerstack is full and if it is it dumps down into the
    //appropriate trail que
    private void checkHikerStackFull(HikerStack h, int trailNumber){
        if(h.isFull()){
            trailController.assignHikerStack(h, trailNumber);
            //clear the stack
            h.clear();
        }
    }
    
    //only to be called when checkTrailsFull button is pushed to dump any
    //remaining hikers into their respective trails
    public void forceDumpHikerStack(){
        //BE CAREFUL AS THIS MIGHT TRY TO PUT ASSIGN AN EMPTY HIKERSTACK
        //THIS METHOD MIGHT CAUSE PROBLEMS
        if(!hikerStackOne.empty()){
            trailController.assignHikerStack(hikerStackOne, hikerStackOne.peek().getTrailNo());
        }
        if(!hikerStackTwo.empty()){
            trailController.assignHikerStack(hikerStackTwo, hikerStackTwo.peek().getTrailNo());
        }
        if(!hikerStackTwo.empty()){
            trailController.assignHikerStack(hikerStackThree, hikerStackThree.peek().getTrailNo());
        }
        if(!hikerStackTwo.empty()){
            trailController.assignHikerStack(hikerStackFour, hikerStackFour.peek().getTrailNo());
        }
    }
}
