package data_structures.graph.medium;

import java.util.*;

public class CloneGraph_133 {

    public static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private final Map<Node, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        //If cloned already, return it
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        Node clonedNode = new Node(node.val);
        visited.put(node, clonedNode);
        for (Node neighbor : node.neighbors) {
            clonedNode.neighbors.add(cloneGraph(neighbor));
        }
        return clonedNode;
    }

    public void printGraph(Node node) {
        Set<Node> visitedNodes = new HashSet<>();
        printGraphDFS(node, visitedNodes);
    }

    private void printGraphDFS(Node node, Set<Node> visitedNodes) {
        if (node == null || visitedNodes.contains(node)) {
            return;
        }
        visitedNodes.add(node);
        System.out.print("Node " + node.val + " -> Neighbors: ");
        for (Node neighbor : node.neighbors) {
            System.out.print(neighbor.val + " ");
        }
        System.out.println();
        for (Node neighbor : node.neighbors) {
            printGraphDFS(neighbor, visitedNodes);
        }
    }
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        CloneGraph_133 solution = new CloneGraph_133();
        Node clonedGraph = solution.cloneGraph(node1);
        System.out.println("Cloned Graph:");
        solution.printGraph(clonedGraph);
    }
}
