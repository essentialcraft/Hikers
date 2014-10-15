package model;

/**
 *
 * @author Spconway
 * 
 * EACH INDIVIDUAL TRAIL EXTENDS THE ABSTRACT CLASS 'TRAIL' AND MUST
 * OVERRIDE THE 'wheelOfFate' METHOD
 */
public class TrailOne extends Trail{
    //weight for the risk of having a hiker die
    //stored initialy as a decimal
    private final double CHANCE_OF_DYING = .06;

    
    //ONLY CALL WHEELOFFATE METHOD WHEN A hikerstack is released up the mountain
    //wheeloffate will use the hikerDies method in the hikerstack class
    @Override
    public void wheelOfFate() {
        super.getHikerStack();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
