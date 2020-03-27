import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tree {

    private Node root;

    @AllArgsConstructor
    @Getter
    @Setter
    public static class Node{
        private Integer value;
        private Node left;
        private Node right;
    }

    public Integer subTreeSum(Node node){
        return getNodeList(node).stream().map(Node::getValue).mapToInt(Integer::intValue).sum();
    }

    public Double subTreeAverage(Node node){
        List<Node> nodes = getNodeList(node);
        return (double) nodes.stream().map(Node::getValue).mapToInt(Integer::intValue).sum() / (double) nodes.size();
    }

    public Double subTreeMedian(Node node){
        List<Integer> nodes = getNodeList(node).stream().map(Node::getValue).sorted().collect(Collectors.toList());
        if(nodes.size() % 2 == 0)
            return (nodes.get(nodes.size() / 2) + nodes.get(nodes.size() / 2 - 1)) / 2.0;
        else
            return (double) nodes.get(nodes.size() / 2);
    }

    private List<Node> getNodeList(Node node){
        List<Node> nodes = new ArrayList<>();

        nodes.add(node);
        addNodeToList(node.getLeft(), nodes);
        addNodeToList(node.getRight(), nodes);

        return nodes;
    }

    private void addNodeToList(Node node, List<Node> nodeList){
        if(node == null)
            return;

        nodeList.add(node);
        addNodeToList(node.getLeft(), nodeList);
        addNodeToList(node.getRight(), nodeList);
    }
}
