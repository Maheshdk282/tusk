import java.util.Scanner;

class AVLTree {
    private int data, height;
    private AVLTree left, right;

    public AVLTree(int data) {
        this.data = data;
        this.height = 1; // New node is initially added at leaf
    }

    private int height(AVLTree node) {
        return node == null ? 0 : node.height;
    }

    private int getBalance(AVLTree node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private AVLTree rightRotate(AVLTree y) {
        AVLTree x = y.left, T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    private AVLTree leftRotate(AVLTree x) {
        AVLTree y = x.right, T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    public AVLTree insert(AVLTree node, int key) {
        if (node == null) return new AVLTree(key);
        if (key < node.data) node.left = insert(node.left, key);
        else if (key > node.data) node.right = insert(node.right, key);
        else return node; // Duplicates are not allowed

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        int balance = getBalance(node);

        if (balance > 1 && key < node.left.data) return rightRotate(node);
        if (balance < -1 && key > node.right.data) return leftRotate(node);
        if (balance > 1 && key > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && key < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    // Inorder traversal
    public void inorder(AVLTree node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    // Preorder traversal
    public void preorder(AVLTree node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    // Postorder traversal
    public void postorder(AVLTree node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AVLTree tree = null;

        // Ask user for number of elements
        System.out.print("Enter the number of elements to insert: ");
        int n = scanner.nextInt();

        // Inserting elements into AVL tree
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            tree = tree == null ? new AVLTree(value) : tree.insert(tree, value);
        }

        // Display the tree traversals
        System.out.println("Inorder traversal of the AVL tree is:");
        tree.inorder(tree);

        System.out.println("\nPreorder traversal of the AVL tree is:");
        tree.preorder(tree);

        System.out.println("\nPostorder traversal of the AVL tree is:");
        tree.postorder(tree);

        scanner.close();
    }
}
