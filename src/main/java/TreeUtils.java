import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Basic utilities which operate on tree of TreeNodes
 *
 * @author Piotr Kuglin
 * @see TreeNode implementation of binary tree node
 */
public class TreeUtils {

    private TreeUtils() {
    }

    /**
     * Calculate sum of all nodes in subtree
     *
     * @param treeNode root node of subtree
     * @return sum of nodes
     */
    public static Integer subTreeSum(TreeNode treeNode) {
        if (treeNode == null)
            throw new NullPointerException("Cannot compute sum of nodes of null tree");

        return getNodeList(treeNode).stream()
                .map(TreeNode::getValue)
                .mapToInt(Integer::intValue)
                .sum();
    }

    /**
     * Calculate average of all nodes in subtree
     *
     * @param treeNode root node of subtree
     * @return average of nodes
     */
    public static Double subTreeAverage(TreeNode treeNode) {
        if (treeNode == null)
            throw new NullPointerException("Cannot compute average of nodes of null tree");

        List<TreeNode> treeNodes = getNodeList(treeNode);
        return (double) treeNodes.stream().map(TreeNode::getValue).mapToInt(Integer::intValue).sum() / (double) treeNodes.size();
    }

    /**
     * Calculate median of all nodes in subtree
     *
     * @param treeNode root node of subtree
     * @return median of nodes
     */
    public static Double subTreeMedian(TreeNode treeNode) {
        if (treeNode == null)
            throw new NullPointerException("Cannot compute median of nodes of null tree");

        List<Integer> nodes = getNodeList(treeNode).stream()
                .map(TreeNode::getValue)
                .sorted()
                .collect(Collectors.toList());

        if (nodes.size() % 2 == 0)
            return (nodes.get(nodes.size() / 2) + nodes.get(nodes.size() / 2 - 1)) / 2.0;
        else
            return (double) nodes.get(nodes.size() / 2);
    }

    /**
     * Create a list of all nodes in subtree
     *
     * @param treeNode root node of subtree
     * @return nodes list
     */
    private static List<TreeNode> getNodeList(TreeNode treeNode) {
        List<TreeNode> treeNodes = new ArrayList<>();

        treeNodes.add(treeNode);
        addNodeToList(treeNode.getLeft(), treeNodes);
        addNodeToList(treeNode.getRight(), treeNodes);

        return treeNodes;
    }

    /**
     * Recursive adding nodes to treeNodeList
     *
     * @param treeNode     current node to add
     * @param treeNodeList list to which nodes will be added
     */
    private static void addNodeToList(TreeNode treeNode, List<TreeNode> treeNodeList) {
        if (treeNode == null)
            return;

        treeNodeList.add(treeNode);
        addNodeToList(treeNode.getLeft(), treeNodeList);
        addNodeToList(treeNode.getRight(), treeNodeList);
    }
}
