package hw8;

import java.util.*;

public class CSE222Dijkstra {
    private CSE222Graph graph;
    private Map<Node, Integer> dist;
    private Map<Node, Node> prev;
    /**
     * 
     * @param graph
     */
    public CSE222Dijkstra(CSE222Graph graph) {
        this.graph = graph;
        this.dist = new HashMap<>();
        this.prev = new HashMap<>();
    }
    /**
     * 
     * @return
     */
    public List<Node> findPath() {
        Node start = graph.getMap().getStart();
        Node end = graph.getMap().getEnd();
        Map<Node, List<Node>> adjacencyList = graph.getAdjacencyList();
    
        for (Node node : adjacencyList.keySet()) {
            dist.put(node, Integer.MAX_VALUE);
        }
        dist.put(start, 0);
    
        Set<Node> settledNodes = new HashSet<>();
        PriorityQueue<Node> unsettledNodes = new PriorityQueue<>(Comparator.comparingInt(dist::get));
    
        unsettledNodes.add(start);
    
        while (!unsettledNodes.isEmpty()) {
            Node currentNode = unsettledNodes.poll();
            settledNodes.add(currentNode);
    
            for (Node adjacentNode : adjacencyList.get(currentNode)) {
                if (!settledNodes.contains(adjacentNode)) {
                    int newDistance = dist.get(currentNode) + 1;
    
                    if (newDistance < dist.get(adjacentNode)) {
                        dist.put(adjacentNode, newDistance);
                        prev.put(adjacentNode, currentNode);
                        unsettledNodes.remove(adjacentNode);
                        unsettledNodes.add(adjacentNode);
                    }
                }
            }
        }
    
        return constructPath(end, start);
    }
    /**
     * 
     * @param end
     * @param start
     * @return
     */
    private List<Node> constructPath(Node end, Node start) {
        LinkedList<Node> path = new LinkedList<>();
        Node currentNode = end;
    
        // Ensure there is a path from start to end
        if (prev.get(currentNode) == null) {
            return path;
        }
    
        while (currentNode != null && !currentNode.equals(start)) {
            path.addFirst(currentNode);
            currentNode = prev.get(currentNode);
        }
    
        // Add the start node to the path
        if (currentNode != null && currentNode.equals(start)) {
            path.addFirst(start);
        }
    
        return path;
    }
    
    
}
