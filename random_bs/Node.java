public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
    
    private T data;
    private Node<T> previous;
    private Node<T> left;
    private Node<T> right;

    public Node(T data) {
        this.data = data;
        this.previous = null;
        this.left = null;
        this.right = null;
    }

    public T getData() {
        return this.data;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getLeft() {
        return this.left;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public Node<T> getRight() {
        return this.right;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public Node<T> getPrevious() {
        return this.previous;
    }

    public String toString() {
        return this.data.toString();
    }

    @Override
    public int compareTo(Node<T> other) {
        return this.data.compareTo(other.data);
    }

    }


