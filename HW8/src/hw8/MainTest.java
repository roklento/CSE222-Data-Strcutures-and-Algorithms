package hw8;
import java.util.List;

/**
 * MainTest class for testing the program.
 */
public class MainTest {
    public static void main(String[] args) {
        // please change the input file name to test different maps example:(map01, map02, map03, map04)
        String InputFile = "map01";
        
       // This code is testing a program that uses different algorithms to find the shortest path
       // between two points on a map.
        CSE222Map Map = new CSE222Map(InputFile);
        CSE222Graph Graph = new CSE222Graph(Map);

        CSE222Dijkstra Dijkstra = new CSE222Dijkstra(Graph);
        List<Node> DijkstraPath = Dijkstra.findPath();
        CSE222BFS BFS= new CSE222BFS(Graph);
        List<Node> BFSPath = BFS.findPath();

        Map.convertPNG(InputFile + "_tempMap.png");
        Map.drawLine(BFSPath);
        Map.drawLine(DijkstraPath);
        Map.writePath(BFSPath, InputFile + "_BFS_path.txt");
        Map.writePath(DijkstraPath, InputFile + "_Dijkstra_path.txt");
        

        System.out.println("Dijkstra Path Length: "+ DijkstraPath.size());
        System.out.println("BFS Path Length: "+ BFSPath.size());
    }
}