package hw5;

import java.util.Scanner;
import javax.swing.tree.DefaultTreeModel;

/** */
public class MainTest {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        Tree tree = new Tree("tree.txt");
        DefaultTreeModel treeModel = tree.getTreeModel();

        int choose;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Display Tree");
        System.out.println("2. Search BFS");
        System.out.println("3. Search DFS");
        System.out.println("4. Search Post-Order Traversal");
        System.out.println("5. Modify Tree");
        System.out.print("Enter your choice: ");
        choose = scanner.nextInt();

        switch (choose) {
            case 1:
                tree.displayTree(treeModel);
                scanner.close();
                break;
            case 2:
                tree.displayTree(treeModel);
                tree.searchBFS(treeModel);
                scanner.close();
                break;
            case 3:
                tree.displayTree(treeModel);
                tree.searchDFS(treeModel);
                scanner.close();
                break;
            case 4:
                tree.displayTree(treeModel);
                tree.searchPostOrderIterative(treeModel);
                scanner.close();
                break;
            case 5:
                tree.displayTree(treeModel);
                tree.moveNode(treeModel);
                scanner.close();
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }
}

