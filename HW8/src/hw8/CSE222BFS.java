package hw8;
import java.util.*;

public class CSE222BFS {
    private CSE222Graph graph;
    private Map<Node, Node> parent;
    /**
     * 
     * @param graph
     */
    public CSE222BFS(CSE222Graph graph) {
        this.graph = graph;
        this.parent = new HashMap<>();
    }
    /**
     * 
     * @return
     */
    public List<Node> findPath() {
        Node start = graph.getMap().getStart();
        Node end = graph.getMap().getEnd();
        Map<Node, List<Node>> adjacencyList = graph.getAdjacencyList();

        Queue<Node> queue = new LinkedList<>();
        Set<Node> explored = new HashSet<>();

        queue.add(start);
        explored.add(start);

        while (!queue.isEmpty()) {
            Node v = queue.poll();

            if (v.equals(end)) {
                return constructPath(v);
            }

            for (Node w : adjacencyList.get(v)) {
                if (!explored.contains(w)) {
                    explored.add(w);
                    parent.put(w, v);
                    queue.add(w);
                }
            }
        }

        return null; 
    }
    /**
     * 
     * @param end
     * @return
     */
    private List<Node> constructPath(Node end) {
        LinkedList<Node> path = new LinkedList<>();
        Node currentNode = end;
        while (currentNode != null) {
            path.addFirst(currentNode);
            currentNode = parent.get(currentNode);
        }
        return path;
    }
}
