package model;

import java.util.LinkedList;




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
    private LinkedList<Hiker> hikersOnTrail;
    //maxCapacity is the limit to how many hikerstacks can be in the
    //que before the que needs to be empties
    private final int MAX_CAPACITY = 2;
    
    public Trail(){
        hikerStackQueue = new ArrayQueue();
        hikersOnTrail = new LinkedList();
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
        
        if(hikerStackQueue.size() == MAX_CAPACITY){
            addHikerToMountain(hikerStackQueue.poll());
            addHikerToMountain(hikerStackQueue.poll());
        }
    }
    
    //inserts HikerStack h into the ArrayQueue
    public void addStack(HikerStack h){
        hikerStackQueue.add(h);
    }
    
    
    public void addHikerToMountain(HikerStack hikerIn){
        for(int i = 0 ; i < hikerIn.size(); i++){
            hikersOnTrail.add(hikerIn.pop());
        }
    }
    
    public LinkedList getHikersOnMountain(){
        return hikersOnTrail;
    }
    
    
    
    
    
    //returns all hikers who are CURRENTLY going up the mountain
    //does not include hikers that are in the que
    //THIS CLASS NEEDS TO HAVE THE CHECKTRAILSFULL METHOD CALLED FIRST BECAUSE
    //IF IT IS NOT CALLED THEN THE BELOW METHOD WILL RETURN AN ERROR
    public HikerStack[] getHikersCurrentlyGoingUpMountain(){
        HikerStack[] h = new HikerStack[MAX_CAPACITY];
        
        //looping through twice removes two hikerstacks so hikers can go up
        //the mountsin
        for(int i = 0; i < h.length; i++){
            h[i] = hikerStackQueue.remove();
        }
        
        return h;
    }
    
    public ArrayQueue<HikerStack> getTrailQueue(){
        return hikerStackQueue;
    }
    
//    public StringBuilder getContentOfStack(){
//        StringBuilder str = new StringBuilder();
//        for(int i = 0; i < hikerStackQueue.size();i++){
//            
//        }
//    }
//    
}
