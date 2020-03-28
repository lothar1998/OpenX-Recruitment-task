import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TreeUtilsTest {

    private static TreeNode evenElementsNodeTree;
    private static TreeNode singleNodeTree;

    @BeforeAll
    static void setUp() {
        evenElementsNodeTree = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2, null, null),
                        new TreeNode(5, null, null)),
                new TreeNode(7,
                        new TreeNode(1, null, null),
                        new TreeNode(0,
                                new TreeNode(2, null, null),
                                new TreeNode(8,
                                        null,
                                        new TreeNode(5, null, null)))));

        singleNodeTree = new TreeNode(21, null, null);
    }

    @Test
    void sumTest() {
        assertEquals(5 + 3 + 7 + 2 + 5 + 1 + 0 + 2 + 8 + 5, TreeUtils.subTreeSum(evenElementsNodeTree));

        assertEquals(21, TreeUtils.subTreeSum(singleNodeTree));

        assertThrows(NullPointerException.class, () -> TreeUtils.subTreeSum(null));
    }

    @Test
    void avgTest() {
        assertEquals((5 + 3 + 7 + 2 + 5 + 1 + 0 + 2 + 8 + 5) / 10.0, TreeUtils.subTreeAverage(evenElementsNodeTree));

        assertEquals(21, TreeUtils.subTreeAverage(singleNodeTree));

        assertThrows(NullPointerException.class, () -> TreeUtils.subTreeAverage(null));
    }

    @Test
    void medianTest() {
        assertEquals(4, TreeUtils.subTreeMedian(evenElementsNodeTree));

        TreeNode rootNodeOfOddElementsTree = evenElementsNodeTree.getLeft();
        assertEquals(3, TreeUtils.subTreeMedian(rootNodeOfOddElementsTree));
        assertEquals(21, TreeUtils.subTreeMedian(singleNodeTree));

        assertThrows(NullPointerException.class, () -> TreeUtils.subTreeMedian(null));
    }
}