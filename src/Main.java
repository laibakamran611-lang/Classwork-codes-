package dsaaignment;

// ================= Node Class =================
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

// ================= BST Operations =================
class BST {

    // Insert
    public static Node insert(Node root, int val) {
        if (root == null) return new Node(val);
        if (val < root.data) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    // Inorder Traversal
    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Preorder Traversal
    public static void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Postorder Traversal
    public static void postorder(Node root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    // Search
    public static boolean search(Node root, int key) {
        if (root == null) return false;
        if (root.data == key) return true;
        if (key < root.data) return search(root.left, key);
        else return search(root.right, key);
    }

    // Find Minimum
    public static Node findMinNode(Node root) {
        while (root.left != null)
            root = root.left;
        return root;
    }

    // Delete
    public static Node delete(Node root, int key) {
        if (root == null) return null;

        if (key < root.data) root.left = delete(root.left, key);
        else if (key > root.data) root.right = delete(root.right, key);
        else {
            // Node with only one child or no child
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            // Node with two children: Get inorder successor
            Node temp = findMinNode(root.right);
            root.data = temp.data;
            root.right = delete(root.right, temp.data);
        }
        return root;
    }

    // Height
    public static int height(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}

// ================= Main Class =================
public class Main {
    public static void main(String[] args) {
        Node root = null;

        // Insert elements
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int val : values) {
            root = BST.insert(root, val);
        }

        // Traversals
        System.out.print("Inorder Traversal: ");
        BST.inorder(root);
        System.out.println();

        System.out.print("Preorder Traversal: ");
        BST.preorder(root);
        System.out.println();

        System.out.print("Postorder Traversal: ");
        BST.postorder(root);
        System.out.println();

        // Search
        int key = 60;
        System.out.println("Search " + key + ": " + BST.search(root, key));

        // Delete
        System.out.println("Deleting 30...");
        root = BST.delete(root, 30);
        System.out.print("Inorder After Deletion: ");
        BST.inorder(root);
        System.out.println();

        // Height
        System.out.println("Height of Tree: " + BST.height(root));
    }
}
