package model;

import java.util.EmptyStackException;


/**
 *
 * @author Spconway
 * 
 * 
 * HikerStack holds anywhere from 1 to 10 hikers
 */
public class HikerStack<E>{
    //stack size can not be bigger than 10
    private final int STACK_SIZE = 10;
    //elements can only hold Hiker objects
    private Hiker[] elements;
    //count to keep track of elements index
    private int count;
    
    //constructor
    public HikerStack(){
        elements = new Hiker[STACK_SIZE];
        count = 0;
    }
    
    //tests if stack is empty
    public boolean empty(){
        if(count == 0){
            return true;
        }else{
            return false;
        }
    }
    
    //tests if stack is full
    public boolean isFull(){
        if(count == 10){
            return true;
        }else{
            return false;
        }
    }
    
    //looks at the object at the top of the stack without removing it from the 
    //stack
    public Hiker peek(){
        Hiker h = null;
        
        if(empty()){
            throw new EmptyStackException();
        }else{
            h = elements[(count-1)];
        }
        
        return h;
    }
    
    //removes the object at the top of this stack and returns that object
    //as the value of this function
    public Hiker pop(){
        Hiker h = null;
        
        if(empty()){
            throw new EmptyStackException();
        }else{
            h = elements[--count];
            elements[count] = null;
        }
        
        return h;
    }
    
    //pushes an item onto the top of this stack.
    public void push(Hiker item){
        try{
            if(count == STACK_SIZE){
                throw new FullStackException("This stack is full.");
            }else{
                elements[count++] = item;
            }
        }catch(FullStackException e){
            e.getMessage();
        }
    }
    
    //returns the desired Hiker object
    public Hiker search(int i){
        Hiker h = null;
        
        if(empty()){
            throw new EmptyStackException();
        }else{
            h = elements[i];
        }
        
        return h;
    }
    
    //accepts a random int which will be used to search for specified index.
    //If given int is found in the stack that hiker is popped (killed).
    //If given int is not found, no hiker is popped
    public Hiker hikerDies(int i){
        Hiker h = null;
        
        if(empty()){
            throw new EmptyStackException();
        }else if(elements[i] != null){
            h = elements[i];
            elements[i] = null;
        }
        /*
         * Hiker h is being returned so that gui can access the getHikerNumber
         * to alert user that a hiker was eliminated from the stack.
         */
        return h;
    }
    
    //clears the stack
    public void clear(){
        for(int i = 0; i < elements.length; i++){
            elements[i] = null;
        }
        count = 0;
    }
}
