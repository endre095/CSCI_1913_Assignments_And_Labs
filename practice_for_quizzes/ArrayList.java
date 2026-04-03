interface List<T> {
    void append(T value);
    void prepend(T value);
    int length();
    T get(int index);
    void set(int index, T value);
    
}

public class ArrayList<T> implements List<T> {
    int size = 0;
    public T[] data;

    public ArrayList() {
        data = (T[]) new Object[10];
    }

    @Override 
    public void append(T value) {
        if (++size >= data.length-1) {
            data = resizeArray();
        }
        data[size] = value;
    }

    @Override
    public void prepend(T value) {

    }

    public T[] resizeArray() {
        int arrSize = data.length * 2;
        T[] tempArr  = (T[]) new Object[arrSize];
        for (int i = 0; i < data.length; i++) {
            tempArr[i] = data[i];
        }
        return tempArr;
    }

    public T[] shiftRight(T[] input) {
        int inputArrSize = input.length * 2
        T[] tempArr =  (T[]) new Object[];
        for (int i = 0; i < input.size)
    }

    @Override 
    public int length() {
        return size;
    }

    @Override
    public T get(int index) {
        return data[index];
    }

    @Override
    public void set(int index, T value) {
        if (index >= data.length || index < data.length) {
            System.out.println("not gonna work.");
            return;
        }
        data[index] = value;
    }
    

}
