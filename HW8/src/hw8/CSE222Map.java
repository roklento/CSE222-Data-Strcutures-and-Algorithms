package hw8;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/** */
public class CSE222Map {
    private BufferedImage image;
    private Graphics2D graphics;
    private Node start;
    private Node end;
    private ArrayList<ArrayList<Integer>> matrix;

    /**
     * 
     * @param inputFile
     */
    public CSE222Map(String inputFile) {
        try {
            this.image = ImageIO.read(new File(inputFile + ".jpg"));
            this.graphics = image.createGraphics();
            this.graphics.setColor(Color.BLUE);

            List<String> lines = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(inputFile + ".txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    lines.add(line);
                }
            }

            String[] parts = lines.get(0).split(",");
            start = new Node(Integer.parseInt(parts[1]), Integer.parseInt(parts[0]));
            parts = lines.get(1).split(",");
            end = new Node(Integer.parseInt(parts[1]), Integer.parseInt(parts[0]));
            int size = lines.size() - 2;
            matrix = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < size; i++) {
                ArrayList<Integer> row = new ArrayList<Integer>();
                parts = lines.get(i + 2).split(",");
                for (int j = 0; j < size; j++) {
                    int value = Integer.parseInt(parts[j]);
                    if (value == -1) {
                        value = 1;
                    }
                    row.add(value);
                }
                matrix.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 
     * @return
     */
    public Node getStart() {
        return start;
    }
    /**
     * 
     * @return
     */
    public Node getEnd() {
        return end;
    }
    /**
     * 
     * @return
     */
    public ArrayList<ArrayList<Integer>> getMatrix() {
        return matrix;
    }

    /**
     * 
     * @param outputFileName
     */
    public void convertPNG(String outputFileName) {
        try {
            ImageIO.write(image, "png", new File(outputFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 
     * @param path
     */
    public void drawLine(List<Node> path) {
        Node lastNode = null;
        for (Node node : path) {
            if (lastNode != null) {
                graphics.drawLine(lastNode.getY(), lastNode.getX(), node.getY(), node.getX());
            }
            lastNode = node;
        }
        convertPNG("output.png");
    }

    /**
     * 
     * @param path
     * @param fileName
     */
    public void writePath(List<Node> path, String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (Node node : path) {
                writer.write(node.getX() + "," + node.getY() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
