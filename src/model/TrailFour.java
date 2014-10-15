package model;
/**
 *
 * @author Spconway
 * 
 * EACH INDIVIDUAL TRAIL EXTENDS THE ABSTRACT CLASS 'TRAIL' AND MUST
 * OVERRIDE THE 'wheelOfFate' METHOD
 */
public class TrailFour extends Trail{
    //weight for the risk of having a hiker die
    //stored initialy as a decimal
    private final double CHANCE_OF_DYING = .09;

    @Override
    public void wheelOfFate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
