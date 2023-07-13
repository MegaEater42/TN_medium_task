import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TreeTraversalTest {
    private static TreeNode<String> treeRootCase1;
    private static TreeNode<String> treeRootCase2;

    @BeforeAll
    public static void setUp() {
//        """
//                           D
//                         /   \\
//                        C     E
//                         \\   /  \\
//                          B F    G
//                         /      / \\
//                        A      H   I
//        """
        treeRootCase1 = new TreeNode<>("D");
        treeRootCase1.setLeftChild(new TreeNode<>("C"));
        treeRootCase1.getLeftChild().setRightChild(new TreeNode<>("B"));
        treeRootCase1.getLeftChild().getRightChild().setLeftChild(new TreeNode<>("A"));
        treeRootCase1.setRightChild(new TreeNode<>("E"));
        treeRootCase1.getRightChild().setLeftChild(new TreeNode<>("F"));
        treeRootCase1.getRightChild().setRightChild(new TreeNode<>("G"));
        treeRootCase1.getRightChild().getRightChild().setLeftChild(new TreeNode<>("H"));
        treeRootCase1.getRightChild().getRightChild().setRightChild(new TreeNode<>("I"));

//        """
//                             F
//                           /   \\
//                          B     G
//                         / \\     \\
//                        A   D     H
//                           / \\   /
//                          C   E I
//        """
        treeRootCase2 = new TreeNode<>("F");
        treeRootCase2.setLeftChild(new TreeNode<>("B"));
        treeRootCase2.getLeftChild().setLeftChild(new TreeNode<>("A"));
        treeRootCase2.getLeftChild().setRightChild(new TreeNode<>("D"));
        treeRootCase2.getLeftChild().getRightChild().setLeftChild(new TreeNode<>("C"));
        treeRootCase2.getLeftChild().getRightChild().setRightChild(new TreeNode<>("E"));
        treeRootCase2.setRightChild(new TreeNode<>("G"));
        treeRootCase2.getRightChild().setRightChild(new TreeNode<>("H"));
        treeRootCase2.getRightChild().getRightChild().setLeftChild(new TreeNode<>("I"));
    }

    @Test
    public void preorderTreeSearch() {
        assertEquals(List.of("D", "C", "B", "A", "E", "F", "G", "H", "I"), TreeTraversal.preorderTraversal(treeRootCase1));
        assertEquals(List.of("F", "B", "A", "D", "C", "E", "G", "H", "I"), TreeTraversal.preorderTraversal(treeRootCase2));
    }

    @Test
    void postorderTreeSearch() {
        assertEquals(List.of("A", "B", "C", "F", "H", "I", "G", "E", "D"), TreeTraversal.postorderTraversal(treeRootCase1));
        assertEquals(List.of("A", "C", "E", "D", "B", "I", "H", "G", "F"), TreeTraversal.postorderTraversal(treeRootCase2));
    }

    @Test
    void inorderTreeSearch() {
        assertEquals(List.of("C", "A", "B", "D", "F", "E", "H", "G", "I"), TreeTraversal.inorderTraversal(treeRootCase1));
        assertEquals(List.of("A", "B", "C", "D", "E", "F", "G", "I", "H"), TreeTraversal.inorderTraversal(treeRootCase2));
    }
}