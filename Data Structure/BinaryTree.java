
class Node {
    int key;
    Node left, right;

    public Node(int key) {
        this.key = key;
        this.left = this.right = null;
    }
}

class BinaryTree {
    Node root;

 
    public Node insert(Node root, int key) {
        if (root == null) return new Node(key);

        if (key < root.key)
            root.left = insert(root.left, key);
        else if (key > root.key)
            root.right = insert(root.right, key);

        return root;
    }

 
    public boolean search(Node root, int key) {
        if (root == null) return false;
        if (root.key == key) return true;

        if (key < root.key) return search(root.left, key);
        return search(root.right, key);
    }

 
    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    
    public void preorder(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

  
    public void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.key + " ");
        }
    }

    private Node minValueNode(Node root) {
        while (root.left != null)
            root = root.left;
        return root;
    }

    
    public Node delete(Node root, int key) {
        if (root == null) return root;

        if (key < root.key)
            root.left = delete(root.left, key);
        else if (key > root.key)
            root.right = delete(root.right, key);
        else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            Node minNode = minValueNode(root.right);
            root.key = minNode.key;
            root.right = delete(root.right, minNode.key);
        }

        return root;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

     
        tree.root = tree.insert(tree.root, 50);
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 70);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 40);
        tree.insert(tree.root, 60);
        tree.insert(tree.root, 80);

     
        System.out.print("Inorder Traversal: ");
        tree.inorder(tree.root);
        System.out.println();

        System.out.print("Preorder Traversal: ");
        tree.preorder(tree.root);
        System.out.println();

        System.out.print("Postorder Traversal: ");
        tree.postorder(tree.root);
        System.out.println();

       
        int searchKey = 40;
        System.out.println("Search " + searchKey + ": " + tree.search(tree.root, searchKey));

       
        System.out.println("Deleting 30...");
        tree.root = tree.delete(tree.root, 30);
        System.out.print("Inorder Traversal after deleting 30: ");
        tree.inorder(tree.root);
        System.out.println();
    }
}
