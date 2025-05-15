public class BinarySearchTree<E extends Comparable> {
    static class Node<E extends Comparable> {
        E data;
        Node leftNode, rightNode;

        Node(E data) {
            this.data = data;
        }
    }

    public Node insert(Node<E> root, E value) {
        if (root == null) {
            return new Node(value);
        }
        if (root.data.compareTo(value) > 0) {
            root.leftNode = insert(root.leftNode, value);
        }
        if (root.data.compareTo(value) < 0) {
            root.rightNode = insert(root.rightNode, value);
        }
        return root;

    }

    public void  inOrder(Node<E> root)
    {
        if (root == null) {
            return ;
        }

        inOrder(root.leftNode);
        System.out.print(root.data+" ");
        inOrder(root.rightNode);
    }



    public static void main(String[] args) {

        Node root = null;
        int[] val = {56, 30, 70};
        BinarySearchTree binarySearchTree= new BinarySearchTree();
        for (int i = 0; i < val.length; i++) {
            root = binarySearchTree.insert(root, val[i]);
        }

        binarySearchTree.inOrder(root);
    }
}






