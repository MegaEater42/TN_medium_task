import java.util.LinkedList;
import java.util.List;

public class TreeTraversal {
    private static <T> List<T> preorderTraversalInner(TreeNode<T> treeNode, List<T> traversal) {
        traversal.add(treeNode.getData());
        if (treeNode.hasLeftChild()) {
            preorderTraversalInner(treeNode.getLeftChild(), traversal);
        }
        if (treeNode.hasRightChild()) {
            preorderTraversalInner(treeNode.getRightChild(), traversal);
        }
        return traversal;
    }

    public static <T> List<T> preorderTraversal(TreeNode<T> treeNode) {
        return preorderTraversalInner(treeNode, new LinkedList<>());
    }

    private static <T> List<T> postorderTraversalInner(TreeNode<T> treeNode, List<T> traversal) {
        if (treeNode.hasLeftChild()) {
            postorderTraversalInner(treeNode.getLeftChild(), traversal);
        }
        if (treeNode.hasRightChild()) {
            postorderTraversalInner(treeNode.getRightChild(), traversal);
        }
        traversal.add(treeNode.getData());
        return traversal;
    }

    public static <T> List<T> postorderTraversal(TreeNode<T> treeNode) {
        return postorderTraversalInner(treeNode, new LinkedList<>());
    }

    private static <T> List<T> inorderTraversalInner(TreeNode<T> treeNode, List<T> traversal) {
        if (treeNode.hasLeftChild()) {
            inorderTraversalInner(treeNode.getLeftChild(), traversal);
        }
        traversal.add(treeNode.getData());
        if (treeNode.hasRightChild()) {
            inorderTraversalInner(treeNode.getRightChild(), traversal);
        }
        return traversal;
    }

    public static <T> List<T> inorderTraversal(TreeNode<T> treeNode) {
        return inorderTraversalInner(treeNode, new LinkedList<>());
    }
}
