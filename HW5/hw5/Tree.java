package hw5;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Arrays;

/** */
class Tree {
    private DefaultTreeModel treeModel;

    /**
     * 
     * @param filename
     */
    public Tree(String filename) {
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Root");
        treeModel = new DefaultTreeModel(rootNode);
        readFileAndCreateTree(filename);
    }

    /**
     * 
     * @param filename
     */
    private void readFileAndCreateTree(String filename) {
        File file = new File(filename);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(";");
                addDataToTree(data);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }

    /**
     * 
     * @param data
     */
    private void addDataToTree(String[] data) {
        DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) treeModel.getRoot();
        for (String value : data) {
            currentNode = findOrCreateChildNode(currentNode, value);
        }
    }

    /**
     * 
     * @param parent
     * @param value
     * @return
     */
    private DefaultMutableTreeNode findOrCreateChildNode(DefaultMutableTreeNode parent, String value) {
        for (int i = 0; i < parent.getChildCount(); i++) {
            DefaultMutableTreeNode child = (DefaultMutableTreeNode) parent.getChildAt(i);
            if (value.equals(child.getUserObject())) {
                return child;
            }
        }
        DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(value);
        parent.add(newNode);
        return newNode;
    }

    /**
     * 
     * @return treeModel
     */
    protected DefaultTreeModel getTreeModel() {
        return treeModel;
    }

    /**
     * 
     * @param treeModel
     */
    protected void displayTree(DefaultTreeModel treeModel) {
        JTree tree = new JTree(treeModel);
        JFrame frame = new JFrame("Tree Structure");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(tree), BorderLayout.CENTER);
        frame.setSize(400, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    /**
     * 
     * @param treeModel
     */
    protected void searchBFS(DefaultTreeModel treeModel) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter the value to find: ");
        String searchValue = inputScanner.nextLine();
        inputScanner.close();
    
        DefaultMutableTreeNode rootNode = (DefaultMutableTreeNode) treeModel.getRoot();
        Queue<DefaultMutableTreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(rootNode);
    
        boolean isFound = false;
        int counter = 1;
    
        System.out.println("Using BFS to find '" + searchValue + "' in the tree...");
        while (!nodeQueue.isEmpty()) {
            DefaultMutableTreeNode currentNode = nodeQueue.poll();
    
            if (searchValue.equals(currentNode.getUserObject())) {
                System.out.println("Step " + counter + " -> " + currentNode.getUserObject() + " (Found!)");
                isFound = true;
                break;
            } else {
                System.out.println("Step " + counter + " -> " + currentNode.getUserObject());
            }
    
            for (int i = 0; i < currentNode.getChildCount(); i++) {
                DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) currentNode.getChildAt(i);
                nodeQueue.add(childNode);
            }
            counter++;
        }
    
        if (!isFound) {
            System.out.println("Not found!");
        }
    }
    
    /**
     * 
     * @param treeModel
     */
    protected void searchDFS(DefaultTreeModel treeModel) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter the value to search: ");
        String searchValue = inputScanner.nextLine();
        inputScanner.close();
    
        DefaultMutableTreeNode rootNode = (DefaultMutableTreeNode) treeModel.getRoot();
        Stack<DefaultMutableTreeNode> stack = new Stack<>();
        stack.push(rootNode);
    
        boolean isFound = false;
        int step = 1;
    
        System.out.println("Using DFS to find '" + searchValue + "' in the tree...");
    
        while (!stack.isEmpty()) {
            DefaultMutableTreeNode currentNode = stack.pop();
    
            if (searchValue.equals(currentNode.getUserObject())) {
                System.out.println("Step " + step + " -> " + currentNode.getUserObject() + " (Found!)");
                isFound = true;
                break;
            } else {
                System.out.println("Step " + step + " -> " + currentNode.getUserObject());
            }
    
            for (int i = currentNode.getChildCount() - 1; i >= 0; i--) {
                DefaultMutableTreeNode child = (DefaultMutableTreeNode) currentNode.getChildAt(i);
                stack.push(child);
            }
            step++;
        }
    
        if (!isFound) {
            System.out.println("Not found!");
        }
    }

    /**
     * 
     * @param treeModel
     */
    protected void searchPostOrderIterative(DefaultTreeModel treeModel) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter the value to search: ");
        String searchValue = inputScanner.nextLine();
        inputScanner.close();
    
        DefaultMutableTreeNode rootNode = (DefaultMutableTreeNode) treeModel.getRoot();
        Stack<DefaultMutableTreeNode> stack = new Stack<>();
        Stack<DefaultMutableTreeNode> outputStack = new Stack<>();
    
        stack.push(rootNode);
    
        while (!stack.isEmpty()) {
            DefaultMutableTreeNode currentNode = stack.pop();
            outputStack.push(currentNode);
    
            for (int i = 0; i < currentNode.getChildCount(); i++) {
                DefaultMutableTreeNode child = (DefaultMutableTreeNode) currentNode.getChildAt(i);
                stack.push(child);
            }
        }
    
        System.out.println("Using post-order traversal to find '" + searchValue + "' in the tree...");
        int step = 1;
        boolean isFound = false;
    
        while (!outputStack.isEmpty()) {
            DefaultMutableTreeNode currentNode = outputStack.pop();
            
    
            if (searchValue.equals(currentNode.getUserObject())) {
                System.out.println("Step " + step + " -> " + currentNode.getUserObject() + " (Found!)");
                isFound = true;
                break;
            }
            else {
                System.out.println("Step " + step + " -> " + currentNode.getUserObject());
            }
    
            step++;
        }
    
        if (!isFound) {
            System.out.println("Not found!");
        }
    }

    /**
     * 
     * @param treeModel
     */
    protected void moveNode(DefaultTreeModel treeModel) {
        Scanner inputScanner = new Scanner(System.in);
    
        System.out.print("Enter the source path: ");
        String sourcePath = inputScanner.nextLine();
        String[] sourceData = sourcePath.split("->");
    
        System.out.print("Enter the destination year: ");
        String destinationYear = inputScanner.nextLine();
    
        inputScanner.close();
    
        DefaultMutableTreeNode rootNode = (DefaultMutableTreeNode) treeModel.getRoot();
        DefaultMutableTreeNode sourceNode = findNode(rootNode, sourceData);
    
        if (sourceNode != null) {
            DefaultMutableTreeNode sourceParent = (DefaultMutableTreeNode) sourceNode.getParent();
            DefaultMutableTreeNode destinationYearNode = findOrCreateChildNode(rootNode, destinationYear);
            DefaultMutableTreeNode parentNode = sourceParent;
            DefaultMutableTreeNode newDestinationNode = destinationYearNode;
            for (int i = sourceData.length - 2; i >= 0; i--) {
                newDestinationNode = findOrCreateChildNode(newDestinationNode, parentNode.getUserObject().toString());
                parentNode = (DefaultMutableTreeNode) parentNode.getParent();
            }
            treeModel.removeNodeFromParent(sourceNode);
            treeModel.insertNodeInto(sourceNode, newDestinationNode, newDestinationNode.getChildCount());
            if (sourceParent.getChildCount() == 0 && !sourceParent.equals(rootNode)) {
                treeModel.removeNodeFromParent(sourceParent);
            }
    
            System.out.println("Node moved successfully!");
            displayTree(treeModel);
        } else {
            System.out.println("Node not found!");
        }
    }

    /**
     * 
     * @param currentNode 
     * @param path
     * @return
     */
    private DefaultMutableTreeNode findNode(DefaultMutableTreeNode currentNode, String[] path) {
        if (path.length == 0) {
            return currentNode;
        }
    
        for (int i = 0; i < currentNode.getChildCount(); i++) {
            DefaultMutableTreeNode child = (DefaultMutableTreeNode) currentNode.getChildAt(i);
            if (child.getUserObject().toString().equals(path[0])) {
                String[] newPath = Arrays.copyOfRange(path, 1, path.length);
                DefaultMutableTreeNode foundNode = findNode(child, newPath);
                if (foundNode != null) {
                    return foundNode;
                }
            }
        }
        return null;
    }
}