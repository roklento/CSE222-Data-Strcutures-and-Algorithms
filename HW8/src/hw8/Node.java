package hw8;
import java.util.Objects;
public class Node {
    private int x;
    private int y;
    /**
     * 
     * @param x
     * @param y
     */
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * 
     * @return
     */
    public int getX() {
        return x;
    }
    /**
     * 
     * @return
     */
    public int getY() {
        return y;
    }
    /** */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return x == node.x && y == node.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Node{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
