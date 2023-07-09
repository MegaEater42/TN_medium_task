public class TreeNode<T> {
    private final T data;
    private TreeNode<T> parent = null;
    private TreeNode<T> leftChild = null;
    private TreeNode<T> rightChild = null;

    public TreeNode(T data) {
        this.data = data;
    }

    public TreeNode(T data, TreeNode<T> parent) {
        this.data = data;
        this.parent = parent;
    }

    public TreeNode(T data, TreeNode<T> parent, TreeNode<T> leftChild, TreeNode<T> rightChild) {
        this.data = data;
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public void setParent(TreeNode<T> parent) {
        this.parent = parent;
    }

    public void setLeftChild(T data) {
        this.leftChild = new TreeNode<>(data, this);
    }

    public void setLeftChild(TreeNode<T> leftChild) {
        this.leftChild = leftChild;
        this.leftChild.parent = this;
    }

    public void setRightChild(T data) {
        this.rightChild = new TreeNode<>(data, this);
    }

    public void setRightChild(TreeNode<T> rightChild) {
        this.rightChild = rightChild;
        this.rightChild.parent = this;
    }

    public TreeNode<T> getParent() {
        return parent;
    }

    public TreeNode<T> getLeftChild() {
        return leftChild;
    }

    public TreeNode<T> getRightChild() {
        return rightChild;
    }

    public T getData() {
        return data;
    }

    public boolean hasLeftChild() {
        return leftChild != null;
    }

    public boolean hasRightChild() {
        return rightChild != null;
    }

    public boolean isLeaf(){
        return (leftChild == null) && (rightChild == null);
    }

    public boolean isRoot(){
        return parent == null;
    }

    public static <T> boolean isLeftChild(TreeNode<T> bastard, TreeNode<T> parent) {
        return parent.hasLeftChild() && parent.getLeftChild().equals(bastard);
    }

    public static <T> boolean isRightChild(TreeNode<T> bastard, TreeNode<T> parent) {
        return parent.hasRightChild() && parent.getRightChild().equals(bastard);
    }

    public static <T> boolean isChild(TreeNode<T> bastard, TreeNode<T> parent) {
        return isLeftChild(bastard, parent) || isRightChild(bastard, parent);
    }
}