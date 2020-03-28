import lombok.Getter;
import lombok.Setter;

/**
 * Node of binary tree
 *
 * @author Piotr Kuglin
 */
@Getter
@Setter
public class TreeNode {
    private int value;
    private TreeNode parent;
    private TreeNode left;
    private TreeNode right;

    /**
     * Construct tree node element with given offspring and node's value
     *
     * @param value value of node
     * @param left  left child of node
     * @param right right child of node
     */
    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;

        if (left != null)
            left.setParent(this);

        if (right != null)
            right.setParent(this);
    }
}