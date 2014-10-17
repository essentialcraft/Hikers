package model;

/**
 *
 * @author Spconway
 */
public class TrailController {
    //Trail objects
//    private TrailOne trailOne;
//    private TrailTwo trailTwo;
//    private TrailThree trailThree;
//    private TrailFour trailFour;
    
    private Trail trails[];
    
    //constructor
    public TrailController(){
//        trailOne = new TrailOne();
//        trailTwo = new TrailTwo();
//        trailThree = new TrailThree();
//        trailFour = new TrailFour();
        
        trails = new Trail[4];
        for(int i=0; i < trails.length; i++){
            trails[i] = new TrailOne();
        }
        
    }
    
    //accepts a number and assigns hikerstack to that trail based on number
    public void assignHikerStack(HikerStack h, int t){
        
        trails[t].addStack(h);
        trails[t].checkTrailsFull();
        
//        if(t == 1){
//            trailOne.addStack(h);
//            trailOne.checkTrailsFull();
//        }else if(t == 2){
//            trailTwo.addStack(h);
//            trailTwo.checkTrailsFull();
//        }else if(t == 3){
//            trailThree.addStack(h);
//            trailThree.checkTrailsFull();
//        }else if(t == 4){
//            trailFour.addStack(h);
//            trailFour.checkTrailsFull();
//        }
        //don't forget to figure out how to check for two hikerstacks
        //each time a stack is added
    }
    
    //NEED GETHIKER METHOD SO TRAILMODEL CAN GET HIKER AND PUSH UP THE GUI
    
    
    
    //get a trail from the trail array
    public Trail getTrail(int trailNeeded){
        return trails[trailNeeded];
    }
    
    
    //IAN: probably not needed, replaced with above method ^
    //DON'T THINK I NEED THESE BUT I'LL KEEP UNTIL I KNOW FOR SURE
    //returns trailOne
//    public TrailOne getTrailOne(){
//        return trailOne;
//    }
//    
//    //returns trailTwo
//    public TrailTwo getTrailTwo(){
//        return trailTwo;
//    }
//    
//    //returns trailThree
//    public TrailThree getTrailThree(){
//        return trailThree;
//    }
//    
//    //returns trailFour
//    public TrailFour getTrailFour(){
//        return trailFour;
//    }
}
