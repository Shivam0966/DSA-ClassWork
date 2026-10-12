

class Main {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Construct binary tree from array (level order)
    static Node buildTree(Integer[] arr, int i) {
        if (i >= arr.length || arr[i] == null) {
            return null;
        }

        Node root = new Node(arr[i]);

        root.left = buildTree(arr, 2 * i + 1);
        root.right = buildTree(arr, 2 * i + 2);

        return root;
    }

    
    static void preorder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    
    static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    
    static void postorder(Node root) {
        if (root == null) return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7};

        Node root = buildTree(arr, 0);

        System.out.print("Preorder: ");
        preorder(root);

        System.out.print("\nInorder: ");
        inorder(root);

        System.out.print("\nPostorder: ");
        postorder(root);
    }
}
