package model;
import java.util.*;

/**
 * Implements the Queue interface using a circular array.
 * @author Koffman & Wolfgang
 **/
public class ArrayQueue<E> extends AbstractQueue<E>
        implements Queue<E> {

    // Data Fields
    /** Index of the front of the queue. */
    private int front;
    /** Index of the rear of the queue. */
    private int rear;
    /** Current size of the queue. */
    private int size;
    /** Current capacity of the queue. */
    private int capacity;
    /** Default capacity of the queue. */
    private static final int DEFAULT_CAPACITY = 10;
    /** Array to hold the data. */
    private E[] theData;

    // Constructors
    /**
     * Construct a queue with the default initial capacity.
     */
    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Construct a queue with the specified initial capacity.
     * @param initCapacity The initial capacity
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue(int initCapacity) {
        capacity = initCapacity;
        theData = (E[]) new Object[capacity];
        front = 0;
        rear = capacity - 1;
        size = 0;
    }

    // Public Methods
    /**
     * Inserts an item at the rear of the queue.
     * @post item is added to the rear of the queue.
     * @param item The element to add
     * @return true (always successful)
     */
    @Override
    public boolean offer(E item) {
        if (size == capacity) {
            reallocate();
        }
        size++;
        rear = (rear + 1) % capacity;
        theData[rear] = item;
        return true;
    }

    /**
     * Returns the item at the front of the queue without removing it.
     * @return The item at the front of the queue if successful;
     * return null if the queue is empty
     */
    @Override
    public E peek() {
        if (size == 0) {
            return null;
        } else {
            return theData[front];
        }
    }

    /**
     * Removes the entry at the front of the queue and returns it
     * if the queue is not empty.
     * @post front references item that was second in the queue.
     * @return The item removed if successful or null if not
     */
    @Override
    public E poll() {
        if (size == 0) {
            return null;
        }
        E result = theData[front];
        front = (front + 1) % capacity;
        size--;
        return result;
    }

    /**
     * Return the size of the queue
     * @return The number of items in the queue
     */
    @Override
    public int size() {
        return size;
    }
    
    // Private Methods
    
    /**
     * Double the capacity and reallocate the data.
     * @pre The array is filled to capacity.
     * @post The capacity is doubled and the first half of the
     *       expanded array is filled with data.
     */
    @SuppressWarnings("unchecked")
    private void reallocate() {
        int newCapacity = 2 * capacity;
        E[] newData = (E[]) new Object[newCapacity];
        int j = front;
       
        System.arraycopy(theData, front, newData, 0, capacity - front);
        System.arraycopy(theData, 0, newData, capacity - front, front);
        
        front = 0;
        rear = size - 1;
        capacity = newCapacity;
        theData = newData;
    }
    
    @Override
    public boolean add(E e){
        if(size == this.capacity){
            reallocate();
        }
        
        size++;
        rear = (rear + 1) % capacity;
        theData[rear] = e;
        
        return true;
    }
    
    @Override
    public E remove(){
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        E result = theData[front];
        front = (front + 1) % capacity;
        size--;
        return result;
    }
    
    @Override
    public E element(){
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty");
        } else {
            return theData[front];
        }
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}