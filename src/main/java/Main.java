import java.util.List;

public class Main {
    public static void main(String[] args) {
//        TreeNode<String> treeRoot = new TreeNode<>("D");
//        treeRoot.setLeftChild(new TreeNode<>("C"));
//        treeRoot.getLeftChild().setRightChild(new TreeNode<>("B"));
//        treeRoot.getLeftChild().getRightChild().setLeftChild(new TreeNode<>("A"));
//        treeRoot.setRightChild(new TreeNode<>("E"));
//        treeRoot.getRightChild().setLeftChild(new TreeNode<>("F"));
//        treeRoot.getRightChild().setRightChild(new TreeNode<>("G"));
//        treeRoot.getRightChild().getRightChild().setLeftChild(new TreeNode<>("H"));
//        treeRoot.getRightChild().getRightChild().setRightChild(new TreeNode<>("I"));

        TreeNode<String> treeRoot = new TreeNode<>("F");
        treeRoot.setLeftChild(new TreeNode<>("B"));
        treeRoot.getLeftChild().setLeftChild(new TreeNode<>("A"));
        treeRoot.getLeftChild().setRightChild(new TreeNode<>("D"));
        treeRoot.getLeftChild().getRightChild().setLeftChild(new TreeNode<>("C"));
        treeRoot.getLeftChild().getRightChild().setRightChild(new TreeNode<>("E"));
        treeRoot.setRightChild(new TreeNode<>("G"));
        treeRoot.getRightChild().setRightChild(new TreeNode<>("I"));
        treeRoot.getRightChild().getRightChild().setLeftChild(new TreeNode<>("H"));

        List<String> preorderTraversalList = TreeTraversal.preorderTraversal(treeRoot);
        List<String> postorderTraversalList = TreeTraversal.postorderTraversal(treeRoot);
        List<String> inorderTraversalList = TreeTraversal.inorderTraversal(treeRoot);
        System.out.println("Результат прямого обхода дерева в глубину: " + preorderTraversalList);
        System.out.println("Результат обратного обхода дерева в глубину: " + postorderTraversalList);
        System.out.println("Результат симметричного обхода дерева в глубину: " + inorderTraversalList);
    }
}
