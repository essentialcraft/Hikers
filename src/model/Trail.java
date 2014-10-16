package model;

import java.util.Iterator;




/**
 *
 * @author Spconway
 * 
 * Trail is the super class of each individual trail.
 * 
 * Trail implements TrailInterface which forces each Trail child 
 * to implement the TrailInterface method directly
 * 
 * TEST COMMENT
 */
public abstract class Trail implements TrailInterface {
    //keep track of each HikerStack that is added to all of the trails
    private ArrayQueue<HikerStack> hikerStackQueue;
    Iterator<HikerStack> iter = hikerStackQueue.iterator();
    
    
    public Trail(){
        hikerStackQueue = new ArrayQueue();
    }
    
    /*
     * tests if the trail is full. A trail is full if there are two stacks
     * of hikers in the hikerStackQueue. There is no limit to how many stacks
     * are in the array queue
     * 
     * returns false if the trail is empty
     * 
     * true if the trail is full
     */
    public void checkTrailsFull(){
        int maxCapacity = 2;
        
        if(hikerStackQueue.size() == maxCapacity){
            //releaseHikers();
            //i assume we can release all 20 hikers at once meaning in the 
            //gui it will show a list of 20 hiker names
            //after the "releaseHikers()" is called empty the que
        }
    }
    
    //inserts HikerStack h into the ArrayQueue
    public void addStack(HikerStack h){
        hikerStackQueue.add(h);
    }
    
    public ArrayQueue getHikerStack(){
        return hikerStackQueue;
    }
    
    
}
