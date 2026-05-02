/*
Author: Andrew Endres
Date: 5/2/26
*/

public class CacheBlockQueue<T> {
    private CacheBlockQueueNode<T> front;
    private CacheBlockQueueNode<T> end;
    private int size; //tracks number of Nodes
    private int elements; //tracks total items in all nodes

    public CacheBlockQueue() {
        this.front = null;
        this.end = null;
        this.size = 0;
        this.elements = 0;
    }


    public void enqueue(T toAdd) {
        if (isEmpty()) {
            CacheBlockQueueNode<T> newNode = new CacheBlockQueueNode<>(toAdd, null);
            front = newNode;
            end = newNode;
            size++;
        } else if (toAdd.equals(end.getData())) {
            end.setCount(end.getCount() + 1);
        } else {
            CacheBlockQueueNode<T> newNode = new CacheBlockQueueNode<>(toAdd, null);
            end.setNext(newNode);
            end = newNode;
            size++;
        }
        elements++;
    }
    /*
     * does three main checks, if it is empty it makes a new node with the input
     * data, assigns the front and end to it and increments the size of the queue,
     * otherwise it checks if the current end is equal to the input data, if it is
     * it just increments the size of that node, if the data doesnt exist in the end
     * node it makes a new new, and points the old end to the new node of new data
     * type
     */


    public T dequeue() {
        if (isEmpty()) {
            return null;
        }

        T data = front.getData();
        elements--; //decrement total elements every time

        if (front.getCount() == 1) {
            front = front.getNext();
            size--; //decrement node count
            if (front == null)
                end = null;
        } else {
            front.setCount(front.getCount() - 1);
        }
        return data;
    }
    /*
     * checks if the queue is empty if so returns null, then checks if the count of
     * the node is 1, if so it decrements the nodes count accordingly, and then
     * returns the data
     */

    public T front() {
        return (isEmpty()) ? null : front.getData(); 
    }
    /*
     * this is just a fancy if else statement which either returns null if the queue
     * is empty, or else it returns the front nodes data
     */

    public int frontOfLineRepeatCount() {
        return (isEmpty()) ? 0 : front.getCount();
    }
    /*
     * identital to above but instead returns zero if the queue is empty, and
     * otherwise returns the front nodes count
     */

    public int getSize() {
        return elements;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        if (isEmpty())
            return "";

        StringBuilder sb = new StringBuilder();
        CacheBlockQueueNode<T> curr = front;

        while (curr != null) {
            sb.append(curr.getData()).append(":").append(curr.getCount());
            if (curr.getNext() != null) {
                sb.append(", ");
            }
            curr = curr.getNext();
        }
        return sb.toString();
    }
    /*
     * if the queue isempty print nothing, if it is not empty, loop through nodes
     * from front to end until the next is null, and print the data and its
     * associated count
     */
}


        
    

