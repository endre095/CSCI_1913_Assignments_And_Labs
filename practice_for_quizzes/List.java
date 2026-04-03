public interface List<T> {
    void append(T value);
    int length();
    T get(int index);
    void set(int index, T value);
}
