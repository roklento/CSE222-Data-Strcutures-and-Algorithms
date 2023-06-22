package hw8;

import java.util.*;
/**
 * CSE222Graph class for creating graph from map.
 */
public class CSE222Graph {
    private CSE222Map map;
    private Map<Node, List<Node>> adjacencyList;

    /**
     * 
     * @param map
     */
    public CSE222Graph(CSE222Map map) {
        this.map = map;
        this.adjacencyList = new HashMap<>();
        constructGraphFromMap();
    }

    /**
     * Construct graph from map.
     */
    private void constructGraphFromMap() {
        ArrayList<ArrayList<Integer>> matrix = map.getMatrix();
        int n = matrix.size();
    
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (matrix.get(y).get(x) == 0) {
                    Node node = new Node(x, y); // x, y
                    adjacencyList.putIfAbsent(node, new ArrayList<>());
    
                    int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
                    int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    
                    for (int i = 0; i < 8; i++) {
                        int ny = y + dy[i];
                        int nx = x + dx[i];
    
                        if (nx >= 0 && nx < n && ny >= 0 && ny < n && matrix.get(ny).get(nx) == 0) {
                            Node neighbour = new Node(nx, ny); // nx, ny
                            adjacencyList.get(node).add(neighbour);
                        }
                    }
                }
            }
        }
    }

    /**
     * 
     * @return
     */
    public CSE222Map getMap() {
        return this.map;
    }
    /**
     * 
     * @return
     */
    public Map<Node, List<Node>> getAdjacencyList() {
        return this.adjacencyList;
    }
}
