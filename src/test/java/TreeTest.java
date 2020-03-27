import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TreeTest {

    private static Tree tree;

    @BeforeAll
    static void setUp(){
        tree = new Tree();
        tree.setRoot(new Tree.Node(5,
                                        new Tree.Node(3,
                                                            new Tree.Node(2, null, null),
                                                            new Tree.Node(5, null, null)),
                                        new Tree.Node(7,
                                                            new Tree.Node(1, null, null),
                                                            new Tree.Node(0,
                                                                                new Tree.Node(2, null, null),
                                                                                new Tree.Node(8,
                                                                                                    null,
                                                                                                    new Tree.Node(5, null, null))))));
    }

    @Test
    void sumTest(){
        assertEquals(5 + 3 + 7 + 2 + 5 + 1 + 0 + 2 + 8 + 5 ,tree.subTreeSum(tree.getRoot()));
    }

    @Test
    void avgTest(){
        assertEquals((5 + 3 + 7 + 2 + 5 + 1 + 0 + 2 + 8 + 5) / 10.0 ,tree.subTreeAverage(tree.getRoot()));
    }

    @Test
    void medianEvenTest(){
        assertEquals(4, tree.subTreeMedian(tree.getRoot()));
    }

    @Test
    void medianOddTest(){
        assertEquals(3, tree.subTreeMedian(tree.getRoot().getLeft()));
    }
}