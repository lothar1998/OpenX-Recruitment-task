import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

class TreeNodeTest {

    private static TreeNode rootTreeNode;
    private static TreeNode singleNodeTree;

    @BeforeAll
    static void setUp() {
        rootTreeNode = new TreeNode(5,
                new TreeNode(3, null, null),
                new TreeNode(7, null, null));

        singleNodeTree = new TreeNode(5, null, null);
    }

    @Test
    void constructorTest() {
        assertSame(rootTreeNode, rootTreeNode.getLeft().getParent());
        assertSame(rootTreeNode, rootTreeNode.getRight().getParent());

        assertNull(singleNodeTree.getLeft());
        assertNull(singleNodeTree.getRight());
    }
}