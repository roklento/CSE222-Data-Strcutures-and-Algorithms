package hw7;

/**
 * mainTest class
 * 
 */
public class testSelection {
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        run();
    }
    /**
     * 
     */
    public static void run() {
        // Example 1
        System.out.println("Example 1:");
        try {
            String input1 = "";
            String preprocessed1 = preprocess(input1);
            System.out.println("Original String: " + input1);
            System.out.println("Preprocessed String: " + preprocessed1);
            

            myMap myMap1 = new myMap(preprocessed1);
            System.out.println("\nThe original (unsorted) map:");
            myMap1.printMap();

            selectionSort selectionSort1 = new selectionSort(myMap1);
            System.out.println("\nThe sorted map:");
            selectionSort1.printSortedMap();

        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Example 2
        System.out.println("\nExample 2:");
        try {
            String input2 = "Buzzing bees buzz.";
            String preprocessed2 = preprocess(input2);
            System.out.println("Original String: " + input2);
            System.out.println("Preprocessed String: " + preprocessed2);

            myMap myMap2 = new myMap(preprocessed2);
            System.out.println("\nThe original (unsorted) map:");
            myMap2.printMap();

            selectionSort selectionSort2 = new selectionSort(myMap2);
            System.out.println("\nThe sorted map:");
            selectionSort2.printSortedMap();
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Example 3
        System.out.println("\nExample 3:");
        try {
            String input3 = "'Hush, hush!' whispered the rushing wind.";
            String preprocessed3 = preprocess(input3);
            System.out.println("Original String: " + input3);
            System.out.println("Preprocessed String: " + preprocessed3);

            myMap myMap3 = new myMap(preprocessed3);
            System.out.println("\nThe original (unsorted) map:");
            myMap3.printMap();

            selectionSort selectionSort3 = new selectionSort(myMap3);
            System.out.println("\nThe sorted map:");
            selectionSort3.printSortedMap();
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // time test for selectionSort
        System.out.println("\n-----------------------------------------");
        System.out.println("\nTime test for selectionSort:");
        warmup();
        worstCase();
        averageCase();
        bestCase();
        
    }
    /**
     * 
     * @param input
     * @return
     */
    private static String preprocess(String input) {
        // if input is null, return null
        if (input.equals("")) {
            System.out.println("Input is null.");
            return null;
        }
        String preprocessed = input.toLowerCase();
        preprocessed = preprocessed.replaceAll("[^a-z ]", "");
        return preprocessed;
    }

    private static void warmup() {
        for (int i = 0; i < 10000; i++) {
            // empty loop
        }
    }

    private static void bestCase() {
        long result = 0;
        System.out.println("\nbest case:");
        long time = 0;
        for (int i = 0; i < 1000; i++) {
            myMap myMap4 = new myMap(preprocess("d d c c c b b b a a a a "));
            selectionSort selectionSort4 = new selectionSort(myMap4);
            time = selectionSort4.runSort();
            result += time;
        }
        System.out.println("\ninput: d d c c c b b b a a a a");
        myMap myMap4 = new myMap(preprocess("d d c c c b b b a a a a"));
        selectionSort selectionSort4 = new selectionSort(myMap4);
        System.out.println("\nThe original (unsorted) map:");
        myMap4.printMap();
        System.out.println("\nThe sorted map:");
        selectionSort4.printSortedMap();
        System.out.println("\nAverage time for 1000 runs: " + result/1000 + " nanoseconds.");
    }

    private static void averageCase() {
        long result = 0;
        System.out.println("\naverage case:");
        long time = 0;
        for (int i = 0; i < 1000; i++) {
            myMap myMap4 = new myMap(preprocess("b b a a c d c a b d a c"));
            selectionSort selectionSort4 = new selectionSort(myMap4);
            time = selectionSort4.runSort();
            result += time;
        }
        System.out.println("\ninput: b b a a c d c a b d c");
        myMap myMap4 = new myMap(preprocess("b b a a c d c a b d a c"));
        selectionSort selectionSort4 = new selectionSort(myMap4);
        System.out.println("\nThe original (unsorted) map:");
        myMap4.printMap();
        System.out.println("\nThe sorted map:");
        selectionSort4.printSortedMap();
        System.out.println("\nAverage time for 1000 runs: " + result/1000 + " nanoseconds.");
    }
    
    private static void worstCase() {
        long result = 0;
        System.out.println("\nworst case:");
        long time = 0;
        for (int i = 0; i < 1000; i++) {
            myMap myMap4 = new myMap(preprocess("a a a a b b b c c c d d"));
            selectionSort selectionSort4 = new selectionSort(myMap4);
            time = selectionSort4.runSort();
            result += time;
        }
        System.out.println("\ninput: a a a a b b b c c c d d");
        myMap myMap4 = new myMap(preprocess("a a a a b b b c c c d d"));
        selectionSort selectionSort4 = new selectionSort(myMap4);
        System.out.println("\nThe original (unsorted) map:");
        myMap4.printMap();
        System.out.println("\nThe sorted map:");
        selectionSort4.printSortedMap();
        System.out.println("\nAverage time for 1000 runs: " + result/1000 + " nanoseconds.");
    }
    
}