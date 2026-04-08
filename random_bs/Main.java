public class Main {
    public static void main(String[] args) {
        Integer value = 5;
        Node<Integer> rootNode = new Node<>(value);
        Integer smaller = 4;
        Node<Integer> smallerNode = new Node<>(smaller);
        Integer larger = 6;
        Node<Integer> largerNode = new Node<>(larger);

        Integer unsure1 = 7;
        Node<Integer> unsure1_ = new Node<>(unsure1);
        Integer unsure2 = 12;
        Node<Integer> unsure2_ = new Node<>(unsure2);
        Integer unsure3 = 2;
        Node<Integer> unsure3_ = new Node<>(unsure3);


        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.setRoot(rootNode);
        tree.addNode(smallerNode);
        tree.addNode(largerNode);
        tree.addNode(unsure1_);
        tree.addNode(unsure2_);
        tree.addNode(unsure3_);
        tree.printTree(rootNode);
        tree.searchForNode(rootNode, unsure1_);
        

    }
}
