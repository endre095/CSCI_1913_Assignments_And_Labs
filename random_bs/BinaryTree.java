public class BinaryTree<T extends Comparable<T>> {
    
    private Node<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public void addNode(Node<T> node) {
        if (root == null) {
            root = node;
        } else {
            addNode(root, node);
        }
    }

    private void addNode(Node<T> current, Node<T> nodeToAdd) {
        int value = current.compareTo(nodeToAdd);
        
        if (value >= 0) { // if nodeToAdd is smaller than the current node, is it to be its left child, so
                          // it is then determined if the left child is null, if it is, it is added,
                          // otherwise it is recursed down further into the left subtree until an empty
                          // spot is found for the data
            //System.out.println("node added");
            if (current.getLeft() == null) {
                current.setLeft(nodeToAdd);
            }
            else {
                addNode(current.getLeft(), nodeToAdd);
            }
        }
        else {
            if (current.getRight() == null) { // essentially does the exact same thing as above but for the right, it
                                              // isnot important that they are ordered in this way though because the
                                              // logic of the tree is unchanged, all it would do is just change which
                                              // comparisons are completed first, which wouldnt break anything
                current.setRight(nodeToAdd);
            }
            else {
                addNode(current.getRight(), nodeToAdd);
            }
        }
    }

    public Node<T> searchForNode(Node<T> rootNode, Node<T> nodeToFind) {
        if (rootNode == null)
            return null;

        int compareVal = nodeToFind.compareTo(rootNode); //sets the value of the comparison between the current root node and the node to find

        if (compareVal == 0) { //if the node to find is the same as the root node, then it has been foudn in the tree and is returned
            System.out.println("FOUND");
            System.out.println("Node Data: " + rootNode.toString());
            return rootNode;
        } else if (compareVal < 0) { // if the node to find is smaller than the current node, recurse with the current nodes left node, or the next smallest node
            return searchForNode(rootNode.getLeft(), nodeToFind);
        } else { // if the compare value indicates that the node to find is larger than the current node, it recurses to the right towards the nxt largest node
            return searchForNode(rootNode.getRight(), nodeToFind); 
        }
    }

    public void printTree(Node<T> current) {
            if (current == null) {return;}
               
            printTree(current.getLeft());
            System.out.println("Node data: " + current.toString());
            printTree(current.getRight());
                
            }
        }
        


    


