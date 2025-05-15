// Generic class BinarySearchTree where E extends Comparable to allow comparisons
public class BinarySearchTree<E extends Comparable> {

    // Static nested Node class to represent each node in the BST
    static class Node<E extends Comparable> {
        E data; // Data stored in the node
        Node leftNode, rightNode; // References to left and right children

        // Constructor to initialize node with data
        Node(E data) {
            this.data = data;
        }
    }

    // Method to insert a value into the BST
    public Node insert(Node<E> root, E value) {
        // Base case: if root is null, create a new node with the value
        if (root == null) {
            return new Node(value);
        }
        // If the value is smaller than root's data, go to left subtree
        if (root.data.compareTo(value) > 0) {
            root.leftNode = insert(root.leftNode, value);
        }
        // If the value is greater than root's data, go to right subtree
        if (root.data.compareTo(value) < 0) {
            root.rightNode = insert(root.rightNode, value);
        }
        // Return the (possibly updated) root
        return root;
    }

    // Method to calculate the size (number of nodes) of the BST
    public int size(Node root) {
        // Base case: if node is null, return 0
        if (root == null) {
            return 0;
        }
        // Return size of left + size of right + 1 (for current node)
        return size(root.leftNode) + size(root.rightNode) + 1;
    }

    // Method to perform in-order traversal (Left -> Root -> Right)
    public void inOrder(Node<E> root) {
        if (root == null) {
            return; // Base case: do nothing if node is null
        }

        inOrder(root.leftNode); // Traverse left subtree
        System.out.print(root.data + " "); // Visit current node
        inOrder(root.rightNode); // Traverse right subtree
    }

    // Method to search for a value in the BST
    public boolean search(Node root, E val) {
        // Base case: not found
        if (root == null) {
            return false;
        }
        // If value is less, search in left subtree
        if (root.data.compareTo(val) > 0) {
            return search(root.leftNode, val);
        }
        // If value is greater, search in right subtree
        else if (root.data.compareTo(val) < 0) {
            return search(root.rightNode, val);
        }
        else {
            return true; // Found the value
        }
    }

    // Main method to run and test BST functionality
    public static void main(String[] args) {

        Node root = null; // Initialize root of BST

        // Array of values to insert into the BST
        int[] val = {56, 30, 70, 22, 40, 60, 95, 11, 3, 16, 65, 63, 67};

        // Create an instance of BinarySearchTree
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        // Insert all values into the BST
        for (int i = 0; i < val.length; i++) {
            root = binarySearchTree.insert(root, val[i]);
        }

        // Display in-order traversal (should be sorted)
        binarySearchTree.inOrder(root);
        System.out.println(); // New line

        // Print the size of the BST
        System.out.println("Size of tree is " + binarySearchTree.size(root));

        // Check if all elements were added successfully
        if (val.length == binarySearchTree.size(root)) {
            System.out.println("All elements are added successfully......!!!");
        } else {
            System.out.println("All elements are not added");
        }

        // Search for value 63 in the BST
        if (binarySearchTree.search(root, 63)) {
            System.out.println("Found");
        } else {
            System.out.println("Not found");
        }
    }
}
