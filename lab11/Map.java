/*
Author: Andrew Endres
Date: 4/19/26
*/

public class Map<Key, Value> {
    private int count;
    private Key[] keys;
    private Value[] values;

    public Map(int length) {
        if (length <= 0) {
            length = 1;
        }
        this.count = 0;
        this.keys = (Key[]) new Object[length];
        this.values = (Value[]) new Object[length];
    }
    /*
     * constructs the map object with a size that determines the size of the mapping
     */

    public <T> T[] resizeArray(T[] current) {
        int newLength = current.length*2;
        T[] newArray = (T[]) new Object[newLength];

        for (int i = 0; i < keys.length; i++) {
            newArray[i] = current[i];
        }
        return newArray;
    }
    /*
     * resizes the arrays by doubling the original size and creating a temp array
     * with that new length, then copies all elements
     * into the new array
     */

    private boolean isEqual(Key leftKey, Key rightKey) {
        if (leftKey == null && rightKey == null) {
            return true;
        }
        else if (leftKey != null && rightKey != null) {
            return leftKey.equals(rightKey);
        }
        return (leftKey == rightKey);
    }
    /*
     * determines if the two input keys are equal by seeing if they are both null,
     * which results in it returning true, or if they arent null, using the
     * .equals() function to determine their equality, otherwise just returns and
     * checks if they are the exact same object
     */

    private int getIndex(Key key) {
        for (int i = 0; i < count; i++) {
            if (isEqual(keys[i], key)) {
                return i;
            }
        }
        return -1;
    }
    /*
     * gets the index of the input key by going through key array and checking each
     * element
     */

    public Value get(Key key) {
        //if (key == null ){System.out.println("attempting to get: null");}
        //else {System.out.println("attempting to get: " + key.toString());}
        if (getIndex(key) == -1) {
            return null;
        }
        Value tempVal = values[getIndex(key)];
        if (tempVal == null) {
            System.out.println("returning to get: null");
            return null;        
        }       
        //System.out.println("attempting to get: " + tempVal.toString());
        return tempVal;
    }
    /*
     * gets a value by using the input key to search through the value array, if the
     * keys index is -1 then it isnt in the key array
     */

    public boolean containsKey(Key key) {
        if (getIndex(key) == -1) {
            return false;
        }
        return true;
    } 
    /*
     * checks if a key is in an array by seeing if its index is equal to -1
     */

    public int size() {
        return this.count;
    }

    public Value getValAtKey(Key key) {
        return values[getIndex(key)];
    }
    /*
     * returns the value of the input key
     */

    public void put(Key key, Value value) {
        int index = getIndex(key);

        if (index != -1) {
            values[index] = value; // update
            return;
        }
        if (count == keys.length) {
            values = resizeArray(values);
            keys = resizeArray(keys);
        }
        System.out.println("Putting key: " + key + ", index found: " + getIndex(key));
        keys[count] = key;
        values[count] = value;
        count++;
        printValuesArray();
    }
    /*
     * first checks if it is in the array already and if it is it updates the value,
     * then checks if the array can fit the new value/key, if not it resizes it,
     * then it puts the new value and new key into their respective arrays
     */

    public void printValuesArray() {
        for (Value v : values) {
            if (v == null) {
                System.out.println("value: " + "null");
            }
            else {
                System.out.println("value: " + v.toString());
            }
        }
    }
    /*
    prints the values in the value array
    */
}









