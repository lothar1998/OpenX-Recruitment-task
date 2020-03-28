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
    private Integer value;
    private TreeNode parent;
    private TreeNode left;
    private TreeNode right;

    /**
     * Construct tree node element with given offspring and node's value
     *
     * @param value value of node
     * @param left  left son of node
     * @param right right son of node
     */
    public TreeNode(Integer value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;

        if (left != null)
            left.setParent(this);

        if (right != null)
            right.setParent(this);
    }
}