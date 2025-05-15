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
    
    public  int size(Node root)
    {
        if(root==null)
        {
            return 0;
        }

        return size(root.leftNode)+size(root.rightNode)+1;
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
        int[] val = {56, 30, 70, 22, 40, 60, 95, 11,3,16, 65,63,67};

        BinarySearchTree binarySearchTree= new BinarySearchTree();
        for (int i = 0; i < val.length; i++) {
            root = binarySearchTree.insert(root, val[i]);
        }

        binarySearchTree.inOrder(root);
        System.out.println();
        System.out.println("Size of tree is "+binarySearchTree.size(root));
        if (val.length==binarySearchTree.size(root))
        {
            System.out.println("All element are added successfully......!!!");
        }
        else
        {
            System.out.println("All element are not added");
        }
    }
}






