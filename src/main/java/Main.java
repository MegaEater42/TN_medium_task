public class Main {
    public static void main(String[] args) {
        System.out.println("Дерево_1:");
        System.out.println(
                """
                           D
                         /   \\
                        C     E
                         \\   /  \\
                          B F    G
                         /      / \\
                        A      H   I
                """
        );
        TreeNode<String> treeRootCase1 = new TreeNode<>("D");
        treeRootCase1.setLeftChild(new TreeNode<>("C"));
        treeRootCase1.getLeftChild().setRightChild(new TreeNode<>("B"));
        treeRootCase1.getLeftChild().getRightChild().setLeftChild(new TreeNode<>("A"));
        treeRootCase1.setRightChild(new TreeNode<>("E"));
        treeRootCase1.getRightChild().setLeftChild(new TreeNode<>("F"));
        treeRootCase1.getRightChild().setRightChild(new TreeNode<>("G"));
        treeRootCase1.getRightChild().getRightChild().setLeftChild(new TreeNode<>("H"));
        treeRootCase1.getRightChild().getRightChild().setRightChild(new TreeNode<>("I"));
        System.out.println("Результат прямого обхода дерева_1 в глубину: " + TreeTraversal.preorderTraversal(treeRootCase1));
        System.out.println("Результат обратного обхода дерева_1 в глубину: " + TreeTraversal.postorderTraversal(treeRootCase1));
        System.out.println("Результат симметричного обхода дерева_1 в глубину: " + TreeTraversal.inorderTraversal(treeRootCase1));

        System.out.println("Дерево_2:");
        System.out.println(
                """
                             F
                           /   \\
                          B     G
                         / \\     \\
                        A   D     H
                           / \\   /
                          C   E I
                """
        );
        TreeNode<String> treeRootCase2 = new TreeNode<>("F");
        treeRootCase2.setLeftChild(new TreeNode<>("B"));
        treeRootCase2.getLeftChild().setLeftChild(new TreeNode<>("A"));
        treeRootCase2.getLeftChild().setRightChild(new TreeNode<>("D"));
        treeRootCase2.getLeftChild().getRightChild().setLeftChild(new TreeNode<>("C"));
        treeRootCase2.getLeftChild().getRightChild().setRightChild(new TreeNode<>("E"));
        treeRootCase2.setRightChild(new TreeNode<>("G"));
        treeRootCase2.getRightChild().setRightChild(new TreeNode<>("I"));
        treeRootCase2.getRightChild().getRightChild().setLeftChild(new TreeNode<>("H"));

        System.out.println("Результат прямого обхода дерева_2 в глубину: " + TreeTraversal.preorderTraversal(treeRootCase2));
        System.out.println("Результат обратного обхода дерева_2 в глубину: " + TreeTraversal.postorderTraversal(treeRootCase2));
        System.out.println("Результат симметричного обхода дерева_2 в глубину: " + TreeTraversal.inorderTraversal(treeRootCase2));
    }
}
