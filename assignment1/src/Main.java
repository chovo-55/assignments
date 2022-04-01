public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(tree.rootnode, 5);
        tree.insert(tree.rootnode, 1);
        tree.insert(tree.rootnode, 6);
        tree.insert(tree.rootnode, 19);
        tree.insert(tree.rootnode, 17);
        tree.insert(tree.rootnode, 21);

        System.out.println("\nDepth first search:  ");
        tree.depthFirstSearch(tree.rootnode);

        System.out.println("\n\nBreadth first search: ");
        tree.breadthFirstSearch();
    }
}
