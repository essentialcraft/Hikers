package model;

/**
 *
 * @author Spconway
 * 
 * Interface to guarantee inclusion of wheelOfFate method which will be 
 * different for every trail object due to the weight of the risk of having
 * a hiker die
 * 
 */
public interface TrailInterface {
    
    //wheelOfFate decides if a hiker dies for the given trail
    void wheelOfFate();
}
