public class Main {
    public static void main(String[] args) {
        System.out.println("Дерево:");
        System.out.println(
                """
                           5
                         /   \\
                        3     7
                         \\   /  \\
                          2 6    18
                         /      /
                        1      17
                              /
                             16
                """
        );
        TreeNode<String> treeRootCase1 = new TreeNode<>("5");
        treeRootCase1.setLeftChild(new TreeNode<>("3"));
        treeRootCase1.getLeftChild().setRightChild(new TreeNode<>("2"));
        treeRootCase1.getLeftChild().getRightChild().setLeftChild(new TreeNode<>("1"));
        treeRootCase1.setRightChild(new TreeNode<>("7"));
        treeRootCase1.getRightChild().setLeftChild(new TreeNode<>("6"));
        treeRootCase1.getRightChild().setRightChild(new TreeNode<>("18"));
        treeRootCase1.getRightChild().getRightChild().setLeftChild(new TreeNode<>("17"));
        treeRootCase1.getRightChild().getRightChild().setLeftChild(new TreeNode<>("16"));
        System.out.println("Результат прямого обхода дерева в глубину: " + TreeTraversal.preorderTraversal(treeRootCase1));
        System.out.println("Результат обратного обхода дерева в глубину: " + TreeTraversal.postorderTraversal(treeRootCase1));
        System.out.println("Результат симметричного обхода дерева в глубину: " + TreeTraversal.inorderTraversal(treeRootCase1));
    }
}
