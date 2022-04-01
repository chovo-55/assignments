public class BinaryTree {
    Node rootnode = new Node(10);


    public void insert(Node node, int value) {
        if (value < node.value) {
            if (node.left != null) {
                insert(node.left, value);
            } else {
                System.out.println("Inserted " + value + " to left of Node " + node.value);
                node.left = new Node(value);
            }
        } else if (value > node.value) {
            if (node.right != null) {
                insert(node.right, value);
            } else {
                System.out.println("  Inserted " + value + " to right of Node " + node.value);
                node.right = new Node(value);
            }
        }
    }

    void depthFirstSearch(Node node) {
        if (node == null)
            return;
        System.out.print(node.value + " ");
        depthFirstSearch(node.left);
        depthFirstSearch(node.right);
    }

    void breadthFirstSearch() {
        int h = height(rootnode);
        for (int i = 1; i <= h; i++)
            printCurrentLevel(rootnode, i);
    }

    int height(Node root) {
        if (root == null)
            return 0;
        else {
            int lheight = height(root.left);
            int rheight = height(root.right);
            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }

    void printCurrentLevel(Node root, int level) {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.value + " ");
        else if (level > 1) {
            printCurrentLevel(root.left, level - 1);
            printCurrentLevel(root.right, level - 1);
        }
    }
}