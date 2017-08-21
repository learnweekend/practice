/*
 Problem : Clone Graph
 Given an undirected graph where each node contains a label and a list of its neighbors,
 copy the whole data structure.
 */
import java.util.*;

public class CloneGraph {
    /*
     Solution 1 : clone the graph using BFS traversal,
     Use HashMap to store old node and new node mapping and keep track of visited Nodes.
     Runtime : O(N), Space : O(N)
    */
    public static Node cloneGraphBFS(Node root) {
        if(root == null) return null;
        Queue<Node> queue = new LinkedList<Node>();
        Map<Node, Node> visitedMap = new HashMap<Node, Node>();
        Node cloneNode = new Node(root.label);
        visitedMap.put(root, cloneNode);
        queue.add(root);

        while(!queue.isEmpty()){
            Node currNode = queue.poll();

            for(Node neighbor : currNode.neighbors){
                if(visitedMap.containsKey(neighbor)) {
                    visitedMap.get(currNode).neighbors.add(visitedMap.get(neighbor));
                } else {
                    Node copyAdjNode = new Node(neighbor.label);
                    visitedMap.put(neighbor, copyAdjNode);
                    visitedMap.get(currNode).neighbors.add(copyAdjNode);
                    queue.add(neighbor);
                }
            }
        }
        return cloneNode;
    }
    /*
     Solution 2 : clone the graph using BFS traversal
     Use HashMap to store old node --> new node mapping and keep track of visited Nodes.
     Runtime : O(N), Space : O(N)
    */
    public static Node cloneGraphDFS(Node root){
        if(root == null)
            return null;
        Map<Node, Node> visitedMap = new HashMap<Node, Node>();
        return cloneGraphDFS(root, visitedMap);
    }

    private static Node cloneGraphDFS(Node root, Map<Node, Node> visitedMap){
        if(root == null) return null;
        Node copyNode = new Node(root.label);
        visitedMap.put(root, copyNode);

        for(Node neighbor : root.neighbors){
            if(visitedMap.containsKey(neighbor)){
                copyNode.neighbors.add(visitedMap.get(neighbor));
            } else {
                copyNode.neighbors.add(cloneGraphDFS(neighbor, visitedMap));
            }
        }
        return copyNode;
    }

    // Graph Node
    private static class Node {
        private String label;
        private List<Node> neighbors;

        private Node(String label){
            this.label = label;
            neighbors = new ArrayList<Node>();
        }
    }
}
