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

    public <T> T[] resizeArray(T[] current) {
        int newLength = keys.length*2;
        T[] newArray = (T[]) new Object[newLength];

        for (int i = 0; i < keys.length; i++) {
            newArray[i] = current[i];
        }
        return newArray;
    }

    private boolean isEqual(Key leftKey, Key rightKey) {
        if (leftKey == null && rightKey == null) {
            return true;
        }
        else if (leftKey != null && rightKey != null) {
            return leftKey.equals(rightKey);
        }
        return (leftKey == rightKey);
    }

    private int getIndex(Key key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public Value get(Key key) {
        System.out.println("Accessing element: " + getIndex(key));
        if (getIndex(key) == -1) {
            return null;
        }
        Value tempVal = values[getIndex(key)];
        if (tempVal == null) {
            return null;        
        }
        return tempVal;
    }

    public boolean containsKey(Key key) {
        if (getIndex(key) == -1) {
            return false;
        }
        return true;
    } 

    public int size() {
        return this.count;
    }

    public void put(Key key, Value value) {
        if (containsKey(key)) {
            //System.out.println("VALUE PUT");
            values[getIndex(key)] = value;
            count++;
        }
        else if (count < keys.length) {
            keys[count] = key;
            //System.out.println("VALUE PUT");
            values[getIndex(key)] = value;
            count++;
        }
        else {
            keys = resizeArray(keys);
            values = resizeArray(values);
            //System.out.println("VALUE PUT");
            values[getIndex(key)] = value;
            count++;
        }
    }








}
